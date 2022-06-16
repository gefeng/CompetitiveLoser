package codeforces.r799div4;

import java.io.*;
import java.util.*;

public class H {
    void go() {
        int n = Reader.nextInt();
        int[] A = new int[n];
        int[] ans = new int[3];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
            map.computeIfAbsent(A[i], k -> new ArrayList<>()).add(i);    
        }
        
        int max = 0;
        for(int k : map.keySet()) {
            List<Integer> e = map.get(k);
            int sz = e.size();
            for(int l = 0, r = 0; r < sz; r++) {
                while(r - l + 1 <= e.get(r) - e.get(l) + 1 - (r - l + 1)) {
                    l++;
                }

                int tot = e.get(r) - e.get(l) + 1;
                int f = r - l + 1;
                if(f - tot + f > max) {
                    max = f - tot + f;
                    ans[0] = k;
                    ans[1] = e.get(l) + 1;
                    ans[2] = e.get(r) + 1;
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            Writer.print(ans[i]);
            Writer.print(i == 2 ? "\n" : " ");
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
        new H().run();
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
