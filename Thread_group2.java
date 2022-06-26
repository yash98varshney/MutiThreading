package Multi_Threading;

class ThreadNew extends Thread{
    ThreadGroup tg;
    public ThreadNew(String name,ThreadGroup tg){
        super(tg,name);
        this.tg=tg;
        
        start();
    }

    @Override
    public void run(){
        System.out.println("Thread name "+ Thread.currentThread().getName());
        System.out.println("Thread group name "+ tg.getName() + " For Thread "+Thread.currentThread().getName());
    }
}

class Thread_group2{
    public static void main(String[] args) {
        ThreadGroup TGroup=new ThreadGroup("Group Alpha");
        ThreadGroup Tgroup2=new ThreadGroup(TGroup,"Child Group of Alpha");   // Using second Constructor of ThreadGroup class 
        ThreadNew t1=new ThreadNew("One", TGroup);
        ThreadNew t2=new ThreadNew("Two", TGroup);
        ThreadNew t3=new ThreadNew("Three", TGroup);
        Tgroup2.setDaemon(true);
        System.out.println(Tgroup2.isDaemon());
    }
}
