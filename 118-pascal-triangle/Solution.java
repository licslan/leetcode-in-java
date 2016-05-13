public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            res.add(list);
        }
        for (int i = 2; i < numRows; i++)
            for (int j = 1; j < i; j++)
                res.get(i).add(j, res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
        return res;
    }

    // a better and more concise solution
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            res.add(new ArrayList<Integer>(row));
        }
        return res;
    }
}