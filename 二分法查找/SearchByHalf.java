package ClassExamples;

/**
 * Created by 25375 on 2017/10/21.
 * 二分法查找
 */
public class SearchByHalf {
    public static int binarySearch(int[] a, int m) {
        int startPos = 0;
        int endPose = a.length - 1;
        int middle = 0;
        while(startPos <= endPose) {
            middle = (startPos + endPose) / 2;
            if (m == a[middle]) {
                return middle;
            }else if (m > a[middle]) {
                startPos = middle + 1;
            }else {
                endPose = middle - 1;
            }
        }
        return middle;
    }

    public static void main(String[] args) {
        int[] arr = {-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int m = (int) (Math.random()*19+1);
    //    int m = -3;
        System.out.println(m);
        System.out.println(binarySearch(arr,m));
    }
}
