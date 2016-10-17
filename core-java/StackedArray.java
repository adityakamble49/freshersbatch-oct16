public class StackedArray {

    private int[] ary = new int[20];
    private int currentPosition = -1;

    public void push(int num){
        currentPosition++;
        ary[currentPosition] = num;
    }

    public Integer pop(){
        if(currentPosition>-1){
            int top = ary[currentPosition];
            currentPosition--;
            return top;
        }else{
            System.out.print("Stack Empty !");
        }
        return null;
    }

    public static void main(String args[]){
        StackedArray a1 = new StackedArray();
        a1.push(10);
        a1.push(20);
        a1.push(30);
        System.out.println(a1.pop());
        a1.push(40);
        System.out.println(a1.pop());
        System.out.println(a1.pop());
        System.out.println(a1.pop());
        System.out.println(a1.pop());
    }
}
