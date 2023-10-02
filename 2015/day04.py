# 2015 day four
import hashlib

with open('inputs\day04_input.txt') as f:
    inpt = f.read()

    # part one
    i = 0
    while (str(hashlib.md5((inpt + str(i)).encode()).hexdigest())[0:5]
           != '00000'):
        i += 1
    print('part one: ' + str(i))

    # part two
    i = 0
    while (str(hashlib.md5((inpt + str(i)).encode()).hexdigest())[0:6]
           != '000000'):
        i += 1
    print('part two: ' + str(i))
