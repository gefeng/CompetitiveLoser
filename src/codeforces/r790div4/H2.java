package codeforces.r790div4;

import java.io.*;
import java.util.*;

public class H2 {
    private class BIT {
        int[] A;
        int n;
        BIT(int n) {
            this.n = n + 1;
            this.A = new int[n + 1];
        }
        void update(int i) {
            while(i < n) {
                A[i]++;
                i += (i & -i);
            }
        }
        int query(int i) {
            int sum = 0;
            while(i > 0) {
                sum += A[i];
                i -= (i & -i);
            }
            return sum;
        }
        int query(int i, int j) {
            return query(j) - query(i - 1);
        }
    }
    void go() {
        int n = Reader.nextInt();
        int[] A = new int[n + 1];
        BIT bit = new BIT(n);
        long ans = 0;

        for(int i = 1; i <= n; i++) {
            A[i] = Reader.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            ans += bit.query(A[i], n);
            bit.update(A[i]);
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
        new H2().run();
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