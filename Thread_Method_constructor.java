package Multi_Threading;

class NewThread2 extends Thread{

    //Constructor

    public NewThread2(String name){   // We have to create a thread with some name but no option to creat it directly because we create direct object of extended class and run the thread 
        super(name);  // so we make constructer of extending class and use super to set the constructor of Thread class 
        //setPriority(9);
        setPriority(Thread.MAX_PRIORITY);
    }

    @Override
    public void run(){
        int count=1;
        while(true){
            System.out.println(count);
            try{
                Thread.sleep(1000);     
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            
            count++;
        }
    }
}

class Thread1 implements Runnable{
    public void run(){};
}

public class Thread_Method_constructor {

    public static void main(String[] args){

        // making constructor using Runnable R object as parameter
        Thread t1=new Thread(new Thread1());  
        t1.start();
        // making constructor using Runnable R object as parameter and name of thread
        Thread t2=new Thread(new Thread1(),"Thread2"); 
        t2.start();

        NewThread2 t3=new NewThread2("Thread3");
        t3.start();
        t3.interrupt();
        // These all will print only once as we have called these fuctions once 

        System.out.println("Id: "+ t3.getId());
        System.out.println("Name: "+t3.getName());
        System.out.println("Priority: "+ t3.getPriority());
        System.out.println("State: "+ t3.getState());
        System.out.println("State: "+ t3.isAlive());

    }

    
}
