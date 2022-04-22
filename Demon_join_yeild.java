package Multi_Threading;


class CheckThread extends Thread{

    public void run(){
        int count=1;
        while(true){
            System.out.println(count+" CheckThread");
            count++;
        }
    }
}
public class Demon_join_yeild {
    
    public static void main(String[] args){
        CheckThread ck=new CheckThread();
        ck.setDaemon(true);
        ck.start();
        // try {
        //     ck.sleep(100);
        // }
        // catch(Exception e){

        // }
        Thread mainThread=Thread.currentThread();  // making refrence of main method thread and using currentThread to get the refrence 
        try
        {
            mainThread.join();  //using join so that this main thread can join with the checkthread
        }
        catch(Exception e){
        }

        


    }
}
