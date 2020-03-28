package test;

/**
 * @author jinpeng_chen
 * @create 2020-03-04 下午 4:58
 **/

public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        TestThread t=new TestThread();
        t.stop.start();

//        HelloThread h=new HelloThread();
//        if (h.isAlive()){
//            h.running = false; // 标志位置为false
//        }else {
//            h.start();
//        }


        System.out.println("执行完了...");

    }

   Thread stop = new Thread() {
        @Override
        public void run() {
            try {
                HelloThread t = new HelloThread();
                t.start();
                Thread.sleep(1000);
                t.running = false; // 标志位置为false
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    };
}

class HelloThread extends Thread {
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end!");
    }
}
