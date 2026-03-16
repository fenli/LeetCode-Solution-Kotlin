/**
 * Problem : https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
 * Submission : https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/submissions/1950198196
 */

class Solution1431 {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val result = mutableListOf<Boolean>()
        val max = candies.max()
        for (n in candies) {
            result.add(n + extraCandies >= max)
        }
        return result
    }
}

fun main() {
    val solution = Solution1431()
    check(solution.kidsWithCandies(intArrayOf(2, 3, 5, 1, 3), 3) == listOf(true, true, true, false, true))
    check(solution.kidsWithCandies(intArrayOf(4, 2, 1, 1, 2), 1) == listOf(true, false, false, false, false))
    check(solution.kidsWithCandies(intArrayOf(12, 1, 12), 10) == listOf(true, false, true))
}
