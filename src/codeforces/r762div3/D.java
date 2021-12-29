package codeforces.r762div3;

import java.io.*;
import java.util.*;

public class D {
    private boolean isOk(long[][] g, int m, int n, long min) {
        int atMost = Math.min(n - 1, m);
        int cnt = 0;
        Set<Integer> shops = new HashSet<>();

        for(int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < m; j++) {
                if(g[j][i] >= min) {
                    set.add(j);
                }
            }
            if(set.isEmpty()) return false;

            boolean needMore = true;
            for(int x : set) {
                if(shops.contains(x)) {
                    needMore = false;
                    break;
                }
            }
            if(needMore) {
                shops.addAll(set);
                cnt++;
            }
        }

        return cnt <= Math.min(n - 1, m);
    }
    void go() {
        //Reader.next();
        int m = Reader.nextInt();
        int n = Reader.nextInt();
        long[][] g = new long[m][n];
        //Writer.println(m + " " + n);
        long lo = Long.MAX_VALUE;
        long hi = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                g[i][j] = Reader.nextLong();
                lo = Math.min(lo, g[i][j]);
                hi = Math.max(hi, g[i][j]);
            }
        }
        //System.out.println(lo + " " + hi);
        long ans = 0;
        while(lo <= hi) {
            long mid = lo + hi >> 1;

            if(isOk(g, m, n, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
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

        public static void println(long x) {
            pw.println(x);
        }

        public static void close() {
            pw.close();
        }
    }
}