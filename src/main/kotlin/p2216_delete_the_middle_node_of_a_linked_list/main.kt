package p2216_delete_the_middle_node_of_a_linked_list

fun main() {
    fun List<Int>.toListNode(): ListNode? {
        if (isEmpty()) return null
        return ListNode(first(), drop(1).toListNode())
    }

    val solution = Solution()
    check(solution.deleteMiddle(listOf(1, 3, 4, 7, 1, 2, 6).toListNode()) == listOf(1, 3, 4, 1, 2, 6).toListNode())
    check(solution.deleteMiddle(listOf(1, 2, 3, 4).toListNode()) == listOf(1, 2, 4).toListNode())
    check(solution.deleteMiddle(listOf(2, 1).toListNode()) == listOf(2).toListNode())
}
