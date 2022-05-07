package codeforces.r787div3;

import java.io.*;
import java.util.*;

public class F {
    private int[] dfs(List<Integer>[] g, Set<Integer> tasks, int y, int cur, int p) {
        boolean hasY = cur == y;
        boolean hasT = tasks.contains(cur);

        int tot = 0;
        for(int c : g[cur]) {
            if(c != p) {
                int[] ret = dfs(g, tasks, y, c, cur);
                int f = ret[0];
                if(f == 1) {
                    hasT = true;
                } else if(f == 2) {
                    hasY = true;
                }

                tot += ret[1];
            }
        }

        if(hasY) {
            return new int[] {2, tot + 1};
        } else if(hasT) {
            return new int[] {1, tot + 2};
        } else {
            return new int[] {0, 0};
        }
    }
    void go() {
        int n = Reader.nextInt();
        int k = Reader.nextInt();
        int x = Reader.nextInt();
        int y = Reader.nextInt();
        int ans = 0;
        Set<Integer> tasks = new HashSet<>();
        int[][] E = new int[n - 1][2];
        List<Integer>[] g = new List[n + 1];

        for(int i = 0; i < k; i++) {
            tasks.add(Reader.nextInt());
        }

        for(int i = 0; i < n - 1; i++) {
            E[i] = new int[] {Reader.nextInt(), Reader.nextInt()};
        }

        for(int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for(int[] e : E) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        ans = dfs(g, tasks, y, x, -1)[1] - 1;
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
        new F().run();
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