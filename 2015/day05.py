# 2015 day five
import re

with open('inputs\day05_input.txt') as f:
    inpt = f.readlines()
    
    # part one
    nice = 0

    for i in inpt:
        # matches: .*['aeiou']{3,}
        # matches: (.)\1{1}
        # does not match: ab|cd|pq|xy
        # use .search()
        if :
            nice += 1
    print('part one: ' + str(nice))
