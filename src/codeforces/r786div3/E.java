package codeforces.r786div3;

import java.io.*;
import java.util.*;

public class E {
    private int min2(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        if((max + 1) / 2 >= min) {
            return (max + 1) / 2;
        } else {
            return (max + min + 2) / 3;
        }
    }
    private int min3(int a, int b, int c) {
        int cand1 = min2(a, b);
        int cand2 = min2(b, c);
        int cand3 = (a + c + 1) / 2;

        return Math.min(Math.min(cand1, cand2), cand3);
    }
    void go() {
        int n = Reader.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
        }

        int adj = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int m = (A[i] + 1) / 2;

            if(i == 0) {
                adj = Math.min(adj, min2(A[i], A[i + 1]));
            } else if(i == n - 1) {
                adj = Math.min(adj, min2(A[i], A[i - 1]));
            } else {
                adj = Math.min(adj, min3(A[i - 1], A[i], A[i + 1]));
            }

            if(m < min1) {
                min2 = min1;
                min1 = m;
            } else if(m < min2){
                min2 = m;
            }
        }

        Writer.println(Math.min(adj, min1 + min2));
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