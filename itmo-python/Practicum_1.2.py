"""Считать несколько имен людей одной строкой, записанных латиницей, через пробел, например:
«Anna Maria Peter».
Вывести их одной строкой в порядке возрастания «Anna Maria Peter».
Вывести их одной строкой в порядке убывания «Peter Maria Anna»."""

lst = input().split()
print(*sorted(lst))
print(*sorted(lst, reverse=True))