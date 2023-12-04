# day02.py
import re

with open(r'inputs\day02_input.txt') as f:
    inp = f.readlines()
    patternNums = re.compile(r'(\d+)')
    patternColors = re.compile(r'(red|green|blue)')


    # part one
    maxes = [12, 13, 14]  # in order of red, green, blue
    total = 0
    
    for line in inp:
        # find all the numbers and colors in the input: the first number is
        # the game #, then 2nd num corresponds w/ 1st color and so on.
        # limitation of this approach: the info about which cubes are in which
        # handfuls is lost
        nums = list(map(lambda x: int(x), re.findall(patternNums, line)))
        colors = re.findall(patternColors, line)
        isPossible = True
        for i in range(len(colors)):
            if (colors[i] == 'red' and nums[i + 1] > maxes[0]) \
                    or (colors[i] == 'green' and nums[i + 1] > maxes[1]) \
                    or (colors[i] == 'blue' and nums[i + 1] > maxes[2]):
                isPossible = False

        total += nums[0] if isPossible else 0
                     
    print('part one: ' + str(total))

    # part two
    total = 0
    
    for line in inp:
        nums = list(map(lambda x: int(x), re.findall(patternNums, line)))
        colors = re.findall(patternColors, line)
        maxes = [0, 0, 0]

        for i in range(len(colors)):
            if colors[i] == 'red':
                maxes[0] = max(maxes[0], nums[i + 1])
            elif colors[i] == 'green':
                maxes[1] = max(maxes[1], nums[i + 1])
            elif colors[i] == 'blue':
                maxes[2] = max(maxes[2], nums[i + 1])
        total += maxes[0] * maxes[1] * maxes[2]

    print('part two: ' + str(total))
