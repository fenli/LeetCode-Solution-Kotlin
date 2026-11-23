package p1168_duplicate_zeros

class Solution {
    fun duplicateZeros(arr: IntArray): Unit {
        val duplicate = Array(arr.size) { i -> arr[i] }
        var i = 0
        var j = 0
        while (j < arr.size) {
            arr[j] = if (duplicate[i] == 0) {
                0
                .also { if (++j < arr.size) arr[j] = 0 }
            } else {
                duplicate[i]
            }
            i++
            j++
        }
    }
}
