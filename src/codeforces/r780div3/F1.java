package codeforces.r780div3;

import java.io.*;
import java.util.*;

public class F1 {
    void go() {
        int n = Reader.nextInt();
        String s = Reader.next();
        int ans = 0;

        int cntAdd = 0;
        int cntSub = 0;
        int cntPair = 0;
        int preSub = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '+') {
                cntAdd++;
                preSub = 0;
            } else {
                cntSub++;
                if(preSub == 1) {
                    cntPair++;
                    preSub = 0;
                } else {
                    preSub = 1;
                }
            }

            int d = cntAdd - cntSub;
            ans += map.getOrDefault(d, 0);

            int x = cntAdd;
            int y = cntSub;
            for(int j = 0; j < cntPair; j++) {
                x += 1;
                y -= 2;
                ans += map.getOrDefault(x - y, 0);
            } 
            
            map.put(d, map.getOrDefault(d, 0) + 1);
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
        new F1().run();
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
