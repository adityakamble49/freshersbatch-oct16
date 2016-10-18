import java.util.*;

public class PersonRunner {
    public static void main(String[] args){

        Person[] personArray = new Person[2];
        personArray[0] = new Person("Akshay Chordiya", 66.0, 67.0);
        personArray[1] = new Person("Aditya Kamble", 64.8, 68.0);

        System.out.println();
        System.out.println("Sorted Using Comparable Name");
        Arrays.sort(personArray);
        for (int i=0; i<personArray.length; i++){
            System.out.println(personArray[i]);
        }

        System.out.println();
        System.out.println("Sorted Using Height");
        Arrays.sort(personArray, new HeightComparator());
        for (int i=0; i<personArray.length; i++){
            System.out.println(personArray[i]);
        }

        System.out.println();
        System.out.println("Sorted Using Weight");
        Arrays.sort(personArray, new WeightComparator());
        for (int i=0; i<personArray.length; i++){
            System.out.println(personArray[i]);
        }
    }
}

class Person implements Comparable<Person> {

    private String name;
    private Double height;
    private Double weight;

    public Person(String name, Double height, Double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName(){
        return name;
    }

    public Double getHeight(){
        return height;
    }

    public Double getWeight(){
        return weight;
    }

    public String toString(){
        return name + " Height : " + height + " Weight : " + weight;
    }

    public int compareTo(Person p){
        return this.name.compareTo(p.getName());
    }

}

class HeightComparator implements Comparator<Person>{
    @Override
    public int compare(Person p1, Person p2){
        return p1.getHeight().compareTo(p2.getHeight());
    }
}

class WeightComparator implements Comparator<Person>{
    @Override
    public int compare(Person p1, Person p2){
        return p1.getWeight().compareTo(p2.getWeight());
    }
}
