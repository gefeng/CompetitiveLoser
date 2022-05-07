package codeforces.r787div3;

import java.io.*;
import java.util.*;

public class C {
    void go() {
        String s = Reader.next();
        int n = s.length();
        int ans = 0;

        int tot0 = 0;
        int tot1 = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') {
                tot1++;
            } else if(s.charAt(i) == '0') {
                tot0++;
            }
        }

        int cnt0 = 0;
        int cnt1 = 0;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if(c == '1') {
                cnt1++;
                if(cnt1 == tot1) {
                    ans++;
                }
            } else if(c == '0') {
                cnt0++;
                if(cnt0 == 1) {
                    ans++;
                }
            } else {
                if(cnt1 == tot1 && cnt0 == 0) {
                    ans++;
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