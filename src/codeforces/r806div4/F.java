package codeforces.r806div4;

import java.io.*;
import java.util.*;

public class F {
    void go() {
        int n = Reader.nextInt();
        int[] A = new int[n];
        
        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
        }

        long ans = 0;
        List<int[]> l = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(A[i] < i + 1) {
                int pos = bs(l, A[i]);
                ans += pos + 1;
                l.add(new int[] {A[i], i + 1});
            }
        }

        Writer.println(ans);
    }
    private int bs(List<int[]> l, int t) {
        int lo = 0;
        int hi = l.size() - 1;
        int res = -1;
        while(lo <= hi) {
            int mid = lo + hi >> 1;
            if(l.get(mid)[1] < t) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
    private class BIT {
        int[] bit;
        int n;
        BIT(int n) {
            this.n = n + 1;
            this.bit = new int[n + 1];
        }

        void update(int i) {
            i += 1;
            while(i < n) {
                bit[i] += 1;
                i += i & (-i);
            }
        }
        int query(int i) {
            int sum = 0;
            i += 1;
            while(i > 0) {
                sum += bit[i];
                i -= i & (-i);
            }
            return sum;
        }
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
        new F().run();
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
