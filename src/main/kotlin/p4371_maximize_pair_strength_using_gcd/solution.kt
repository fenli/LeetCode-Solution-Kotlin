package p4371_maximize_pair_strength_using_gcd

class Solution {
    fun maxPairStrength(nums: IntArray): Long {
        var maxStr: Long = 0
        for (i in 0 until nums.size) {
            for (j in 0 until nums.size) {
                if (i != j) {
                    val gcd = gcd(nums[i].toLong(), nums[j].toLong())
                    val str = (nums[i].toLong() * nums[j].toLong()) / (gcd * gcd)
                    maxStr = maxOf(str, maxStr)
                }
            }
        }

        return maxStr
    }

    private tailrec fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) a else gcd(b, a % b)
    }
}
