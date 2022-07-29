import sys

N = int(sys.stdin.readline())
M = 1

while (M < 10):
    A = N * M
    print('%d * %d = %d' % (N, M, A))
    M += 1