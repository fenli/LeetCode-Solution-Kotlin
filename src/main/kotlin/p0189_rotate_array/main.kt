package p0189_rotate_array

fun main() {
    val solution = Solution()

    val n1 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    solution.rotate(n1, 3)
    check(n1.contentEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4)))

    val n2 = intArrayOf(-1, -100, 3, 99)
    solution.rotate(n2, 2)
    check(n2.contentEquals(intArrayOf(3, 99, -1, -100)))
}
