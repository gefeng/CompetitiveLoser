package kickstart.r2022B;

import java.io.*;
import java.util.*;

public class C {
    private long dfs(int[] A, int N, int D, int l, int r, int d, Long[][][] memo) {
        if(l > r) {
            return 0;
        }

        if(memo[l][r][d] != null) {
            return memo[l][r][d];
        }

        long k = 0;
        if(d == 0) {
            k = D - A[l - 1];
        } else if(d == 1) {
            k = D - A[r + 1];
        }

        long vl = (A[l] + k) % D;
        long vr = (A[r] + k) % D;

        long minl = Math.min(vl, D - vl);
        long minr = Math.min(vr, D - vr);

        long min = 0;
        long resl = dfs(A, N, D, l + 1, r, 0, memo) + minl;
        long resr = dfs(A, N, D, l, r - 1, 1, memo) + minr;

        min = Math.min(resl, resr);

        return memo[l][r][d] = min;
    }
    void go(int T) {
        int N = Reader.nextInt();
        int D = Reader.nextInt();
        int[] A = new int[N];
        long ans = 0;

        for(int i = 0; i < N; i++) {
            A[i] = Reader.nextInt();
        }

        ans = dfs(A, N, D, 0, N - 1, 2, new Long[N][N][3]);

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