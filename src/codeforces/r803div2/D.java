package codeforces.r803div2;

import java.io.*;
import java.util.*;

public class D {
    int[] q(int l, int r) {
        int len = r - l + 1;
        int[] res = new int[len];
        
        Writer.println("? " + l + " " + r);
        Writer.flush();

        for(int i = 0; i < len; i++) {
            res[i] = Reader.nextInt();
        }

        return res;
    }
    private int helper(int st, int ed) {
        if(st == ed) {
            return st;
        }

        int mid = st + ed >> 1;
        
        int[] seq = q(st, mid);

        int cnt = 0;
        int res = -1;
        for(int x : seq) {
            if(x >= st && x <= mid) {
                cnt += 1;
                res = x;
            }
        }

        if(cnt % 2 == 0) {
            return helper(mid + 1, ed);
        }

        return helper(st, mid);
    }
    void go() {
        int n = Reader.nextInt();
        Writer.println("! " + helper(1, n));
        Writer.flush();
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
        new D().run();
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
