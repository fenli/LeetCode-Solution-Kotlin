package p0334_increasing_triplet_subsequence

fun main() {
    val solution = Solution()
    check(solution.increasingTriplet(intArrayOf(1, 2, 3, 4, 5)))
    check(!solution.increasingTriplet(intArrayOf(5, 4, 3, 2, 1)))
    check(solution.increasingTriplet(intArrayOf(2, 1, 5, 0, 4, 6)))
}
