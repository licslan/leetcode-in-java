public class Solution {
    // the solution is guaranteed to be unique
    // following solution is based on 2 idea
    // If car starts at A and can not reach B. Any station between A and B can not reach B.(B is the first station that A can not reach.)
    // If the total number of gas is bigger than the total number of cost. There must be a solution.
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0, start = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return gasSum < costSum ? -1 : start;
    }

    // Error!!!Time Limit Exceeded!
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int count = 0, left = 0;
            for (int j = i; j < i + gas.length; j++) {
                left += gas[j%gas.length] - cost[j%gas.length];
                if (left >= 0) count++;
                else if (count != gas.length) break;
                else return i;
            }
        }
        return -1;
    }
}