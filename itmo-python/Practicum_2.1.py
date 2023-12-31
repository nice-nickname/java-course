"""Считать отдельными операторами целочисленные ширину и высоту прямоугольника. Создать функцию (def), принимающую
в качестве параметров ширину и высоту фигуры и название функции, которую необходимо выполнить. Имя вложенной функции
передавать явным образом (например: (a,b,name='perim')).
Внутри функции создать две вложенные функции (def) по подсчету площади и периметра фигуры. Вывести одной строкой
через пробел площадь и периметр, разделенные пробелом (например, '20 18')."""


def geometry(a, b, name='perim'):
    def perim(a, b):
        return 2*(a+b)

    def plosh(a, b):
        return a*b

    if name == 'perim':
        return perim(a, b)
    elif name == 'plosh':
        return plosh(a, b)


a = int(input())
b = int(input())
x1 = geometry(a, b, 'plosh')
x2 = geometry(a, b, 'perim')
print(x1, x2)
