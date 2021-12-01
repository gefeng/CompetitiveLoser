package Codeforces.DeltixRoundAutumn2021;

import java.io.*;
import java.util.*;

public class C {
    private static final int MAX = (int)1e6;
    private boolean primes[] = new boolean[MAX + 1];
    void go() {
        // add code
        int n = Reader.nextInt();
        int e = Reader.nextInt();
        int[] arr = new int[n];
        long ans = 0;

        int max = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Reader.nextInt();
        }

        for(int i = 0; i < n; i++) {
            boolean pri = primes[arr[i]];
            if(pri) {
                long cntL = 0;
                long cntR = 0;

                // to right
                for(int j = i + e; j < n; j += e) {
                    if(arr[j] == 1) {
                        cntR++;
                    } else {
                        break;
                    }
                }

                // to left
                for(int j = i - e; j >= 0; j -= e) {
                    if(arr[j] == 1) {
                        cntL += cntR + 1;
                    } else {
                        break;
                    }
                }

                ans += cntL + cntR;
            }
        }

        Writer.println(ans);
    }
    void solve() {
        sieve();
        for(int T = Reader.nextInt(); T > 0; T--) go();
    }
    void run() throws Exception {
        Reader.init(System.in);
        Writer.init(System.out);
        solve();
        Writer.close();
    }

    private void sieve() {
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for(int i = 2; i * i <= MAX; i++) {
            if(primes[i]) {
                for(int j = i * i; j <= MAX; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new C().run();
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