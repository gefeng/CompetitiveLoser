package codeforces.r787div3;

import java.io.*;
import java.util.*;

public class E {
    void go() {
        int n = Reader.nextInt();
        int k = Reader.nextInt();
        String s = Reader.next();
        StringBuilder sb = new StringBuilder();

        if(k >= 25) {
            for(int i = 0; i < n; i++) {
                sb.append("a");
            }
        } else {
            int max = 0;
            int p = 0;
            while(p < n && s.charAt(p) - 'a' <= k) {
                max = Math.max(max, s.charAt(p++) - 'a');
                sb.append("a");
            }

            k -= max;
            for(int i = p; i < n; i++) {
                if(s.charAt(i) - 'a' <= max) {
                    sb.append("a");
                } else {
                    char t = (char)(s.charAt(p) - k);

                    if(s.charAt(i) > s.charAt(p) || s.charAt(i) < t) {
                        sb.append(s.charAt(i));
                    } else {
                        sb.append(t);
                    }
                }
            }
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