import java.io.*;
import java.util.*;

public class P46B {
    void go() {
        int[] f = new int[5];
        String[] map = new String[] {"S", "M", "L", "XL", "XXL"};

        for(int i = 0; i < 5; i++) {
            f[i] = Reader.nextInt();
        }

        int k = Reader.nextInt();
        String[] s = new String[k];

        for(int i = 0; i < k; i++) {
            s[i] = Reader.next();
        }

        for(int i = 0; i < k; i++) {
            int j = 0;
            String sz = "";
            if(s[i].equals("S")) j = 0;
            else if(s[i].equals("M")) j = 1;
            else if(s[i].equals("L")) j = 2;
            else if(s[i].equals("XL")) j = 3;
            else j = 4;

            if(f[j] == 0) {
                for(int d = 1; d < 5; d++) {
                    int l = j - d;
                    int r = j + d;
                    if(r < 5 && f[r] != 0) {
                        f[r] -= 1;
                        sz = map[r];
                        break;
                    }
                    if(l >= 0 && f[l] != 0) {
                        f[l] -= 1;
                        sz = map[l];
                        break;
                    }
                }
            } else {
                f[j] -= 1;
                sz = s[i];
            }

            Writer.println(sz);
        }
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
        new P46B().run();
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
