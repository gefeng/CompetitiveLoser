package kickstart.r2022A;

import java.io.*;
import java.util.*;

public class C {
    private boolean dfs(String s, int i, int state, Boolean[][] memo) {
        int n = s.length();
        if(i == n) {
            return true;
        }
        if(memo[i][state] != null) {
            return memo[i][state];
        }

        char c = s.charAt(i);

        if(c == '?') {
            if(i < 5) {
                int nstate1 = (1 << i) | state;
                int nstate2 = state;
                if(i == 4) {
                    if(isOk(nstate1, 5) && dfs(s, i + 1, nstate1, memo)) {
                        return true;
                    }
                    if(isOk(nstate2, 5) && dfs(s, i + 1, nstate2, memo)) {
                        return true;
                    }
                } else {
                    if(dfs(s, i + 1, nstate1, memo)) {
                        return true;
                    }
                    if(dfs(s, i + 1, nstate2, memo)) {
                        return true;
                    }
                }
            } else {
                int state5 = (state >> 1) | (1 << 4);
                int state6 = state | (1 << 5);
                if(isOk(state5, 5) && isOk(state6, 6) && dfs(s, i + 1, state5, memo)) {
                    return true;
                }

                state5 = state >> 1;
                state6 = state;
                if(isOk(state5, 5) && isOk(state6, 6) && dfs(s, i + 1, state5, memo)) {
                    return true;
                }
            }
        } else {
            if(i < 5) {
                int nstate = (c - '0' << i) | state;
                if(i == 4) {
                    //System.out.println(nstate + " " + isOk(nstate,5));
                    if(isOk(nstate, 5) && dfs(s, i + 1, nstate, memo)) {
                        return true;
                    }
                } else {
                    if (dfs(s, i + 1, nstate, memo)) {
                        return true;
                    }
                }
            } else {
                int state5 = (state >> 1) | (c - '0' << 4);
                int state6 = state | (c - '0' << 5);
                if(isOk(state5, 5) && isOk(state6, 6) && dfs(s, i + 1, state5, memo)) {
                    return true;
                }
            }
        }

        return memo[i][state] = false;
    }
    private boolean isOk(int state, int len) {
        int[] bits = new int[len];
        for(int i = 0; i < len; i++) {
            bits[i] = state & 1;
            state >>= 1;
        }
        for(int l = 0, r = len - 1; l < r; l++, r--) {
            if(bits[l] != bits[r]) {
                return true;
            }
        }

        return false;
    }
    void go(int T) {
        int n = Reader.nextInt();
        String s = Reader.next();
        String ans = "IMPOSSIBLE";

        if(n < 5) {
            ans = "POSSIBLE";
        } else {
            boolean res = dfs(s, 0, 0, new Boolean[n][1 << 5]);
            if(res) {
                ans = "POSSIBLE";
            }
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