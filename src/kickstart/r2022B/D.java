package kickstart.r2022B;

import java.io.*;
import java.util.*;

public class D {
    private int getDegree(int r, int c, int m, int n, char[][] g, int[][] directions, int[][] deg, boolean[][] visited) {
        int d = -1;
        for(int i = 0; i < 4; i++) {
            int[] dir = directions[i];
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && g[nr][nc] != '#') {
                if (!visited[nr][nc]) {
                    d = d == -1 ? 1 : d + 1;
                }
            }
        }

        return d;
    }
    private boolean dfs(char[][] g, int[][] directions, String dn, int[][] deg, int tot, int r, int c, boolean[][] visited, StringBuilder path) {
        visited[r][c] = true;

        int m = g.length;
        int n = g[0].length;

        int bestD = Integer.MAX_VALUE;
        int[] best = null;

        List<int[]> neis = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            int[] dir = directions[i];
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && g[nr][nc] != '#') {
                if (nr == 0 && nc == 0 && tot == path.length() + 1) {
                    path.append(dn.charAt(i));
                    return true;
                }
                if (!visited[nr][nc]) {
                    int d = getDegree(nr,nc,m,n,g, directions,deg,visited);
                    if(d == -1) continue;
                    if(d < bestD) {
                        bestD = d;
                        best = new int[] {nr, nc, i};
                    }
                    //bestD = Math.min(deg[nr][nc], bestD);
                }
            }
        }

        if(bestD == Integer.MAX_VALUE) {
            return false;
        }

        path.append(dn.charAt(best[2]));
        return dfs(g, directions, dn, deg, tot, best[0], best[1], visited, path);
//        for(int i = 0; i < 4; i++) {
//            int[] dir = directions[i];
//            int nr = r + dir[0];
//            int nc = c + dir[1];
//            if(nr >= 0 && nc >= 0 && nr < m && nc < n && g[nr][nc] != '#' && !visited[nr][nc] && bestD == deg[nr][nc]) {
//                neis.add(new int[] {nr, nc, i});
//            }
//        }
//
//        for(int[] nei : neis) {
//            path.append(dn.charAt(nei[2]));
//            if(dfs(g, directions, dn, deg, tot, nei[0], nei[1], visited, path)) {
//                return true;
//            }
//            path.deleteCharAt(path.length() - 1);
//        }
//
//        visited[r][c] = false;
        //return false;
    }
    void go(int T) {
        int M = Reader.nextInt();
        int N = Reader.nextInt();
        int m = 2 * M;
        int n = 2 * N;
        char[][] grid = new char[m][n];
        int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        String dn = "NESW";
        String ans = "";
        int tot = 0;

        for(int i = 0; i < M; i++) {
            String s = Reader.next();

            for(int j = 0; j < N; j++) {
                char c = s.charAt(j);
                grid[2 * i][2 * j] = c;
                grid[2 * i][2 * j + 1] = c;
                grid[2 * i + 1][2 * j] = c;
                grid[2 * i + 1][2 * j + 1] = c;
            }
        }

        int[][] deg = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '*') {
                    tot++;
                    int d = 0;
                    for(int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if(ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] != '#') {
                            d++;
                        }
                    }
                    deg[i][j] = d;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean res = dfs(grid, directions, dn, deg, tot, 0, 0, new boolean[m][n], sb);

        ans = res ? sb.toString() : "IMPOSSIBLE";
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