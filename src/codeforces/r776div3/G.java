package codeforces.r776div3;

import java.io.*;
import java.util.*;

public class G {
    void go() {
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        int s = Reader.nextInt();
        int t = Reader.nextInt();
        int ans = 0;
        int mod = (int)1e9 + 7;
        List<Integer>[] g = new List[n + 1];

        for(int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int u = Reader.nextInt();
            int v = Reader.nextInt();
            g[u].add(v);
            g[v].add(u);
        }
        
        int[][] dis = new int[2][n + 1];
        int[][] dp = new int[2][n + 1];
        Queue<int[]> q = new ArrayDeque<>();
        
        Arrays.fill(dis[0], Integer.MAX_VALUE);
        Arrays.fill(dis[1], Integer.MAX_VALUE);
        dis[0][s] = 0;
        dp[0][s] = 1;
        q.offer(new int[] {s, 0, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], f = cur[1], d = cur[2]; 

            if(x == t) {
                continue;
            }
             
            for(int nei : g[x]) {
                if(dis[0][nei] >= d + 1) {
                    if(d + 1 < dis[0][nei]) {
                        dis[0][nei] = d + 1; 
                        q.offer(new int[] {nei, 0, d + 1});
                    }
                    dp[0][nei] = (dp[0][nei] + dp[f][x]) % mod;
                } 

                if(dis[0][nei] + 1 == d + 1) {
                    if(d + 1 < dis[1][nei]) {
                        dis[1][nei] = d + 1;
                        q.offer(new int[] {nei, 1, d + 1});
                    }
                    dp[1][nei] = (dp[1][nei] + dp[f][x]) % mod;
                }
            }
        }
        Writer.println((dp[0][t] + dp[1][t]) % mod); 
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
        new G().run();
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
