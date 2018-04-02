package ClassExamples;

/**
 * 冒泡排序法
 */
public class Sort2 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int temp = 0;
        for (int i=0; i<arr.length; i++) {
            arr[i] = (int) (Math.random()*100+1);
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        for (int i=arr.length-1; i>=1; i--) {
            for (int j=0; j<=i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
