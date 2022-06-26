package Multi_Threading;

class Table{
    
    synchronized public static void printtable(int n){
        
            for(int i=1;i<=5;i++){
                System.out.println(n*i);
                try{
                    Thread.sleep(1000);
                }
                catch(Exception e){
                
                }
            }
       
        
    }
    
}

class Threada extends Thread{
    
    Table t1;
    Threada(Table t1){
        this.t1=t1;
    }
    public void run(){
        Table.printtable(6);
    }
    
}

class Threadb extends Thread{

    Table t1;
    Threadb(Table t1){
        this.t1=t1;
    }
    public void run(){
        Table.printtable(10);
    }
}

class Threadc extends Thread{

    Table t1;
    Threadc(Table t1){
        this.t1=t1;
    }
    public void run(){
        Table.printtable(100);
    }
}

class Threadd extends Thread{
    Table t1;
    Threadd(Table t1){
        this.t1=t1;
    }
    public void run(){
        Table.printtable(20);
    }
}


public class Static_synchronization{
    public static void main (String[] args) {
        Table t1=new Table();
        Table t2=new Table();
        Threada thread1=new Threada(t1);
        Threadb thread2=new Threadb(t1);
        thread1.start();
        thread2.start();
        
        Threadc thread3=new Threadc(t2);
        Threadd thread4=new Threadd(t2);
        thread3.start();
        thread4.start();
    }
}

