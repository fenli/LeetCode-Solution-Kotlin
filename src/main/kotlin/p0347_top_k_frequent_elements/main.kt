package p0347_top_k_frequent_elements

fun main() {
    val solution = Solution()
    check(solution.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).contentEquals(intArrayOf(2, 1)))
    check(solution.topKFrequent(intArrayOf(1), 1).contentEquals(intArrayOf(1)))
    check(solution.topKFrequent(intArrayOf(1, 2, 1, 2, 1, 2, 3, 1, 3, 2), 2).contentEquals(intArrayOf(1, 2)))
}
