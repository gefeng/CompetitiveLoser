package codeforces.r776div3;

import java.io.*;
import java.util.*;

public class E {
    void go() {
        int n = Reader.nextInt();
        int d = Reader.nextInt();
        int[] A = new int[n];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
        }

        int min = d;
        int minPos = -1;
        int pre = 0;
        for(int i = 0; i < n; i++) {
            int u = A[i] - pre - 1;
            if(u < min) {
                min = u;
                minPos = i;
            }
            pre = A[i];
        }

        int gap = move(A, d, minPos);
        if(minPos > 0) {
            gap = Math.max(gap, move(A, d, minPos - 1));
        }
        
        Writer.println(gap);
    }
    
    private int move(int[] A, int d, int minPos) {
        int n = A.length;
        int pre = 0;
        int min = d;
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(i == minPos) {
                continue;
            }
            int u = A[i] - pre - 1;
            min = Math.min(min, u);
            max = Math.max(max, u);
            pre = A[i];
        }
        
        int gap = (max - 1) / 2;
        gap = Math.max(gap, d - pre - 1); 

        return Math.min(min, gap);
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
