package p0394_decode_string

fun main() {
    val solution = Solution()
    check(solution.decodeString("3[a]2[bc]") == "aaabcbc")
    check(solution.decodeString("3[a2[c]]") == "accaccacc")
    check(solution.decodeString("2[abc]3[cd]ef") == "abcabccdcdcdef")
}
