package p0941_sort_array_by_parity

class Solution {
    fun sortArrayByParity(a: IntArray) = a.sortedBy { it % 2 != 0 }.toIntArray()
}
