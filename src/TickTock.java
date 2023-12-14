public class TickTock {
    String state;

    synchronized void tick(boolean running){
        if(!running){
            state="ticked";
            notify();
            return;
        }
        System.out.print("tik ");

        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println("The thread has been interrupted.");
        }

        state="ticked";
        notify();

        try{
            while(!state.equals("tocked"))
                wait();
        }catch(InterruptedException e){
            System.out.println("The thread has been interrupted.");
        }
    }


    synchronized void tock(boolean running){
        if(!running){
            state="tocked";
            notify();
            return;
        }
        System.out.println("tak");

        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println("The thread has been interrupted.");
        }

        state="tocked";
        notify();
        try{
            while(!state.equals("ticked"))
                wait();
        }catch (InterruptedException e){
            System.out.println("The thread has been interrupted.");
        }
    }

    public static class MyThreadClock implements Runnable {
        Thread thread;
        TickTock ttOb;

        MyThreadClock(String name, TickTock tt) {
            thread = new Thread(this, name);
            ttOb = tt;
        }

        public static MyThreadClock createAndStart(String name, TickTock tt) {
            MyThreadClock myThreadClock = new MyThreadClock(name, tt);
            myThreadClock.thread.start();
            return myThreadClock;
        }

        public void run() {
            if (thread.getName().compareTo("tik")==0) {
                for (int i = 0; i < 10; i++) ttOb.tick(true);
                ttOb.tick(false);
            } else {
                for (int i = 0; i < 10; i++) ttOb.tock(true);
                ttOb.tock(false);
            }
        }
    }

}
class ThreadCom{
    public static void main(String[] args) {
        TickTock tt=new TickTock();
        TickTock.MyThreadClock myThreadClock1= TickTock.MyThreadClock.createAndStart("tik",tt);
        TickTock.MyThreadClock myThreadClock2= TickTock.MyThreadClock.createAndStart("tak",tt);
        try{
            myThreadClock1.thread.join();
            myThreadClock2.thread.join();
        }catch(InterruptedException e){
            System.out.println("The thread has been terminated.");
        }
    }
}
