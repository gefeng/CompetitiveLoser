import java.io.*;
import java.util.*;

public class B {
    void go() {
        int n = Reader.nextInt();
        int[] A = new int[n];
        int[] P = new int[n];

        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt() - 1;
        }
        
        if(n == 1) {
            Writer.println(-1);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!set.contains(j) && j != A[i]) {
                    P[i] = j;
                    set.add(j);
                    break;
                }
            }
        }

        if(set.size() != n) {
            for(int i = n - 2; i >= 0; i--) {
                if(A[i] != n - 1 && A[n - 1] != P[i]) {
                    P[n - 1] = P[i]; 
                    P[i] = n - 1;
                    break;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            Writer.print(P[i] + 1);
            Writer.print(i == n - 1 ? "\n" : " ");
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
