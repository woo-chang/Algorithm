def main():
    n = int(input())
    num_array = list(map(int, input().split()))
    result_table = [[1, -1] for _ in range(n)]
    position = [0, 0, 0]
    answer = []
    for i in range(n):
        for j in range(i-1, -1, -1):
            if num_array[i] > num_array[j] and result_table[i][0] < result_table[j][0] + 1:
                result_table[i][0] = result_table[j][0] + 1
                result_table[i][1] = j
        if position[2] < result_table[i][0]:
            position[0] = i
            position[1] = num_array[i]
            position[2] = result_table[i][0]
    answer.append(position[1])
    print(position[2])
    while result_table[position[0]][1] != -1:
        position[0] = result_table[position[0]][1]
        answer.append(num_array[position[0]])
    answer.reverse()
    print(" ".join(map(str, answer)))


main()