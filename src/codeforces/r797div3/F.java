package codeforces.r797div3;

import java.io.*;
import java.util.*;

public class F {
    void go() {
		int n = Reader.nextInt();
		String s = Reader.next();
		int[] P = new int[n];
		long ans = 1;

		for(int i = 0; i < n; i++) {
			P[i] = Reader.nextInt();
		}

		boolean[] seen = new boolean[n];
		for(int i = 0; i < n; i++) {
			if(seen[i]) {
				continue;
			}
			int cur = i;
			int len = 0; 
			char[] c1 = new char[n];
			c1 = s.toCharArray();			
			do {
				seen[cur] = true;
				len++;
				//c1[cur] = s.charAt(cur);
				cur = P[cur] - 1;	
			} while(!seen[cur]);
			
			int round = 0;
			cur = i;
			char[] pre = Arrays.copyOf(c1, n);
			char[] nxt = Arrays.copyOf(c1, n);
			while(true) {
				round++;
				for(int j = 0; j < len; j++) {
					nxt[P[cur] - 1] = pre[cur];
					cur = P[cur] - 1;
				}	

				if(Arrays.equals(c1, nxt)) {
					break;
				}

				pre = nxt;
				nxt = Arrays.copyOf(c1, n);
				cur = i;
			}
			ans = lcm(ans, round);
		}
		Writer.println(ans);
    }
	private long lcm(long x, long y) {
		long gcd = gcd(x, y);
		return x * (y / gcd);
	}
	private long gcd(long x, long y) {
		if(x == 0) {
			return y;
		}
		return gcd(y % x, x);
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
        new F().run();
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
