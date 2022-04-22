package kickstart.r2021A;

import java.io.*;
import java.util.*;

public class C {
    void go(int T) {
        int m = Reader.nextInt();
        int n = Reader.nextInt();
        long ans = 0;
        Queue<int[]> q = new ArrayDeque<>();
        int[][] g = new int[m][n];
        int[][] hmap = new int[m][n];
        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                g[i][j] = Reader.nextInt();

                if(g[i][j] > 0) {
                    q.offer(new int[] {i, j, g[i][j]});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int h = cur[2];

            if(h == 0) {
                continue;
            }

            for(int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                int nh = h - 1;
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && nh > hmap[nr][nc]) {
                    q.offer(new int[] {nr, nc, nh});
                    hmap[nr][nc] = nh;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(hmap[i][j] > g[i][j]) {
                    ans += hmap[i][j] - g[i][j];
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
