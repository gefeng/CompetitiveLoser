package codeforces.er119div2;

import java.io.*;
import java.util.*;

public class D {
    int getMinCoins(int t) {
        int[] dp = new int[t + 1];
        Arrays.fill(dp, t);
        dp[0] = 0;
        for(int i = 1; i < 4; i++) {
            for(int j = 1; j <= t; j++) {
                if(j - i >= 0)
                dp[j] = Math.min(dp[j], dp[j - i] + 1);
            }
        }

        return dp[t];
    }

    void go() {
        int n = Reader.nextInt();
        int ans = 0;
        TreeSet<Integer> cost = new TreeSet<>();

        for(int i = 0; i < n; i++) {
            cost.add(Reader.nextInt());
        }

        for(int x : cost) {
            ans = Math.max(ans, getMinCoins(x));
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

        public static void println(long x) {
            pw.println(x);
        }

        public static void close() {
            pw.close();
        }
    }
}