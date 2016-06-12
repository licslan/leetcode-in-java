public class Solution {
    // O(n^1.5)，LTE
    public int countPrimes(int n) {
        int count = 0;

        for (int i = 2; i < n; i++)
            if (isPrime(i))
                count++;
        return count;
    }

    // O(n^0.5)
    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // OK solution
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];// true为合数，false为素数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++)
                    notPrime[i * j] = true;
            }
        }
        return count;
    }
}