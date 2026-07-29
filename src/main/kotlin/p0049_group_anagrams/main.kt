package p0049_group_anagrams

fun main() {
    val solution = Solution()
    check(
        solution.groupAnagrams(
            arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
        ) == listOf(
            listOf("eat", "tea", "ate"),
            listOf("tan", "nat"),
            listOf("bat")
        )
    )
    check(solution.groupAnagrams(arrayOf("")) == listOf(listOf("")))
    check(solution.groupAnagrams(arrayOf("a")) == listOf(listOf("a")))
}
