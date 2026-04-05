class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combined = new int[nums1.length + nums2.length];
        int qty1 = 0;
        int qty2 = 0;
        for(int i =0 ;i<combined.length;i++) {
        	if(nums2.length == 0 || qty2 == nums2.length) {
        		combined[i] = nums1[qty1];
        		qty1++;
        	}
        	else if(nums1.length == 0 || qty1 == nums1.length) {
        		combined[i] = nums2[qty2];
        		qty2++;
        	}
        	else {
        		if(nums1[qty1] <= nums2[qty2]) {
        			combined[i] = nums1[qty1];
        			qty1++;
        		}
        		else {
        			combined[i] = nums2[qty2];
        			qty2++;
        		}
        	}
        }
        
        if(combined.length % 2 == 1) {
        	return combined[combined.length/2];
        }
        else {
        	double num1 = combined[combined.length/2];
        	double num2 = combined[combined.length/2-1];
        	double res = (num1+num2) /2;
        	return res;
        }
    }
}
