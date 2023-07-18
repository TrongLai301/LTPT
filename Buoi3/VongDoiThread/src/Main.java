public class Main extends Thread {
    @Override
    public void run() {
        System.out.println("Thread Start");
        commonResource();

//        System.out.println("Runnable start");
//        for (int i = 0; i < 100 ; i++) {
//            try{
//                Thread.sleep(100);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//        System.out.println("MyRunnable end");
    }

    public static void main(String[] args) {
        Main main = new Main();
        Main main1 = new Main();

        main.start();
        main1.start();

//        System.out.println(main.getState());
        System.out.println(main.getName() + ": " + main.getState());
        System.out.println(main1.getName() + ": " + main1.getState());

    }

    public static synchronized void commonResource() {
        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
