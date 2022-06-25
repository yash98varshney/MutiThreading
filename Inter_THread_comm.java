package Multi_Threading;

class SharedObject{

    int value;
    boolean flag=true;

    synchronized public void set(int v){
        while(flag!=true){
            try{
                wait();
            }
            catch(Exception e){

            }
        }
        value=v;    // after wait set the value 
        flag=false;          // make flag false so that consumer can use it's method 
        notify();            // and notify consumer wake up all the threads 
    }

    synchronized public int get(){
        int x=0;
        while(flag!=false){     // wait till flag != false means when producer is using it's set function this method has to wait 
            try{
                wait();
            }
            catch(Exception e){

            }
        }
        x=value;  // after wait get the value
        flag=true;     // make flag true so that producer can use his chance
        notify();      // also notify producer 
        return x;
    }
}

class Producer extends Thread{
    SharedObject shared;

    public Producer(SharedObject s){
        shared=s;
    }

    public void run(){
        int count=1;
        while(true){
            shared.set(count);
            System.out.println("Producer " +count);
            try{
                sleep(100);
            }
            catch(Exception e){}
            count++;
        }
    }

}

class Consumer extends Thread{
    SharedObject shared;

    public Consumer(SharedObject s){
        shared=s;
    }

    public void run(){
        int val;
        while(true){
            val=shared.get();
            System.out.println("Consumer "+val);
            try{
                sleep(100);
            }
            catch(Exception e){}
        }
    }

}



public class Inter_THread_comm {
    public static void main(String[] args){
        SharedObject shared=new SharedObject();
        Producer p=new Producer(shared);
        Consumer c=new Consumer(shared);
        p.start();
        c.start();
    }
}
