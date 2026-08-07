package p3635_smallest_divisible_digit_product_ii

class Solution {

    fun smallestNumber(num: String, t: Long): String {
        var temp = t
        for (i in 2L..9L) while (temp % i == 0L) temp /= i
        if (temp > 1L) return "-1"

        val n = num.length
        val rem = LongArray(n + 1)
        rem[0] = t

        var pos = n - 1
        val numChars = num.toCharArray()

        for (i in 0 until n) {
            if (numChars[i] == '0') {
                pos = i
                break
            }
            rem[i + 1] = rem[i] / gcd(rem[i], (numChars[i] - '0').toLong())
        }

        if (rem[n] == 1L) {
            return num
        }

        for (i in pos downTo 0) {
            while (true) {
                numChars[i]++

                if (numChars[i] > '9') {
                    break
                }

                var tNow = rem[i] / gcd(rem[i], (numChars[i] - '0').toLong())
                var k = 9

                for (j in n - 1 downTo i + 1) {
                    while (tNow % k.toLong() != 0L) {
                        k--
                    }
                    tNow /= k.toLong()
                    numChars[j] = ('0'.code + k).toChar()
                }

                if (tNow == 1L) {
                    return String(numChars)
                }
            }
        }

        val ans = StringBuilder()
        var originalT = t

        for (i in 9 downTo 2) {
            while (originalT % i.toLong() == 0L) {
                ans.append(('0'.code + i).toChar())
                originalT /= i.toLong()
            }
        }

        val padding = maxOf(n + 1 - ans.length, 0)
        repeat(padding) {
            ans.append('1')
        }

        return ans.reverse().toString()
    }

    private tailrec fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) a else gcd(b, a % b)
    }
}
