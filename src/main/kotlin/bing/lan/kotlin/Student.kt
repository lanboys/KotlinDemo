package bing.lan.kotlin

import java.io.BufferedReader
import java.io.Closeable
import java.io.FileReader
import kotlin.reflect.KFunction


fun main(args: Array<String>) {

//    println("abc" * 5)
//    val person = Person(12, "bing")
//    println(person)
//
//    val copy = person.copy(3, "lan")
//    println(copy.component1())
//    println(copy.component2())


    args.filter(String::isNotEmpty)
    args.forEach(LambadaTest()::testLam)


//     类的方法传入 forEach1 会将实例自身传入
    val listOf: List<LambadaTest> = listOf(LambadaTest(), LambadaTest())
    listOf.forEach1(LambadaTest::testLam1)

    val kFunction1 = LambadaTest::testLam222
    listOf.forEach1(kFunction1)


    val javaClass = LambadaTest().javaClass
    val clazz = LambadaTest::class.java
    val kClass = LambadaTest::class
    kClass.constructors



    args.map1(LambadaTest()::testLam2)
    LambadaTest().testLam222();



    listOf.forEach1({
        val message = "----------"
//        println(message)
        message
    })


    val listOf1 = listOf(
            1..12,
            5..12,
            4..8
    )

    val map = listOf1.map({
        it.forEach({
            println(it)
        })

        it.toString()

    })

    val flatMap = listOf1.flatMap({ intRange ->

        var map1 = intRange.map({ ele ->

            "N000 $ele"
            " N0$ele"
        })

        map1
    })


    flatMap.forEach(::print)


    flatMap.reduce({ acc1, s ->
        acc1 + s
    })


    (0..6).map {
        println("--$it--${factorial(it)}----")
    }

    val map1 = (0..6).map(::factorial)

    map1.fold(StringBuilder()) { acc, i ->
        acc.append(i).append(",")
    }
//    map1.fold(StringBuilder(), StringBuilder::append)


    print((1..6).joinToString())


    val filter = (1..6).filter {
        it % 2 == 0
    }


    filter.forEach(::print)

//    LambadaTest().
//    val kClass = LambadaTest::class
//    kClass.
//
//    val kClass1 = LambadaTest().javaClass
//    kClass1.declaredMethods

//    val constructors = kClass.constructors

    println("")

    getLambadaObject()?.lett({ lambadaTest ->
        lambadaTest.testLam1()
    })

    val applyy = getLambadaObject()?.applyy({

    })
    getLambadaObject()?.applyy(fun LambadaTest.() {

    })

    getLambadaObject()?.applyy(LambadaTest::block)

    with(getLambadaObject(), {
        this?.testLam1();
    })


    var bufferedReader = BufferedReader(FileReader("hello.txt"))

    with(bufferedReader) {
        var line: String?
        while (true) {
            line = readLine() ?: break
            println(line)
        }
        close()
    }
    bufferedReader = BufferedReader(FileReader("hello.txt"))

    bufferedReader.use {
        var line: String?
        while (true) {
            line = it.readLine() ?: break
            println(line)
        }
    }

    bufferedReader = BufferedReader(FileReader("hello.txt"))

    bufferedReader.use(fun(it) {

        var line: String?
        while (true) {
            line = it.readLine() ?: break
            println(line)
        }


    })

    val xx10: (Int) -> Unit = { i -> i + 4 }
    val xx1 = { println("ceshi") }
    val xx2 = fun() {}

    var e2 = ::makeFun1
    var e3 = ::makeFun

    var e4 = makeFun2()
//    e4()

    var xxxx = makeFun()
    xxxx()


    fun x11x() {
        println("ceshi1111")
    }

    x11x()
    x11x()

    val xx0 = makeFun3()

    xx0()
}

fun makeFun(): () -> Unit {
    return {
        println("我是闭包")
    }
}

fun makeFun3(): () -> String {

    fun xx(): String {
        return "0-0-0-0-"
    }

    val xx0 = ::xx

    return xx0
}

fun makeFun2(): KFunction<String> {
    return ::makeFun1
}

fun makeFun1(): String {
    return "111"
}


public inline fun <T : Closeable?, R> T.use(block: (T) -> R): R {
    var closed = false
    try {
        return block(this)
    } catch (e: Exception) {
        closed = true
        try {
            this?.close()
        } catch (closeException: Exception) {
        }
        throw e
    } finally {
        if (!closed) {
            this?.close()
        }
    }
}

public inline fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()

public inline fun <T> T.applyy(block: T.() -> Unit): T {
    block();
    return this
}

public inline fun LambadaTest.block() {
    testLam1()


    print("llllllllllllllllll")

}

public inline fun <T> T.block() {


}

public inline fun <T, R> T.lett1(block: (T) -> R): R {
    return block(this)
}

public inline fun <T, R> T.lett(block: (T) -> R): R = block(this)

fun getLambadaObject(): LambadaTest? {
    return LambadaTest()
}


fun factorial(n: Int): Int {
    if (n == 0) {
        return 0
    }
    return (1..n).reduce({ acc1, s ->
        acc1 * s
    })
}


public fun <T> List<out T>.forEach1(action: (T) -> String): Unit {

    print("=====222======" + action + "======222=====")
    for (element in this) action(element)

}

public inline fun <T, R> Array<out T>.map1(transform: (T) -> R): List<R> {
    return mapTo(ArrayList<R>(size), transform)
}

class LambadaTest {
    fun testLam(int: String) {
        println(this)
        println("testLam")


    }

    fun testLam1(): String {
        println(this)
        println("testLam1")
        return "1111"

    }

    fun testLam2(int: String): String {
        println(this)
        println("testLam2")
        return "2222"

    }
}

fun LambadaTest.testLam222(): String {
    return "1111"

}


operator fun String.times(int: Int): String {
    return "21212"
}

data class Person(val id: Int, val name: String)