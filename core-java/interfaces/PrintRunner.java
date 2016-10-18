public class PrintRunner {

    public static void printAll(Printable[] printableArray){
        for(int i=0; i<printableArray.length; i++){
            printableArray[i].print();
        }
    }

    public static void main(String[] args){

        Printable[] printArray = new Printable[2];
        printArray[0] =  new Employee(1, "ABC");
        printArray[1] =  new Circle(5);

        printAll(printArray);

    }
}

interface Printable {
    void print();
}

class Employee implements Printable {

    private int empID;
    private String name;

    public Employee(int empID, String name){
        this.empID = empID;
        this.name = name;
    }

    public void print(){
        System.out.println("Employee : " + empID + " : " + name);
    }
}

class Circle implements Printable {

    private int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    public void print(){
        System.out.println("Circle : " + radius);
    }
}
