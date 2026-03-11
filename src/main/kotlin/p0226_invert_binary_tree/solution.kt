package p0226_invert_binary_tree

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
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root?.left != null || root?.right != null) {
            var temp = root?.left
            root?.left = root?.right
            root?.right = temp
            invertTree(root?.left)
            invertTree(root?.right)
        }

        return root
    }
}
