package Multi_Threading;

import java.util.concurrent.*;


class WorkerThread implements Runnable{

    private String message;

    public WorkerThread(String message){
        this.message=message;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+" Start " + message);
        try{
            Thread.sleep(1000);

        }
        catch(Exception e){

        }

        System.out.println(Thread.currentThread().getName()+" End " + message);
    }
}

public class Java_Thread_Pool {
    
    public static void main(String[] args) {
        ExecutorService exe=Executors.newFixedThreadPool(5);
        for(int i=1;i<10;i++){
            Runnable rn=new WorkerThread(""+i);
            exe.execute(rn);
        }

        exe.shutdown();
        System.out.println("Finished all threads");
    }

}
