package codeforces.r1613;

import java.io.*;
import java.util.*;

public class D {
    /**
     * Valid MEX sequence:
     *  A. 0..0 1..1 2..2 x-1..x-1 x..x
     *  B. 0..0 1..1 2..2 x-1..x-1 x+1..x+1 x-1..x-1
     *
     * state:
     *  dp1[i][j] denotes # sequences on type A on prefix of length i with MEX equal to j
     *  dp2[i][j] denotes # sequences on type B on prefix of length i with MEX equal to j
     * transition:
     *  0 1 2 3    +4   x == j
     *  0 1 2 3     3   x == j - 1
     *  0 1 2 3     5   x == j + 1
     *  pre: dp[i - 1][j]
     *  if x == j - 1 dp1[i - 1][j] -> dp1[i][j]
     *  if x == j     dp1[i - 1][j] -> dp1[i][j + 1]
     *  if x == j + 1 dp1[i - 1][j] -> dp2[i][j]
     *  0 1 2 4 +2/4
     *  if x == j - 1 dp2[i - 1][j] -> dp2[i][j]
     *  if x == j + 1 dp2[i - 1][j] -> dp2[i][j]
     * */
    private static final int MOD = 998244353;
    void go() {
        // add code
        int n = Reader.nextInt();
        int ans = -1;

        int[] dp1 = new int[n + 2];
        int[] dp2 = new int[n + 2];

        dp1[0] = 1;

        for(int i = 1; i <= n; i++) {
            int x = Reader.nextInt();

            // previous mex = x + 1
            dp1[x + 1] = add(dp1[x + 1], dp1[x + 1]);   // 0 1 2 3  +3
            dp2[x + 1] = add(dp2[x + 1], dp2[x + 1]);   // 0 1 2 4  +2

            // previous mex = x
            dp1[x + 1] = add(dp1[x + 1], dp1[x]);       // 0 1 2 3  +4

            // previous mex = x - 1
            if(x > 0) {
                dp2[x - 1] = add(dp2[x - 1], dp2[x - 1]);  // 0 1 2 4 2  +4
                dp2[x - 1] = add(dp2[x - 1], dp1[x - 1]);
            }
        }

        for(int i = 0; i <= n + 1; i++) {
            ans = add(ans, dp1[i]);
            ans = add(ans, dp2[i]);
        }

        Writer.println(ans);
    }

    private int add(int x, int y) {
        return (x + y) % MOD;
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

        public static void print(int x) {
            pw.print(x);
        }

        public static void print(long x) {
            pw.print(x);
        }

        public static void println(String s) {
            pw.println(s);
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