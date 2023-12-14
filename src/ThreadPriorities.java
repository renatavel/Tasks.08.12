public class ThreadPriorities implements Runnable{
    int count; Thread thread; static boolean stop=false; static String currentName;

    ThreadPriorities(String name){
        thread=new Thread(this,name);
        count=0;
        currentName=name;
    }

    public void run(){
        System.out.println(thread.getName()+ "starts to operate");
        do{
            count++;
            if(currentName.compareTo(thread.getName()) !=0){
                currentName=thread.getName();
                System.out.println(currentName+ " is executed");
            }
        }while(stop==false && count<10_000_000);
        stop=true;
        System.out.println("\n"+ thread.getName()+ " finishes running");
    }
}
class PriorityDemo{
    public static void main(String[] args) {
        ThreadPriorities mt1=new ThreadPriorities("High priority thread");
        ThreadPriorities mt2=new ThreadPriorities("Thread with low priority");
        ThreadPriorities mt3=new ThreadPriorities("Thread 1 with normal priority");
        ThreadPriorities mt4=new ThreadPriorities("Thread 2 with normal priority");
        ThreadPriorities mt5=new ThreadPriorities("Thread 3 with normal priority");

        mt1.thread.setPriority(Thread.MAX_PRIORITY);
        mt2.thread.setPriority(Thread.MIN_PRIORITY);

        mt1.thread.start();mt2.thread.start();mt3.thread.start();mt4.thread.start();mt5.thread.start();
        try {
            mt1.thread.join();mt2.thread.join();mt3.thread.join();mt4.thread.join();mt5.thread.join();
        }catch (InterruptedException e){
            System.out.println("The main thread starts running.");
        }
        System.out.println("High priority thread counted to "+mt1.count);
        System.out.println("Low priority thread counted to "+mt2.count);
        System.out.println("1 Normal priority thread counted to "+mt3.count);
        System.out.println("2 Normal priority thread counted to "+mt4.count);
        System.out.println("3 Normal priority thread counted to "+mt5.count);
        //7 out of 10
    }
}
