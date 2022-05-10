package codeforces.r789div2;

import java.io.*;
import java.util.*;

public class D {
    void go() {
        int m = Reader.nextInt();
        int n = Reader.nextInt();
        String s = Reader.next();
        boolean[] col = new boolean[n];
        Queue<Integer> row = new ArrayDeque<>();
        int[] dp = new int[m * n];
        int cntRow = 0;
        int cntCol = 0;

        for(int i = 0; i < m * n; i++) {
            int c = s.charAt(i) - '0';

            if(c == 1 && !col[i % n]) {
                col[i % n] = true;
                cntCol++;
            }

            row.offer(c);
            if(c == 1) {
                cntRow++;
            }
            if(row.size() > n) {
                cntRow -= row.poll();
            }

            if(i > n - 1) {
                dp[i] = dp[i - n] + (cntRow > 0 ? 1 : 0);
            } else {
                dp[i] = cntRow > 0 ? 1 : 0;
            }

            if(i == m * n - 1) {
                Writer.print(cntCol + dp[i] + "\n");
            } else {
                Writer.print(cntCol + dp[i] + " ");
            }

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