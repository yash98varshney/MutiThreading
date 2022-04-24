package Multi_Threading;

class Whiteboard{

    String text;
    int numberofstudents=0;
    int count=0;

    synchronized public void write(String t){
        System.out.println("Teacher writting "+t);
        while(count!=0){
            try{
                wait();
            }
            catch(Exception e){

            }
        }
        text=t;
        count=numberofstudents;
        notifyAll();

    }

    synchronized public String read(){
        while(count==0){
            try{
                wait();
            }
            catch(Exception e){

            }
        }
        String t=text;
        count--;
        if(count==0){
            notifyAll();
        }
        return t;
    }

    public void attendance(){
        numberofstudents++;
    }
}


class Teacher extends Thread{
    Whiteboard wb;
    String[] notes={"Hello", "please not this", "Java is language","end" };

    public Teacher(Whiteboard w){
        wb=w;
    }
    public void run(){
        for(int i=0;i<notes.length;i++){
            wb.write(notes[i]);
        }
    }
}

class Student extends Thread{
    String name;
    Whiteboard wb;

    public Student(String n,Whiteboard w){
        name=n;
        wb=w;
    }

    public void run(){
        String text;
        
        wb.attendance();

        do{
            text=wb.read();
            System.out.println(name + " Reading "+ text);
            System.out.flush();
        }
        while(!text.equals("end"));
        
    }
}

public class Student_Challenge_Teacher {
    public static void main(String[] args){
        Whiteboard wb=new Whiteboard();
        Teacher t=new Teacher(wb);

        Student s1=new Student("1. John", wb);
        Student s2=new Student("2. Harry", wb);
        Student s3=new Student("3. Ajay", wb);
        Student s4=new Student("4. Smith", wb);

        t.start();
        s1.start();
        s2.start();
        s3.start();
        s4.start();
        

    }
}
