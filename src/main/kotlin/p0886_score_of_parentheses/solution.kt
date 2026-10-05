package p0886_score_of_parentheses

class Solution {
    fun scoreOfParentheses(s: String): Int {
        val stack = ArrayDeque<Int>()
        for(c in s) {
            when (c) {
                '(' -> stack.addLast(0)
                ')' -> {
                    stack.removeLast().also { level -> 
                        stack.add(( if(stack.isNotEmpty()) stack.removeLast() else 0) + if(level == 0) 1 else 2*level )
                    }
                }
            }
        }
        return stack.removeLast()
    }
}

