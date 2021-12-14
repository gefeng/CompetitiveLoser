package codeforces.r760div3;

import java.io.*;
import java.util.*;

public class C {
    long gcd(long a, long b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
    void go() {
        int n = Reader.nextInt();
        long[] arr = new long[n];
        long d = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = Reader.nextLong();
        }

        long gcd1 = arr[0];
        long gcd2 = arr[1];
        for(int i = 2; i < n; i++) {
            if(i % 2 == 0) gcd1 = gcd(gcd1, arr[i]);
            else gcd2 = gcd(gcd2, arr[i]);
        }
        boolean ok1 = true;
        boolean ok2 = true;
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0 && arr[i] % gcd2 == 0) {
                ok2 = false;
            }
            if(i % 2 != 0 && arr[i] % gcd1 == 0) {
                ok1 = false;
            }
        }

        if(ok1) Writer.println(gcd1);
        else if(ok2) Writer.println(gcd2);
        else Writer.println(0);
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