def predicate_prime(n):
    if n <= 1:
        return 0

    for i in range(2, n//2+1):
        if n % i == 0:
            return 0
    return 1


def main():
    n = int(input())
    input_list = list(map(int, input().split(" ")))
    answer = 0
    for i in range(n):
        answer += predicate_prime(input_list[i])
    print(answer)


main()