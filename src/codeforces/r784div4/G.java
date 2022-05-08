package codeforces.r784div4;

import java.io.*;
import java.util.*;

public class G {
    void go() {
        int m = Reader.nextInt();
        int n = Reader.nextInt();
        char[][] g = new char[m][n];

        for(int i = 0; i < m; i++) {
            String s = Reader.next();
            for(int j = 0; j < n; j++) {
                g[i][j] = s.charAt(j);
            }
        }

        for(int i = m - 2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                if(g[i][j] == '*') {
                    int k = i;
                    while(k + 1 < m && g[k + 1][j] == '.') {
                        k++;
                    }

                    g[i][j] = '.';
                    g[k][j] = '*';
                }
            }
        }

        for(int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(g[i][j]);
            }
            Writer.println(sb.toString());
        }
        Writer.print("\n");
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
        new G().run();
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