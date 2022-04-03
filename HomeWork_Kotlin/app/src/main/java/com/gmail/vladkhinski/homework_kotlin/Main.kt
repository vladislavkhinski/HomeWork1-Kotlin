package com.gmail.vladkhinski.homework_kotlin

import net.objecthunter.exp4j.ExpressionBuilder
import java.util.*

var scanner = Scanner(System.`in`)
fun main() {
    println("Введите что вы хотитите сделать : \n1)Использовать калькулятор\n2)Распарсить выражение")
    runApp()
}

private fun runApp() {
    when (scanner.nextInt()) {
        1 -> {
            simpleCalculator()
        }
        2 -> {
            print("Введите выражение без пробелов : ")
            val str = scanner.next()
            parsing(str)
        }
        else -> print("Введите правильно значение числа!")
    }
}

fun simpleCalculator(): String {
    var result = 0.0
    print("Введите число :")
    val num1 = scanner.nextInt()
    print("Введите число :")
    var num2 = scanner.nextInt()
    print("Введите знак операции:")
    var char = scanner.next()[0]
    when (char) {
        '+' -> result = (num1 + num2).toDouble()
        '-' -> result = (num1 - num2).toDouble()
        '*' -> result = (num1 * num2).toDouble()
        '/' -> result = (num1 / num2).toDouble()
    }
    do {
        //println("Результат операции: $result") "закоментил потому что подумал что он немного сбивает"
        print("Введите знак операции:")
        char = scanner.next()[0]
        if (char != '=') {
            print("Введите число :")
            num2 = scanner.nextInt()
            when (char) {
                '+' -> result += num2
                '-' -> result -= num2
                '*' -> result *= num2
                '/' -> result /= num2

            }
        }
    } while (char != '=')
    return print("Результат всех операции: $result").toString()
}
//не мог смириться что задача не работает до конца, хотя бы просто для себя(понимаю что за это оценка мне не поставится)
fun parsing(str: String): String {
    val expression = ExpressionBuilder(str)
        .build()
    val result =expression.evaluate()
    return print("Выражение равняется: $result").toString()
    /*Это то как я пытался придти своими руками, но потом сам себя начал загонять в тупик
     val num1 = 0
     val num2 = 0
     val leftList = mutableListOf<Int>()
     var rightList = mutableListOf<Int>()
     var listResult = mutableListOf<String>()
     var res: String
     for (i in str.indices) {
         if (str[i] == '(') leftList.add(i)
         if (str[i] == ')') rightList.add(i)
     }
     rightList = rightList.sortedDescending().toMutableList()

     for (i in leftList.size - 1 downTo 0) {
         res = str.substring(leftList[i] + 1, rightList[i])
         listResult.add(res)
     }

     val result = 0*/

}


