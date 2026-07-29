package p0125_valid_palindrome

fun main() {
    val solution = Solution()
    check(solution.isPalindrome("A man, a plan, a canal: Panama"))
    check(!solution.isPalindrome("race a car"))
    check(solution.isPalindrome(" "))
}
