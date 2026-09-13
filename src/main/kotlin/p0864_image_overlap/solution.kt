package p0864_image_overlap

class Solution {
    
    protected fun shiftAndCount(
        xShift: Int,
        yShift: Int,
        M: Array<IntArray>,
        R: Array<IntArray>
    ): Int {
        var leftShiftCount = 0
        var rightShiftCount = 0
        var rRow = 0

        for (mRow in yShift until M.size) {
            var rCol = 0

            for (mCol in xShift until M.size) {
                if (M[mRow][mCol] == 1 && M[mRow][mCol] == R[rRow][rCol]) {
                    leftShiftCount++
                }

                if (M[mRow][rCol] == 1 && M[mRow][rCol] == R[rRow][mCol]) {
                    rightShiftCount++
                }

                rCol++
            }

            rRow++
        }

        return maxOf(leftShiftCount, rightShiftCount)
    }

    fun largestOverlap(A: Array<IntArray>, B: Array<IntArray>): Int {
        var maxOverlaps = 0

        for (yShift in A.indices) {
            for (xShift in A.indices) {
                maxOverlaps = maxOf(maxOverlaps, shiftAndCount(xShift, yShift, A, B))
                maxOverlaps = maxOf(
                    maxOverlaps,
                    shiftAndCount(xShift, yShift, B, A)
                )
            }
        }

        return maxOverlaps
    }
}

