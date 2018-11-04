package TestThread;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Runable1 runable1 = new Runable1();
        Runable2 runable2 = new Runable2();

        Thread thread = new Thread(runable1);
        Thread thread1 = new Thread(runable2);
        thread.start();
        thread1.start();
        thread1.join();
        thread.join();
        System.out.println(123);

    }
}
