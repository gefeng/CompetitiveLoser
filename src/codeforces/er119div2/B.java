package codeforces.er119div2;

import java.io.*;
import java.util.*;

public class B {
    void go() {
        int w = Reader.nextInt();
        int h = Reader.nextInt();
        int k = Reader.nextInt();
        long ans = 0;

        int[][] hp1 = new int[k][2];
        for(int i = 0; i < k; i++) {
            hp1[i][0] = Reader.nextInt();
            hp1[i][1] = 0;
        }

        ans = Math.max(ans, ((long)hp1[k - 1][0] - hp1[0][0]) * h);

        k = Reader.nextInt();
        int[][] hp2 = new int[k][2];
        for(int i = 0; i < k; i++) {
            hp2[i][0] = Reader.nextInt();
            hp2[i][1] = h;
        }

        ans = Math.max(ans, ((long)hp2[k - 1][0] - hp2[0][0]) * h);

        k = Reader.nextInt();
        int[][] vp1 = new int[k][2];
        for(int i = 0; i < k; i++) {
            vp1[i][0] = 0;
            vp1[i][1] = Reader.nextInt();
        }

        ans = Math.max(ans, ((long)vp1[k - 1][1] - vp1[0][1]) * w);

        k = Reader.nextInt();
        int[][] vp2 = new int[k][2];
        for(int i = 0; i < k; i++) {
            vp2[i][0] = w;
            vp2[i][1] = Reader.nextInt();
        }

        ans = Math.max(ans, ((long)vp2[k - 1][1] - vp2[0][1]) * w);

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