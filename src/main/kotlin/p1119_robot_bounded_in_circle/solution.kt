package p1119_robot_bounded_in_circle

class Solution {
    fun isRobotBounded(instructions: String): Boolean {
        var facesIdx = 0
        var x = 0
        var y = 0
        for (i in instructions) {
            when(i) {
                'G' -> {
                    when(facesIdx) {
                        0 -> y++
                        1 -> x++
                        2 -> y--
                        3 -> x--
                    }
                }
                'L' -> facesIdx = (facesIdx + 3) % 4
                'R' -> facesIdx = (facesIdx + 1) % 4
            }
        }

        return facesIdx != 0 || (x == 0 && y == 0)
    }
}
