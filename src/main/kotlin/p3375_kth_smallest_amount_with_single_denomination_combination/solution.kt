package p3375_kth_smallest_amount_with_single_denomination_combination

class Solution {

    fun findKthSmallest(coins: IntArray, k: Int): Long {
        coins.sort()

        val newCoins = mutableListOf<Int>()
        for (x in coins) {
            var keep = true
            for (y in newCoins) {
                if (x % y == 0) {
                    keep = false
                    break
                }
            }
            if (keep) newCoins.add(x)
        }

        val n = newCoins.size
        val m = 1 shl n
        val lcm = LongArray(m) { 1L }

        var left = k.toLong()
        val rightInitial = newCoins[0].toLong() * k + 1
        var right = rightInitial

        for (mask in 1 until m) {
            val prevMask = mask and (mask - 1)
            val bit = mask and -mask
            val i = Integer.numberOfTrailingZeros(bit)

            val temp = lcm[prevMask] / gcd(
                lcm[prevMask],
                newCoins[i].toLong()
            )

            lcm[mask] = if (temp <= right / newCoins[i]) {
                temp * newCoins[i]
            } else {
                right + 1
            }
        }

        while (left < right) {
            val mid = left + (right - left) / 2

            if (countLEQ(mid, lcm, m) >= k) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }

    private fun countLEQ(x: Long, lcm: LongArray, m: Int): Long {
        var count = 0L

        for (mask in 1 until m) {
            if (lcm[mask] > x) {
                continue
            }

            if (Integer.bitCount(mask) % 2 == 1) {
                count += x / lcm[mask]
            } else {
                count -= x / lcm[mask]
            }
        }

        return count
    }

    private tailrec fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) a else gcd(b, a % b)
    }
}
