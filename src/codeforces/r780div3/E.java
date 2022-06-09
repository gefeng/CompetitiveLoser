package codeforces.r780div3;

import java.io.*;
import java.util.*;

public class E {
    void go() {
        int n = Reader.nextInt();
        int[][] M = new int[n][n];
        int ans = n * n;

        for(int i = 0; i < n; i++) {
            String col = Reader.next();
            for(int j = 0; j < n; j++) {
                M[i][j] = col.charAt(j) - '0';
            }
        }

        int[] rOne = new int[n];
        int[] cOne = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                rOne[i] += M[i][j];
                cOne[j] += M[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            int cost1 = 0;
            int cost2 = 0;
            for(int j = 0, c = 0; j < n; j++, c++) {
                int r = (i + j) % n;
                if(M[r][c] == 0) {
                    cost1++;
                }
                cost2 += rOne[r] - M[r][c];
            }
            ans = Math.min(ans, cost1 + cost2);
        }

        for(int i = 0; i < n; i++) {
            int cost1 = 0;
            int cost2 = 0;
            for(int j = 0, r = 0; j < n; j++, r++) {
                int c = (i + j) % n;
                if(M[r][c] == 0) {
                    cost1++;
                }
                cost2 += cOne[c] - M[r][c];
            }
            ans = Math.min(ans, cost1 + cost2);
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
        new E().run();
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
