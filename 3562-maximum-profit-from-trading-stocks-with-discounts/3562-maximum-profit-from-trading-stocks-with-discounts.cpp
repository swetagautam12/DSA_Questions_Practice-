class Solution {
public:
    std::vector<std::vector<int>> graph;
    int B;
    int maxProfit(int n, vector<int>& present, vector<int>& future, vector<vector<int>>& hierarchy, int budget) {
        

        std::vector<std::vector<std::vector<int>>>dp(n, std::vector<std::vector<int>>(2, std::vector<int>(budget+1)));
        B = budget;

        graph.resize(n);
        for (const auto hier:hierarchy) {
            graph[hier[0]-1].push_back(hier[1]-1);
        }

        help(0, present, future, dp);

        return dp[0][0][B];
    }


    void help(const int cur, const vector<int>& present, const vector<int>& future, std::vector<std::vector<std::vector<int>>>&dp) {
        

        for (int c : graph[cur]) {
            help(c, present, future, dp);
        }

        for(int p = 0; p < 2; ++p) {

            
            if (cur == 0 && p==1) {
                break;
            }
            const int price = p ? present[cur] / 2 : present[cur]; 
            const int profit = future[cur] - price;
    
            

            std::vector<int> used(B+1);
          
            for (int c : graph[cur]) {
                for (int k = B-price; k >= 0; --k) {
                    for (int j = 0; j <= k; ++j) {
                        used[k] = std::max(used[k], used[k-j] + dp[c][1][j]);
                    }
                }
            }

            std::vector<int> used2(B+1);
            for (int k = 0; k <= B - price; ++k) {
                used2[k+price] = used[k] + profit;
            }



            std::vector<int> nused(B+1);
           
            for (int c : graph[cur]) {
                for (int k = B; k >= 0; --k) {
                    for (int j = 0; j <= k; ++j) {
                        nused[k] = std::max(nused[k], nused[k-j] + dp[c][0][j]);
                    }
                }
            }
            for(int k = 0; k <= B; ++k) {
                dp[cur][p][k] = std::max(used2[k], nused[k]);
            }
        }
        
    }


};