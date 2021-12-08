package codeforces.r1613;

import java.io.*;
import java.util.*;

public class E {
    /**
     * state:
     *  (r, c, d, win/draw)
     *
     *
     * */
    private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean in(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
    void go() {
        int m = Reader.nextInt();
        int n = Reader.nextInt();

        char[][] g = new char[m][n];
        int lx = 0, ly = 0;
        for(int i = 0; i < m; i++) {
            String s = Reader.next();
            for(int j = 0; j < n; j++) {
                g[i][j] = s.charAt(j);
                if(g[i][j] == 'L') {
                    lx = i;
                    ly = j;
                }
            }
        }

        int[][] d = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int[] dir : DIRECTIONS) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if(in(ni, nj, m, n) && g[ni][nj] != '#') {
                        d[i][j]++;
                    }
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] win = new boolean[m][n];
        win[lx][ly] = true;
        q.offer(new int[] {lx, ly});

        while(!q.isEmpty()) {
            int[] s = q.poll();
            int x = s[0];
            int y = s[1];
            for(int[] dir : DIRECTIONS) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(in(nx, ny, m, n) && g[nx][ny] != '#' && !win[nx][ny]) {
                    if(--d[nx][ny] <= 1) {
                        q.offer(new int[] {nx, ny});
                        win[nx][ny] = true;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(win[i][j] && g[i][j] != 'L') {
                    g[i][j] = '+';
                }
                Writer.print(g[i][j]);
            }
            Writer.print("\n");
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

        public static void println(long x) {
            pw.println(x);
        }

        public static void close() {
            pw.close();
        }
    }
}