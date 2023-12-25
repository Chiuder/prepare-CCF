/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-08 16:45
 */
public class NumOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i > grid.length || j > grid[0].length || grid[i][j] == '0')
            return;
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
    }
}
