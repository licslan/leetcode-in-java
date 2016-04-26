public class Solution {
    public int trap(int[] A) {
        int low = 0;
        int high = A.length - 1;
        int secHigh = 0;
        int area = 0;
        while (low < high) {
            if (A[low] < A[high]) {
                secHigh = Math.max(A[low], secHigh);
                area += secHigh - A[low];
                low++;
            } else {
                secHigh = Math.max(A[high], secHigh);
                area += secHigh - A[high];
                high--;
            }
        }
        return area;
    }
}
