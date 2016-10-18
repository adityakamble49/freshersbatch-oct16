public class SortRunner {

    public static Sortable[] sortAll(Sortable[] sortableArray){

        for(int i=0; i<sortableArray.length; i++){
            for(int j=0; j<sortableArray.length; j++){
                if(sortableArray[i].compare(sortableArray[j]) == 1){
                    Sortable temp = sortableArray[i];
                    sortableArray[i] = sortableArray[j];
                    sortableArray[j] = temp;
                }
            }
        }

        return sortableArray;
    }

    public static void main(String[] args){

        Sortable[] sortableArray = new Sortable[5];
        sortableArray[0] = new Employee(2, "ABC");
        sortableArray[1] = new Employee(3, "ABC");
        sortableArray[2] = new Employee(1, "ABC");
        sortableArray[3] = new Employee(5, "ABC");
        sortableArray[4] = new Employee(4, "ABC");

        Sortable[] sortableArray1 = new Sortable[5];
        sortableArray1[0] = new Circle(2);
        sortableArray1[1] = new Circle(3);
        sortableArray1[2] = new Circle(1);
        sortableArray1[3] = new Circle(5);
        sortableArray1[4] = new Circle(4);

        Sortable[] sortedArray = sortAll(sortableArray);
        for(int i=0; i<sortedArray.length; i++){
            System.out.println(sortedArray[i]);
        }

        Sortable[] sortedArray1 = sortAll(sortableArray1);
        for(int i=0; i<sortedArray1.length; i++){
            System.out.println(sortedArray1[i]);
        }

    }
}

interface Sortable {
    int compare(Sortable anotherSortable);
}


class Employee implements Sortable {

    private int empID;
    private String name;

    public Employee(int empID, String name){
        this.empID = empID;
        this.name = name;
    }

    public int compare(Sortable anotherSortable){
        if(this.empID < ((Employee)anotherSortable).empID){
            return 1;
        }else{
            return 0;
        }
    }

    public String toString(){
        return empID + " : " + name;
    }
}

class Circle implements Sortable {

    private int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    public int compare(Sortable anotherSortable){
        if(this.radius < ((Circle)anotherSortable).radius){
            return 1;
        }else{
            return 0;
        }
    }

    public String toString(){
        return "Circle : " + radius;
    }
}
