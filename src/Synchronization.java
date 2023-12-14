import java.util.Random;
import java.util.Scanner;

class AvgValArray{
    private int avg,sum;
    synchronized int avgArray(int val[]){
        avg=0;
        sum=0;
        for(int i=0;i< val.length;i++){
            sum+=val[i];
            System.out.println(Thread.currentThread().getName()+ " computed sum value equals to "+ sum);
        try {
            Thread.sleep(200);
        }catch(InterruptedException e){
            System.out.println("The thread has been interrupted.");
        }}
        System.out.println("The computed "+Thread.currentThread().getName()+ " average equals: "+(avg=sum/ val.length));
        return avg;
    }
}
public class Synchronization implements Runnable{
Thread thread;
static AvgValArray avgAr=new AvgValArray();
int a[], answer;
Synchronization(String name, int val[]){
    thread=new Thread(this,name);
    a=val;
}

public static Synchronization createAndStart(String name,int val[]){
    Synchronization myThreadSync=new Synchronization(name, val);
    myThreadSync.thread.start();
    return myThreadSync;
}
public void run(){
    System.out.println(thread.getName()+ " starts a new action.");
    answer=avgAr.avgArray(a);
    System.out.println(thread.getName()+ " computed the average value to "+ answer);
    System.out.println(thread.getName()+ " finishes running.");
}
}

class SyncAvg{
    public static void main(String[] args) {
        Random rnd=new Random(10);
        int[] a=new int[10];

        for (int i=0;i< a.length;i++){
            a[i]= rnd.nextInt(100);
        }
        Synchronization myThreadSync1=Synchronization.createAndStart("Thread 1",a);
        Synchronization myThreadSync2=Synchronization.createAndStart("Thread 2",a);
        try{
            myThreadSync1.thread.join();
            myThreadSync2.thread.join();
        }catch(InterruptedException e){
            System.out.println("The thread has been interrupted.");
        }
    }
}
