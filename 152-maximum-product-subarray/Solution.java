public class Solution {
    // DP
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int maxHerePre = nums[0];
        int minHerePre = nums[0];
        int max = nums[0];
        int maxHere, minHere;

        for (int i = 1; i < nums.length; i++) {
            maxHere = Math.max(Math.max(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
            minHere = Math.min(Math.min(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
            max = Math.max(max, maxHere);
            maxHerePre = maxHere;
            minHerePre = minHere;
        }

        return max;
    }
}