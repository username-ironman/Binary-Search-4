import java.util.*;

class Solution {
    // Binary Search solution
    // Time complexity is O(nlog(m)) where m is the largest array length
    // Space complexity is O(1)
    // This solution is submitted on leetcode with zero errors
    public int[] intersect(int[] nums1, int[] nums2) {
        // Edge case
        if(nums1==null || nums2==null) return new int[0];
        
        if(nums1.length>nums2.length) intersect(nums2, nums1);
        //Sorting the array as followup question
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int low = 0;
        for(int num: nums1){
            int res = binarySearch(nums2,low, num);
            if(res!=-1){
                result.add(num);
                low = res+1;
            }
        }
        int[] arr = new int[result.size()];
        for(int k = 0; k<result.size();k++){
            arr[k]=result.get(k);
        }
        return arr;
    }
    private int binarySearch(int[] vals, int low, int target){
        int high = vals.length -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(vals[mid]== target){
                if(mid == low || vals[mid-1]!=target) return mid;
                high = mid-1;
            } else if(vals[mid]<target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }
}