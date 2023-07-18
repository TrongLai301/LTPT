public class OptimizedPrimeFactorization implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (isPrimeNumber(i)) {
                System.out.println("OptimizedPrimeFactorization: " + i);
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
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i < squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
