/*
Implementing
Polymorphism - (Runtime Polymorphism - Method Overriding),(Compiletime Polymorphism - Method Overloading)
Encapsulation- Getter/Setter Methods
Abstraction - Hiding the details
Inheritance- Extending the Classes
*/
class Bank {
    public void display() {
        System.out.println("In Bank Class");
    }
}

class SBI extends Bank {
    float Roi;

    @Override
    public void display() {
        System.out.println("In SBI Class");
    }

    public float getRoi() {
        return Roi;
    }

    public void setRoi(float Roi) {
        this.Roi = Roi;
    }
}

class ICICI extends Bank {
    String bankName;

    @Override
    public void display() {
        System.out.println("In ICICI Class");
    }

    public void add(int x, int y) {
        int c = x + y;
        System.out.println("Sum:" + c);
    }

    public void add(float x, float y)//method overloading - Change in type of parameters
    {
        float z = x + y;
        System.out.println("Sum:" + z);
    }

    public String display(String bankName)//method overloading - Change in return type and parameters
    {
        this.bankName = bankName; //setName
        return bankName; //getName
    }
}

abstract class A {
    abstract void run();
}

class B extends A {
    public void run() {
        System.out.println("In class B which extended abstract class A");
    }
}

public class Main {
    public static void main(String[] args) {
        Bank b;
        b = new SBI(); //upcasting
        b.display();

        ICICI ic = new ICICI();
        ic.display();
        ic.add(2, 5);
        ic.add(2.4f, 6.4f);
        String bn = ic.display("SBI Bank");
        System.out.println("BankName:" + bn);

        b = new ICICI(); //upcasting
        b.display();

        b = new Bank();
        b.display();

        //Abstraction
        B bb = new B(); //Object of the abstract class
        bb.run();
        A a = new B(); //Object of the abstract class (upcasting)
        a.run();


        //Encapsulation- Getter/Setter Methods
        SBI sbi = new SBI();
        sbi.setRoi(9.7f);
        float ReturnOnInvestment = sbi.getRoi();
        System.out.println("ReturnOnInvestment for SBI:" + ReturnOnInvestment);
    }
}