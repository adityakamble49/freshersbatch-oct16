public class ComplexNumber {

    int real;
    int imaginary;

    public ComplexNumber(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public void printNumber(){
        System.out.println("Number: " + real + "+" + imaginary + "i");
    }

    public void addNumber(ComplexNumber complexNumber){
        int realSum = this.real + complexNumber.real;
        int imaginarySum = this.imaginary + complexNumber.imaginary;
        System.out.println("Addition : " + realSum + "+" + imaginarySum
                + "i");
    }

    public void subtractNumber(ComplexNumber complexNumber){
        int realSub = this.real - complexNumber.real;
        int imaginarySub = this.imaginary - complexNumber.imaginary;
        System.out.println("Subtraction : " + realSub + "+" + imaginarySub
                + "i");
    }

    public void multiplyNumber(ComplexNumber complexNumber){
        int realMul = this.real * complexNumber.real;
        int imaginaryMul = this.imaginary * complexNumber.imaginary;
        System.out.println("Multiplication : " + realMul + "+" + imaginaryMul
                + "i");
    }

    public static void swapNumbers(ComplexNumber[] twoNumbers){
        ComplexNumber tmp = twoNumbers[0];
        twoNumbers[0] = twoNumbers[1];
        twoNumbers[1] = tmp;
    }

    public static void main(String args[]){
        ComplexNumber c1 = new ComplexNumber(5,8);
        ComplexNumber c2 = new ComplexNumber(2,3);

        c1.addNumber(c2);
        c1.subtractNumber(c2);
        c1.multiplyNumber(c2);

        ComplexNumber[] twoNumbers = new ComplexNumber[2];
        twoNumbers[0] = c1;
        twoNumbers[1] = c2;
        ComplexNumber.swapNumbers(twoNumbers);

        twoNumbers[0].printNumber();
        twoNumbers[1].printNumber();

    }
}
