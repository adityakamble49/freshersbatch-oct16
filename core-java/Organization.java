public class Organization{

    public static double getTotalSalary(Employee[] empArray){

        double totalSalary = 0;

        for(int i =0; i<empArray.length; i++){
            totalSalary += empArray[i].getSalary();
        }

        return totalSalary;
    }

    public static void main(String[] args){

        Employee[] empArray = new Employee[5];

        empArray[0] = new Manager(1, "ABC1", 100000, 50000);
        empArray[1] = new Labour(2, "ABC2", 100000, 50000);
        empArray[2] = new Manager(3, "ABC3", 100000, 50000);
        empArray[3] = new Labour(4, "ABC4", 100000, 50000);
        empArray[4] = new Manager(5, "ABC5", 100000, 50000);

        System.out.println("Total Salary : " + getTotalSalary(empArray));
    }
}

class Employee {

    private int empID;
    private String empName;
    private double salary;

    public Employee(int empID, String empName, double salary){
        this.empID = empID;
        this.empName = empName;
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

}

class Manager extends Employee{

    private double incentive;

    public Manager(int empID, String empName, double salary,
            double incentive){
        super(empID, empName, salary);
        this.incentive = incentive;
    }

    public double getSalary(){
        return super.getSalary() + incentive;
    }
}

class Labour extends Employee{

    private double overtime;

    public Labour(int empID, String empName, double salary,
            double overtime){
        super(empID, empName, salary);
        this.overtime = overtime;
    }

    public double getSalary(){
        return super.getSalary() + overtime;
    }
}
