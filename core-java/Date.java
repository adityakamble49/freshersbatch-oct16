public class Date{

    private int day;
    private int month;
    private int year;

    public Date(){

    }

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDay(int day){
        this.day = day;
    }

    public void setMonth(int month){
        this.month = month;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public void printDate(){
        System.out.println("Date : " + day+ "/" + month + "/" + year);
    }

    public static void swapDates(Date[] twoDates){
        Date tmp = twoDates[0];
        twoDates[0] = twoDates[1];
        twoDates[1] = tmp;
    }

    public static void main(String args[]){
        Date date1 = new Date();
        date1.setDay(1);
        date1.setMonth(2);
        date1.setYear(2016);
        date1.printDate();

        Date date2 = new Date(2,1,1995);
        date2.printDate();

        Date[] twoDate = new Date[2];
        twoDate[0] = date1;
        twoDate[1] = date2;
        Date.swapDates(twoDate);

        twoDate[0].printDate();
        twoDate[1].printDate();

    }
}
