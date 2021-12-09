package com.anymore.leetcode

/**
 * https://leetcode-cn.com/problems/path-sum/
 * Created by anymore on 2021/12/9.
 */

object LeetCode112 {

    @JvmStatic
    fun main(args: Array<String>) {

    }

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        if (root.left == null && root.right == null && root.`val` == targetSum) return true
        val left = root.left
        if (left != null){
            if (hasPathSum(left,targetSum-root.`val`)) return true
        }
        val right = root.right
        if (right != null){
            if (hasPathSum(right, targetSum-root.`val`)) return true
        }
        return false
    }
}