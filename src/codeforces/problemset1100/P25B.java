import java.io.*;
import java.util.*;

public class P25B {
    void go() {
        int n = Reader.nextInt();
        String s = Reader.next();
        StringBuilder sb = new StringBuilder();
        
        int a = n % 2 == 0 ? n / 2 : (n - 3) / 2;
        int b = n % 2 == 0 ? 0 : 1;

        for(int i = 0; i < a; i++) {
            sb.append(s.charAt(i * 2));
            sb.append(s.charAt(i * 2 + 1));
            sb.append('-');
        }

        if(b == 1) {
            sb.append(s.substring(n - 3));
        } else {
            sb.deleteCharAt(sb.length() - 1);
        }
        Writer.println(sb.toString());
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
        new P25B().run();
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
