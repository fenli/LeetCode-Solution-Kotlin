package p2236_maximum_twin_sum_of_a_linked_list

fun main() {
    fun List<Int>.toListNode(): ListNode? {
        if (isEmpty()) return null
        return ListNode(first(), drop(1).toListNode())
    }

    val solution = Solution()
    check(solution.pairSum(listOf(5, 4, 2, 1).toListNode()) == 6)
    check(solution.pairSum(listOf(4, 2, 2, 3).toListNode()) == 7)
    check(solution.pairSum(listOf(1, 100000).toListNode()) == 100001)
}
