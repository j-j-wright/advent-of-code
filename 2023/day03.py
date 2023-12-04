# day03.py

inp = [l.strip('\n') for l in open(r'inputs\day03_input.txt')]
# pad the arr with . to avoid special cases
arr = [['.'] * (len(inp[0]) + 2)]
for line in inp:
    arr += [['.'] + [*line] + ['.']]
arr += [['.'] * (len(inp[0]) + 2)]


# part one
total = 0
syms = '*-%$=@#/&+'  # determined experimentally

# find the nums adjacent to a symbol, add them to total
for i in range(1, len(arr) - 1):
    j = 1
    while j < len(arr[0]) - 1:
        if arr[i][j].isdigit():
            num = ''
            adjSym = False
            # check the chars to the left of the first digit found
            if arr[i-1][j-1] in syms \
                    or arr[i][j-1] in syms \
                    or arr[i+1][j-1] in syms:
                adjSym = True
            # check the chars immediately above/below each digit
            while arr[i][j].isdigit():
                num += arr[i][j]
                if arr[i-1][j] in syms \
                        or arr[i+1][j] in syms:
                    adjSym = True
                j += 1
            # check the chars to the right of the last digit
            if arr[i-1][j] in syms \
                    or arr[i][j] in syms \
                    or arr[i+1][j] in syms:
                adjSym = True
            if adjSym:
                total += int(num)
        j += 1

print('part one: ' + str(total))

# part two
def numFind(arr, i, j):
    ''' Return the str version of the number which has a char at arr[i][j].'''
    n = arr[i][j]
    l = j - 1
    r = j + 1
    while arr[i][l].isdigit():
        n = arr[i][l] + n
        l -= 1
    while arr[i][r].isdigit():
        n = n + arr[i][r]
        r += 1
    return n

total = 0
for i in range(1, len(arr) - 1):
    for j in range(1, len(arr[0]) - 1):
        if arr[i][j] == '*':
            adjNums = []
            for row in range(i - 1, i + 2):
                for col in range(j - 1, j + 2):
                    if arr[row][col].isdigit():
                        adjNums += [numFind(arr, row, col)]
            # below line assumes no duplicate nums adjacent to a gear
            adjNums = list(set(adjNums))
            if len(adjNums) == 2:
                total += int(adjNums[0]) * int(adjNums[1])

print('part two: ' + str(total))
                
