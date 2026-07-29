package p0242_valid_anagram

fun main() {
    val solution = Solution()
    check(solution.isAnagram("anagram", "nagaram"))
    check(!solution.isAnagram("rat", "car"))
}
