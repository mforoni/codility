def indexes_of(char, string):
    pos = []
    for i in range(len(string)):
        if string[i] == char:
            pos.append(i)
    return pos


def first_index_of(char, string):
    for n in range(len(string)):
        if string[n] == char:
            return n
    return -1


def last_index_of(char, string):
    for n in range(len(string) - 1, 0, -1):
        if string[n] == char:
            return n
    return -1
