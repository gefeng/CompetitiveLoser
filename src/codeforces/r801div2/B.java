package codeforces.r801div2;

import java.io.*;
import java.util.*;

public class B {
    void go() {
        int n = Reader.nextInt();
        int[] A = new int[n];
        
        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
        }

        boolean win = true;
        if(n == 1) {
            win = true;
        } else if(n == 2) {
            win = A[0] > A[1];
        } else {
            if(n % 2 == 1) {
                win = true;
            } else {
                int min1 = Integer.MAX_VALUE;
                int min2 = Integer.MAX_VALUE;
                int pos1 = 0;
                int pos2 = 0;
                for(int i = 0; i < n; i++) {
                    if(i % 2 == 0) {
                        min1 = Math.min(min1, A[i]);
                    } else {
                        min2 = Math.min(min2, A[i]);
                    }
                }

                if(min1 == min2) {
                    for(int i = 0; i < n; i += 2) {
                        if(A[i] == min1) {
                            pos1 = i;
                            break;
                        }
                    }

                    for(int i = 1; i < n; i += 2) {
                       if(A[i] == min2) {
                           pos2 = i;
                           break;
                       } 
                    }

                    win = pos1 > pos2;
                } else {
                    win = min1 > min2;
                }
            }
        } 

        Writer.println(win ? "Mike" : "Joe");
    }
    void solve() {
        for(int T = Reader.nextInt(); T > 0; T--) go();
    }
    void run() throws Exception {
        Reader.init(System.in);
        Writer.init(System.out);
        solve();
        Writer.close();
    }

    public static void main(String[] args) throws Exception {
        new B().run();
    }

    public static class Reader {
        public static StringTokenizer st;
        public static BufferedReader br;

        public static void init(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = new StringTokenizer("");
        }

        public static String next() {
            while(!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
            }
            return st.nextToken();
        }

        public static int nextInt() {
            return Integer.parseInt(next());
        }

        public static long nextLong() {
            return Long.parseLong(next());
        }

        public static double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static class Writer {
            public static PrintWriter pw;

            public static void init(OutputStream os) {
                pw = new PrintWriter(new BufferedOutputStream(os));
            }

            public static void print(String s) {
                pw.print(s);
            }

            public static void print(char c) {
                pw.print(c);
            }

            public static void print(int x) {
                pw.print(x);
            }

            public static void print(long x) {
                pw.print(x);
            }

            public static void println(String s) {
                pw.println(s);
            }

            public static void println(char c) {
                pw.println(c);
            }

            public static void println(int x) {
                pw.println(x);
            }

            public static void flush() {
                pw.flush();
            }

            public static void println(long x) {
                pw.println(x);
            }

            public static void close() {
                pw.close();
            }
        }
}
