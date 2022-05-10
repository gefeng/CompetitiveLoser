package codeforces.r789div2;

import java.io.*;
import java.util.*;

public class E {
    void go() {
        int n = Reader.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        int[] p1 = new int[n + 1];
        int[] p2 = new int[n + 1];
        long ans = 0;
        long r = n;
        long l = 1;

        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
            p1[A[i]] = i;
        }

        for(int i = 0; i < n; i++) {
            B[i] = Reader.nextInt();
            p2[B[i]] = i;
        }

        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }

            int cycle = 0;
            int cur = i;
            long upper = 0;
            long lower = 0;
            do{
                visited[cur] = true;
                cycle++;
                cur = p2[A[cur]];
            } while(!visited[cur]);

            cycle = cycle % 2 == 0 ? cycle : cycle - 1;
            while(cycle != 0) {
                upper += r * 2;
                lower += l * 2;
                r--;
                l++;
                cycle -= 2;
            }

            ans += upper - lower;
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