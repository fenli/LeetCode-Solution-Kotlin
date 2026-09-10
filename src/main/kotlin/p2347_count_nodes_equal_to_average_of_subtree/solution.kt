package p2347_count_nodes_equal_to_average_of_subtree

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    private var count = 0

    fun averageOfSubtree(root: TreeNode?): Int {
        trav(root)
        return count
    }

    private fun trav(root: TreeNode?): IntArray {
        if (root == null) return intArrayOf(0, 0)

        val left = trav(root.left)
        val right = trav(root.right)

        val subtreeSum = left[0] + right[0] + root.`val`
        val subtreeCount = left[1] + right[1] + 1

        if (subtreeSum / subtreeCount == root.`val`) {
            count++
        }

        return intArrayOf(subtreeSum, subtreeCount)
    }
}
