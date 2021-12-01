package codeforces.r1613;

import java.io.*;
import java.util.*;

public class B {
    private static final int MAX = (int)1e6;
    void go() {
        int n = Reader.nextInt();
        int m = n / 2;
        int[] arr = new int[n];
        boolean[] exist = new boolean[MAX + 1];

        for(int i = 0; i < n; i++) {
            arr[i] = Reader.nextInt();
            exist[arr[i]] = true;
        }

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int rem = arr[i] % arr[j];
                if(!exist[rem]) {
                    Writer.println(arr[i] + " " + arr[j]);
                    m--;
                    if(m == 0) {
                        break;
                    }
                }
            }
            if(m == 0) {
                break;
            }
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

        public static void print(int x) {
            pw.print(x);
        }

        public static void print(long x) {
            pw.print(x);
        }

        public static void println(String s) {
            pw.println(s);
        }

        public static void println(int x) {
            pw.println(x);
        }

        public static void println(long x) {
            pw.println(x);
        }

        public static void close() {
            pw.close();
        }
    }
}