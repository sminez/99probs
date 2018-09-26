package probs


fun main(args: Array<String>) {
    // Lists
    println("List Problems")
    val lst = listOf(1,2,3,4,5)
    println(prob1(lst))
    println(prob2(lst))
    println(prob3(lst, 3))
    println(prob4(lst))
    println(prob5(lst))
    println(prob6(lst))
    println(prob6(listOf(1,2,3,2,1)))
    println(prob7(listOf(1,2,3, listOf(4,5, listOf(6,7), 8), 9)))
    println(prob8(listOf(1,1,1,2,2,3,3,3,3,3,3,4,4,4,4,4,5,5,5,6)))
    println(prob9(listOf(1,1,1,2,2,3,3,3,3,3,3,4,4,4,4,4,5,5,5,6)))
    println(prob10(listOf(1,1,1,2,2,3,3,3,3,3,3,4,4,4,4,4,5,5,5,6)))
    println(prob12(prob10(listOf(1,1,1,2,2,3,3,3,3,3,3,4,4,4,4,4,5,5,5,6))))
    println(prob14(lst))
    println(prob15(lst, 5))
    println(prob16(listOf(1,2,3,4,5,6,7,8,9,10), 3))
    println(prob17(listOf(1,2,3,4,5,6,7,8,9,10), 3))
    println(prob18(lst, 1, 4))

    // arithmetic
    println("\nArithmetic Problems")
    println("103 is prime: ${prob31(103)}")
    println("104 is prime: ${prob31(104)}")
    println(prob32(17, 170))
    println(prob33(14, 86))
    println(prob34(20))
    println(prob37(20))
    println(prob40(18656))
}
