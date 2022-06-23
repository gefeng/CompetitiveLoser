package codeforces.r776div3;

import java.io.*;
import java.util.*;

public class F {
    void go() {
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        int[] T = new int[n];
        int[][] S = new int[m][3];
        int[][] O = new int[m][4];

        for(int i = 0; i < n; i++) {
            T[i] = Reader.nextInt();
        }

        for(int i = 0; i < m; i++) {
            S[i] = new int[] {Reader.nextInt(), Reader.nextInt(), Reader.nextInt()};
            O[i] = new int[] {S[i][0], S[i][1], S[i][2], i};
        }

        Arrays.sort(O, (a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[0], b[0]);
        });  

        long t = 0;
        int solved = 0;
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < m; ) {
            int j = i;
            while(i < m && O[j][0] == O[i][0]) {
                i++;
            }

            List<Integer> ops = helper(O, j, i - 1);
            for(int o : ops) {
                t += S[o][1];
            }
            
            if(ops.isEmpty() || T[O[j][0] - 1] < t) {
                Writer.println(-1); 
                return;
            }

            solved++;
            l.addAll(ops);
        }

        if(solved == n) {
            Writer.println(l.size());
            for(int i = 0; i < l.size(); i++) {
                Writer.print(l.get(i) + 1);
                Writer.print(i == l.size() - 1 ? "\n" : " ");
            }
        } else {
            Writer.println(-1);
        }
    }

    private List<Integer> helper(int[][] O, int st, int ed) {
        int n = ed - st + 1;
        long min = -1;
        long[][] dp = new long[n + 1][101]; 
        int[][] seq = new int[n + 1][101];

        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(seq[i], -1);
        }

        for(int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= 100; j++) {
                int k = Math.max(0, j - O[st + i - 1][2]);
                long pick = dp[i - 1][k] == -1 ? -1 : dp[i - 1][k] + O[st + i - 1][1];
                long skip = dp[i - 1][j];
                    
                if(pick != -1 && skip != -1) {
                    dp[i][j] = Math.min(pick, skip); 
                    if(pick < skip) {
                        seq[i][j] = i - 1;
                    }
                } else {
                    dp[i][j] = pick == -1 ? skip : pick;
                    if(pick != -1) {
                        seq[i][j] = i - 1;
                    }
                }
            }
        }

//        Writer.println(dp[n][100]);
//        for(int i = 1; i <= n; i++) {
//            if(dp[i][100] != -1) {
//                min = min == -1 ? dp[i][100] : Math.min(min, dp[i][100]);
//            }
//        }

        List<Integer> res = new ArrayList<>();
        if(dp[n][100] != -1) {
            int p = 100;
            int cur = -1;
            for(int i = n; i > 0; i--) {
                int pre = seq[i][p];
//                System.out.println(cur + " " + pre);
                if(pre != cur && pre != -1) {
                    res.add(O[st + pre][3]);
                    p = Math.max(0, p - O[st + pre][2]);
                    cur = pre;
                } 
            }
        }
        return res; 
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
