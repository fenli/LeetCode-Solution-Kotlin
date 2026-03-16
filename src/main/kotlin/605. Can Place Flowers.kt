/**
 * Problem : https://leetcode.com/problems/can-place-flowers/description/
 * Submission : https://leetcode.com/problems/can-place-flowers/submissions/1950256602
 */

class Solution605 {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if (n == 0) return true
        if (flowerbed.size == 1) return flowerbed[0] == 0
        var maxFlower = 0
        var emptyPot = 0
        var seenOne = false
        for (i in 0 until flowerbed.size) {
            if (flowerbed[i] == 1) {
                if (!seenOne && flowerbed[0] == 0) maxFlower += emptyPot / 2
                else maxFlower += (emptyPot - 1) / 2
                emptyPot = 0
                seenOne = true
            } else {
                emptyPot++
            }
        }
        maxFlower += if (seenOne) emptyPot / 2 else (emptyPot / 2) + (emptyPot % 2)

        return maxFlower >= n
    }
}

fun main() {
    val solution = Solution605()
    check(solution.canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1))
    check(!solution.canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 2))
}
