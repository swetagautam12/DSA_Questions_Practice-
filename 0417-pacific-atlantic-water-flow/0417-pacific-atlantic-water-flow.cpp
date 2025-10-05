class Solution {
public:
    vector<pair<int, int>> directions {{0,1}, {1,0}, {0,-1}, {-1,0}};
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        vector<vector<bool>> atl(row, vector<bool> (col, false));
        vector<vector<bool>> pac(row, vector<bool> (col, false));
        
        queue<pair<int, int>> atlanticq;
        queue<pair<int, int>> pacificq;

        for (int c = 0; c<col; c++) {
            pacificq.push({0,c});
            atlanticq.push({row-1,c});
        }
        
        for (int r = 0; r<row; r++) {
            pacificq.push({r,0});
            atlanticq.push({r,col-1});
        }
        
        bfs(pacificq, pac, grid);
        bfs(atlanticq, atl, grid);
        
        vector<vector<int>> res;

        for (int i = 0; i<row; i++) {
            for (int j = 0; j<col; j++) {
                if (atl[i][j] && pac[i][j]) {
                    res.push_back({i,j});
                }
            }
        }
        return res;
    }

    void bfs(queue<pair<int, int>> &q, vector<vector<bool>> &ocean, vector<vector<int>>& grid) {
        while (!q.empty()) {
            auto [i,j] = q.front();
            q.pop();
            ocean[i][j] = true;
            for (auto &[dr, dc] : directions) {
                int r = i + dr;
                int c = j + dc;
                if (r >=0 && c >= 0 && r<grid.size() && c<grid[0].size() && !ocean[r][c] && grid[r][c] >= grid[i][j]) {
                    q.push({r,c});
                }
            }
        }
    }
};