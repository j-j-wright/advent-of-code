# day04.py

inp = [l.strip('\n') for l in open(r'inputs\day04_input.txt')]

# part one
points = 0
for card in inp:
    nums = card.split(':')[1].split('|')
    win = nums[0].split()
    have = nums[1].split()
    matches = 0
    for n in have:
        if n in win:
            matches += 1
    points += 0 if matches == 0 else pow(2, matches - 1)
print('day one: ' + str(points))

# part two
cards = [1] * len(inp)
for i in range(len(inp)):
    nums = inp[i].split(':')[1].split('|')
    win = nums[0].split()
    have = nums[1].split()
    matches = 0
    for n in have:
        if n in win:
            matches += 1
    for j in range(1, matches + 1):
        cards[i + j] += cards[i]
print('part two: ' + str(sum(cards)))
