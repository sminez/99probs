[99 x Problems for x in langList]
---------------------------------

These are my solutions to the 99 prolog/LISIP/Haskell... problem set in a
variety of languages. I'd made decent progress a while back but not keeping the
solutions under git combined with a hard-drive failure lost me what I had so
far.

Let's try again!


### The Problem Sets

As per the [haskell.org wiki](https://wiki.haskell.org/H-99:_Ninety-Nine_Haskell_Problems),
I'm splitting the problems into 11 sets:
  - Questions 1 to 10: Lists
  - Questions 11 to 20: Lists, continued
  - Questions 21 to 28: Lists again
  - Questions 31 to 41: Arithmetic
  - Questions 46 to 50: Logic and codes
  - Questions 54A to 60: Binary trees
  - Questions 61 to 69: Binary trees, continued
  - Questions 70B to 73: Multi-way trees
  - Questions 80 to 89: Graphs
  - Questions 90 to 94: Miscellaneous problems
  - Questions 95 to 99: Miscellaneous problems, continued 


The corresponding solutions to each set can be found in `problems_X.{ext}` for
each corresponding language.


### Problem Specifications
An overview of the problems is given below. The full details can be found in the
Haskell.org wiki.


Problems for Lists

1 : Find the last element of a list.
2 : Find the last but one element of a list :
3 : Find the K'th element of a list : The first element in the list is number 1 :
4 : Find the number of elements of a list :
5 : Reverse a list :
6 : Find out whether a list is a palindrome : A palindrome can be read forward or backward; e.g : (x a m a x) :
7 : Flatten a nested list structure
8 : Eliminate consecutive duplicates of list elements :
9 : Pack consecutive duplicates of list elements into sublists : If a list contains repeated elements they should be placed in separate sublists :
10 : Run-length encoding of a list : Use the result of problem P09 to implement the so-called run-length encoding data compression method : Consecutive duplicates of elements are encoded as lists (N E) where N is the number of duplicates of the element E :

11 : Modified run-length encoding : Modify the result of problem 10 in such a way that if an element has no duplicates it is simply copied into the result list : Only elements with duplicates are transferred as (N E) lists :
12 : Decode a run-length encoded list : Given a run-length code list generated as specified in problem 11 : Construct its uncompressed version :
13 : Run-length encoding of a list (direct solution) : Implement the so-called run-length encoding data compression method directly : I.e : don't explicitly create the sublists containing the duplicates, as in problem 9, but only count them : As in problem P11, simplify the result list by replacing the singleton lists (1 X) by X :
14 : Duplicate the elements of a list :
15 : Replicate the elements of a list a given number of times :
16 : Drop every N'th element from a list :
17 : Split a list into two parts; the length of the first part is given :
18 : Extract a slice from a list :
19 : Rotate a list N places to the left :
20 : Remove the K'th element from a list :

21 : Insert an element at a given position into a list :
22 : Create a list containing all integers within a given range :
23 : Extract a given number of randomly selected elements from a list :
24 : Lotto: Draw N different random numbers from the set 1..M :
25 : Generate a random permutation of the elements of a list :
26 : Generate the combinations of K distinct objects chosen from the N elements of a list In how many ways can a committee of 3 be chosen from a group of 12 people? We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficients) : For pure mathematicians, this result may be great : But we want to really generate all the possibilities in a list :
27 : Group the elements of a set into disjoint subsets :
28 : Sorting a list of lists according to length of sublists :

Problems in Arithmetic

31 : Determine whether a given integer number is prime :
32 : Determine the greatest common divisor of two positive integer numbers :
33 : Determine whether two positive integer numbers are coprime : Two numbers are coprime if their greatest common divisor equals 1 :
34 : Calculate Euler's totient function phi(m) : Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r < m) that are coprime to m : Example: m = 10: r = 1,3,7,9; thus phi(m) = 4 : Note the special case: phi(1) = 1 :
35 : Determine the prime factors of a given positive integer : Construct a flat list containing the prime factors in ascending order :
36 : Determine the prime factors of a given positive integer :
37 : Calculate Euler's totient function phi(m) (improved) : See problem 34 for the definition of Euler's totient function : If the list of the prime factors of a number m is known in the form of problem 36 then the function phi(m) can be efficiently calculated as follows: Let ((p1 m1) (p2 m2) (p3 m3) ...) be the list of prime factors (and their multiplicities) of a given number m : Then phi(m) can be calculated with the following formula:
phi(m) = (p1 - 1) * p1 ** (m1 - 1) + (p2 - 1) * p2 ** (m2 - 1) + (p3 - 1) * p3 ** (m3 - 1) + ...
Note that a ** b stands for the b'th power of a : Note: Actually, the official problems show this as a sum, but it should be a product :
38 : Compare the two methods of calculating Euler's totient function :
39 : A list of prime numbers :
40 : Goldbach's conjecture : Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers : Example: 28 = 5 + 23 : It is one of the most famous facts in number theory that has not been proved to be correct in the general case : It has been numerically confirmed up to very large numbers (much larger than w e can go with our Prolog system) : Write a predicate to find the two prime numbers that sum up to a given even integer :
41 : Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach composition :

Problems in Logics and Codes

46 : Define predicates and/2, or/2, nand/2, nor/2, xor/2, impl/2 and equ/2 (for logical equivalence) which succeed or fail according to the result of their respective operations; e.g : and(A,B) will succeed, if and only if both A and B succeed :
47 : Truth tables for logical expressions (2).
Continue problem P46 by defining and/2, or/2, etc as being operators : This allows to write the logical expression in the more natural way, as in the example: A and (A or not B) : Define operator precedence as usual; i.e : as in Java :
48 : Truth tables for logical expressions (3).
Generalize problem P47 in such a way that the logical expression may contain any number of logical variables : Define table/2 in a way that table(List,Expr) prints the truth table for the expression Expr, which contains the logical variables enumerated in List :
49 : Gray codes.
50 : Huffman codes.

Problems in Binary Trees

54 : (A) Check whether a given term represents a binary tree
55 : Construct completely balanced binary trees
56 : Symmetric binary trees
57 : Binary search trees (dictionaries)
58 : Generate-and-test paradigm
59 : Construct height-balanced binary trees
60 : Construct height-balanced binary trees with a given number of nodes Consider a height-balanced binary tree of height H : What is the maximum number of nodes it can contain? Clearly, MaxN = 2**H - 1 : However, what is the minimum number MinN? This question is more difficult : Try to find a recursive statement and turn it into a function minNodes that returns the minimum number of nodes in a height-balanced binary tree of height H.

61 : Count the leaves of a binary tree
61 : (A) Collect the leaves of a binary tree in a list
62 : Collect the internal nodes of a binary tree in a list An internal node of a binary tree has either one or two non-empty successors : Write a predicate internals/2 to collect them in a list.
62 : (B) Collect the nodes at a given level in a list A node of a binary tree is at level N if the path from the root to the node has length N-1 : The root node is at level 1 : Write a predicate atlevel/3 to collect all nodes at a given level in a list.
63 : Construct a complete binary tree
64 : Drawing Binary Trees
65 : Drawing Binary Trees (2)
66 : Drawing Binary Trees (3)
67 : A string representation of binary trees
68 : Preorder and inorder sequences of binary trees : We consider binary trees with nodes that are identified by single lower-case letters, as in the example of problem P67.
a) Write predicates preorder/2 and inorder/2 that construct the preorder and inorder sequence of a given binary tree, respectively : The results should be atoms, e.g : 'abdecfg' for the preorder sequence of the example in problem P67.
b) Can you use preorder/2 from problem part a) in the reverse direction; i.e : given a preorder sequence, construct a corresponding tree? If not, make the necessary arrangements.
c) If both the preorder sequence and the inorder sequence of the nodes of a binary tree are given, then the tree is determined unambiguously : Write a predicate pre_in_tree/3 that does the job :
69 : Dotstring representation of binary trees : We consider again binary trees with nodes that are identified by single lower-case letters, as in the example of problem P67 : Such a tree can be represented by the preorder sequence of its nodes in which dots (.) are inserted where an empty subtree (nil) is encountered during the tree traversal : For example, the tree shown in problem P67 is represented as 'abd..e..c.fg...' : First, try to establish a syntax (BNF or syntax diagrams) and then write a predicate `tree_dotstring`/2 which does the conversion in both directions : Use difference lists.

Problems for Multiway Trees

70 : (B) Check whether a given term represents a multiway tree.
70 : (C) Count the nodes of a multiway tree.
71 : (A) Tree construction from a node string.
71 : Determine the internal path length of a tree.
72 : Construct the bottom-up order sequence of the tree nodes.
73 : Lisp-like tree representation.

Problems for Graphs

81 : Path from one node to another one.

Miscellaneous Problems

90 : Eight queens problem.
91 : Knight's tour.
92 : Von Koch's conjecture
93 : An arithmetic puzzle
94 : Generate K-regular simple graphs with N nodes
95 : English number words
96 : Syntax checker
97 : Sudoku
98 : Nonograms
99 : Crossword puzzle
