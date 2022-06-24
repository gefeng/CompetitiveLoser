import java.io.*;
import java.util.*;

public class P3A {
    void go() {
        String s = Reader.next();
        String t = Reader.next();
        int[] dr = new int[] {0, 0, 1, -1, 1, 1, -1, -1};
        int[] dc = new int[] {-1, 1, 0, 0, 1, -1, -1, 1};
        String[] dn = new String[] {"L", "R", "U", "D", "RU", "LU", "LD", "RD"};
        
        List<String> seq = new ArrayList<>();

        int sx = s.charAt(0) - 'a';
        int sy = s.charAt(1) - '0'; 
        int tx = t.charAt(0) - 'a';
        int ty = t.charAt(1) - '0';
        int vx = tx - sx;
        int vy = ty - sy;
        int d = Math.min(Math.abs(vx), Math.abs(vy));
        if(d != 0) {
            for(int i = 4; i < 8; i++) {
                if(vx * dc[i] > 0 && vy * dr[i] > 0) {
                    for(int j = 0; j < d; j++) {
                        seq.add(dn[i]);
                        sx += dc[i];
                        sy += dr[i];
                    }
                    break;
                }
            }       
        }

        vx = tx - sx;
        vy = ty - sy;
        d = Math.max(Math.abs(vx), Math.abs(vy));
        if(d != 0) {
            for(int i = 0; i < 4; i++) {
                if(vx * dc[i] > 0 || vy * dr[i] > 0) {
                    for(int j = 0; j < d; j++) {
                        seq.add(dn[i]);
                    }
                    break;
                }        
            }
        }

        Writer.println(seq.size());
        for(String step : seq) {
            Writer.println(step);
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
        new P3A().run();
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
