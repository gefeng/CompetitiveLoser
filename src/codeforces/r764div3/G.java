package codeforces.r764div3;

import java.io.*;
import java.util.*;

public class G {
    void go() {
        int n = Reader.nextInt();
        int m = Reader.nextInt();

        List<int[]> edges = new ArrayList<>();
        int or = 0;
        int ans = 0;
        for(int i = 0; i < m; i++) {
            int[] e = new int[3];
            for(int j = 0; j < 3; j++) {
                e[j] = Reader.nextInt();
            }
            edges.add(e);
            or |= e[2];
        }

        ans = or;

        for(int i = 31; i >= 0; i--) {
            if((or & (1 << i)) == 0) continue;
            DJSet djs = new DJSet(n + 1);
            List<int[]> nedges = new ArrayList<>();
            for(int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                if((w & (1 << i)) == 0) {
                    djs.union(u, v);
                    nedges.add(e);
                }
            }

            if(djs.count() == 1) {
                edges = nedges;
                ans ^= (1 << i);
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
        new G().run();
    }

    private class DJSet {
        int[] p;
        int[] w;
        DJSet(int n) {
            p = new int[n];
            w = new int[n];
            Arrays.fill(p, -1);
            Arrays.fill(w, 1);
        }
        int find(int i) {
            if(p[i] < 0) return i;
            return p[i] = find(p[i]);
        }
        void union(int i, int j) {
            int x = find(i);
            int y = find(j);
            if(x == y) return;
            if(w[x] >= w[y]) {
                p[y] = x;
                w[x] += w[y];
            } else {
                p[x] = y;
                w[y] += w[x];
            }
        }
        int count() {
            int cnt = 0;
            for(int i = 1; i < p.length; i++) {
                if(p[i] < 0) cnt++;
            }
            return cnt;
        }
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