package codeforces.r1613;

import java.io.*;
import java.util.*;

public class A {
    void go() {
        int x1 = Reader.nextInt();
        int p1 = Reader.nextInt();
        int x2 = Reader.nextInt();
        int p2 = Reader.nextInt();
        String res = "";
        while(true) {
            if(x1 % 10 == 0) {
                p1++;
                x1 /= 10;
            } else {
                break;
            }
        }

        while(true) {
            if(x2 % 10 == 0) {
                p2++;
                x2 /= 10;
            } else {
                break;
            }
        }

        if(x1 == x2) {
            if(p1 == p2) {
                res = "=";
            } else {
                res = p1 > p2 ? ">" : "<";
            }
        } else {
            int cnt1 = cntDigits(x1);
            int cnt2 = cntDigits(x2);

            if(cnt1 + p1 == cnt2 + p2) {
                res = Integer.toString(x1).compareTo(Integer.toString(x2)) > 0 ? ">" : "<";
            } else {
                res = cnt1 + p1 > cnt2 + p2 ? ">" : "<";
            }
        }
        Writer.println(res);
    }
    private int cntDigits(int x) {
        int cnt = 0;
        while(x != 0) {
            cnt++;
            x /= 10;
        }
        return cnt;
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