package p0783_search_in_a_binary_search_tree

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
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return null
        else if (root?.`val` == `val`) return root
        else if (root!!.`val` > `val`) return searchBST(root?.left, `val`)
        else return searchBST(root?.right, `val`)
    }
}
