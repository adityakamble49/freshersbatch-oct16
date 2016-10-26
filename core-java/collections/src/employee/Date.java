package employee;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int unique = day + month;
        return prime * unique;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.day == ((Date) obj).day && this.month == ((Date) obj).month) {
            return true;
        }
        return false;
    }

}
