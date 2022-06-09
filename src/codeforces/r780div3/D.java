package codeforces.r780div3;

import java.io.*;
import java.util.*;

public class D {
    void go() {
        int n = Reader.nextInt();
        int[] A = new int[n];
        int max = -1;
        int l = -1;
        int r = -1;
        
        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
        }

        Map<Integer, int[]> map = new HashMap<>();
        int mask = 0;
        int cnt = 0;
        map.put(0, new int[] {-1, 0});
        for(int i = 0; i < n; i++) {
            if(A[i] == 0) {
                mask = 0;
                cnt = 0;
                map = new HashMap<>();
                map.put(0, new int[] {i, 0});
            } else {
                mask ^= A[i] > 0 ? 0 : 1;
                cnt += Math.abs(A[i]) == 2 ? 1 : 0;
                if(map.containsKey(mask)) {
                    int pre[] = map.get(mask);
                    if(max < cnt - pre[1]) {
                        max = cnt - pre[1];
                        l = pre[0] + 1;
                        r = n - 1 - i;
                    }
                } else {
                    map.put(mask, new int[] {i, cnt});
                }
            }
        }
        
        if(max == -1) {
            Writer.println(n + " " + 0);
        } else {
            Writer.println(l + " " + r);
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
