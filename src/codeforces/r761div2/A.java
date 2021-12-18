package codeforces.r761div2;

import java.io.*;
import java.util.*;

public class A {
    void go() {
        String s = Reader.next();
        String t = Reader.next();

        char[] arr = s.toCharArray();
        int n = arr.length;
        Arrays.sort(arr);

        if(t.equals("abc")) {
            boolean[] seen = new boolean[26];

            for(int i = 0; i < arr.length; i++) {
                seen[arr[i] - 'a'] = true;
            }

            boolean has = true;
            for(int i = 0; i < 3; i++) {
                if(!seen[i]) {
                    has = false;
                }
            }

            if(has) {
                int i = 0, j = 0;
                while(arr[i] != 'b') {
                    i++;
                }
                while(arr[j] != 'c') {
                    j++;
                }

                while(i < n && j < n && arr[i] == 'b' && arr[j] == 'c') {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j++;
                }
            }
        }

        Writer.println(new String(arr));
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
        new A().run();
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

        public static void close() {
            pw.close();
        }
    }
}