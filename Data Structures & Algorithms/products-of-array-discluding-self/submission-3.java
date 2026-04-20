class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
        }
        int product = 1;
        if (zeroCount >= 2) {
            return result;
        } else if (zeroCount == 1) {
            int zeroIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    product *= nums[i];
                } else {
                    zeroIndex = i;
                }
            }
            result[zeroIndex] = product;
            return result;
        } else {
            for (int i = 0; i < nums.length; i++) {
                product *= nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                result[i] = product / nums[i];
            }
            return result;
        }
    }
}  
