"""Считать с клавиатуры отдельными операторами:
- заголовок страницы (например, Hello);
- цвет заголовка первого уровня (например, blue);
- цвет текста абзаца (например, red);
- текст заголовка первого уровня (например, Title 1);
- текст статьи (например, Article text).

Использовать только латинские символы.
Используя декораторы, сформировать текст html-страницы для публикации статьи."""

from functools import wraps

title = input()
color_h1 = input()
color_text = input()
text_h1 = input()
art_text = input()

# Этот вариант более сжатый, но, который выбрал я, на мой взгляд более изящный
def head_part_1(func):
    @wraps(func)
    def inner(text):
        print('<html>')
        print('<head>')
        func(text)
    return inner


def head_part_2(func):
    @wraps(func)
    def inner(text_1, text_2):
        func(text_1, text_2)
        print('</head>')
    return inner


def body_part(func):
    @wraps(func)
    def inner(text_1, text_2):
        print('<body>')
        func(text_1, text_2)
        print('</body>')
        print('</html>')
    return inner


@head_part_1
def head_part(text):
    print('<title>' + text + '</title>')


@head_part_2
def head_part_i(text_1, text_2):
    print('<style>' + 'h1{color:' + text_1 + '}'
          + 'p{color:' + text_2 + '}' + '</style>')


@body_part
def body_part_1(text_1, text_2):
    print('<h1>' + text_1 + '</h1>')
    print('<p>' + text_2 + '</p>')


head_part(title)
head_part_i(color_h1, color_text)
body_part_1(text_h1, art_text)
