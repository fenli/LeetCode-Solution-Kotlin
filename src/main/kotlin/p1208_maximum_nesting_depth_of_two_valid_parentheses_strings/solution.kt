package p1208_maximum_nesting_depth_of_two_valid_parentheses_strings

class Solution {
    fun maxDepthAfterSplit(seq: String): IntArray {
        var d=0
        return IntArray(seq.length) { i ->
            if(seq[i] == '(' ) d++ and 1 else --d and 1
        }
    }
}
