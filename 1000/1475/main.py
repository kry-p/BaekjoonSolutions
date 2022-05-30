import sys
import math

num = list(sys.stdin.readline())
count = [0 for i in range(10)]

for i in range(0, len(num) - 1):
    count[(int)(num[i])] += 1

sixAndNine = count[6] + count[9]
count[6] = math.floor(sixAndNine / 2) if sixAndNine % 2 == 0 else (math.floor(sixAndNine / 2) + 1)
count[9] = 0
print(max(count))