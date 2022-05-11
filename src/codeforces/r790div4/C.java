package codeforces.r790div4;

import java.io.*;
import java.util.*;

public class C {
    void go() {
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        String[] A = new String[n];
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            A[i] = Reader.next();
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                String s1 = A[i];
                String s2 = A[j];
                int d = 0;
                for(int k = 0; k < m; k++) {
                    if(s1.charAt(k) < s2.charAt(k)) {
                        d += s2.charAt(k) - s1.charAt(k);
                    } else {
                        d += s1.charAt(k) - s2.charAt(k);
                    }
                }

                ans = Math.min(ans, d);
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