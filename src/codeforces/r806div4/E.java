package codeforces.r806div4;

import java.io.*;
import java.util.*;

public class E {
    void go() {
        int n = Reader.nextInt();
        int[][] g = new int[n][n];
        int ans = 0;
        
        for(int i = 0; i < n; i++) {
            int j = 0;
            for(char c : Reader.next().toCharArray()) {
                g[i][j++] = c - '0';
            }
        }

        for(int i = 0; i < n / 2; i++) {
            int len = n - 2 * i - 1;
            for(int j = 0; j < len; j++) {
                int r = 0;
                int c = j;
                int cnt = 0;
                for(int k = 0; k < 4; k++) {
                    cnt += g[r + i][c + i];
                    int nr = c;
                    int nc = len - r;
                    r = nr;
                    c = nc;
                }
                ans += Math.min(cnt, 4 - cnt);
            }
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
