package codeforces.r764div3;

import java.io.*;
import java.util.*;

public class E {
    Map<String, int[]> map;
    boolean dfs(String phone, int st, List<int[]> seg, Boolean[] memo) {
        int n = phone.length();

        if(st == n) return true;
        if(memo[st] != null) return memo[st];

        if(st + 2 <= n) {
            String s = phone.substring(st, st + 2);

            if(map.containsKey(phone.substring(st, st + 2))) {
                if(dfs(phone, st + 2, seg, memo)) {
                    seg.add(map.get(s));
                    return true;
                }
            }
        }

        if(st + 3 <= n) {
            String s = phone.substring(st, st + 3);

            if(map.containsKey(phone.substring(st, st + 3))) {
                if(dfs(phone, st + 3, seg, memo)) {
                    seg.add(map.get(s));
                    return true;
                }
            }
        }

        return memo[st] = false;
    }

    void go() {
        map = new HashMap<>();
        int n = Reader.nextInt();
        int m = Reader.nextInt();

        String[] nums = new String[n];
        for(int i = 0; i < n; i++) {
            nums[i] = Reader.next();
        }
        String t = Reader.next();

        for(int i = 0; i < n; i++) {
            String phone = nums[i];
            for(int j = 0; j <= phone.length() - 2; j++) {
                String seg = phone.substring(j, j + 2);
                map.put(seg, new int[] {j, j + 1, i});
            }

            for(int j = 0; j <= phone.length() - 3; j++) {
                String seg = phone.substring(j, j + 3);
                map.put(seg, new int[] {j, j + 2, i});
            }
        }

        List<int[]> seg = new ArrayList<>();
        if(dfs(t, 0, seg, new Boolean[m])) {
            Writer.println(seg.size());
            for(int i = seg.size() - 1; i >= 0; i--) {
                int[] s = seg.get(i);
                Writer.print((s[0] + 1) + " ");
                Writer.print((s[1] + 1) + " ");
                Writer.print((s[2] + 1) + "\n");
            }
        } else {
            Writer.println(-1);
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