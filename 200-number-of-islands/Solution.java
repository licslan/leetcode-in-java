public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 每发现一个岛上的一个点，让这个岛上所有点消失，数量+1
                if (grid[i][j] == '1') {
                    disappear(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    // 让这个岛上所有点消失
    private void disappear(int i, int j, char[][] grid) {
        // 数组边界
        if (i < 0 || i >= grid.length)
            return;
        if (j < 0 || j >= grid[i].length)
            return;
        // 这个岛的边界
        if (grid[i][j] == '0')
            return;

        grid[i][j] = '0';// 让岛上的这个点消失
        // 让岛上其他点消失
        disappear(i + 1, j, grid);
        disappear(i - 1, j, grid);
        disappear(i, j + 1, grid);
        disappear(i, j - 1, grid);
    }
}