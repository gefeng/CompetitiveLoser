package codeforces.r802div2;

import java.io.*;
import java.util.*;

public class B {
    void go() {
        int n = Reader.nextInt();        
        String s = Reader.next();

        for(int len = n; len < n + 2; len++) {
            for(int i = 1; i < 10; i++) {
                String t = getPal(len, i);

                if(isGreater(t, s)) {
                    String x = sub(s, t);
                    if(x.length() == n) {
                        Writer.println(x);
                        return;
                    }
                }
            }
        }
    }

    private String getPal(int len, int d) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            sb.append(d);
        }
        return sb.toString();
    }

    private boolean isGreater(String t, String s) {
        if(t.length() > s.length()) {
            return true;
        }
        int n = s.length();
        for(int i = 0; i <n; i++) {
            if(t.charAt(i) > s.charAt(i)) {
                return true;
            }
            if(t.charAt(i) < s.charAt(i)) {
                return false;
            }
        }
        return false;
    }

    private String sub(String s, String t) {
        int c = 0;
        int n = t.length();
        int m = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i = n - 1, j = m - 1; i >= 0; i--, j--) {
            int x = t.charAt(i) - '0';
            int y = j < 0 ? 0 : s.charAt(j) - '0'; 

            x = (x - c + 10) % 10;
            if(x < y) {
                c = 1;
                x = x + 10;
            } else {
                c = 0;
            }

            sb.append(x - y);
        }
        
        int p = sb.length() - 1;
        while(p >= 0 && sb.charAt(p) == '0') {
            sb.deleteCharAt(p);
            p--;
        }
        return sb.reverse().toString();
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
