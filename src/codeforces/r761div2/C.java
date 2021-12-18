package codeforces.r761div2;

import java.io.*;
import java.util.*;

public class C {
    void go() {
        int n = Reader.nextInt();
        int[] arr = new int[n];

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < n; i++) {
            int x = Reader.nextInt();
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int ans = 0;
        boolean[] found = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            if(map.containsKey(i)) {
                int f = map.get(i);
                if(f == 1) map.remove(i);
                else map.put(i, f - 1);
                found[i] = true;
            }
        }
        for(int i = 1; i <= n; i++) {
            if(found[i]) continue;
            Integer c = map.ceilingKey(2 * i + 1);
            if(c == null) {
                //Writer.println(i);
                ans = -1;
                break;
            }
            int f = map.get(c);
            if(f == 1) map.remove(c);
            else map.put(c, f - 1);
            ans++;
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

        public static void println(long x) {
            pw.println(x);
        }

        public static void close() {
            pw.close();
        }
    }
}