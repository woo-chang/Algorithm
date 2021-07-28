def solution(answers):
    answer = []
    length = [5, 8, 10]
    solved = [0, 0, 0]
    one = [1, 2, 3, 4, 5]
    two = [2, 1, 2, 3, 2, 4, 2, 5]
    three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    L = len(answers)
    for i in range(L):
        if one[i%length[0]] == answers[i]:
            solved[0] += 1
        if two[i%length[1]] == answers[i]:
            solved[1] += 1
        if three[i%length[2]] == answers[i]:
            solved[2] += 1
    solve_max = max(solved)
    for i in range(3):
        if solved[i] == solve_max:
            answer.append(i+1)
    return answer