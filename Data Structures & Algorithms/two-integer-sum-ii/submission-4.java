class Solution {
    public static void bubbleSort(int[] arr) {
		for(int i= 0; i<arr.length-1;i++) {
			for(int j = 0;j<arr.length-1-i;j++) {
				if(arr[j] == arr[j+1] || arr[j] <arr[j+1]) {
					continue;
				}
				else {
					int temp = arr[j];
					arr[j] =arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = numbers.length-1;
        bubbleSort(numbers);
        while(start != end) {
        	if(numbers[start] + numbers[end] == target) {
        		res[0] = start+1;
        		res[1] = end+1;
        		break;
        	}
        	else if(numbers[start] + numbers[end] < target) {
        		start++;
        		continue;
        	}
        	else {
        		end--;
        		continue;
        	}
        }
        return res;
    }
}
