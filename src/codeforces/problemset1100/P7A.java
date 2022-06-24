import java.io.*;
import java.util.*;

public class P7A {
    void go() {
        int[][] g = new int[8][8];
        int cnt = 0;
        for(int i = 0; i < 8; i++) {
            String s = Reader.next();
            for(int j = 0; j < 8; j++) {
                g[i][j] = s.charAt(j) == 'W' ? 0 : 1;
            }
            if(s.equals("BBBBBBBB")) {
                cnt++;
            }
        }

        if(cnt < 8) {
            for(int i = 0; i < 8; i++) {
                boolean paint = true;
                for(int j = 0; j < 8; j++) {
                    if(g[j][i] == 0) {
                        paint = false;
                        break;
                    } 
                } 
                if(paint) {
                    cnt++;
                }
            }
        }

        Writer.println(cnt);
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
        new P7A().run();
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
