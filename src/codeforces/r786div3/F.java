package codeforces.r786div3;

import java.io.*;
import java.util.*;

public class F {
    void go() {
        int m = Reader.nextInt();
        int n = Reader.nextInt();
        int q = Reader.nextInt();
        char[][] g = new char[m][n];
        int[][] qs = new int[q][2];
        int tot = 0;
        //Queue<Integer> in = new PriorityQueue<>(Comparator.reverseOrder());
        //Queue<Integer> out = new PriorityQueue<>();
        TreeSet<Integer> in  = new TreeSet<>();
        TreeSet<Integer> out = new TreeSet<>();

        for(int i = 0; i < m; i++) {
            String s = Reader.next();
            for(int j = 0; j < n; j++) {
                g[i][j] = s.charAt(j);
                if(g[i][j] == '*') {
                    tot++;
                }
            }
        }

        for(int i = 0; i < q; i++) {
            qs[i] = new int[] {Reader.nextInt(), Reader.nextInt()};
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(g[i][j] == '*') {
                    if(j * m + i < tot) {
                        in.add(j * m + i);
                    } else {
                        out.add(j * m + i);
                    }
                }
            }
        }

        for(int i = 0; i < q; i++) {
            int r = qs[i][0] - 1;
            int c = qs[i][1] - 1;
            if(g[r][c] == '*') {
                int idx = c * m + r;

                if(in.contains(idx)) {
                    in.remove(idx);
                } else {
                    out.remove(idx);
                }
                tot--;
                if(!in.isEmpty() && in.last() >= tot) {
                    out.add(in.pollLast());
                }
                g[r][c] = '.';
            } else {
                int idx = c * m + r;
                tot++;
                if(idx < tot) {
                    in.add(idx);
                } else {
                    out.add(idx);
                }

                if(!out.isEmpty() && out.first() < tot) {
                    in.add(out.pollFirst());
                }
                g[r][c] = '*';
            }

            Writer.println(out.size());
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