package codeforces.r760div3;

import java.io.*;
import java.util.*;

public class B {
    void go() {
        int n = Reader.nextInt();
        String[] bigram = new String[n - 2];

        for(int i = 0; i < n - 2; i++) {
            bigram[i] = Reader.next();
        }

        String pre = bigram[0];
        StringBuilder sb = new StringBuilder();
        sb.append(pre);
        for(int i = 1; i < n - 2; i++) {
            String cur = bigram[i];
            if(pre.charAt(1) != cur.charAt(0)) {
                sb.append(cur.charAt(0));
            }
            sb.append(cur.charAt(1));
            pre = cur;
        }

        if(sb.length() != n) {
            sb.append('b');
        }

        Writer.println(sb.toString());
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