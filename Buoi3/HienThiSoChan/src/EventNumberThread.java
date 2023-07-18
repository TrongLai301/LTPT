public class EventNumberThread extends Thread {
    @Override
    public void run() {
        try{
            for (int i = 2; i < 10; i+=2) {
                System.out.println(i);
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public static class Main {
        public static void main(String[] args) {
                EventNumberThread eventNumberThread = new EventNumberThread();
                eventNumberThread.start();
        }
    }
}