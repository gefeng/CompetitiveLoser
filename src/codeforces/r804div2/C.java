package codeforces.r804div2;

import java.io.*;
import java.util.*;

public class C {
    void go() {
        int n = Reader.nextInt();
        int[] A = new int[n];
        int[] P = new int[n];
        int l = -1;
        int r = -1;
        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
            if(A[i] == 0 || A[i] == 1) {
                if(l == -1) {
                    l = i;
                } else {
                    r = i;
                }
            }

            P[A[i]] = i;
        }
        
        if(n < 3) {
            Writer.println(1);
            return;
        }

        long mod = (long)1e9 + 7;
        long ans = 1; 
        int fixed = 2;
        List<Integer> slots = new ArrayList<>();
        for(int i = 2; i < n; i++) {
            int p = P[i];
            
            if(p > l && p < r) {
                slots.add(r - l + 1 - fixed);
            } else {
                l = Math.min(l, p);
                r = Math.max(r, p);
                fixed += 1;
            }
        }

        int used = 0;
        for(int slot : slots) {
            ans = ans * (slot - used) % mod;
            used += 1;
        }

        Writer.println(ans);
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
