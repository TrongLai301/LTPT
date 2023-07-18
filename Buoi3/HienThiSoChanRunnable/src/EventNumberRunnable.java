public class EventNumberRunnable implements Runnable{
    @Override
    public void run(){
        for (int i = 2; i < 10; i+=2) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        EventNumberRunnable eventNumberRunnable = new EventNumberRunnable();
        Thread thread = new Thread();
        thread.start();
    }
}