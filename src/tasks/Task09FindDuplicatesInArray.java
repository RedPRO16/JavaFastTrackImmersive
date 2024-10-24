package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task09FindDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums = {1,1,4,3,1,5,6,5,2, 2};
        //1, 5
        nums = findDuplicates(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {1,1,4,3,1,5,6,5,2, 2};
        nums2 = findUnique(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    public static int[] findUnique(int[] nums) {
        //track nums that we already checked
        List<Integer> checked = new ArrayList<>();
        //array to store values that we know has duplicates
        int[] uniqueArr = new int[nums.length];
        int index = 0;
        for(int each : nums) {

            //check if already counted for this number
            if (checked.contains(each)) {
                continue;
            }

            //loop through array and count number of matches
            int count = 0;
            for(int temp : nums) {
                if (temp == each) {
                    count++;
                }
            }
            //if unique found then add to uniqueArr
            if(count == 1) {
                checked.add(each);
                uniqueArr[index++] = each;
            }
        }
        //return only duplicate values part.
        return Arrays.copyOf(uniqueArr, checked.size());
    }

    public static int[] findDuplicates(int[] nums) {
        //track nums that we already checked
        List<Integer> checked = new ArrayList<>();
        //array to store values that we know has duplicates
        int[] dupArr = new int[nums.length];
        int index = 0;
        for(int each : nums) {

            //check if already counted for this number
            if (checked.contains(each)) {
                continue;
            }

            //loop through array and count number of matches
            int count = 0;
            for(int temp : nums) {
                if (temp == each) {
                    count++;
                }
            }
            //if duplicate found then add to dupArray
            if(count > 1) {
                checked.add(each);
                dupArr[index++] = each;
            }
        }
        //return only duplicate values part.
        return Arrays.copyOf(dupArr, checked.size());
    }
}
