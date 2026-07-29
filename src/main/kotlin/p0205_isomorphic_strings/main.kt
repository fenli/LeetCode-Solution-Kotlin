package p0205_isomorphic_strings

fun main() {
    val solution = Solution()
    check(solution.isIsomorphic("egg", "add"))
    check(!solution.isIsomorphic("foo", "bar"))
    check(solution.isIsomorphic("paper", "title"))
}
