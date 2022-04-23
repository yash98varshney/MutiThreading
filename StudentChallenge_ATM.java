package Multi_Threading;

class ATM{
    synchronized protected void checkBalance(String name){
        System.out.println("Mr. "+ name+ " is checking Balance");
    }

    protected void withdraw(String name, int amount){
        synchronized(this){
            System.out.println("Mr. "+ name+ " is withdrawing " +amount);
        }
    }
}

class Customer extends Thread{
    ATM atm;
    String name;
    int amount;
    
    public Customer(ATM atm,String name,int amount){
        this.atm=atm;
        this.name=name;
        this.amount=amount;
    }

    public void useATM(){
        atm.checkBalance(this.name);
        atm.withdraw(this.name, this.amount);
    }

    public void run(){
        useATM();
    }

}

public class StudentChallenge_ATM {

    public static void main(String[] args){
        ATM atm=new ATM();
        Customer c1=new Customer(atm, "Hari", 200);
        Customer c2=new Customer(atm, "Mohan", 20);
        Customer c3=new Customer(atm, "Ram", 2000);
        c1.start();
        c2.start();
        c3.start();
    }

}
