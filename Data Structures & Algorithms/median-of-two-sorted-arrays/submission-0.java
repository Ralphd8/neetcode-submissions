class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = res(nums1,nums2,0,0);
        if(res.length % 2 == 0) {
        	double x = res[res.length/2];
        	double y = res[res.length/2 -1];
        	return (x+y)/2;
        }
        else {
        	double x = res[res.length/2];
        	return x;
        }
    }
    public int[] res (int[] nums1,int[] nums2,int start1,int start2) {
		int[] res = new int[nums1.length+nums2.length];
		int i = 0;
		while(start1 != nums1.length || start2 != nums2.length) {
			
			if(start1 == nums1.length) {
				for (int j = i;j<res.length;j++) {
					res[j] = nums2[start2];
					start2++;
				}
				break;
			}
			if(start2 == nums2.length) {
				for (int j = i;j<res.length;j++) {
					res[j] = nums1[start1];
					start1++;
				}
				break;
			}
			if(nums1[start1] <= nums2[start2]) {
				res[i] = nums1[start1];
				i++;
				start1++;
			}
			else {
				res[i] = nums2[start2];
				i++;
				start2++;
			}
			
		}
		return res;
	}
}
