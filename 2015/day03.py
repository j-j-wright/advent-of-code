# 2015 day three
import cmath

with open('inputs\day03_input.txt') as f:
    inpt = f.read()

    # part one
    pos = 0j
    grid = {pos:1}

    for i in inpt:
        pos += 1 if i == '^' else -1 if i == 'v' else 1j if i == ">" else -1j
        if pos not in grid:
            grid.update({pos:1})
        else:
            grid.update({pos:grid[pos] + 1})
    print('part one: ' + str(len(grid.keys())))

    # part two
    santas = [0j,0j]
    grid = {0j:2}

    for i in range(len(inpt)):
        santas[i % 2] += (1 if inpt[i] == '^' else -1
            if inpt[i] == 'v' else 1j if inpt[i] == ">" else -1j)
        if santas[i % 2] not in grid:
            grid.update({santas[i % 2]:1})
        else:
            grid.update({santas[i % 2]:grid[santas[i % 2]] + 1})
    print('part two: ' + str(len(grid.keys())))
        
