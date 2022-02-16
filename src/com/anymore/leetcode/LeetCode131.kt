package com.anymore.leetcode

import java.util.*
import kotlin.collections.ArrayList

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * Created by anymore on 2022/1/10.
 */
object LeetCode131 {

    @JvmStatic
    fun main(args: Array<String>) {
        println(partition("aab"))
    }

    fun partition(s: String): List<List<String>> {
        val res = mutableListOf<List<String>>()
        if (s.isEmpty()) return res
        val dp = Array(s.length) { BooleanArray(s.length) { true } }
        for (i in s.length - 1 downTo 0) {
            for (j in i + 1 until s.length) {
                dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]
            }
        }
        dfs(s, 0, mutableListOf(), dp, res)
        return res
    }

    private fun dfs(
        s: String,
        i: Int,
        ans: MutableList<String>,
        dp: Array<BooleanArray>,
        res: MutableList<List<String>>
    ) {
        if (i == s.length) {
            res += ArrayList(ans)
            return
        }
        for (j in i until s.length) {
            if (dp[i][j]) {
                ans += s.substring(i, j + 1)
                dfs(s, j + 1, ans, dp, res)
                ans.removeAt(ans.lastIndex)
            }
        }
    }
}