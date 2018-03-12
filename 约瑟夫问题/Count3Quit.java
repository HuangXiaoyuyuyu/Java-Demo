package ClassExamples;

/**
 * Created by 25375 on 2017/10/20.
 */
public class Count3Quit {
    public static void main(String[] args) {
        boolean[] arr = new boolean[500];
        for (int i=0; i<arr.length; i++) {
            arr[i] = true;
        }

        int leftCount = arr.length;
        int countNum = 0;
        int index = 0;
        while (leftCount > 1) {
            if (arr[index]) {
                countNum ++;
            }
            if (countNum == 3) {
                countNum = 0;
                arr[index] = false;
                leftCount --;
            }
            index ++;

            if (index == arr.length) {
                index = 0;
            }
        }

        for (int i=0; i<arr.length; i++) {
            if (arr[i])
            System.out.println(i);
        }

    }
}


