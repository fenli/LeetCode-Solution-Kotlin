package p3995_gcd_of_odd_and_even_sums

class Solution {
    // Simple Solution
    fun gcdOfOddEvenSums(n: Int): Int = n

    // Alternative Solution
    fun gcdOfOddEvenSums_Alt(n: Int): Int {
        val sumOdd = n * n
        val sumEven = n * (n + 1)
        return gcd(sumOdd, sumEven)
    }

    private tailrec fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}
