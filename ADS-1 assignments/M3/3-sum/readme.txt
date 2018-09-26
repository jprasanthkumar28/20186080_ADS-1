input:
first line of input is int N represent no of elements in given array
Below N line represents each element in the array

output:
print 3-sum value of the array 



int count = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			int left = i + 1;
			int right = arr.length - 1;
			while(left < right) {
				int result = arr[i] + arr1[left] + arr[right];
				if (result == 0) {
					count++;
					right--;
				}
			}
		}
		return count;