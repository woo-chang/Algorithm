def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


def main():
    n = int(input())
    for _ in range(n):
        a, b = map(int, input().split(" "))
        print(b * a // gcd(b, a))


main()
