public class TestThread {
    public static void main(String[] args) {
            OddThread oddThread = new OddThread();
            EvenThread evenThread = new EvenThread();
//            evenThread.start();
//        try {
//            evenThread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        oddThread.start();
//        try {
//            oddThread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        oddThread.start();
        evenThread.start();
    }
}