package p1231_replace_elements_with_greatest_element_on_right_side

class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        var maxRight = -1

        for (i in arr.lastIndex downTo 0) {
            val current = arr[i]
            arr[i] = maxRight
            maxRight = maxOf(maxRight, current)
        }

        return arr
    }
}
