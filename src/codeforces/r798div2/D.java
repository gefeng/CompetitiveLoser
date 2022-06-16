package codeforces.r798div2;

import java.io.*;
import java.util.*;

public class D {
    void go() {
        int m = Reader.nextInt();
        int n = Reader.nextInt();
        int[][] M = new int[m][n];
        int min = Integer.MAX_VALUE;
        int minR = -1;
        int minC = -1;
        int[][] border = new int[4][2];

        border[0] = new int[] {Integer.MAX_VALUE, 0};
        border[1] = new int[] {Integer.MAX_VALUE, 0};
        border[2] = new int[] {Integer.MIN_VALUE, 0};
        border[3] = new int[] {Integer.MIN_VALUE, 0};
        for(int i = 0; i < m; i++) {
            String s = Reader.next();
            for(int j = 0; j < n; j++) {
                M[i][j] = s.charAt(j) == 'W' ? 0 : 1;
                if(M[i][j] == 1) {
                    if(i + j < border[0][0] + border[0][1]) {
                        border[0][0] = i;
                        border[0][1] = j;
                    }
                    if(i - j < border[1][0] - border[1][1]) {
                        border[1][0] = i;
                        border[1][1] = j;
                    }
                    if(i - j > border[2][0] - border[2][1]) {
                        border[2][0] = i;
                        border[2][1] = j;
                    }
                    if(i + j > border[3][0] + border[3][1]) {
                        border[3][0] = i;
                        border[3][1] = j;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int max = 0;
                for(int[] p : border) {
                    max = Math.max(max, Math.abs(i - p[0]) + Math.abs(j - p[1]));
                }
                if(max < min) {
                    min = max;
                    minR = i + 1;
                    minC = j + 1;
                }
            }
        } 

        Writer.println(minR + " " + minC);
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
