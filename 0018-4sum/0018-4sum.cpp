
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& v, int target) {
        int n = v.size();
        sort(v.begin(), v.end());
        set<vector<int>> s;
        vector<vector<int>> ans;

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int k = j + 1, l = n - 1;
                long long nt = (long long) target - v[i] - v[j];

                while (k < l) {
                    if (nt == v[k] + v[l]) {
                        s.insert({v[i], v[j], v[k], v[l]});
                        k++; l--;
                    } else if (nt > v[k] + v[l]) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        for (auto &quad : s) ans.push_back(quad);
        return ans;
    }
};