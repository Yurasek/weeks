package week3.chronometer;

import java.util.concurrent.TimeUnit;

public class Main {
    public int i = 1;
    public static void main(String[] args) {
        Main seconds = new Main();
        (new Thread(()->{
            synchronized (seconds){
                while(true) {
                    if (seconds.i % 5 == 0) {
                        System.out.println("C начала сессии прошло " + seconds.i + " секунд");
                    }
                    seconds.notify();
                    try {
                        seconds.wait();
                    } catch (InterruptedException e) { }
                    seconds.notify();
                }
            }
        })).start();
        synchronized (seconds) {
            while (seconds.i < 60) {
                System.out.println(seconds.i++);
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    seconds.wait();
                } catch (InterruptedException e) {

                }
                seconds.notify();
            }
        }
    }
}
