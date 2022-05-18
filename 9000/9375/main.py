import sys
input = sys.stdin.readline
case = int(input())

for i in range(case):
    n = int(input())
    list = {}
    answer = 1

    for j in range(n):
        name, category = input().split()

        if category in list:
            list[category] += 1
        else:
            list[category] = 1

    for k in list:
        answer *= list[k] + 1
    answer -= 1
    print(answer)