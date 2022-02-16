package com.anymore.leetcode

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 * Created by anymore on 2022/2/16.
 */
object LeetCode13 {

    @JvmStatic
    fun main(args: Array<String>) {
        println(romanToInt("III"))
        println(romanToInt("IV"))
        println(romanToInt("IX"))
        println(romanToInt("LVIII"))
        println(romanToInt("MCMXCIV"))


    }

    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     */
    fun romanToInt(s: String): Int {
        var result = 0
        var text = s
        when {
            text.startsWith('M') -> {
                result += 1000
                text = text.substring(1)
            }
            text.startsWith("CM") -> {
                result += 900
                text = text.substring(2)
            }
            text.startsWith("CD") -> {
                result += 400
                text = text.substring(2)
            }
            text.startsWith('D') -> {
                result += 500
                text = text.substring(1)
            }
            text.startsWith('C') -> {
                result += 100
                text = text.substring(1)
            }
            text.startsWith("XC") -> {
                result += 90
                text = text.substring(2)
            }
            text.startsWith("XL") -> {
                result += 40
                text = text.substring(2)
            }
            text.startsWith('L') -> {
                result += 50
                text = text.substring(1)
            }
            text.startsWith('X') -> {
                result += 10
                text = text.substring(1)
            }
            text.startsWith("IX") -> {
                result += 9
                text = text.substring(2)
            }
            text.startsWith("IV") -> {
                result += 4
                text = text.substring(2)
            }
            text.startsWith('V') -> {
                result += 5
                text = text.substring(1)
            }
            text.startsWith('I') -> {
                result += 1
                text = text.substring(1)
            }
        }
        if (text.isNotEmpty()) {
            result += romanToInt(text)
        }
        return result
    }
}