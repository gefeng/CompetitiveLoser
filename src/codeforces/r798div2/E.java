package codeforces.r798div2;

import java.io.*;
import java.util.*;

public class E {
    void go() {
        int n = Reader.nextInt();
        int[] A = new int[n];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
            if(A[i] == 0) {
                A[i]++;
                ans++;
            }
        }

        UF uf = new UF(30);
        int[][] g = new int[30][30];
        int max = 0;
        for(int i = 0; i < n; i++) {
            int x = A[i];
            int lsb = x & -x;
            max = Math.max(max, lsb);
            addEdge(g, x);
        } 

        if(!isConnect(g)) {
            ans += 1;
            boolean isOk = false;
            for(int i = 0; i < n; i++) {
                if((A[i] & -A[i]) == max) {
                    removeEdge(g, A[i]);
                    addEdge(g, --A[i]);
                    if(isConnect(g)) {
                        isOk = true;
                        break;
                    }
                    removeEdge(g, A[i]);
                    addEdge(g, ++A[i]);
                }
            }

            if(!isOk) {
                for(int i = 0; i < n; i++) {
                    if((A[i] & -A[i]) == max) {
                        removeEdge(g, A[i]);
                        addEdge(g, ++A[i]);
                        if(isConnect(g)) {
                            isOk = true;
                            break;
                        }
                        removeEdge(g, A[i]);
                        addEdge(g, --A[i]);
                    }
                }

                if(!isOk) {
                    ans += 1;
                    for(int i = 0; i < n; i++) {
                        if((A[i] & -A[i]) == max) {
                            A[i] -= 1;
                            break;
                        }
                    }

                    for(int i = 0; i < n; i++) {
                        if((A[i] & -A[i]) == max) {
                            A[i] += 1;
                            break;
                        }
                    }
                }
            }
        }
        
        Writer.println(ans);
        for(int i = 0; i < n; i++) {
            Writer.print(A[i]);
            Writer.print(i == n - 1 ? "\n" : " ");
        }
    }

    private void addEdge(int[][] g, int x) {
        for(int i = 0; i < 30; i++) {
            for(int j = i; j < 30; j++) {
                if((x & (1 << i)) != 0 && (x & (1 << j)) != 0) {
                    g[i][j] += 1;
                    g[j][i] += 1;
                }
            }
        }
    }

    private void removeEdge(int[][] g, int x) {
        for(int i = 0; i < 30; i++) {
            for(int j = i; j < 30; j++) {
                if((x & (1 << i)) != 0 && (x & (1 << j)) != 0) {
                    g[i][j] -= 1;
                    g[j][i] -= 1;
                }
            }
        }
    }

    private boolean isConnect(int[][] g) {
        UF uf = new UF(30);
        for(int i = 0; i < 30; i++) {
            for(int j = 0; j < 30; j++) {
                if(g[i][j] > 0) {
                    uf.unite(i, j);
                }
            }
        } 

        int p = -1;
        for(int i = 0; i < 30; i++) {
            for(int j = 0; j < 30; j++) {
                if(g[i][j] > 0) {
                    if(p != -1 && uf.find(i) != p) {
                        return false; 
                    }
                    p = uf.find(i);
                }
            }
        }
        return true;
    }

    private class UF {
        int[] p;
        int[] w;
        int n;
        UF(int n) {
            this.n = n;
            p = new int[n];
            w = new int[n];
            Arrays.fill(p, -1);
            Arrays.fill(w, 1);
        }
        int find(int i) {
            if(p[i] < 0) {
                return i;
            }
            return p[i] = find(p[i]);
        }
        void unite(int i, int j) {
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
        int count() {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                cnt += p[i] < 0 ? 1 : 0;
            }
            return cnt;
        }
        int groupSize(int i) {
            int x = find(i);
            return w[x];
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
