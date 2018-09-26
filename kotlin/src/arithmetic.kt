/*
 * Arithmetic problems from the 99 prolog problems problem set.
 */
package probs

import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.util.Random
import kotlin.math.pow
import kotlin.coroutines.experimental.*


// A lazy infinite stream of primes
private fun primes() = buildSequence {
    val sieve = HashMap<Int, MutableList<Int>>()
    var k = 2

    while (true) {
        val kFactors = sieve[k]

        if (kFactors != null) {
            sieve.remove(k)
            for (f in kFactors) {
                val facts = sieve.getOrDefault(f+k, mutableListOf())
                facts.add(f)
                sieve[f+k] = facts
            }
        } else {
            yield(k)
            sieve[k*k] = mutableListOf(k)
        }
        k += 1
    }
}



// Find all of the primes up to (but not including) n
private fun primesToN(n: Int): List<Int> {
    return primes().takeWhile({it < n}).toList()
}


// Determine the prime factor decomposition of an integer
private fun pFactors(n: Int): List<Int> {
    val factors = mutableListOf<Int>()
    var k = n
    for (p in primesToN(Math.sqrt(k.toDouble()).toInt() + 1)) {
        while (k % p == 0) {
            factors.add(p)
            k /= p
        }
    }

    if (k != 1) {
        factors.add(k)
    }
    return factors
}

/**
Check n for primalty using the Miller-Rabin method
    https://en.wikipedia.org/wiki/Miller%E2%80%93Rabin_primality_test
    http://mathworld.wolfram.com/Rabin-MillerStrongPseudoprimeTest.html

Return True if n passes k rounds of the Miller-Rabin primality test (and is
probably prime). Return False if n is proved to be composite.

NOTE: This is faster than generating primes >= n and checking if we are in
      the list but it is slower at generating a list of primes than
      using `lazy_primes`.
**/
private fun probablyPrime(n: Int, k: Int = 20): Boolean {
    val smallPrimes = listOf(2, 3, 5, 7, 11, 13, 17, 23, 29, 31)

    // Handle small known cases quickly
    if (n < 2) return false

    for (p in smallPrimes) {
        if (n < p * p) return true
        if (n % p == 0) return false
    }

    // Run Miller-Rabin
    var r = 0
    var s = n - 1
    val uBound = n - 1

    while (s % 2 == 0) {
        r += 1
        s /= 2
    }

    for (i in 1..k) {
        val a = Random().nextInt(uBound - 2) + 2
        var x = a.toDouble().pow(s).toInt() % n

        if (x == 1 || x == uBound) {
            continue
        }

        var flag = false

        for (j in 0 until r) {
            x = x.toDouble().pow(2).toInt() % n
            if (x == uBound) {
                flag = true
                break
            }
        }
        // If we didn't break then we are composite
        if (!flag) return false

    }
    return true
}

// Determine if two integers are co-prime
private fun areCoprime(a: Int, b: Int): Boolean {
    var aa = a
    var bb = b
    while (bb != 0) {
        val tmp = bb
        bb = aa % bb
        aa = tmp
    }
    return aa == 1
}

// Determine if an integer is prime
fun prob31(n: Int) = probablyPrime(n)


// Determine the greatest common divisor of two positive integers
// NOTE: tailrec, if allowed, is optimised out by the compiler into
//       efficient looping.
tailrec fun prob32(a: Int, b: Int): Int {
    return if (b == 0) a else prob32(b, a % b)
}

// Determine if two integers are co-prime
fun prob33(a: Int, b: Int): Boolean {
    return areCoprime(a, b)
}

/**
Calculate Euler's totient function phi(m) : Euler's so-called totient
function phi(m) is defined as the number of positive integers r
(1 <= r < m) that are co-prime to m.
    Example: m = 10: r = 1,3,7,9; thus phi(m) = 4
Note the special case: phi(1) = 1
 **/
fun prob34(m: Int): Int {
    if (m == 1) return 1

    var phiM = 0
    for (k in 1 until m) {
        if (areCoprime(m, k)) phiM += 1
    }
    return phiM
}


/**
Calculate Euler's totient function phi(m) (improved) : See problem 34 for
the definition of Euler's totient function : If the list of the prime
factors of a number m is known in the form of problem 36 then the function
phi(m) can be efficiently calculated as follows: Let ((p1 m1) (p2 m2) (p3
m3) ...) be the list of prime factors (and their multiplicities) of a given
number m : Then phi(m) can be calculated with the following formula:
  phi(m) = (p1 - 1) * p1 ** (m1 - 1) * (p2 - 1) * p2 ** (m2 - 1) * ...
 **/
fun prob37(n: Int): Int {
    val factors = pFactors(n)
    var phiM = 1
    val groups = factors.groupBy { it }
    for ((p, group) in groups) {
        val m = group.size
        phiM *= (p - 1) * p.toDouble().pow(m-1).toInt()
    }
    return phiM
}

/**
Goldbach's conjecture : Goldbach's conjecture says that every positive even
number greater than 2 is the sum of two prime numbers.
    For example: 28 = 5 + 23
It is one of the most famous facts in number theory that has not been
proved to be correct in the general case, but it has been numerically
confirmed up to very large numbers.
Write a function to find the two prime numbers that sum up to a given even
integer.
 **/
fun prob40(n: Int): Pair<Int, Int> {
    if (n % 2 != 0) throw IllegalArgumentException("n must be even")

    val pList = primesToN(n)

    for ((ix, p) in pList.withIndex()) {
        for (q in pList.subList(ix, pList.size)) {
            if (p + q == n) {
                return Pair(p, q)
            }
        }
    }
    throw IllegalStateException("Just found a counterexample to Goldbach!")
}
