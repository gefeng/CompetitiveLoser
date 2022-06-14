import java.io.*;
import java.util.*;

public class C {
    void go() {
        char[][] g = new char[8][8];
        for(int i = 0; i < 8; i++) {
            String s = Reader.next();
            for(int j = 0; j < 8; j++) {
                g[i][j] = s.charAt(j);
            }
        }
        
        int[] dr = {1, 1, -1, -1};
        int[] dc = {1, -1, 1, -1};
        for(int i = 1; i < 7; i++) {
            for(int j = 1; j < 7; j++) {
                if(g[i][j] == '#') {
                    boolean is = true;
                    for(int k = 0; k < 4; k++) {
                        int r = i;
                        int c = j;
                        while(r >= 0 && c >= 0 && r < 8 && c < 8) {
                            if(g[r][c] != '#') {
                                is = false;
                                break;
                            }
                            r += dr[k];
                            c += dc[k];
                        }
                        if(!is) {
                            break;
                        }
                    }
                    if(is) {
                        Writer.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }
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
