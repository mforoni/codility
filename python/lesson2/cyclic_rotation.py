from collections import deque


def solution(A, K):
    """
    An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one
    index, and the last element of the array is moved to the first place. For example, the rotation of array
    A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

    The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

    Write a function:

    def solution(A, K)

    that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

    For example, given

    A = [3, 8, 9, 7, 6]
    K = 3

    the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]

    For another example, given

    A = [0, 0, 0]
    K = 1

    the function should return [0, 0, 0]

    Given

    A = [1, 2, 3, 4]
    K = 4

    the function should return [1, 2, 3, 4]

    Assume that:

    N and K are integers within the range [0..100];
    each element of array A is an integer within the range [−1,000..1,000].
    In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
    :param A:
    :param K:
    :return:
    """
    if K == 0 or len(A) == 0:
        return A
    return rotate(A, K)


def rotate_one(a):
    last = a[-1]
    for i in range(len(a) - 1, 0, -1):
        a[i] = a[i - 1]
    a[0] = last
    return a


def rotate(a, k):
    k = k % len(a)
    # print("k={}".format(k))
    tmp = a[-k:]
    # print("tmp={}".format(tmp))
    for i in range(len(a) - 1, 0, -1):
        a[i] = a[i - k]
    for i in range(0, k, 1):
        a[i] = tmp[i]
    return a


def simple_solution(a, k):
    if k == 0:
        return a
    items = deque(a)
    for i in range(k):
        items.rotate()
    return list(items)


def swap(a, i, j):
    # print("swap a={}, on i, j = {}, {}".format(a, i, j))
    assert 0 <= i < j < len(a)
    a[i], a[j] = a[j], a[i]
    return a
