package codeforces.r761div2;

import java.io.*;
import java.util.*;

public class D {
    int q(int a, int b, int c) {
        Writer.println("? " + a + " " + b + " " + c);
        Writer.flush();
        return Reader.nextInt();
    }
    void go() {
        int n = Reader.nextInt();

        int pre = -1;
        int imp = -1;
        int cre = -1;
        for(int i = 0; i < n; i++) {
            int a = i + 1;
            int b = (i + 1) % n + 1;
            int c = (i + 2) % n + 1;
            int cur = q(a, b, c);

            //1 2 3 = 1/2 3 4 = 0
            if(pre != -1 && pre != cur) {
                if(cur == 0) {
                    cre = a - 1;
                    imp = c;
                } else {
                    imp = a - 1;
                    cre = c;
                }
                break;
            }

            pre = cur;
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(imp);
        for(int i = 0; i < n; i++) {
            if(i + 1 != imp && i + 1 !=  cre) {
                int res = q(i + 1, imp, cre);
                if(res == 0) {
                    ans.add(i + 1);
                }
            }
        }

        Writer.print("! " + ans.size() + " ");
        for(int i = 0; i < ans.size(); i++) {
            if(i < n - 1) Writer.print(ans.get(i) + " ");
            else Writer.print(ans.get(i) + "\n");
        }
        Writer.flush();
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

        public static void println(long x) {
            pw.println(x);
        }

        public static void flush() {
            pw.flush();
        }

        public static void close() {
            pw.close();
        }
    }
}