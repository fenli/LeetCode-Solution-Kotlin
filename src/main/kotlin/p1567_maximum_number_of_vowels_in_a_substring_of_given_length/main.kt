package p1567_maximum_number_of_vowels_in_a_substring_of_given_length

fun main() {
    val solution = Solution()
    check(solution.maxVowels("abciiidef", 3) == 3)
    check(solution.maxVowels("aeiou", 2) == 2)
    check(solution.maxVowels("leetcode", 3) == 2)
}
