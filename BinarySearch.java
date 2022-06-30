import java.util.Arrays;
import java.lang.Math;
public class BinarySearch
{
    public static void main(String args[]){
        System.out.println("Binary Search");
        int[] bigO = new int[3];
        
        int[] test10 = makeTest(10);
        System.out.println("original array is: "+ Arrays.toString(test10));
        System.out.println("searching for 10 random nums in a list of 10");
        bigO = runTest(test10, 10);
        System.out.println("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);
        
        int[] test100 = makeTest(100);
        System.out.println("original array is: " + Arrays.toString(test100));
        System.out.println("searching for 10 random nums in a list of 100");
        bigO = runTest(test100, 100);
        System.out.println("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);
        /*
        int[] test1000 = makeTest(1000);
        System.out.println("original array is: " + Arrays. toString (test1000));
        System.out.println("searching for 10 random nums in a list of 1000");
        bigO = runTest(test1000, 1000);
        System.out.println ("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);
        
        System.out.println("\n");
        
        int[] test10k = makeTest(10000);
        System.out.println("searching for 10 random nums in a list of 10,000");
        bigO = runTest(test10k, 10000);
        System.out.println ("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);
        
        int[] test100k = makeTest(100000);
        System.out.println("searching for 10 random nums in a list of 100,000");
        bigO = runTest(test100k, 100000);
        System.out.println ("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);
        
        int[] test1M = makeTest(1000000);
        System.out.println("searching for 10 random nums in a list of 1,000,000");
        bigO = runTest(test1M, 1000000);
        System.out.println ("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);
        */
    }
    
    public static int[] makeTest(int n) {//generate n randoms numbers between 1-n, Arrays.sort()
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * n) + 1;
        }
        Arrays.sort(arr);
        return arr;
    }
    
    public static int[] runTest(int[] nums, int n) {//check middle, if >x move right, else left
        //if >x --> left = mid
        //else --> right = mid
        int[] results = new int[]{n, 0, 0};//best, average, worst
        for (int i = 0; i < 10; i++) {//trials
            int search = (int)(Math.random() * n) + 1;
            int left = 0;
            int right = nums.length-1;
            while (left <= right) {
                //System.out.println("in while loop");
                int mid = (left + right) / 2;
                if (nums[mid] == search) {
                    if (mid < results[0])//best
                        results[0] = mid+1; 
                    if (mid > results[2]) //worst
                        results[2] = mid+1;
                    results[1] += mid+1;
                    break;
                }
                if (nums[mid] > search) {
                    right = mid;
                }
                else if (nums[mid] < search) {
                    left = mid+1;
                }
                
            }
        }
        results[1] = results[1] / 10;
        return results;
    }
}
