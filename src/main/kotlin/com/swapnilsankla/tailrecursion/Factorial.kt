package com.swapnilsankla.tailrecursion

fun main() {
    nonRecursiveFactorialWithVars(15).also(::println)

    nonRecursiveFactorialWithoutVars(15).also(::println)

    linearRecursiveFactorial(15).also(::println)

    tailRecursiveFactorial(15).also(::println)
}

fun nonRecursiveFactorialWithVars(num: Int): Int {
    var result = 1
    var counter = num

    while (counter > 1) {
        result *= counter
        counter -= 1
    }
    return result
}

fun nonRecursiveFactorialWithoutVars(num: Int): Int = (1..num).reduce { acc, number -> acc * number }

fun linearRecursiveFactorial(num: Int): Int = if (num <= 1) 1 else num * linearRecursiveFactorial(num - 1)

fun tailRecursiveFactorial(num: Int) = tailRecursiveFactorial(num, num)

tailrec
private fun tailRecursiveFactorial(number1: Int, count: Int): Int {
    return if (count <= 1) number1 else return tailRecursiveFactorial(number1 * (count - 1), count - 1)
}