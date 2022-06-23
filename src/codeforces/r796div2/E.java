package codeforces.r796div2;

import java.io.*;
import java.util.*;

public class E {
    private int q(String s) {
        Writer.println("? " + s);
        Writer.flush();
        return Reader.nextInt();
    }
    void go() {
		int n = Reader.nextInt();
		int m = Reader.nextInt();
        int ans = 0;
        
        int[][] E = new int[m][2];
         
        for(int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < m; j++) {
                sb.append(i == j ? "1" : "0");
            }
            
            E[i] = new int[] {q(sb.toString()), i};
        }

        Arrays.sort(E, Comparator.comparingInt(a -> a[0]));

        char[] s = new char[m];
        Arrays.fill(s, '0');

        int pre = -1;
        for(int i = 0; i < m; i++) {
            int[] e = E[i];
            
            s[e[1]] = '1';

            int res = q(new String(s));
            if(pre == -1 || res - pre == e[0]) {
                ans += e[0];
            }
            pre = res;
        }

        Writer.println("! " + ans);
        Writer.flush();
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
        new E().run();
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
