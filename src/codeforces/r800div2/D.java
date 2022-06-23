package codeforces.r800div2;

import java.io.*;
import java.util.*;

public class D {
    void go() {
        int n = Reader.nextInt();
        List<Integer>[] g = new List[n + 1];
        int[][] range = new int[n + 1][2];

        for(int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for(int i = 2; i <= n; i++) {
            int p = Reader.nextInt();
            g[p].add(i);
        }

        for(int i = 1; i <= n; i++) {
            range[i] = new int[] {Reader.nextInt(), Reader.nextInt()};
        }

        long ans = dfs(g, range, 1)[0];

        Writer.println(ans);
    }
    private long[] dfs(List<Integer>[] g, int[][] range, int cur) {
        long sum = 0;
        long tot = 0;

        for(int nei : g[cur]) {
            long[] res = dfs(g, range, nei);
            tot += res[0];
            sum += res[1];
        }

        if(sum < range[cur][0] || sum > range[cur][1]) {
            tot += sum < range[cur][0] ? 1 : 0;
            sum = range[cur][1];
        } 
        return new long[] {tot, sum};
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
