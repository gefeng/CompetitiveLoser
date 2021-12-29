package codeforces.r762div3;

import java.io.*;
import java.util.*;

public class E {
    private int upperBound(int[] arr, int t) {
        int lo = 0;
        int hi = arr.length - 1;
        int idx = arr.length;
        while(lo <= hi) {
            int mid = lo + hi >> 1;
            if(arr[mid] > t) {
                idx = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return idx;
    }
    private int lowerBound(int[] arr, int t) {
        int lo = 0;
        int hi = arr.length - 1;
        int idx = -1;
        while(lo <= hi) {
            int mid = lo + hi >> 1;
            if(arr[mid] < t) {
                idx = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return idx;
    }
    void go() {
        int n = Reader.nextInt();
        int[] arr = new int[n];
        int[] ans = new int[n + 1];
        Arrays.fill(ans, -1);

        for(int i = 0; i < n; i++) {
            arr[i] = Reader.nextInt();
        }

        Arrays.sort(arr);

        boolean gap = false;
        for(int i = 0; i <= n; i++) {
            String padding = i == n ? "\n" : " ";

            if(gap) {
                Writer.print("-1" + padding);
            } else {
                int lb = lowerBound(arr, i);
                int ub = upperBound(arr, i);

                if(i < n && arr[i] > i) {
                    gap = true;
                }

                Writer.print((ub - lb - 1) + padding);
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

        public static void println(long x) {
            pw.println(x);
        }

        public static void close() {
            pw.close();
        }
    }
}