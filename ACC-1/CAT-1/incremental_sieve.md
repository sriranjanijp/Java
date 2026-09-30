```
function incrementalSieve(limit):
primes = [2]
next_num = 3
while next_num <= limit:
    is_prime = True
    sqrt_next_num = sqrt(next_num)
    for prime in primes:
        if prime > sqrt_next_num:
            break
        if next_num % prime == 0:
            is_prime = False
            break;
if is_prime:
        primes.append(next_num)
        for i in range(next_num * next_num, limit + 1, next_num * 2):
            # Mark multiples of the new prime as composite
            # Start at prime squared to avoid marking even multiples
            # Increment by 2*prime to skip even multiples
            is_composite[i] = True
    next_num += 2
return primes
```