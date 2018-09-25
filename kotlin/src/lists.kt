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


/*fun prob_6(lst):*/
/*    /***/
/*    Find out whether a list is a palindrome : A palindrome can be read forward*/
/*    or backward; e.g : (x a m a x)*/
/*    **/*/
/*    return lst == reversed(lst)*/


/*fun prob_7(lst):*/
/*    // Flatten a nested list structure*/
/*    fun flatten(col):*/
/*        if not isinstance(col, list):*/
/*            return [col]*/
/*        return reduce(lambda a, b: a+b, map(flatten, col))*/

/*    return flatten(lst)*/


/*fun prob_8(lst):*/
/*    // Eliminate consecutive duplicates of list elements*/
/*    last = lst[0]*/
/*    new_list = [last]*/

/*    for elem in lst[1:]:*/
/*        if elem != last:*/
/*            new_list.append(elem)*/
/*            last = elem*/
/*    return new_list*/


/*fun prob_9(lst):*/
/*    /***/
/*    Pack consecutive duplicates of list elements into sublists : If a list*/
/*    contains repeated elements they should be placed in separate sublists*/
/*    **/*/
/*    new_list = []*/
/*    last = lst[0]*/
/*    sub_list = [last]*/

/*    for elem in lst[1:]:*/
/*        if elem == last:*/
/*            sub_list.append(elem)*/
/*        else:*/
/*            new_list.append(sub_list)*/
/*            sub_list = [elem]*/
/*            last = elem*/

/*    new_list.append(sub_list)*/

/*    return new_list*/


/*fun prob_10(lst):*/
/*    /***/
/*    Run-length encoding of a list : Use the result of problem P09 to implement*/
/*    the so-called run-length encoding data compression method : Consecutive*/
/*    duplicates of elements are encoded as lists [N, E] where N is the number of*/
/*    duplicates of the element E*/
/*    **/*/
/*    new_list = []*/
/*    last = lst[0]*/
/*    count = 1*/

/*    for elem in lst[1:]:*/
/*        if elem == last:*/
/*            count += 1*/
/*        else:*/
/*            new_list.append([count, last])*/
/*            last = elem*/
/*            count = 1*/

/*    new_list.append([count, last])*/

/*    return new_list*/
