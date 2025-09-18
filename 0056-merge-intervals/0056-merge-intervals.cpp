class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        // Step 1: Sort by start time
        sort(intervals.begin(), intervals.end());
        
        vector<vector<int>> merged;
        
        // Step 2: Iterate and merge
        for (auto& interval : intervals) {
            if (merged.empty() || merged.back()[1] < interval[0]) {
                // No overlap, push new interval
                merged.push_back(interval);
            } else {
                // Overlap → update the end time
                merged.back()[1] = max(merged.back()[1], interval[1]);
            }
        }
        return merged;
    }
};