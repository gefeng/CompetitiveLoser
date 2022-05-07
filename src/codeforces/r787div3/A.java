package codeforces.r787div3;

import java.io.*;
import java.util.*;

public class A {
    void go() {
        int a = Reader.nextInt();
        int b = Reader.nextInt();
        int c = Reader.nextInt();
        int x = Reader.nextInt();
        int y = Reader.nextInt();

        boolean dog = false;
        boolean cat = false;

        if(a >= x) {
            dog = true;
        } else {
            x -= a;
            if(c >= x) {
                dog = true;
                c -= x;
            } else {
                dog = false;
                c = 0;
            }
        }

        if(b >= y) {
            cat = true;
        } else {
            y -= b;
            if(c >= y) {
                cat = true;
                c -= y;
            } else {
                cat = false;
                c = 0;
            }
        }

        Writer.println(dog && cat ? "YES" : "NO");
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
        new A().run();
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