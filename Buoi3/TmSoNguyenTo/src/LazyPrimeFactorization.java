public class LazyPrimeFactorization implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (isPrimeNumber(i)) {
                System.out.println("LazyPrimeFactorization: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
