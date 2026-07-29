package p0443_string_compression

fun main() {
    val solution = Solution()
    check(solution.compress("aabbccc".toCharArray()) == 6)
    check(solution.compress("a".toCharArray()) == 1)
    check(solution.compress("abbbbbbbbbbbb".toCharArray()) == 4)
}
