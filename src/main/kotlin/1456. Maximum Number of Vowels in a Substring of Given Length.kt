/**
 * Problem : https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 * Submission : https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/submissions/1951930771
 */

class Solution1456 {
    fun maxVowels(s: String, k: Int): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        var maxV = 0
        var vSum = 0
        for (i in 0 until s.length) {
            if (vowels.contains(s[i])) vSum++
            if (i - k >= 0 && vowels.contains(s[i - k])) vSum--
            if (vSum > maxV) maxV = vSum
            if (maxV == k) break
        }

        return maxV
    }
}

fun main() {
    val solution = Solution1456()
    check(solution.maxVowels("abciiidef", 3) == 3)
    check(solution.maxVowels("aeiou", 2) == 2)
    check(solution.maxVowels("leetcode", 3) == 2)
}
