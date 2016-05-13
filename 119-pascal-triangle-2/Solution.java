public class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex--;
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
        }
        return row;
    }

    // runtime beats 84.70%
    public List<Integer> getRow(int rowIndex) {
        int[] row = new int[rowIndex + 1];
        row[0] = 1;
        for (int i = 1; i <= rowIndex; i++)
            for (int j = i; j > 0; j--)
                row[j] += row[j - 1];
        List<Integer> list = new ArrayList<>();
        for (int a : row) list.add(a);
        return list;
    }
}