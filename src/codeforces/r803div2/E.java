package codeforces.r803div2;

import java.io.*;
import java.util.*;

public class E {
    void go() {
        int n = Reader.nextInt();
        int s = Reader.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        int[] SP = new int[n + 1]; // for each [1..n] it's original position in A
        int[] TP = new int[n + 1]; // for each [1..n] it's target position in B
        long mod = 998244353;
        long ans = 0;

        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
            SP[A[i]] = i;
        }

        Arrays.fill(TP, -1);
        for(int i = 0; i < n; i++) {
            B[i] = Reader.nextInt();
            if(B[i] != -1) {
                TP[B[i]] = i;
            }
        } 

        boolean isOk = true;
        for(int i = 1; i <= n; i++) {
            if(TP[i] != -1) {
                if(A[TP[i]] > i && A[TP[i]] - i > s) {
                    isOk = false;
                    break;
                }
            } 
        }
        
        if(isOk) {
            ans = 1;
            int cnt = 0;
            for(int i = 1, j = 1; i <= n; i++) {
                if(TP[i] == -1) {
                    while(j <= n && (B[SP[j]] != -1 || i + s >= j)) {
                        cnt += B[SP[j]] == -1 ? 1 : 0;
                        j++;
                    }
                    ans = ans * cnt % mod;
                    cnt -= 1;
                }
            }
        }

        Writer.println(isOk ? ans : 0);
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
