package codeforces.r1613;

import java.io.*;
import java.util.*;

public class B {
    /**
     * Observation:
     *  1. x % y < y which means if we pick the smallest number in the array as y, we are guarantied the remainder
     *  is not in the array.
     *  2. In addition, there is at least n - 1 pairs if we fix y with the smallest value in the array and n - 1 >= n / 2.
     *
     * Time:  O(N)
     * Space: O(N)
     * */
    void go() {
        int n = Reader.nextInt();
        int m = n / 2;
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int pos = -1;

        for(int i = 0; i < n; i++) {
            arr[i] = Reader.nextInt();
            if(arr[i] < min) {
                min = arr[i];
                pos = i;
            }
        }

        for(int i = 0; i < n; i++) {
            if(i != pos) {
                Writer.println(arr[i] + " " + min);
                m--;
                if(m == 0) {
                    break;
                }
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