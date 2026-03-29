package p0904_leafsimilar_trees

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
    private val leaf1 = mutableListOf<Int>()
    private val leaf2 = mutableListOf<Int>()

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        findLeaf(root1, leaf1)
        findLeaf(root2, leaf2)

        return leaf1 == leaf2
    }

    fun findLeaf(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) return
        if (root?.left == null && root?.right == null) {
            list.add(root!!.`val`)
        }

        findLeaf(root?.left, list)
        findLeaf(root?.right, list) 
    }

    // Recursive attempt
    // fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    //     val isLeaf1 = (root1?.left == null && root1?.right == null)
    //     val isLeaf2 = (root2?.left == null && root2?.right == null)
    //     if (isLeaf1 && isLeaf2) {
    //         println("${root1?.`val`} == ${root2?.`val`}")
    //         return (root1?.`val` == root2?.`val`)
    //     }
    //     else if (isLeaf1) return leafSimilar(root1, root2?.left) xor leafSimilar(root1, root2?.right)
    //     else if (isLeaf2) return leafSimilar(root1?.left, root2) xor leafSimilar(root1?.right, root2)
    //     return leafSimilar(root1?.left ?: root1?.right, root2?.left)
    // }
}
