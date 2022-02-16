package com.anymore.leetcode.offer

import java.util.*

/**
 * Created by anymore on 2022/1/6.
 */
object Offer09 {

    class CQueue() {
        val push = Stack<Int>()
        val pop = Stack<Int>()

        fun appendTail(value: Int) {
            push.push(value)
        }

        fun deleteHead(): Int {
            if (pop.isNotEmpty()){
                return pop.pop()
            }else{
                while (push.isNotEmpty()){
                    pop.push(push.pop())
                }
            }
            if (pop.isNotEmpty()){
                return pop.pop()
            }
            return -1
        }

    }
}