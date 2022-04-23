package Multi_Threading;

class Mydata{
    void display(String str){
        for(int i=0;i<str.length();i++){
            System.out.println(str.charAt(i));
        }
    }
}

class SynThread1 extends Thread{
    Mydata d;
    public SynThread1(Mydata data){
        d=data;
    }

    public void run(){
        d.display("Hello Worlds");
    }
}

class SynThread2 extends Thread{
    Mydata d;
    public SynThread2(Mydata data){
        d=data;
    }

    public void run(){
        d.display("Worlds");
    }
}

public class Without_syncronization {
    public static void main(String[] args){
        Mydata d=new Mydata();
        SynThread1 t1=new SynThread1(d);
        SynThread2 t2=new SynThread2(d);
        t1.start();
        t2.start();
    }
}
