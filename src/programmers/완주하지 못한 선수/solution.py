import collections

def solution(participant, completion):
    dic = collections.defaultdict(int)
    answer = ''
    for p in participant:
        dic[p] += 1
    for c in completion:
        dic[c] -= 1
    for k in dic.keys():
        if dic[k] != 0:
            answer = k
            break

    return answer