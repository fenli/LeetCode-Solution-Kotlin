package p0150_evaluate_reverse_polish_notation

class Solution {
    private val stack = Stack<Int>()

    fun evalRPN(tokens: Array<String>): Int {
        for (t in tokens) {
            when(t) {
                "+" -> {
                    val top = stack.pop().toInt()
                    stack.push(stack.pop().toInt() + top)
                }
                "-" -> {
                    val top = stack.pop().toInt()
                    stack.push(stack.pop().toInt() - top)
                }
                "*" -> {
                    val top = stack.pop().toInt()
                    stack.push(stack.pop().toInt() * top)
                }
                "/" -> {
                    val top = stack.pop().toInt()
                    stack.push(stack.pop().toInt() / top)
                }
                else -> {
                    stack.push(t.toInt())
                }
            }
        }

        return stack.pop()
    }
}
