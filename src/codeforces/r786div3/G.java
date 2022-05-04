package codeforces.r786div3;

import java.io.*;
import java.util.*;

public class G {
    void go() {
        int ans = 0;
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        List<Integer>[] g = new List[n + 1];
        List<Integer>[] rg = new List[n + 1];
        int[] ind = new int[n + 1];

        List<Integer> top = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        int[] dp = new int[n + 1]; // longest path ending at vertex i

        for(int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
            rg[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int u = Reader.nextInt();
            int v = Reader.nextInt();
            g[u].add(v);
            rg[v].add(u);
            ind[v]++;
        }

        for(int i = 1; i <= n; i++) {
            if(ind[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int v = q.poll();

            top.add(v);

            for(int nei : g[v]) {
                if(--ind[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        for(int v : top) {
            List<Integer> l = rg[v];
            List<Integer> atLeastTwo = new ArrayList<>();
            int max = 0;
            for(int u : l) {
                if(g[u].size() > 1) {
                    atLeastTwo.add(u);
                    max = Math.max(dp[u], max);
                }
            }

            if(atLeastTwo.size() > 1) {
                dp[v] = max + 1;
            } else {
                if(atLeastTwo.isEmpty() || (atLeastTwo.size() == 1 && l.size() == 1)) {
                    dp[v] = 1;
                } else {
                    dp[v] = max + 1;
                }
            }

            ans = Math.max(ans, dp[v]);
        }

        Writer.println(ans);
    }
    void solve() {
        go();
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

        public static void flush() {
            pw.flush();
        }

        public static void close() {
            pw.close();
        }
    }
}