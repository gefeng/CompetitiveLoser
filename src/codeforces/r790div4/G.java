package codeforces.r790div4;

import java.io.*;
import java.util.*;

public class G {
    private int[] dfs(List<Integer>[] g, String s, int cur) {
        List<Integer> ch = g[cur];

        int b = s.charAt(cur - 1) == 'B' ? 1 : 0;
        int w = s.charAt(cur - 1) == 'W' ? 1 : 0;
        int tot = 0;
        for(int c : ch) {
            int[] res = dfs(g, s, c);
            b += res[0];
            w += res[1];
            tot += res[2];
        }

        if(b == w) {
            tot++;
        }

        return new int[] {b, w, tot};
    }
    void go() {
        int n = Reader.nextInt();
        int[] p = new int[n + 1];
        String s = "";

        for(int i = 2; i <= n; i++) {
            p[i] = Reader.nextInt();
        }

        s = Reader.next();

        List<Integer>[] g = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for(int i = 2; i <= n; i++) {
            g[p[i]].add(i);
        }

        Writer.println(dfs(g, s, 1)[2]);
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