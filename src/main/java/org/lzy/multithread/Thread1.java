package org.lzy.multithread;

public class Thread1 extends Thread {
    private String name;
    
    public Thread1(String name) {
        this.name = name;
    }
    
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行： " + i);
            try {
                sleep((int)Math.random()*10);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Thread1 m1 = new Thread1("A");
        Thread1 m2 = new Thread1("B");
//        m2 = m1;
        m1.start();
        m2.start();
    }
}
