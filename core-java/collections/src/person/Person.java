package person;

public class Person implements Comparable<Person> {

    private String name;
    private Double height;
    private Double weight;

    public Person(String name, Double height, Double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person o) {
        int weightCompare = this.weight.compareTo(o.weight);
        if (weightCompare == 0) {
            return this.height.compareTo(o.height);
        }
        return weightCompare;
    }

    @Override
    public String toString() {
        return this.name + " " + this.height + " " + this.weight;
    }

}
