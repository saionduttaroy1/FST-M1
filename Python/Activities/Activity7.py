numbers = list(input("Enter a sequence of comma separated values: ").split(", "))
mySum = 0

for number in numbers:
    mySum += int(number)

print(mySum)
