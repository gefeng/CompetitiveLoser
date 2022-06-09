package lib.math;

/**
 * Calculate binomial coefficient
 * */
public class Comb {
    int MAX;
    long MOD;
    long[] frac;
    long[] invf;
    Comb(int n, long mod) {
        MAX = n;
        MOD = mod;
        frac = new long[MAX + 1];
        invf = new long[MAX + 1];

        frac[0] = 1;
        invf[0] = 1;

        for(int i = 1; i <= MAX; i++) {
            frac[i] = frac[i - 1] * i % MOD;
        }

        invf[MAX] = power(frac[MAX], MOD - 2);

        for(int i = MAX - 1; i >= 0; i--) {
            invf[i] = invf[i + 1] * (i + 1) % MOD;
        }
    }

    private long power(long x, long y) {
        long res = 1;
        while(y > 0) {
            if(y % 2 == 1) {
                res = res * x % MOD;
            }
            y >>= 1;
            x = x * x % MOD;
        }
        return res;
    }
}

// Comb comb = new Comb(max_n)
// comb.bc(n, k)