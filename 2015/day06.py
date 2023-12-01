# day06.py
import re
import functools

with open (r'inputs\day06_input.txt') as f:
    inpt = f.readlines()
    # need to collect toggle/turn off/turn on; the two coordinate pairs
    reg = re.compile(r'(toggle|turn off|turn on) (\d*),(\d*) through (\d*),(\d*)')


    # part one
    lights = [[False]*1000 for i in range(1000)]

    for line in inpt:
        mat = re.match(reg, line)
        command = [mat.group(1), int(mat.group(2)), int(mat.group(3)), \
                   int(mat.group(4)), int(mat.group(5))]
        for i in range(command[1], command[3] + 1):
            for j in range(command[2], command[4]+ 1):
                match command[0]:
                    case 'toggle':
                        lights[i][j] = not lights[i][j]
                    case 'turn off':
                        lights[i][j] = False
                    case 'turn on':
                        lights[i][j] = True
    print('part one: ' + str(functools.reduce(lambda acc, elt: \
                                              acc + sum(elt), lights, 0)))

    # part two
    lights = [[0]*1000 for i in range(1000)]
    
    for line in inpt:
        mat = re.match(reg, line)
        command = [mat.group(1), int(mat.group(2)), int(mat.group(3)), \
                   int(mat.group(4)), int(mat.group(5))]
        for i in range(command[1], command[3] + 1):
            for j in range(command[2], command[4]+ 1):
                match command[0]:
                    case 'toggle':
                        lights[i][j] += 2
                    case 'turn off':
                        lights[i][j] = max(lights[i][j] - 1, 0)
                    case 'turn on':
                        lights[i][j] += 1
    print('part two: ' + str(functools.reduce(lambda acc, elt: \
                                              acc + sum(elt), lights, 0)))
