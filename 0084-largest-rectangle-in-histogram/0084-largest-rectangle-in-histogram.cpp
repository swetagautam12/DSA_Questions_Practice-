class Solution {
public:
     int largestRectangleArea(std::vector<int>& heights) {

          std::vector<int> stk{-1};  
          const int n=heights.size() ;
          int area{ 0 };

          for (int i{ 0}; i <n; ++i)
          {  
               
              while (stk.back()!=-1 && heights[i] < heights[stk.back()])
              {  
                   int h{ heights[stk.back()] }; stk.pop_back();
                   int l{ stk.back() };
                   int r{ i };
                   int width{ r - l - 1 };

                   area = std::max(area, h * width);
              }
               
              stk.push_back(i);      
          }
          

          while (stk.back()!=-1)
          {
               int h{ heights[stk.back()] }; stk.pop_back();
               int l{ stk.back() };
               int r{n}; 
               int width{ r - l - 1 };

               area = std::max(area, h * width);
          }
          return area;
     }
};