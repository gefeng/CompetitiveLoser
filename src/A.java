import java.io.*;
import java.util.*;

public class A {
    void solve() {
        go();
    }
    void go() {
        // add code
        int n = Integer.parseInt(st.nextToken());
        String res = (n % 2 == 0 && n - 2 > 0) ? "YES" : "NO";
        out.println(res);
    }
    void run() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(reader.readLine());
        out = new PrintWriter(new BufferedOutputStream(System.out));
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new A().run();
    }

    public static StringTokenizer st;
    public static PrintWriter out;

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
