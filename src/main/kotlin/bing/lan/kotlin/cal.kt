package bing.lan.kotlin

fun main(args: Array<String>) {

    while (true) {
        println("请输入算式例如：3 + 4")
        val input = readLine()
        if (input == "bing") {
            break
        }
        if (input != null) {
            val split = input.split(" ")
            val arg1 = split[0].toDouble()
            val op = split[1]
            val arg2 = split[2].toDouble()

            val oper = Oper(op)
            val apply = oper(arg1, arg2)
//            val apply = oper.apply(arg1, arg2)

            println("$arg1$op$arg2=$apply")
        }
    }


}


class Oper(op: String) {

    val opFun: (Double, Double) -> Double

//    val bingFun: (p1: Double, p2: Double, p3: Double, p4: Double, p5: Double, p6: Double, p7: Double,
//                  p8: Double, p9: Double, p10: Double, p11: Double, p12: Double, p13: Double,
//                  p14: Double, p15: Double, p16: Double, p17: Double, p18: Double, p19: Double,
//                  p20: Double, p21: Double, p22: Double, p23: Double) -> Double

    init {
        opFun = when (op) {
            "+" -> { l, r -> l + r }
            "-" -> { l, r -> l - r }
            else -> {
                throw RuntimeException()
            }
        }


//        bingFun = { p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
//                    p11, p12, p13, p14, p15, p16, p17, p18,
//                    p19, p20, p21, p22, p23 ->
//            p1 + p2
//        }

    }

    fun xxxx(opFun: (Double, Double) -> Double, left: Double, right: Double): Double {

        return opFun(left, right)
    }

    operator fun invoke(left: Double, right: Double): Double {
//    operator fun apply(left: Double, right: Double): Double {
        println(opFun.toString())

        return opFun(left, right)
    }


}

public interface Function23<in P1, in P2, in P3, in P4, in P5, in P6, in P7, in P8, in P9, in P10, in P11, in P12, in P13, in P14, in P15, in P16, in P17, in P18, in P19, in P20, in P21, in P22, in P23, out R> : Function<R> {
    /** Invokes the function with the specified arguments. */
    public operator fun invoke(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14, p15: P15, p16: P16, p17: P17, p18: P18, p19: P19, p20: P20, p21: P21, p22: P22, p23: P23): R
}