public class GuessRandomNumber extends Thread{
    private int count;
    private int guessNumber;

    public GuessRandomNumber(int guessNumber){
        this.guessNumber=guessNumber;
    }
    @Override
    public void run(){
        int randomNum;
        do{
            randomNum = (int) (Math.random()*100+1);
            count++;
            System.out.println(getName() +" guess: "+randomNum);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while(randomNum != guessNumber);
        System.out.println(getName()+ " correct guess "+randomNum+" in "+ count);
    }
}
