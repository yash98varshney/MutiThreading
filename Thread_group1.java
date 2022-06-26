package Multi_Threading;

class MyRunnable implements Runnable{
    
    String name;
    MyRunnable(String name){
        this.name=name;
    }
    
    public void run(){
        System.out.println("Group number : "+ Thread.currentThread().getName());
    }
}

class Thread_group1{
    public static void main (String[] args) {
        
        //Constructor ThreadGroup(String group_name)  or   ThreadGroup(ThreadGroup parent, String name)
        ThreadGroup tg1=new ThreadGroup("Group A");
        Thread t1=new Thread(tg1,new MyRunnable("1"),"one");  // Parent Group_name,Implmented class , Name_of_thread
        Thread t2=new Thread(tg1,new MyRunnable("2"),"two");
        Thread t3=new Thread(tg1,new MyRunnable("3"),"three");
        
        
        
        t1.start();
        t2.start();
        t3.start();
        
        // try{
        //     t1.join();
        //     t3.join();
        //     t2.join();
        // }
        // catch(Exception e){
            
        // }
        System.out.println(tg1.activeCount());
        tg1.list();
    }
}
