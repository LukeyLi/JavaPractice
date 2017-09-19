package org.lzy.multithread;

public class Counter {
    public static int counter = 0;
    public static void inc() {
        try {
            Thread.sleep(1);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        counter++;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for(int i = 0 ; i < 1000; i++ ) {
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Counter.inc();
            }
        }).start();
        }
   System.out.println(Counter.counter);
    }

}
