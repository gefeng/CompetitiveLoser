package kickstart.r2022B;

import java.io.*;
import java.util.*;

public class B {
    private void gen(int t, int len, long l, long r, long d, List<Long> pal) {
        if(len == t / 2) {
            if(t % 2 == 0) {
                pal.add(l * d + r);
            } else {
                for(int i = 0; i < 10; i++) {
                    pal.add(l * d * 10 + i * d + r);
                }
            }

            return;
        }

        int st = len == 0 ? 1 : 0;
        for(int i = st; i < 10; i++) {
            gen(t, len + 1, l * 10 + i, i * d + r, d * 10, pal);
        }
    }
    void go(int T) {
        long A = Reader.nextLong();
        long ans = 0;

        List<Long> pal = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            gen(i, 0, 0, 0, 1, pal);
        }

        for(long f : pal) {
            if(f == 0) {
                continue;
            }
            if(f > A) {
                break;
            }

            if(A % f == 0) {
                ans++;
            }
        }

        Writer.println("Case #" + T + ": " + ans);
    }
    void solve() {
        int T = Reader.nextInt();
        for(int i = 1; i <= T; i++) go(i);
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