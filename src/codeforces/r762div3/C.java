package codeforces.r762div3;

import java.io.*;
import java.util.*;

public class C {
    void go() {
        char[] a = Long.toString(Reader.nextLong()).toCharArray();
        char[] s = Long.toString(Reader.nextLong()).toCharArray();

        int m = a.length;
        int n = s.length;
        List<Integer> b = new ArrayList<>();

        int i = m - 1;
        int j = n - 1;
        while(j >= 0) {
            int x = i < 0 ? 0 : a[i] - '0';
            int y = s[j] - '0';

            if(x > y) {
                if(j > 0 && s[j - 1] == '1') {
                    y += 10;
                    j--;
                } else {
                    break;
                }
            }

            b.add(y - x);
            i--;
            j--;
        }
        if(i < 0 && j < 0) {
            long ans = 0;
            long base = 1;
            for(int d : b) {
                ans = ans + d * base;
                base *= 10;
            }
            Writer.println(ans);
        } else {
            Writer.println("-1");
        }
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