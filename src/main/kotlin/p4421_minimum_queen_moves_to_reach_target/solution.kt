package p4421_minimum_queen_moves_to_reach_target

class Solution {
    fun minQueenMoves(source: IntArray, target: IntArray): Int {
        val (sr, sc) = source
        val (tr, tc) = target

        if (sr == tr && sc == tc) return 0
        if (sr == tr || sc == tc || Math.abs(sr - tr) == Math.abs(sc - tc)) return 1

        return 2
        
    }
}
