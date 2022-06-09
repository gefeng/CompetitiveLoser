import java.io.*;
import java.util.*;

public class F2 {
    private class BIT {
        int n;
        int A[];
        BIT(int n) {
            this.n = n + 5;
            this.A = new int[n + 5];
        }
        void update(int i) {
            i++;
            while(i < n) {
                A[i]++;
                i += i & (-i);
            }
        }
        int query(int i) {
            int sum = 0;
            i++;
            while(i > 0) {
                sum += A[i];
                i -= i & (-i);
            }
            return sum;
        }
        int query(int l, int r) {
            return query(r) - query(l - 1);
        }
    }
    void go() {
        int n = Reader.nextInt();
        String s = Reader.next();
        long ans = 0;

        BIT[] B = new BIT[3];
        for(int i = 0; i < 3; i++) {
            B[i] = new BIT(2 * n + 1);
        }
        B[0].update(n);
        int bal = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '+') {
                bal++;
            } else {
                bal--;
            }
            BIT bit = null;
            if(bal < 0) {
                bit = B[(3 - (bal * -1 % 3)) % 3]; 
            } else {
                bit = B[bal % 3];
            }
            //BIT bit = B[Math.abs(d) % 3];
            int tot = bit.query(bal + n, 2 * n);
            ans += tot;
            bit.update(bal + n);
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
        new F2().run();
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
