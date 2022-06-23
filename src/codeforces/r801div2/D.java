package codeforces.r801div2;

import java.io.*;
import java.util.*;

public class D {
    void go() {
        int n = Reader.nextInt();
        List<Integer>[] g = new List[n + 1];

        for(int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            int u = Reader.nextInt();
            int v = Reader.nextInt();
            g[u].add(v);
            g[v].add(u);
        }
        
        if(n == 1) {
            Writer.println(0);
            return;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            int res = dfs(g, i, -1) + 1;
            ans = Math.min(ans, res);
        }
         
        Writer.println(ans);
    }
    private int dfs(List<Integer>[] g, int cur, int p) {
        int tot = 0;
        int cnt = 0; 
        for(int nei : g[cur]) {
            if(nei != p) {
                int res = dfs(g, nei, cur);
                if(res == 0) {
                    cnt += 1;
                }
                tot += res;
            }
        }

        return tot + Math.max(0, cnt - 1); 
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
