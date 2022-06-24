import java.io.*;
import java.util.*;

public class P14B {
    void go() {
        int n = Reader.nextInt();
        int st = Reader.nextInt();
        int l = 0;
        int r = 1000;
        int ans = 0; 
        for(int i = 0; i < n; i++) {
            int a = Reader.nextInt();
            int b = Reader.nextInt();

            if(a > b) {
                int c = a;
                a = b;
                b = c;
            }
            if(a > r || b < l) {
                l = -1;
                r = -1;
                break;
            }

            l = Math.max(l, a);
            r = Math.min(r, b);
        }

        if(l == -1) {
            ans = -1;
        } else {
            if(st < l || st > r) {
                ans = Math.min(Math.abs(st - l), Math.abs(st - r));
            } else {
                ans = 0;
            }
        }
        Writer.println(ans);
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
        new P14B().run();
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

            public static void flush() {
                pw.flush();
            }

            public static void close() {
                pw.close();
            }
        }
}
