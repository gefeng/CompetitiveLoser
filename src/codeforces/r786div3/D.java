package codeforces.r786div3;

import java.io.*;
import java.util.*;

public class D {
    void go() {
        int n = Reader.nextInt();
        int[] A = new int[n];

        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
        }

        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        String ans = "YES";
        if(n < 3) {
            ans = "YES";
        } else {
            for(int i = n - 1; i >= 0; i -= 2) {
                int x = A[i];
                int y = i - 1 >= 0 ? A[i - 1] : 0;

                if(x <= l && x <= r && y <= l && y <= r) {
                    l = x;
                    r = y;
                } else {
                    ans = "NO";
                    break;
                }
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