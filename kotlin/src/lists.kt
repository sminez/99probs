/*
 * List problems from the 99 prolog problems problem set.
 */
package listprobs

fun main(args: Array<String>) {
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
}

// Find the last element of a list.
fun <T> prob1(lst: List<T>) = lst.last()

// Find the last but one element of a list
fun <T> prob2(lst: List<T>) = lst[lst.size-2]


// Find the K'th element of a list (1 indexed)*/
fun <T> prob3(lst: List<T>, k: Int) = lst[k-1]


// Find the number of elements of a list
fun <T> prob4(lst: List<T>) = lst.size


// Reverse a list
fun <T> prob5(lst: List<T>) = lst.reversed()


// Find out whether a list is a palindrome : A palindrome can be read forward*/
// or backward; e.g : (x a m a x)*/
fun <T> prob6(lst: List<T>) = lst == lst.reversed()


// Flatten a nested list structure
fun <T> prob7(lst: List<T>): List<T> {
    fun <T> flatten(l: List<T>): List<T> {
        val flattened = mutableListOf<T>()
        for (subList in l) {
            when (subList) {
                is List<*> -> {
                    @Suppress("UNCHECKED_CAST")
                    flattened.addAll(flatten(subList as List<T>))
                }
                else -> flattened.add(subList)
            }
        }
        return flattened
    }
    return flatten(lst)
}


// Eliminate consecutive duplicates of list elements
fun <T> prob8(lst: List<T>): List<T> {
    var current = lst.first()
    val newList = mutableListOf<T>()

    for (elem in lst.subList(1, lst.size)) {
        if (elem != current) {
            newList.add(elem)
            current = elem
        }
    }
    return newList
}

/**
Pack consecutive duplicates of list elements into sublists : If a list
contains repeated elements they should be placed in separate sublists
**/
fun <T> prob9(lst: List<T>): List<List<T>> {
    val newList = mutableListOf<List<T>>()
    var current = lst.first()
    var subList = mutableListOf(current)

    for (elem in lst.subList(1, lst.size)) {
        if (elem == current) {
            subList.add(elem)
        } else {
            newList.add(subList)
            subList = mutableListOf(elem)
            current = elem
        }
    }
    newList.add(subList)
    return newList
}


/**
Run-length encoding of a list : Use the result of problem P09 to implement
the so-called run-length encoding data compression method : Consecutive
duplicates of elements are encoded as lists [N, E] where N is the number of
duplicates of the element E
 **/
fun <T> prob10(lst: List<T>): List<Pair<Int, T>> {
    val newList = mutableListOf<Pair<Int, T>>()
    var current = lst.first()
    var count = 1

    for (elem in lst.subList(1, lst.size)) {
        if (elem == current) {
            count += 1
        } else {
            newList.add(Pair(count, current))
            current = elem
            count = 1
        }
    }
    newList.add(Pair(count, current))
    return newList
}
