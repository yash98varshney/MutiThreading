package Multi_Threading;

public class Way2_multiThread extends Thread{
    
    @Override
    public void run(){
        int i=1;
        while(true){
            System.out.println(i+" Hello");
            i++;
        }
    }

    public static void main(String[] args){
        
        Way2_multiThread t=new Way2_multiThread();
        t.start();
        int i=0;
        while(true){
            System.out.println(i+" world");
            i++;
        }


    }

}
