//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Counter {
    int count = 0;
    public synchronized void increment() {
        count++;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++) {
                    c.increment();
                }
            }
        });
        Thread t2 = new Thread((new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++) {
                    c.increment();
}
            }
        }));

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count: " + c.count);
    }
}