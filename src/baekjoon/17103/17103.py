def find_prime(table):
    table[0] = 0
    table[1] = 0
    start = 0
    while start * start <= 1000000:
        if table[start] == 0:
            start += 1
            continue
        index = start
        while index + start <= 1000000:
            index += start
            table[index] = 0
        start += 1


def test(n, table):
    answer = 0
    for i in range(2, n//2+1):
        if table[i] == 1:
            if table[n-i] == 1:
                answer += 1
    print(answer)


def main():
    # 소수인 수는 1로 지정, 소수가 아닌 수는 0으로 지정
    prime_table = [1] * 1000001
    find_prime(prime_table)
    t = int(input())
    for _ in range(t):
        n = int(input())
        test(n, prime_table)


main()