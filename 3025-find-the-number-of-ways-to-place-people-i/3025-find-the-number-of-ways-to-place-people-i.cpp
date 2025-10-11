class Solution {
public:
    int numberOfPairs(vector<vector<int>>& points) {
        int cnt = 0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (i != j) {
                    int x1 = points[i][0], y1 = points[i][1];
                    int x2 = points[j][0], y2 = points[j][1];
                    if (x1 <= x2 && y1 >= y2) {
                        bool flag = true;
                        for (int k = 0; k < points.size(); k++) {
                            if (k != i && k != j) {
                                int x = points[k][0], y = points[k][1];
                                if (x1 <= x && x <= x2 && y2 <= y && y <= y1) {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if (flag) cnt++;
                    }
                }
            }
        }
        return cnt;
    }
};