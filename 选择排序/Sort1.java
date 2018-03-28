package ClassExamples;

/**
 * Created by 25375 on 2017/10/20.
 * 选择排序
 */
public class Sort1 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int temp = 0;
        int index = 0;
        for (int i=0; i<arr.length; i++) {
            arr[i] = (int) (Math.random()*100+1);
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        for (int i=0; i<arr.length; i++) {
            index = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[index] > arr[j]) {
                     index = j;
                }
            }
            if (i != index) {
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }

        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
