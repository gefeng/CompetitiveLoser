package codeforces.r790div4;

import java.io.*;
import java.util.*;

public class E {
    void go() {
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        int[] A = new int[n];
        int[][] Q = new int[m][2];
        int[] ans = new int[m];

        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
        }

        Arrays.sort(A);
        
        for(int i = 0; i < m; i++) {
            Q[i] = new int[] {Reader.nextInt(), i};
        }

        Arrays.sort(Q, Comparator.comparingInt(a -> a[0]));

        int sum = 0;
        int p = n - 1;
        for(int[] q : Q) {
            while(p >= 0 && sum < q[0]) {
                sum += A[p--];
            }

            if(sum >= q[0]) {
                ans[q[1]] = n - p - 1;
            } else {
                ans[q[1]] = -1;
            }
        }

        for(int i = 0; i < m; i++) {
            Writer.println(ans[i]);
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
        new E().run();
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