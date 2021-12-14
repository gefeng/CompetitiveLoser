package codeforces.r757div2;

import java.io.*;
import java.util.*;

public class B {
    void go() {
        // add code
        int n = Reader.nextInt();
        int[][] vis = new int[n][2];

        for(int i = 0; i < n; i++) {
            vis[i][0] = Reader.nextInt();
            vis[i][1] = i + 1;
        }

        Arrays.sort(vis, Comparator.comparing(a -> a[0], Comparator.reverseOrder()));

        long t = 0;
        int[] ans = new int[n + 1];
        long offset = 1;
        for(int i = 0; i < n; i += 2, offset++) {
            ans[vis[i][1]] = (int)offset;

            t += 2 * offset * vis[i][0];

            if(i + 1 < n) {
                ans[vis[i + 1][1]] = -(int)offset;
                t += 2 * offset * vis[i + 1][0];
            }
        }

        Writer.println(t);
        for(int i = 0; i <= n; i++) {
            if(i == n) Writer.print(ans[i] + "\n");
            else Writer.print(ans[i] + " ");
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
        new B().run();
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