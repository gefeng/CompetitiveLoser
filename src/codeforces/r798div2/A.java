package codeforces.r798div2;

import java.io.*;
import java.util.*;

public class A {
    void go() {
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        int k = Reader.nextInt();
        char[] a = Reader.next().toCharArray();
        char[] b = Reader.next().toCharArray();
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(a);
        Arrays.sort(b);

        int cntA = 0;
        int cntB = 0;
        for(int i = 0, j = 0; i < n && j < m; ) {
            if(a[i] < b[j]) {
                if(cntA < k) {
                    sb.append(a[i++]);
                    cntA++;
                    cntB = 0;
                } else {
                    sb.append(b[j++]);
                    cntA = 0;
                    cntB++;
                }
            } else {
                if(cntB < k) {
                    sb.append(b[j++]);
                    cntB++;
                    cntA = 0;
                } else {
                    sb.append(a[i++]);
                    cntB = 0;
                    cntA++;
                }
            }
        }

        Writer.println(sb.toString());
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
        new A().run();
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
