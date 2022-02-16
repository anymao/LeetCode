package com.anymore.leetcode

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Created by anymore on 2022/1/5.
 */
object LeetCode122 {

    fun maxProfit(prices: IntArray): Int {
        var result = 0
        if (prices.size <= 1) return result
        for (i in 1 until prices.size){
            if (prices[i] > prices[i-1]){
                result+=prices[i]-prices[i-1]
            }
        }
        return result
    }
}