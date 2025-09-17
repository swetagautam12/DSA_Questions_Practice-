class FoodRatings {
    unordered_map<string, string> food_cuisines;
    unordered_map<string, int> food_ratings;
    unordered_map<string, set<pair<int, string>>> cuisine_ratings;
public:
    FoodRatings(vector<string>& foods, vector<string>& cuisines, vector<int>& ratings) {
        int n = foods.size();
        for (int i = 0; i < n; i++) {
            food_cuisines[foods[i]] = cuisines[i];
            food_ratings[foods[i]] = ratings[i];
            cuisine_ratings[cuisines[i]].insert( { -ratings[i], foods[i] } );
        }
    }
    
    void changeRating(string food, int newRating) {
        auto cuisine = food_cuisines[food];
        cuisine_ratings[cuisine].erase( { -food_ratings[food], food } );
        food_ratings[food] = newRating;
        cuisine_ratings[cuisine].insert( { -newRating, food } );
    }
    
    string highestRated(string cuisine) {
        return cuisine_ratings[cuisine].begin()->second;
    }
};