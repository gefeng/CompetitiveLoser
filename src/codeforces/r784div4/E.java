package codeforces.r784div4;

import java.io.*;
import java.util.*;

public class E {
    void go() {
        int n = Reader.nextInt();
        String[] A = new String[n];
        Map<String, Integer> map = new HashMap<>();
        long ans = 0;

        for(int i = 0; i < n; i++) {
            A[i] = Reader.next();
        }

        for(String s : A) {
            char c1 = s.charAt(0);
            char c2 = s.charAt(1);
            for(char c = 'a'; c <= 'k'; c++) {
                if(c1 != c) {
                    String ss = "" + c + c2;
                    ans += map.getOrDefault(ss, 0);
                }
            }

            for(char c = 'a'; c <= 'k'; c++) {
                if(c2 != c) {
                    String ss = "" + c1 + c;
                    ans += map.getOrDefault(ss, 0);
                }
            }

            map.put(s, map.getOrDefault(s, 0) + 1);
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