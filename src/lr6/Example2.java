package lr6;

public class Example2 {
    public static void main(String[] args) throws InterruptedException{
        Thread thr = new Thread(() -> {
            for (int i = 1; i <= 10; i++){
                System.out.println("Число: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        thr.start();
        thr.join();
    }
}
