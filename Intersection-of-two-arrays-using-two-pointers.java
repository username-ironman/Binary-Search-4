import java.util.*;

class Solution {
    // Two pointer solution
    // Time complexity is O(m+n)
    // Space complexity is O(1)
    // This solution is submitted on leetcode with zero errors
    public int[] intersect(int[] nums1, int[] nums2) {
        // Edge case
        if(nums1==null || nums2==null) return new int[0];
        
        if(nums1.length>nums2.length) intersect(nums2, nums1);
        //Sorting the array as followup question
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        int p1 = 0;
        int p2 = 0;
        List<Integer> result = new ArrayList<>();
        while(p1<m && p2<n){
            if(nums1[p1] == nums2[p2]){
                result.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1]<nums2[p2]){
                p1++;
            } else p2++;
        }
        int[] arr = new int[result.size()];
        for(int k = 0; k<result.size();k++){
            arr[k]=result.get(k);
        }
        return arr;
    }
}