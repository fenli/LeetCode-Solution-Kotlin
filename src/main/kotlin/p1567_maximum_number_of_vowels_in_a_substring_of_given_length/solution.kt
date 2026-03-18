package p1567_maximum_number_of_vowels_in_a_substring_of_given_length

class Solution {
    fun maxVowels(s: String, k: Int): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        var maxV = 0
        var vSum = 0
        for (i in 0 until s.length) {
            if (vowels.contains(s[i])) vSum++
            if (i - k >= 0 && vowels.contains(s[i-k])) vSum--
            if (vSum > maxV) maxV = vSum
            if (maxV == k) break
        }

        return maxV
    }
}
