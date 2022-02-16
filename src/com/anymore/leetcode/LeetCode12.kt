package com.anymore.leetcode

/**
 * https://leetcode-cn.com/problems/integer-to-roman/
 * Created by anymore on 2022/1/4.
 */
object LeetCode12 {

    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     */
    fun intToRoman(num: Int): String {
        if (num <= 0) return ""
        if (num >= 1000) {
            val n = num / 1000
            val m = num % 1000
            return "M".repeat(n) + intToRoman(m)
        }
        if (num >= 900) {
            val m = num % 100
            return "CM" + intToRoman(m)
        }
        if (num >= 500) {
            val n = num / 100
            val m = num % 100
            return "D" + "C".repeat(n - 5) + intToRoman(m)
        }
        if (num >= 400) {
            val m = num % 100
            return "CD" + intToRoman(m)
        }
        if (num >= 100) {
            val n = num / 100
            val m = num % 100
            return "C".repeat(n) + intToRoman(m)
        }
        if (num >= 90) {
            val m = num % 10
            return "XC" + intToRoman(m)
        }
        if (num >= 50) {
            val n = num / 10
            val m = num % 10
            return "L" + "X".repeat(n - 5) + intToRoman(m)
        }
        if (num >= 40) {
            val m = num % 10
            return "XL" + intToRoman(m)
        }
        if (num >= 10) {
            val n = num / 10
            val m = num % 10
            return "X".repeat(n) + intToRoman(m)
        }
        if (num >= 9) {
            return "IX"
        }
        if (num >= 5) {
            return "V" + "I".repeat(num - 5)
        }
        if (num >= 4) {
            return "IV"
        }
        if (num >= 1) {
            return "I".repeat(num)
        }
        return ""
    }
}