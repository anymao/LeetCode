package com.anymore.leetcode

/**
 * https://leetcode-cn.com/problems/shortest-completing-word/
 * Created by anymore on 2021/12/10.
 */
object LeetCode748 {

    @JvmStatic
    fun main(args: Array<String>) {
        val res = shortestCompletingWord(
            "1s3 PSt", arrayOf(
                "step", "steps", "stripe", "stepple"
            )
        )
        println(res)
    }

    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        val counts = IntArray(26) { 0 }
        licensePlate.forEach {
            if (it in 'a'..'z') {
                counts[it - 'a']++
            } else if (it in 'A'..'Z') {
                counts[it - 'A']++
            }
        }
        val minLength = counts.sum()
        words.sortBy { it.length }
        val wordCounts = IntArray(26) { 0 }
        words.forEach {
            if (it.length < minLength) return@forEach
            wordCounts.fill(0)
            it.forEach { char ->
                if (char in 'a'..'z') {
                    wordCounts[char - 'a']++
                } else if (char in 'A'..'Z') {
                    wordCounts[char - 'A']++
                }
            }
            for (i in counts.indices) {
                if (wordCounts[i] < counts[i]) return@forEach
            }
            return it
        }
        return ""
    }

}