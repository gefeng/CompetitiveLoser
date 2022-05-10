package codeforces.r789div2;

import java.io.*;
import java.util.*;

public class B2 {
    void go() {
        int n = Reader.nextInt();
        String s = Reader.next();
        char[] c = s.toCharArray();
        int ans = 0;
        int cnt = 0;
        List<int[]> two = new ArrayList<>();

        for(int i = 0; i < n; ) {
            int j = i;
            while(i < n && c[i] == c[j]) {
                i++;
            }

            int curLen = i - j;

            if(curLen % 2 == 1) {
                if(i - j == 1) {
                    if(!two.isEmpty() && two.get(two.size() - 1)[1] + 1 == j) {
                        two.get(two.size() - 1)[1] = i;
                    } else {
                        two.add(new int[] {j, i});
                    }
                } else {
                    c[i] = c[j];
                }

                ans++;
                i++;
            }
        }

        if(!two.isEmpty()) {
            for(int[] p : two) {
                char bit = '0';
                int l = p[0];
                int r = p[1];

                if(l > 0) {
                    bit = c[l - 1];
                } else if(r < n - 1) {
                    bit = c[r + 1];
                }

                for(int j = l; j <= r; j++) {
                    c[j] = bit;
                }
            }
        }

        for(int i = 0; i < n; ) {
            int j = i;
            while(i < n && c[i] == c[j]) {
                i++;
            }
            cnt++;
        }

        Writer.println(ans + " " + cnt);
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
        new B2().run();
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