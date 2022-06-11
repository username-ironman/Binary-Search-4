import java.util.*;

class Solution {
    // Hashmap solution
    // Time complexity is O(m+n)
    // Space complexity is O(min(m,n))
    // This solution is submitted on leetcode with zero errors
    public int[] intersect(int[] nums1, int[] nums2) {
        //Edge case
        if(nums1== null || nums2 == null) return new int[0];
        int m = nums1.length;
        int n = nums2.length;
        if(m>n) intersect(nums2,nums1);
        // Now my nums1 is smaller
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums1){
            if(!map.containsKey(i)) map.put(i,0);
            map.put(i,map.get(i)+1);
        }
        List<Integer> result = new ArrayList<>();
        for(int j : nums2){
            if(map.containsKey(j)){
                result.add(j);
                map.put(j,map.get(j)-1);
                map.remove(j,0);
            }
        }
        int[] arr = new int[result.size()];
        for(int k = 0; k<result.size();k++){
            arr[k]=result.get(k);
        }
        return arr;
    }
}