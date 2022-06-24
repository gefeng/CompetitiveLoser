import java.io.*;
import java.util.*;

public class P6B {
    void go() {
        int m = Reader.nextInt();
        int n = Reader.nextInt();
        int p = Reader.next().charAt(0) - 'A';
        int[][] g = new int[m][n];
        int[] dr = new int[] {1, -1, 0, 0};
        int[] dc = new int[] {0, 0, 1, -1};
        boolean[] adj = new boolean[26];

        for(int i = 0; i < m; i++) {
            String s = Reader.next();
            for(int j = 0; j < n; j++) {
                g[i][j] = s.charAt(j) - 'A'; 
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(g[i][j] == p) {
                    for(int k = 0; k < 4; k++) {
                        int ni = i + dr[k];
                        int nj = j + dc[k];
                        if(ni >= 0 && nj >= 0 && ni < m && nj < n && g[ni][nj] != '.' - 'A' && g[ni][nj] != p) {
                            adj[g[ni][nj]] = true;
                        }
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < 26; i++) {
            ans += adj[i] ? 1 : 0;
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
        new P6B().run();
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
