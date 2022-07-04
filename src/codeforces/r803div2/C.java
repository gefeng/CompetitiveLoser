package codeforces.r803div2;

import java.io.*;
import java.util.*;

public class C {
    void go() {
        int n = Reader.nextInt();
        int[] A = new int[n];
        String ans = "";
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        int cntZero = 0;

        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
            if(A[i] < 0) {
                neg.add(A[i]);
            } else if(A[i] > 0) {
                pos.add(A[i]);
            } else {
                cntZero += 1;
            }
        }

        int sz1 = neg.size();
        int sz2 = pos.size();

        if(sz1 > 2 || sz2 > 2) {
            ans = "NO";
        } else {
            List<Integer> l = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            l.addAll(neg);
            l.addAll(pos);
            set.addAll(neg);
            set.addAll(pos);
            for(int i = 0; i < Math.min(cntZero, 2); i++) {
                l.add(0);
                set.add(0);
            }

            int sz = l.size();
            for(int i = 0; i < sz; i++) {
                for(int j = i + 1; j < sz; j++) {
                    for(int k = j + 1; k < sz; k++) {
                        if(!set.contains(l.get(i) + l.get(j) + l.get(k))) {
                            Writer.println("NO");
                            return;
                        }
                    }
                }
            }
            
            ans = "YES";
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
