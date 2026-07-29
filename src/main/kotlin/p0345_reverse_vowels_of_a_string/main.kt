package p0345_reverse_vowels_of_a_string

fun main() {
    val solution = Solution()
    check(solution.reverseVowels("IceCreAm") == "AceCreIm")
    check(solution.reverseVowels("leetcode") == "leotcede")
}
