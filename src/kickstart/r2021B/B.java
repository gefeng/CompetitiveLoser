package kickstart.r2021B;

import java.io.*;
import java.util.*;

public class B {
    private int helper(int[] arr) {
        int n = arr.length;
        int ans = 2;
        int[] dif = new int[n - 1];

        for(int i = 0; i < n - 1; i++) {
            dif[i] = arr[i + 1] - arr[i];
        }

        for(int i = 0; i < n - 1; ) {
            int j = i;

            while(j < n - 1 && dif[i] == dif[j]) {
                j++;
            }

            if(j < n - 2 && arr[j + 2] - arr[j] == dif[i] * 2) {
                int k = j + 2;
                while(k < n - 1 && dif[i] == dif[k]) {
                    k++;
                }
                ans = Math.max(ans, k - i + 1);

                i = k == j + 2 ? j : k;
            } else {
                if(i == 0 && j == n - 1) {
                    ans = Math.max(ans, j - i + 1);
                } else {
                    ans = Math.max(ans, j - i + 2);
                }

                i = j;
            }
        }

        return ans;
    }
    void go(int T) {
        int n = Reader.nextInt();
        int[] arr = new int[n];
        int[] rarr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Reader.nextInt();
            rarr[n - i - 1] = arr[i];
        }

        Writer.println("Case #" + T + ": " + Math.max(helper(arr), helper(rarr)));
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
        new B().run();
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
