package p3870_minimum_moves_to_clean_the_classroom

import java.util.LinkedList
import java.util.Queue


class Solution {

    fun minMoves(classroom: Array<String>, energy: Int): Int {
        val m = classroom.size
        val n = classroom[0].length

        val litterMap = Array(m) { IntArray(n) }

        var startX = -1
        var startY = -1
        var litterCount = 0

        for (i in 0 until m) {
            for (j in 0 until n) {
                when (val c = classroom[i][j]) {
                    'S' -> {
                        startX = i
                        startY = j
                    }

                    'L' -> {
                        litterMap[i][j] = litterCount++
                    }
                }
            }
        }

        if (litterCount == 0) {
            return 0
        }

        val targetMask = (1 shl litterCount) - 1

        val q: Queue<IntArray> = LinkedList()
        q.offer(intArrayOf(startX, startY, energy, 0, 0))

        val visited = Array(m) {
            Array(n) {
                Array(energy + 1) {
                    BooleanArray(1 shl litterCount)
                }
            }
        }

        visited[startX][startY][energy][0] = true

        val dirs = intArrayOf(-1, 0, 1, 0, -1)

        while (q.isNotEmpty()) {
            val curr = q.poll()

            val r = curr[0]
            val c = curr[1]
            val e = curr[2]
            val mask = curr[3]
            val steps = curr[4]

            for (i in 0 until 4) {
                val nr = r + dirs[i]
                val nc = c + dirs[i + 1]

                if (
                    nr >= 0 &&
                    nr < m &&
                    nc >= 0 &&
                    nc < n &&
                    classroom[nr][nc] != 'X'
                ) {
                    var nextEnergy = e - 1
                    var nextMask = mask
                    val nextCell = classroom[nr][nc]

                    if (nextCell == 'L') {
                        nextMask = nextMask or (1 shl litterMap[nr][nc])
                    }

                    if (nextMask == targetMask) {
                        return steps + 1
                    }

                    if (nextCell == 'R') {
                        nextEnergy = energy
                    }

                    if (nextEnergy == 0 && nextCell != 'R') {
                        continue
                    }

                    if (!visited[nr][nc][nextEnergy][nextMask]) {
                        visited[nr][nc][nextEnergy][nextMask] = true
                        q.offer(
                            intArrayOf(
                                nr,
                                nc,
                                nextEnergy,
                                nextMask,
                                steps + 1
                            )
                        )
                    }
                }
            }
        }

        return -1
    }
}
