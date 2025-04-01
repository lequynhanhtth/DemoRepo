package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] arr =nextPermutation(new int[]{3,2,1});
        System.out.println(Arrays.toString(arr));
    }
    public static int[] nextPermutation(int[] nums) {

        if(nums.length == 1) {
            return nums;
        }
        if(nums.length == 2) {
            return new int[]{nums[1],nums[0]};
        }
        if( nums[0] > nums[1]) {
            int[] result = new int[nums.length];
            int[] result1 = new int[nums.length];
            for(int i = nums.length-1 ; i>=0 ; i--) {
                result[nums.length-1-i] = nums[i];
            }
            for(int i = 0; i< nums.length; i++) {
                System.out.println(result[i]);
                result1[i] = result[i];
            }
            return result1;
        } else {
            for(int i = 1 ; i < nums.length-1 ; i++) {
                if(nums[i] != nums[i+1]) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }

            }}
        return nums;
    }
}
