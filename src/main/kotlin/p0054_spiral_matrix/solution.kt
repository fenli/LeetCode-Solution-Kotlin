package p0054_spiral_matrix

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val spiral = mutableListOf<Int>()
        var w = matrix[0].size
        var h = matrix.size
        var topLeft = 0
        var x = topLeft
        var y = topLeft

        while(w > 0 && h > 0) {
            spiral.add(matrix[y][x])
            
            if (y == topLeft) { // Top row
                if (x == topLeft + w - 1) y++ else x++
            } else if (x == topLeft + w - 1) { // Right column
                if (y == topLeft + h - 1) x-- else y++
            } else if (y == topLeft + h - 1) { // Bottow row
                if (x == topLeft) y-- else x--
            } else if (x == topLeft) { // Left column
                y--
            }

            // Break when reach center (last item)
            if (x < topLeft || y < topLeft || x >= topLeft + w || y >= topLeft + h ) break

            // When reaching top left again, reduce inner box
            if (x == topLeft && y == topLeft) { 
                w -= 2
                h -= 2
                topLeft++
                x = topLeft
                y = topLeft
            }
        }

        return spiral
    }
}
