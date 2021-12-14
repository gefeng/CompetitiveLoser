package codeforces.r758div1div2;

import java.io.*;
import java.util.*;

public class C {
    void go() {
        // add code
        int n = Reader.nextInt();
        int[][] s1 = new int[n][2];
        int[] s2 = new int[n];

        for(int i = 0; i < n; i++) {
            s1[i][0] = Reader.nextInt();
            s1[i][1] = i;
        }
        for(int i = 0; i < n; i++) {
            s2[i] = Reader.nextInt();
        }

        Arrays.sort(s1, Comparator.comparingInt(a -> a[0]));

        int[] l = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            int idx = s1[i][1];
            max = Math.max(max, s2[idx]);
            l[i] = max;
        }

        int[] ans = new int[n];
        int min = s2[s1[n - 1][1]];
        ans[s1[n - 1][1]] = 1;
        for(int i = n - 2; i >= 0; i--) {
            int idx = s1[i][1];
            if(l[i] > min) ans[idx] = 1;
            min = Math.min(min, s2[idx]);
        }

        for(int i = 0; i < n; i++) {
            Writer.print(ans[i]);
        }
        Writer.print("\n");
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

        public static void println(long x) {
            pw.println(x);
        }

        public static void close() {
            pw.close();
        }
    }
}