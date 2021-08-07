def gcd(a, b):
    if b > a:
        b, a = a, b
    while b != 0:
        r = a % b
        a = b
        b = r
    return a


def lcm(a, b, n):
    return a * b // n


def main():
    a, b = map(int, input().split(" "))
    gcd_num = gcd(a, b)
    print(gcd_num)
    print(lcm(a, b, gcd_num))


main()
