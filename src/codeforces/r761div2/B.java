package codeforces.r761div2;

import java.io.*;
import java.util.*;

public class B {
    private int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
    void go() {
        int n = Reader.nextInt();
        int a = 0;
        int b = 0;
        int c = 1;
        int x = n - 1;

        if(x % 2 == 1) {
            a = x / 2;
            b = a + 1;
        } else {
            if(x / 2 % 2 == 0) {
                a = x / 2 - 1;
                b = x / 2 + 1;
            } else {
                a = x / 2 - 2;
                b = x / 2 + 2;
            }
        }
        //Writer.print(gcd(a, b) + " ");
        Writer.print(a + " ");
        Writer.print(b + " ");
        Writer.print(c + "\n");
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