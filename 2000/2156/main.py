import sys
n = int(sys.stdin.readline())
dp = []
input = []
dp.append(0)
input.append(0)
for i in range(n):
  input.append(int(sys.stdin.readline()))

dp.append(input[1])
if n>1:
  dp.append(input[1] + input[2])
  for i in range(3, n + 1):
    dp.append(max(dp[i - 1], 
              dp[i - 2] + input[i],
              dp[i - 3] + input[i - 1] + input[i]))

print(max(dp))