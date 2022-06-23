package codeforces.r776div3;

import java.io.*;
import java.util.*;

public class D {
    void go() {
        int n = Reader.nextInt();
        int[] A = new int[n];
        int[] O = new int[n];
        int[] P = new int[n];

        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt() - 1;
        }
       
        int[] cur = Arrays.copyOf(A, n);
        for(int i = n - 1; i >= 0; i--) {
            int pos = -1;
            for(int j = 0; j < n; j++) {
                if(i == cur[j]) {
                    pos = j;
                    break;
                }
            } 

            int[] pre = new int[n]; 
            Arrays.fill(pre, -1);
            for(int j = n - 1; j >= i; j--) {
                pre[j] = j;
            }
            
            int len = i + 1;
            int d = (pos - i + len) % len;
            O[i] = d;
            for(int j = 0; j < n; j++) {
                int v = cur[j];
                if(v < i) {
                    int npos = (j - d + len) % len;
                    if(pre[npos] != -1) {
                        Writer.println(-1);
                        return;
                    }
                    pre[npos] = v;
                }
            } 

            cur = pre;
        }

        for(int i = 0; i < n; i++) {
            if(cur[i] != i) {
                Writer.println(-1);
                return;
            }
        }

        for(int i = 0; i < n; i++) {
            Writer.print(O[i]);
            if(i == n - 1) {
                Writer.print("\n");
            } else {
                Writer.print(" ");
            }
        }
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
        new D().run();
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
