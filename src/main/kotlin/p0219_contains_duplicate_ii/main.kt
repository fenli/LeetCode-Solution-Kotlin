package p0219_contains_duplicate_ii

fun main() {
    val solution = Solution()
    check(solution.containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
    check(solution.containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1))
    check(!solution.containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
}
