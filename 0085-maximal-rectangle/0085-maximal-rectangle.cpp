class Solution {
public:
    int largestRectangleArea(vector<int>& arr) {
        int n = arr.size();
        stack<int> st;
        int maxArea = 0;
        int nse, pse, element;
        
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] > arr[i]) {
                element = st.top();
                st.pop();
                nse = i;
                pse = st.empty() ? -1 : st.top();
                maxArea = max(arr[element] * (nse - pse - 1), maxArea);
            }
            st.push(i);
        }

        while (!st.empty()) {
            element = st.top();
            st.pop();
            nse = n;
            pse = st.empty() ? -1 : st.top();
            maxArea = max(arr[element] * (nse - pse - 1), maxArea);
        }

        return maxArea;
    }
    
    int maximalRectangle(vector<vector<char>>& matrix) {
        if (matrix.empty() || matrix[0].empty()) return 0;

        int cols = matrix[0].size();
        vector<int> heights(cols, 0);
        int maxArea = 0;

        for (auto& row : matrix) {
            for (int i = 0; i < cols; ++i)
                heights[i] = (row[i] == '1') ? heights[i] + 1 : 0;
            maxArea = max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }
};