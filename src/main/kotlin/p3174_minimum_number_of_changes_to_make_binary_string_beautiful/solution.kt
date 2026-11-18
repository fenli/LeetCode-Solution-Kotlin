package p3174_minimum_number_of_changes_to_make_binary_string_beautiful

class Solution {
    fun minChanges(s: String): Int {
        var count = 0;
        for(i in 0..s.length-1 step 2){
            if(s[i] != s[i+1]) count++;
        }
        return count;
    }
}
