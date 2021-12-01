package codeforces.r1609;

import java.io.*;
import java.util.*;

public class B {
    void go() {
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        char[] s = Reader.next().toCharArray();

        int tot = 0;
        for(int i = 0; i < n; i++) {
            if(i > 0 && i < n - 1) {
                if(s[i - 1] == 'a' && s[i] == 'b' && s[i + 1] == 'c') {
                    tot++;
                }
            }
        }
        // abcabc
        for(int i = 0; i < m; i++) {
            int pos = Reader.nextInt() - 1;
            char c = Reader.next().charAt(0);

            if(s[pos] != c) {
                if (s[pos] == 'a' && pos + 2 < n && s[pos + 1] == 'b' && s[pos + 2] == 'c') {
                    tot--;
                }
                if (s[pos] == 'b' && pos + 1 < n && pos - 1 >= 0 && s[pos - 1] == 'a' && s[pos + 1] == 'c') {
                    tot--;
                }
                if (s[pos] == 'c' && pos - 2 >= 0 && s[pos - 1] == 'b' && s[pos - 2] == 'a') {
                    tot--;
                }

                if (c == 'a' && pos + 2 < n && s[pos + 1] == 'b' && s[pos + 2] == 'c') {
                    tot++;
                }
                if (c == 'b' && pos + 1 < n && pos - 1 >= 0 && s[pos - 1] == 'a' && s[pos + 1] == 'c') {
                    tot++;
                }
                if (c == 'c' && pos - 2 >= 0 && s[pos - 1] == 'b' && s[pos - 2] == 'a') {
                    tot++;
                }
            }

            s[pos] = c;
            Writer.println(tot);
        }
    }
    void solve() {
        go();
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
