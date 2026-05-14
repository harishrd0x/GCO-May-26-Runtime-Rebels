import math

total = 0

while True:

    line = input()

    if line == "":
        break

    valid = (
        line.count(" ") == 2 and "," not in line
    ) or (
        line.count(",") == 2 and ", " not in line
    ) or (
        line.count(", ") == 2
    )

    if not valid:
        continue

    try:
        if ", " in line:
            nums = line.split(", ")
        elif "," in line:
            nums = line.split(",")
        else:
            nums = line.split()

        if len(nums) != 3:
            continue

        a, b, c = map(int, nums)

        g = math.gcd(math.gcd(a, b), c)

        total += g

    except:
        continue

print(total)