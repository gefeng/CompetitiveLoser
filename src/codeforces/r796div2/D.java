package codeforces.r796div2;

import java.io.*;
import java.util.*;

public class D {
    void go() {
		int n = Reader.nextInt();
		int k = Reader.nextInt();
		int[] A = new int[n];
		long ans = 0;

		for(int i = 0; i < n; i++) {
			A[i] = Reader.nextInt();
		}

		if(k <= n) {
			long max = 0;
			long sum = 0;
			for(int l = 0, r = 0; r < n; r++) {
				sum += A[r];
				if(r - l + 1 > k) {
					sum -= A[l++];
				}
				if(r - l + 1 == k) {
					max = Math.max(max, sum);
				}
			}
			ans = max;
			if(k > 1) {
				ans += (long)k * (k - 1) / 2;	
			}
		} else {
			for(int i = 0; i < n; i++) {
				ans += A[i];
			}
			ans += ((long)k - n + k - 1) * n / 2;
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
