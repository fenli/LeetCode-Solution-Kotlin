package p4378_nearest_available_drone

class Solution {
    fun nearestDrone(drones: Array<IntArray>, target: IntArray): Int {
        var minIdx = -1
        var minDistance = Int.MAX_VALUE
        val (tx, ty) = target
        for (i in drones.indices) {
            val (xi, yi, range) = drones[i]
            val distance = abs(xi - tx) + abs(yi - ty)
            if (distance <= range) {
                if (distance < minDistance) {
                    minIdx = i
                    minDistance = distance
                }
            }
        }

        return minIdx
    }
}
