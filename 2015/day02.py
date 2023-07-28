# day two
with open('inputs\day02_input.txt') as f:
    inpt = [list(map(int,y)) for y in \
            [x.split('x') for x in f.read().split('\n')]]
    paper, ribbon = 0, 0

    for i in inpt:
        j = sorted(i)
        # where a <= b <= c,
        # 2ab + 2bc + 2ac + ab == 3ab + 2c(a + b)
        paper += 3 * j[0] * j[1] + 2 * j[2] * (j[0] + j[1])
        # twice the sum of the shorter sides plus the volume
        ribbon += 2 * (j[0] + j[1]) + (j[0] * j[1] * j[2])
    print('part one: ' + str(paper))
    print('part two: ' + str(ribbon))
    
