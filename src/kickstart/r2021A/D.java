package kickstart.r2021A;

import java.io.*;
import java.util.*;

public class D {
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
            if(p[i] < 0) {
                return i;
            }

            return find(p[i]);
        }

        void union(int i, int j) {
            int x = find(i);
            int y = find(j);
            if(x == y) {
                return;
            }

            if(w[x] >= w[y]) {
                p[y] = x;
                w[x] += w[y];
            } else {
                p[x] = y;
                w[y] += w[x];
            }
        }
    }
    void go(int T) {
        int n = Reader.nextInt();
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[] R = new int[n];
        int[] C = new int[n];
        int ans = 0;
        DJSet djs = new DJSet(2 * n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                A[i][j] = Reader.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                B[i][j] = Reader.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            R[i] = Reader.nextInt();
        }

        for(int i = 0; i < n; i++) {
            C[i] = Reader.nextInt();
        }

        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == -1) {
                    edges.add(new int[] {i, j, B[i][j]});
                    ans += B[i][j];
                }
            }
        }

        Collections.sort(edges, Comparator.comparing(a -> a[2], Comparator.reverseOrder()));

        for(int[] e : edges) {
            int u = e[0];
            int v = e[1] + n;
            if(djs.find(u) == djs.find(v)) {
                continue;
            }
            ans -= e[2];
            djs.union(u, v);
        }

        Writer.println("Case #" + T + ": " + ans);
    }
    void solve() {
        int T = Reader.nextInt();
        for(int i = 1; i <= T; i++) go(i);
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
