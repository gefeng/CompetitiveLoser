package Codeforces.CodeforcesBetaRound4;

import java.io.*;
import java.util.*;

public class A {
    void go() {
        // add code
        int n = Reader.nextInt();
        String res = (n % 2 == 0 && n - 2 > 0) ? "YES" : "NO";
        Writer.println(res);
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

        public static void println(String s) {
            pw.println(s);
        }

        public static void close() {
            pw.close();
        }
    }

//    private byte[] inBuf = new byte[1024];
//    private int lenBuf = 0;
//    private int ptrBuf = 0;
//
//    private int readByte() {
//
//    }
//
//    public static class FastWriter {
//        private static final int BUF_SIZE = 1 << 13;
//        private final byte[] buf = new byte[BUF_SIZE];
//        private final OutputStream out;
//        private int ptr = 0;
//
//        public FastWriter(OutputStream os) {
//            this.out = os;
//        }
//
//        private void innerFlush() {
//            try {
//                out.write(buf, 0, ptr);
//                ptr = 0;
//            } catch (IOException e) {
//                throw new RuntimeException("flush");
//            }
//        }
//
//        public void flush() {
//            innerFlush();
//            try {
//                out.flush();
//            } catch (IOException e) {
//                throw new RuntimeException("flush");
//            }
//        }
//    }
}
