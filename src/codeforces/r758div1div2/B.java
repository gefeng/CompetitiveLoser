package codeforces.r758div1div2;

import java.io.*;
import java.util.*;

public class B {
    void go() {
        // add code
        int n = Reader.nextInt();
        int a = Reader.nextInt();
        int b = Reader.nextInt();

        if(2 * a + 1 > n || 2 * b + 1 > n || a + b + 2 > n || Math.abs(a - b) > 1) {
            Writer.print(-1 + "\n");
            return;
        }

        int[] arr = new int[n];
        int l = 0;
        int r = n - 1;
        int st1 = 0;
        int st2 = 0;
        if(a >= b) {
            st1 = 1;
            st2 = 2;
        }  else {
            st1 = 2;
            st2 = 1;
        }

        for(int i = 0; i < b; i++, l++) {
            arr[2 * i + st2] = l + 1;
        }

        for(int i = 0; i < a; i++, r--) {
            arr[2 * i + st1] = r + 1;
        }

        if(a > b) {
            for(int i = 0; i < n; i++) {
                if(arr[i] == 0) {
                    arr[i] = r + 1;
                    r--;
                }
            }
        } else {
            for(int i = 0; i < n; i++) {
                if(arr[i] == 0) {
                    arr[i] = l + 1;
                    l++;
                }
            }
        }


        for(int i = 0; i < n - 1; i++) {
            Writer.print(arr[i] + " ");
        }
        Writer.print(arr[n - 1] + "\n");
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