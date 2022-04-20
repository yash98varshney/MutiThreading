package Multi_Threading;

//Using 2 classes seperately 

class Mythread extends Thread{
    @Override
    public void run(){
        int i=1;
        while(true){
            System.out.println(i+" Hello");
            i++;
        }
    }
}
public class Way1_multiThread {
    
    public static void main(String[] args){
        Mythread t=new Mythread();
        t.start();
        int i=1;
        while(true){
            System.out.println(i+" World");
            i++;
        }
    }
}
