public class Main {
    public static void main(String[] args) {
        LazyPrimeFactorization lazyPrimeFactorization = new LazyPrimeFactorization();
        Thread threadLazyPrimeFactorization = new Thread(lazyPrimeFactorization);
        threadLazyPrimeFactorization.start();
        OptimizedPrimeFactorization optimizedPrimeFactorization = new OptimizedPrimeFactorization();
        Thread threadOptimizedPrimeFactorization = new Thread(optimizedPrimeFactorization);
        threadOptimizedPrimeFactorization.start();

    }
}