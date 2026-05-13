/**
 * Problem : https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/
 * Submission : https://leetcode.com/problems/successful-pairs-of-spells-and-potions/submissions/2001850447
 */

class Solution2300 {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val pairs = IntArray(spells.size)
        potions.sort()

        for (i in spells.indices) {
            val minPotion = Math.ceil(success / spells[i].toDouble()).toInt()
            pairs[i] = potions.size - findIndexOnSortedArr(minPotion, potions)
        }

        return pairs
    }

    fun findIndexOnSortedArr(target: Int, arr: IntArray): Int {
        if (arr[0] >= target) return 0
        if (arr[arr.size - 1] < target) return arr.size

        var low = 0
        var high = arr.size - 1
        var found = 0
        while (low <= high) {
            // Prevent overflow by using this formula instead of (low + high) / 2
            val mid = low + (high - low) / 2
            if (arr[mid] >= target) {
                // Search the left half
                found = mid
                high = mid - 1
            } else {
                // Search the right half
                low = mid + 1
            }
        }

        return found
    }
}

fun main() {
    val solution = Solution2300()
    check(
        solution.successfulPairs(
            spells = intArrayOf(5, 1, 3),
            potions = intArrayOf(1, 2, 3, 4, 5),
            success = 7
        ).contentEquals(intArrayOf(4, 0, 3))
    )
    check(
        solution.successfulPairs(
            spells = intArrayOf(3, 1, 2),
            potions = intArrayOf(8, 5, 8),
            success = 16
        ).contentEquals(intArrayOf(2, 0, 2))
    )
}
