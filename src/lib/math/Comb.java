package lib.math;

/**
 * Calculate binomial coefficient
 * */
public class Comb {
    int MAX;
    long MOD;
    long[] fact;
    long[] invf;
    Comb(int n, long mod) {
        MAX = n;
        MOD = mod;
        fact = new long[MAX + 1];
        invf = new long[MAX + 1];

        fact[0] = 1;
        invf[0] = 1;

        for(int i = 1; i <= MAX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invf[MAX] = power(fact[MAX], MOD - 2);

        for(int i = MAX - 1; i >= 0; i--) {
            invf[i] = invf[i + 1] * (i + 1) % MOD;
        }
    }

    long get(int n, int k) {
        if(n < 0 || k < 0 || n < k) {
            return 0;
        }

        return fact[n] * (invf[k] * invf[n - k] % MOD) % MOD;
    }

    long power(long x, long y) {
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