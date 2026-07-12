package p0020_valid_parentheses

import java.util.Stack

class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (c in s) {
            if (stack.size == 0) {
                stack.push(c)
            } else if (c == ')') {
                if (stack.peek() != '(') return false
                else stack.pop()
            } else if (c == ']') {
                if (stack.peek() != '[') return false
                else stack.pop()
            } else if (c == '}') {
                if (stack.peek() != '{') return false
                else stack.pop()
            } else {
                stack.push(c)
            }
        }

        return stack.size == 0
    }
}
