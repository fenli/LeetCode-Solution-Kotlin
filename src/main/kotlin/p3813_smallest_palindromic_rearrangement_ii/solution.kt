package p3813_smallest_palindromic_rearrangement_ii

class Solution {

    private fun comb(n: Long, m: Long, k: Long): Long {
        var res = 1L
        val mm = minOf(m, n - m)

        for (i in 1..mm) {
            res = (res * (n - i + 1)) / i
            if (res > k) {
                return k + 1
            }
        }
        return res
    }

    private fun permutations(rem: Int, bucket: IntArray, k: Long): Long {
        var remaining = rem
        var ways = 1L

        for (i in 0 until 26) {
            if (bucket[i] == 0) continue

            ways *= comb(remaining.toLong(), bucket[i].toLong(), k)
            if (ways > k) break

            remaining -= bucket[i]
        }

        return ways
    }

    fun smallestPalindrome(s: String, k: Int): String {
        val partition = s.length / 2
        val bucket = IntArray(26)

        for (i in 0 until partition) {
            bucket[s[i] - 'a']++
        }

        val left = StringBuilder()
        var startIndex = 1L

        for (pos in 0 until partition) {
            for (i in 0 until 26) {
                if (bucket[i] == 0) continue

                bucket[i]--

                val ways = permutations(partition - pos - 1, bucket, k.toLong())
                if (startIndex + ways > k) {
                    left.append(('a'.code + i).toChar())
                    break
                }

                bucket[i]++
                startIndex += ways
            }
        }

        if (left.length < partition) {
            return ""
        }

        if (s.length % 2 != 0) {
            left.append(s[partition])
        }

        for (i in partition - 1 downTo 0) {
            left.append(left[i])
        }

        return left.toString()
    }
}
