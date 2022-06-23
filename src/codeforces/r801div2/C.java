package codeforces.r801div2;

import java.io.*;
import java.util.*;

public class C {
    void go() {
        int m = Reader.nextInt();
        int n = Reader.nextInt();
        int[][] g = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                g[i][j] = Reader.nextInt();
            }
        }
        
        int[][] min = new int[m][n];
        int[][] max = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    min[i][j] = g[i][j];
                    max[i][j] = g[i][j];
                } else if(i == 0) {
                    min[i][j] = min[i][j - 1] + g[i][j];
                    max[i][j] = max[i][j - 1] + g[i][j];
                } else if(j == 0) {
                    min[i][j] = min[i - 1][j] + g[i][j];
                    max[i][j] = max[i - 1][j] + g[i][j];
                } else {
                    min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + g[i][j];
                    max[i][j] = Math.max(max[i - 1][j], max[i][j - 1]) + g[i][j];
                }
            }
        }

        String ans = "NO";
        if((m + n) % 2 == 1 && min[m - 1][n - 1] <= 0 && max[m - 1][n - 1] >= 0) {
            ans = "YES";
        }
        Writer.println(ans);
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
        new C().run();
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
