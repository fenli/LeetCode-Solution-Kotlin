/**
 * Problem : https://leetcode.com/problems/unique-number-of-occurrences/description/
 * Submission : https://leetcode.com/problems/unique-number-of-occurrences/submissions/1952867886
 */

class Solution1207 {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val counts = hashMapOf<Int, Int>()
        for (n in arr) {
            counts[n] = (counts[n] ?: 0) + 1
        }

        val sets = hashSetOf<Int>()
        for (item in counts) {
            if (!sets.add(item.value)) return false
        }

        return true
    }
}

fun main() {
    val solution = Solution1207()
    check(solution.uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3)))
    check(!solution.uniqueOccurrences(intArrayOf(1, 2)))
    check(solution.uniqueOccurrences(intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0)))
}
