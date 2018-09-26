"""
Problems in Arithmetic
"""
import random
from itertools import groupby


def lazy_primes():
    '''
    An infinite generator of primes based on a sieve that stores each prime
    indexed against its current greatest multiple.
    '''
    sieve = {}
    k = 2
    while True:
        k_factors = sieve.get(k)
        if k_factors:
            del sieve[k]
            for f in k_factors:
                sieve.setdefault(f + k, []).append(f)
        else:
            yield k
            sieve[k ** 2] = [k]
        k += 1


def primes_to_n(n):
    '''All primes below n'''
    primes = lazy_primes()
    p = next(primes)

    while p < n:
        yield p
        p = next(primes)


def probably_prime(n, k=20):
    """
    Determine if a number is likely to be prime using the Miller-Rabin method
    """
    r, s = 0, n - 1

    while s % 2 == 0:
        r += 1
        s //= 2

    for _ in range(k):
        a = random.randrange(2, n - 1)
        x = pow(a, s, n)  # a^s (mod n)

        if x == 1 or x == n - 1:
            continue

        for _ in range(r - 1):
            x = pow(x, 2, n)
            if x == n - 1:
                break
        else:
            return False

    return True


def prime_factors(n):
    """Find the prime factors of n"""
    factors = []
    for p in primes_to_n(int(n ** 0.5) + 1):
        while n % p == 0:
            factors.append(p)
            n /= p
    if n != 1:
        factors.append(int(n))
    return factors


def prob_31(n):
    """Determine whether a given integer number is prime"""
    return probably_prime(n)


def prob_32(a, b):
    """
    Determine the greatest common divisor of two positive integer numbers
    """
    while b != 0:
        a, b = b, a % b
    return a


def prob_33(a, b):
    """
    Determine whether two positive integer numbers are coprime : Two numbers
    are coprime if their greatest common divisor equals 1
    """
    while b != 0:
        a, b = b, a % b
    return a == 1


def prob_34(m):
    """
    Calculate Euler's totient function phi(m) : Euler's so-called totient
    function phi(m) is defined as the number of positive integers r (1 <= r <
    m) that are coprime to m : Example: m = 10: r = 1,3,7,9; thus phi(m) = 4 :
        Note the special case: phi(1) = 1 :
    """
    def is_coprime(m, r):
        while r != 0:
            m, r = r, m % r
        if m == 1:
            return m
        return 0

    if m == 1:
        return 1

    phi_m = sum(is_coprime(m, r) for r in range(1, m))
    return phi_m


def prob_35(n):
    """
    Determine the prime factors of a given positive integer : Construct a flat
    list containing the prime factors in ascending order
    """
    return prime_factors(n)


def prob_37(n):
    """
    Calculate Euler's totient function phi(m) (improved) : See problem 34 for
    the definition of Euler's totient function : If the list of the prime
    factors of a number m is known in the form of problem 36 then the function
    phi(m) can be efficiently calculated as follows: Let ((p1 m1) (p2 m2) (p3
    m3) ...) be the list of prime factors (and their multiplicities) of a given
    number m : Then phi(m) can be calculated with the following formula:
      phi(m) = (p1 - 1) * p1 ** (m1 - 1) * (p2 - 1) * p2 ** (m2 - 1) * ...
    """
    p_factors = prime_factors(n)
    phi_m = 1

    for p, g in groupby(p_factors):
        m = len(list(g))
        phi_m *= (p - 1) * p ** (m - 1)
    return phi_m


def prob_40(n):
    """
    Goldbach's conjecture : Goldbach's conjecture says that every positive even
    number greater than 2 is the sum of two prime numbers : Example: 28 = 5 +
    23 : It is one of the most famous facts in number theory that has not been
    proved to be correct in the general case : It has been numerically
    confirmed up to very large numbers.
    Write a function to find the two prime numbers that sum up to a given even
    integer.
    """
    if n % 2 != 0:
        raise ValueError('Must pass an even number')

    primes = list(primes_to_n(n))

    for ix, p in enumerate(primes):
        for q in primes[ix:]:
            if p + q == n:
                return (p, q)
