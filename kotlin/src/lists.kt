/*
 * List problems from the 99 prolog problems problem set.
 */
package probs


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

// Given a run-length code list, construct its uncompressed version
fun <T> prob12(lst: List<Pair<Int, T>>): List<T> {
    var newList = mutableListOf<T>()
    for ((count, elem) in lst) {
        for (k in 1..count) {
            newList.add(elem)
        }
    }
    return newList
}

// Duplicate the elements of a list
fun <T> prob14(lst: List<T>): List<T> {
    val newList = mutableListOf<T>()
    for (elem in lst) {
        newList.addAll(listOf(elem, elem))
    }
    return newList
}

// Replicate the elements of a list a given number of times :
fun <T> prob15(lst: List<T>, count: Int): List<T> {
    val newList = mutableListOf<T>()
    for (elem in lst) {
        for (k in 1..count) {
            newList.add(elem)
        }
    }
    return newList
}

// Drop every N'th element from a list
fun <T> prob16(lst: List<T>, n: Int): List<T> {
    return lst.filterIndexed { index, _ -> (index + 1) % n != 0 }
}

// Split a list into two parts; the length of the first part is given
fun <T> prob17(lst: List<T>, split: Int): Pair<List<T>, List<T>> {
    var list1 = lst.subList(0, split)
    var list2 = lst.subList(split, lst.size)
    return Pair(list1, list2)
}

// Extract a slice from a list
fun <T> prob18(lst: List<T>, from: Int, to: Int) = lst.subList(from, to)

// 19 : Rotate a list N places to the left

// 20 : Remove the K'th element from a list

