package p1468_check_if_n_and_its_double_exist

class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        for (i in arr.indices) {
            for (j in arr.indices) {
                if (i != j && arr[i] == 2 * arr[j]) {
                    return true
                }
            }
        }
        return false
    }
}
