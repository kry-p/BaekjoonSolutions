import sys

input = sys.stdin.readline
case = int(input())

for i in range(case):
    n = input()
    print(n[0] + n.strip()[-1])