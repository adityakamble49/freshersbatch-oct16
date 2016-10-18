public class Cloning {
    public static void main(String[] args) throws Exception {

        Employee e1 = new Employee(1, new Date(1,2,1994));
        Employee e2 = e1.clone();

        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());

        EmployeeDeep ed1 = new EmployeeDeep(1, new Date(1,2,1994));
        EmployeeDeep ed2 = ed1.clone();

        System.out.println(ed1.hashCode());
        System.out.println(ed2.hashCode());

    }
}

class Employee implements Cloneable {

    private int empID;
    private Date dateOfBirth;

    public Employee(int empID, Date dateOfBirth){
        this.empID = empID;
        this.dateOfBirth = dateOfBirth;
    }

    public String toString(){
        return empID + " : " + dateOfBirth;
    }

    public Employee clone() throws CloneNotSupportedException {
        return (Employee)super.clone();
    }
}

class EmployeeDeep implements Cloneable {

    private int empID;
    private Date dateOfBirth;

    public EmployeeDeep(int empID, Date dateOfBirth){
        this.empID = empID;
        this.dateOfBirth = dateOfBirth;
    }

    public String toString(){
        return empID + " : " + dateOfBirth;
    }

    public EmployeeDeep clone() throws CloneNotSupportedException {
        EmployeeDeep ed = (EmployeeDeep)super.clone();
        ed.dateOfBirth = (Date) dateOfBirth.clone();
        return ed;
    }
}

class Date implements Cloneable {

    private int date;
    private int month;
    private int year;

    public Date(int date, int month, int year){
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public String toString(){
        return date + "/" + month + "/" + year;
    }

    public Date clone() throws CloneNotSupportedException {
        return (Date) super.clone();
    }
}
