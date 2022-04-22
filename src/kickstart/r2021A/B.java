package kickstart.r2021A;

import java.io.*;
import java.util.*;

public class B {
    void go(int T) {
        int m = Reader.nextInt();
        int n = Reader.nextInt();
        int[][] g = new int[m][n];
        int ans = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                g[i][j] = Reader.nextInt();
            }
        }

        int[][] l = new int[m][n];
        int[][] r = new int[m][n];
        int[][] u = new int[m][n];
        int[][] d = new int[m][n];

        for(int i = 0; i < m; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                cnt = g[i][j] == 0 ? 0 : cnt + 1;
                l[i][j] = cnt;
            }
            cnt = 0;
            for(int j = n - 1; j >= 0; j--) {
                cnt = g[i][j] == 0 ? 0 : cnt + 1;
                r[i][j] = cnt;
            }
        }

        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                cnt = g[j][i] == 0 ? 0 : cnt + 1;
                u[j][i] = cnt;
            }
            cnt = 0;
            for (int j = m - 1; j >= 0; j--) {
                cnt = g[j][i] == 0 ? 0 : cnt + 1;
                d[j][i] = cnt;
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(g[i][j] == 1) {
                    int x = u[i][j];
                    int y = l[i][j];
                    if(x >= 2 && y >= 2) {
                        ans += Math.min(x / 2 - 1, y - 1);
                        ans += Math.min(x - 1, y / 2 - 1);
                    }

                    y = r[i][j];
                    if(x >= 2 && y >= 2) {
                        ans += Math.min(x / 2 - 1, y - 1);
                        ans += Math.min(x - 1, y / 2 - 1);
                    }

                    x = d[i][j];
                    y = l[i][j];
                    if(x >= 2 && y >= 2) {
                        ans += Math.min(x / 2 - 1, y - 1);
                        ans += Math.min(x - 1, y / 2 - 1);
                    }

                    y = r[i][j];
                    if(x >= 2 && y >= 2) {
                        ans += Math.min(x / 2 - 1, y - 1);
                        ans += Math.min(x - 1, y / 2 - 1);
                    }
                }
            }
        }

        Writer.println("Case #" + T + ": " + ans);
    }
    void solve() {
        int T = Reader.nextInt();
        for(int i = 1; i <= T; i++) go(i);
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
