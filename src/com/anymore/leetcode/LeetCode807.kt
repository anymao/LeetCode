package com.anymore.leetcode

import kotlin.math.min

/**
 * https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/
 * Created by anymore on 2021/12/13.
 */
object LeetCode807 {
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        val rows = grid.size
        if (rows <= 0) return 0
        val cols = grid.firstOrNull()?.size ?: 0
        if (cols <= 0) return 0
        val xMax = IntArray(rows) { grid[it][0] }
        val yMax = IntArray(cols) { grid[0][it] }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] > xMax[i]) {
                    xMax[i] = grid[i][j]
                }
                if (grid[i][j] > yMax[j]) {
                    yMax[j] = grid[i][j]
                }
            }
        }
        var res = 0
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                res += min(xMax[i], yMax[j]) - grid[i][j]
            }
        }
        return res

    }
}