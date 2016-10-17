public class QueuedArray {

    private int[] ary = new int[20];
    private int headPosition = 0;
    private int tailPosition = -1;

    public void push(int num){
        tailPosition++;
        ary[tailPosition] = num;
    }

    public Integer pop(){
        if(headPosition<=tailPosition){
            int top = ary[headPosition];
            headPosition++;
            return top;
        }else{
            System.out.print("Queue Empty !");
        }
        return null;
    }

    public static void main(String args[]){
        QueuedArray a1 = new QueuedArray();
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
