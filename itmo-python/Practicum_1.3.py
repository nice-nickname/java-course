"""Считать единой строкой без пробелов набор целых чисел (28745623873465386),
удалить все дубликаты, вывести отдельными операторами вывода в порядке возрастания
и в порядке убывания в виде кортежей целых чисел (2, 3, 4, 5, 6, 7, 8) и (8, 7, 6, 5, 4, 3, 2)."""

lst = set(map(int, list(input())))
print(tuple(sorted(lst)))
print(tuple(sorted(lst, reverse=True)))