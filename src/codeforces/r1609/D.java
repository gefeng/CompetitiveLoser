package codeforces.r1609;

import java.io.*;
import java.util.*;

public class D {
    void go() {
        int n = Reader.nextInt();
        int d = Reader.nextInt();
        int[][] edges = new int[d][2];
        DSU dsu = new DSU(n + 1);

        for(int i = 0; i < d; i++) {
            edges[i][0] = Reader.nextInt();
            edges[i][1] = Reader.nextInt();
        }

        int free = 0;
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int cnt = 0;

            if(dsu.find(u) == dsu.find(v)) {
                free++;
            } else {
                dsu.union(u, v);
            }

            Map<Integer, Integer> map = new HashMap<>();
            if(free == 0) {
                for(int i = 1; i <= n; i++) {
                    int p = dsu.find(i);
                    map.put(p, map.getOrDefault(p, 0) + 1);
                    cnt = Math.max(cnt, map.get(p));
                }
            } else {
                for(int i = 1; i <= n; i++) {
                    map.put(dsu.find(i), map.getOrDefault(dsu.find(i), 0) + 1);
                }

                Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
                for(int val : map.values()) {
                    pq.offer(val);
                }

                for(int i = 0; i <= free; i++) {
                    cnt += pq.poll();
                }
            }

            Writer.println(cnt - 1);
        }
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

    private class DSU {
        private int[] p;
        private int[] w;
        private int n;
        DSU(int n) {
            this.n = n;
            p = new int[n];
            w = new int[n];
            Arrays.fill(p, -1);
        }
        private int find(int i) {
            if(p[i] < 0) return i;
            return p[i] = find(p[i]);
        }
        private void union(int i, int j) {
            int x = find(i);
            int y = find(j);
            if(x == y) return;
            if(w[x] == w[y]) {
                p[y] = x;
                w[x] += 1;
            } else if(w[x] > w[y]) {
                p[y] = x;
            } else {
                p[x] = y;
            }
        }
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

        public static void print(int x) {
            pw.print(x);
        }

        public static void print(long x) {
            pw.print(x);
        }

        public static void println(String s) {
            pw.println(s);
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