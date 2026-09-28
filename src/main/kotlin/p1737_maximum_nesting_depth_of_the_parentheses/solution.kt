package p1737_maximum_nesting_depth_of_the_parentheses

class Solution {
    fun maxDepth(s: String): Int {
        var max = 0
        var count = 0
        for (c in s) {
            if (c == '(') max = maxOf(max, ++count)
            else if (c == ')') count--
        }
        return max
    }
}
