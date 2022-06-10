def solution(array, commands):
    answer = []
    times = len(commands)
    for t in range(times):
        i, j, k = commands[t][0], commands[t][1], commands[t][2]
        copy_array = array[i-1: j]
        answer.append(sorted(copy_array)[k-1])
    return answer