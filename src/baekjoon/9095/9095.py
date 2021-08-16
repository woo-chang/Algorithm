def main():
    t = int(input())
    table = [0] * 11
    table[0] = 1
    table[1] = 1
    table[2] = 2
    for i in range(3, 11):
        table[i] = table[i-1] + table[i-2] + table[i-3]
    for _ in range(t):
        n = int(input())
        print(table[n])


main()