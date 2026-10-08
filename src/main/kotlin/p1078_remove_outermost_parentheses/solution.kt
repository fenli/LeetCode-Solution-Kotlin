package p1078_remove_outermost_parentheses

class Solution {
    
    fun removeOuterParentheses(s: String): String {
        var count = 0
        return buildString {
            for (i in s.indices) {
                if (s[i] == '(') if (++count > 1) append(s[i])
                if (s[i] == ')') if (--count >= 1) append(s[i])
            }
        }
    }
}
