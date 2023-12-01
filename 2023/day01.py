# day01.py
with open('inputs\day01_input.txt') as f:
    inpt = f.readlines()
    # part one
    total = 0
    for line in inpt:
        n = [-1, -1]
        for char in line:
            if char in '123456789':
                if n[0] == -1:
                    n[0], n[1] = int(char), int(char)
                else:
                    n[1] = int(char)
        total += 10 * n[0] + n[1]
    print(total)
    
    # part two
    total = 0
    nums = {'one':'1', 'two':'2', 'three':'3', 'four':'4', 'five':'5', \
            'six':'6', 'seven':'7', 'eight':'8', 'nine':'9'}
    for line in inpt:
        digline = ''
        # convert to digits
        for i in range(len(line)):
            # check 5 char nums: three, seven, eight
            if i + 5 <= len(line):
                if line[i:i+5] in ['three', 'seven', 'eight']:
                    digline += nums[line[i:i+5]]
            # check 4 char nums: four, five, nine
            if i + 4 <= len(line):
                if line[i:i+4] in ['four', 'five', 'nine']:
                    digline += nums[line[i:i+4]]
            # check 3 char nums: one, two, six
            if i + 3 <= len(line):
                if line[i:i+3] in ['one', 'two', 'six']:
                    digline += nums[line[i:i+3]]
            # check digits
            if line[i] in '123456789':
                digline += line[i]
        # find first/last
        total += 10 * int(digline[0]) + int(digline[-1])
    print(total)
