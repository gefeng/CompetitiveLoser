import java.io.*;
import java.util.*;

public class P43B {
    void go() {
        String s = Reader.nextLine();
        String t = Reader.nextLine();
        int n = s.length();
        int m = t.length();
        int[] f = new int[128];
        String ans = "YES";

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c != ' ') {
                f[c] += 1;
            }
        }

        for(int i = 0; i < m; i++) {
            char c = t.charAt(i);
            if(c != ' ') {
                if(--f[c] < 0) {
                    ans = "NO";
                    break;
                }
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
        new P43B().run();
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

        public static String nextLine() {
            String s = "";
            try {
                s = br.readLine(); 
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            return s;
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
