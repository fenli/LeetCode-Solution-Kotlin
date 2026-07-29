package p0155_min_stack

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
