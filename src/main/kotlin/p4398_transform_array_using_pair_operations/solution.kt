package p4398_transform_array_using_pair_operations

class Solution {
    fun canTransform(source: IntArray, target: IntArray): Boolean {
        if (source.size != target.size) return false

        val sumS = source.fold(0L) { acc, num -> acc + num}
        val sumT = target.fold(0L) { acc, num -> acc + num}
        
        return sumS == sumT
    }
}
