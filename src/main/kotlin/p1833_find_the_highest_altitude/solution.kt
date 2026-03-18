package p1833_find_the_highest_altitude

class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var maxAlt = 0
        var currentAlt = 0
        for (n in gain) {
            currentAlt += n
            if (currentAlt > maxAlt) maxAlt = currentAlt
        }

        return maxAlt
    }
}
