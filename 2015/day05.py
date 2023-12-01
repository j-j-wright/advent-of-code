# day05.py
import re

with open('inputs\day05_input.txt') as f:
    inpt = f.readlines()
    
    # part one
    # rule 1: >= 3 vowel 
    r1 = re.compile(r'(.*[aeiou]){3,}')
    # rule 2: repeated letter
    r2 = re.compile(r'(.)\1{1}')
    # rule 3: no ab|cd|pq|xy
    r3 = re.compile(r'ab|cd|pq|xy')
    
    nice = 0
    for line in inpt:
        if re.search(r1, line) != None \
                and re.search(r2, line) != None \
                and re.search(r3, line) == None:
            nice += 1 
    print('part one: ' + str(nice))

    # part two
    # rule 4: a pair of any two letters appears at least twice without overlap
    r4 = re.compile(r'(?=(..).*?\1)')
    # rule 5: a letter repeats with exactly one letter in between
    r5 = re.compile(r'(.).\1{1}')
    
    nice = 0
    for line in inpt:
        if re.search(r4, line) != None \
               and re.search(r5, line) != None:
            nice += 1
    print('part two: ' + str(nice))
