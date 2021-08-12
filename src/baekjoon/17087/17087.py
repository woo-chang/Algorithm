def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


def main():
    n, s = map(int, input().split(" "))
    pos_list = list(map(int, input().split(" ")))
    pos_distance = []
    for i in range(n):
        pos_distance.append(abs(s-pos_list[i]))
    gcd_num = pos_distance[0]
    for i in range(1, n):
        gcd_num = gcd(gcd_num, pos_distance[i])
    print(gcd_num)


main()