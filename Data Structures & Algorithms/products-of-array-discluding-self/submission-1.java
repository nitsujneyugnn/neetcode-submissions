class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int product = 1;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            product *= nums[i]; 
        }
        
        if (zeroCount >= 2) {
            return new int[nums.length];
        }

        int[] result = new int[nums.length];

        if (zeroCount == 1) {
            int exception = 1;
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    exception *= nums[i];
                } else {
                    index = i;
                }
            }
            result[index] = exception;
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            product /= nums[i];
            result[i] = product;
            product *= nums[i];
        }

        return result;
    }
}  
