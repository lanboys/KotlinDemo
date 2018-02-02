package bing.lan.kotlin


fun main(args: Array<String>) {
//    println(multiply(add5(8)))
//
    val andThen = add5.andThen(multiply)

    println(andThen(9))
}


  fun <P1, P2, R> Function1<P1, P2>.andThen(function: Function1<P2, R>): Function1<P1, R> {

    return fun(p1: P1): R {

        return function(this(p1))

    }
//    return fun(p1: P1): R {
//        return function.invoke(this.invoke(p1))
//
//    }

}

val add5 = { it: Int -> it + 5 }
val multiply = { it: Int -> it * 2 }

fun add51(i: Int): Int {
    return i * 5;
}

fun multiply1(i: Int): Int {
    return i * 2;
}