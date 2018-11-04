package TestThread;

public class Runable1 implements  Runnable{


    @Override
    public void run() {
        try {
            Thread.sleep(1000*30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程1");
    }


}
