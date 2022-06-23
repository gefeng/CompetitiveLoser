package codeforces.r776div3;

import java.io.*;
import java.util.*;

public class C {
    void go() {
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        int[][] A = new int[m][3];

        for(int i = 0; i < m; i++) {
            A[i] = new int[] {i, Reader.nextInt(), Reader.nextInt()};
        }

        Arrays.sort(A, Comparator.comparingInt(a -> a[2]));         

        int[][] B = new int[n * 2][3];
        long sum = 0;
        for(int i = 0; i < 2 * n; i++) {
            B[i] = A[i];
            sum += B[i][2];
        }

        Arrays.sort(B, Comparator.comparingInt(a -> a[1]));

        Writer.println(sum);
        for(int i = 0; i < n; i++) {
            int l = B[i][0] + 1;
            int r = B[2 * n - i - 1][0] + 1;
            Writer.println(l + " " + r);
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
