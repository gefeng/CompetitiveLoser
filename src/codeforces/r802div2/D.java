package codeforces.r802div2;

import java.io.*;
import java.util.*;

public class D {
    void go() {
        int n = Reader.nextInt();
        int A[] = new int[n];

        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
        }

        int m = Reader.nextInt();
        int[] Q = new int[m];
        
        for(int i = 0; i < m; i++) {
            Q[i] = Reader.nextInt();
        }

        long[] psum = new long[n + 1];
        long[] dp = new long[n + 1]; // time takes to fill first i locks by opening first i pipes
        for(int i = 1; i <= n; i++) {
            psum[i] = psum[i - 1] + A[i - 1];
        }

        dp[0] = -1;
        for(int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], (psum[i] + i - 1) / i);
        } 

        for(int i = 0; i < m; i++) {
            int q = Q[i];
            int lo = 1;
            int hi = n;
            int res = -1;
            while(lo <= hi) {
                int mid = lo + hi >> 1;
                
                long need = Math.max(dp[mid], (psum[n] + mid - 1) / mid);
                if(need <= q) {
                    res = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            Writer.println(res);
        }     
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
