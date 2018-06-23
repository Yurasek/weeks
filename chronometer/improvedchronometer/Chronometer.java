package week3.chronometer.improvedchronometer;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;


public class Chronometer implements Runnable {

    public int time = 0;

    public synchronized void changeTime(){
        time++;
    }
    public synchronized int getTime(){
        return time;
    }
    @Override
    public void run() {
            for(int i = 0;i < 60;i++) {
                changeTime();
                out.println(getTime());
                try{
                    TimeUnit.MILLISECONDS.sleep(1000);
                }catch (InterruptedException e){}
            }
    }
    public static void main(String[] args) {
        Chronometer seconds = new Chronometer();
        new Thread(seconds).start();
        (new Thread(()->{
            while(seconds.getTime() < 60) {
                if (seconds.getTime() % 5 == 0) {
                    System.out.println("C начала сессии прошло " + seconds.time + " секунд");
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        })).start();
        (new Thread(()->{
            while(seconds.getTime() < 60) {
                if (seconds.getTime() % 7 == 0) {
                    System.out.println("C начала сессии прошло " + seconds.time + " секунд");
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        })).start();
    }
}

