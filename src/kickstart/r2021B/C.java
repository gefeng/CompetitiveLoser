package kickstart.r2021B;

import java.io.*;
import java.util.*;

public class C {
    private boolean isPrime(long x) {
        for(long i = 2; i * i <= x; i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
    void go(int T) {
        long Z = Reader.nextLong();
        long t = (long)Math.sqrt(Z);

        long p1 = 0;
        long p2 = 0;
        if(t * t == Z) {
            p1 = t - 1;
            p2 = t;
        } else {
            p1 = t;
            p2 = t + 1;
        }


        while(true) {
            if(isPrime(p1)) {
                break;
            }
            p1--;
        }

        while(true) {
            if(isPrime(p2)) {
                break;
            }
            p2++;
        }

        if(p1 * p2 > Z) {
            p2 = p1;
            p1 = p1 - 1;
            while(true) {
                if (isPrime(p1)) {
                    break;
                }
                p1--;
            }
        }

        Writer.println("Case #" + T + ": " + p1 * p2);
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
