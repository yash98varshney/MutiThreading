package Multi_Threading;

class Mydata1{
    synchronized void display(String str){   //Making Synchronized method  // This will become monitor and is called Critical section as Many threads are using this similtaniously
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i));
            try{
               Thread.sleep(100);  
            }
            catch(Exception e){

            }
        }
    }
}

class SynThread3 extends Thread{
    Mydata1 d;
    public SynThread3(Mydata1 d){
        this.d=d;
    }

    public void run(){
        d.display("Hello Worlds");
    }
}

class SynThread4 extends Thread{
    Mydata1 d;
    public SynThread4(Mydata1 d){
        this.d=d;
    }

    public void run(){
        d.display("Welcome All");
    }
}

public class With_Syncronization {
    public static void main(String[] args){
        Mydata1 d=new Mydata1();
        SynThread3 t1=new SynThread3(d);
        SynThread4 t2=new SynThread4(d);
        t1.start();
        t2.start();
    }
}
