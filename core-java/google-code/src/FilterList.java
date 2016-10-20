/*
 int answer({1, 4, 3, 3, 5, 6, 5, 5, 99, 100}, 2) will return – {1, 4, 3, 3, 6, 99, 100}
 int answer({1, 2, 3}, 0) will return – {}
 int answer{1, 2, 2, 3, 3, 3, 4, 5, 5}, 1) will return – {1, 4}
 int answer({1, 2, 3}, 6) will return – {1, 2 3}
 int answer({1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2}, 4) will return – {2, 2, 2, 2}
 Constraints – You can’t use any Java APIs, not even standard APIs.
 You can create your data structures. But code needs to plain simple Java.
 Your solution also has to work in a reasonable time, else it gets rejected.
 There is no indication of how soon it should return the value, it’s up to Google.
 */

public class FilterList {

    public static void main(String[] args) {

        int[] array = { 1, 4, 3, 3, 5, 6, 5, 5, 99, 100 };
        int count = 2;
        int[] array2 = { 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2 };
        int count2 = 4;
        int[] array3 = { 1, 2, 2, 3, 3, 3, 4, 5, 5 };
        int count3 = 1;

        int[] result = ListFilter.filter(array3, count3);
        for (int i = 0; i < ListFilter.resultArrayCounter; i++) {
            System.out.println(result[i]);
        }
        System.out.println(ListFilter.resultArrayCounter);
        ListFilter.resultArrayCounter = 0;
    }
}

class ListFilter {

    static int resultArrayCounter = 0;

    public static int[] filter(int[] array, int maxCount) {

        int currentPos = 0;
        int currentCounter = 0;
        int currentValue = 0;
        int[] resultArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {

            currentValue = array[i];

            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    currentCounter++;
                }
            }

            if (currentCounter < maxCount) {
                resultArray[resultArrayCounter] = currentValue;
                resultArrayCounter++;
            }

            currentCounter = 0;
        }
        return resultArray;
    }
}