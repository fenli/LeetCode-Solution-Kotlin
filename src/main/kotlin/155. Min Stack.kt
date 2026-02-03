import java.util.*

/**
 * Problem : https://leetcode.com/problems/min-stack/description/
 * Submission : https://leetcode.com/problems/min-stack/submissions/1906585595
 */

class MinStack() {

    private val stack = Stack<Int>()
    private val minStack = Stack<Int>()

    fun push(`val`: Int) {
        stack.push(`val`)
        if (minStack.isEmpty() || `val` <= minStack.peek()) minStack.push(`val`)
    }

    fun pop() {
        val item = stack.pop()
        if (!minStack.isEmpty() && minStack.peek() == item) minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}

fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    check(minStack.getMin() == -3)
    minStack.pop()
    check(minStack.top() == 0)
    check(minStack.getMin() == -2)
}
