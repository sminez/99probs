'''
List problems from the 99 prolog problems problem set.
'''
from functools import reduce


def prob_1(lst):
    '''Find the last element of a list.'''
    return lst[-1]


def prob_2(lst):
    '''Find the last but one element of a list'''
    return lst[-2]


def prob_3(lst, k):
    '''Find the K'th element of a list (1 indexed)'''
    return lst[k-1]


def prob_4(lst):
    '''Find the number of elements of a list'''
    return len(lst)


def prob_5(lst):
    '''Reverse a list'''
    return reversed(lst)


def prob_6(lst):
    '''
    Find out whether a list is a palindrome : A palindrome can be read forward
    or backward; e.g : (x a m a x)
    '''
    return lst == reversed(lst)


def prob_7(lst):
    '''Flatten a nested list structure'''
    def flatten(col):
        if not isinstance(col, list):
            return [col]
        return reduce(lambda a, b: a+b, map(flatten, col))

    return flatten(lst)


def prob_8(lst):
    '''Eliminate consecutive duplicates of list elements'''
    last = lst[0]
    new_list = [last]

    for elem in lst[1:]:
        if elem != last:
            new_list.append(elem)
            last = elem
    return new_list


def prob_9(lst):
    '''
    Pack consecutive duplicates of list elements into sublists : If a list
    contains repeated elements they should be placed in separate sublists
    '''
    new_list = []
    last = lst[0]
    sub_list = [last]

    for elem in lst[1:]:
        if elem == last:
            sub_list.append(elem)
        else:
            new_list.append(sub_list)
            sub_list = [elem]
            last = elem

    new_list.append(sub_list)

    return new_list


def prob_10(lst):
    '''
    Run-length encoding of a list : Use the result of problem P09 to implement
    the so-called run-length encoding data compression method : Consecutive
    duplicates of elements are encoded as lists [N, E] where N is the number of
    duplicates of the element E
    '''
    new_list = []
    last = lst[0]
    count = 1

    for elem in lst[1:]:
        if elem == last:
            count += 1
        else:
            new_list.append([count, last])
            last = elem
            count = 1

    new_list.append([count, last])

    return new_list
