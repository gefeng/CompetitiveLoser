package codeforces.r1613;

import java.io.*;
import java.util.*;

public class C {
    void go() {
        // add code
        int n = Reader.nextInt();
        long hp = Reader.nextLong();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Reader.nextInt();
        }

        long lo = 1;
        long hi = hp;
        long ans = hi;

        while(lo <= hi) {
            long mid = lo + hi >> 1;

            long tot = 0;
            long end = arr[0] + mid - 1;
            for(int i = 1; i < n; i++) {
                if(arr[i] <= end) {
                    tot += arr[i] - arr[i - 1];
                } else {
                    tot += mid;
                }
                end = arr[i] + mid - 1;
            }
            tot += mid;

            if(tot >= hp) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
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