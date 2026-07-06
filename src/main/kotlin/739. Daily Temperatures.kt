import java.util.*

/**
 * Problem : https://leetcode.com/problems/daily-temperatures/description/
 * Submission : https://leetcode.com/problems/daily-temperatures/submissions/2058221998
 */

class Solution739 {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stackOfIdx = Stack<Int>()
        val result = IntArray(temperatures.size)
        result[temperatures.size - 1] = 0

        for (i in 0 until temperatures.size - 1) {
            var j = i + 1
            if (temperatures[j] > temperatures[i]) {
                result[i] = 1
                while (!stackOfIdx.isEmpty()) {
                    val top = stackOfIdx.peek()
                    if (temperatures[j] > temperatures[top]) {
                        result[top] = j - top
                        stackOfIdx.pop()
                    } else break
                }
            } else {
                stackOfIdx.push(i)
            }
        }

        return result
    }
}

fun main() {
    val solution = Solution739()
    check(
        solution.dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73))
            .contentEquals(intArrayOf(1, 1, 4, 2, 1, 1, 0, 0))
    )
    check(solution.dailyTemperatures(intArrayOf(30, 40, 50, 60)).contentEquals(intArrayOf(1, 1, 1, 0)))
    check(solution.dailyTemperatures(intArrayOf(30, 60, 90)).contentEquals(intArrayOf(1, 1, 0)))
}
