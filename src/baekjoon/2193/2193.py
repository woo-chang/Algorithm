def main():
    n = int(input())
    num_table = [[0]*2 for _ in range(91)]
    num_table[1][1] = 1
    for i in range(2, 91):
        num_table[i][0] = num_table[i-1][0] + num_table[i-1][1]
        num_table[i][1] = num_table[i-1][0]
    print(num_table[n][0] + num_table[n][1])


main()