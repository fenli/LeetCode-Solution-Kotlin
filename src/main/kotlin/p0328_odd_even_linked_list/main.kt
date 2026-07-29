package p0328_odd_even_linked_list

fun main() {
    fun List<Int>.toListNode(): ListNode? {
        if (isEmpty()) return null
        return ListNode(first(), drop(1).toListNode())
    }

    val solution = Solution()
    check(solution.oddEvenList(listOf(1, 2, 3, 4, 5).toListNode()) == listOf(1, 3, 5, 2, 4).toListNode())
    check(solution.oddEvenList(listOf(2, 1, 3, 5, 6, 4, 7).toListNode()) == listOf(2, 3, 6, 7, 1, 5, 4).toListNode())
}
