import java.io.*;
import java.util.*;
 
public class P66B {
    void go() {
        int n = Reader.nextInt();
        int[] A = new int[n];
        int ans = 0;
 
        for(int i = 0; i < n; i++) {
            A[i] = Reader.nextInt();
        }
 
        for(int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            while(l - 1 >= 0 && A[l - 1] <= A[l]) {
                l -= 1;
            }
            while(r + 1 < n && A[r + 1] <= A[r]) {
                r += 1;
            }
 
            ans = Math.max(ans, r - l + 1);
        }
 
        Writer.println(ans);
    }
    void solve() {
        go();
    }
    void run() throws Exception {
        Reader.init(System.in);
        Writer.init(System.out);
        solve();
        Writer.close();
    }
 
    public static void main(String[] args) throws Exception {
        new P66B().run();
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
