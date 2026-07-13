package p0682_baseball_game

class Solution {
    fun calPoints(operations: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for (o in operations) {
            when(o) {
                "+" -> { stack.add(stack.takeLast(2).sum()) }
                "D" -> { stack.add(stack.last() * 2) }
                "C" -> { stack.removeLast() }
                else -> { stack.add(o.toInt()) }
            }
        }
        return stack.sum()
    }
}
