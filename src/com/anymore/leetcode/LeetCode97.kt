package com.anymore.leetcode

/**
 * https://leetcode-cn.com/problems/interleaving-string/
 * Created by anymore on 2022/1/5.
 */
object LeetCode97 {
    //TODO 超时优化
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.isEmpty()) return s2 == s3
        if (s2.isEmpty()) return s1 == s3
        if (s1[0] == s3[0] && isInterleave(s1.substring(1), s2, s3.substring(1))) return true
        if (s2[0] == s3[0] && isInterleave(s1, s2.substring(1), s3.substring(1))) return true
        return false
    }
}