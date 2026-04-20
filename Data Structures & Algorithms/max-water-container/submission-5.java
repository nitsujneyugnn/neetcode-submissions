class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int currArea = Math.min(heights[l], heights[r]) * (r - l);
            if (currArea > max) {
                max = currArea;
            }
            int lArea = Math.min(heights[l + 1], heights[r]) * (r - (l + 1));
            int rArea = Math.min(heights[l], heights[r - 1]) * ((r - 1) - l);
            // if (currArea < lArea || currArea < rArea) {
            //     if (lArea < rArea) {
            //         r--;
            //     } else {
            //         l++;
            //     }
            // } else {
                if (heights[l] < heights[r]) {
                    l++;
                } else {
                    r--;
                }
            // }
        }
        return max;
    }
}
