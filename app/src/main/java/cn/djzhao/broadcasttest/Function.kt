package cn.djzhao.broadcasttest

import java.lang.StringBuilder


fun num1AndNum2(num1: Int, num2: Int, func: (Int, Int) -> Int): Int {
    return func(num1, num2)
}

// StringBuilder.表示函数参数定义在StringBuilder上，会自动传入StringBuilder的上下文
fun StringBuilder.myBuild(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}


fun main() {
    val a = 6
    val b = 4
    println(num1AndNum2(a, b, Int::plus))
    println(num1AndNum2(a, b, Int::minus))

    println(num1AndNum2(a, b) {
        a, b -> a * b
    })

    val list = listOf("apple", "orange", "pear", "banana")
    val result = StringBuilder().myBuild {
        append("start add fruit...\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("...finished")
    }
    println(result)
}