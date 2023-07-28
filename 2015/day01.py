# day one
with open('inputs\day01_input.txt') as f:
    # part one
    inpt = f.read()
    floor = 0    
    for i in range(len(inpt)):
        floor += 1 if inpt[i] == '(' else -1
    print('part one: ' + str(floor))

    # part two
    floor = 0    
    for i in range(len(inpt)):
        if floor < 0:
            print('part two: ' + str(i))
            break
        floor += 1 if inpt[i] == '(' else -1

