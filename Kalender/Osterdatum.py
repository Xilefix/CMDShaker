def Ostern(x):
    k = x // 100
    m = 15 + (3 * k + 3) // 4 - (8 * k + 13) // 25
    s = 2 - (3 * k + 3) // 4
    a = x % 19
    d = (19 * a + m) % 30
    r = d // 29 + (d // 28 - d // 29) * (a // 11)
    og = 21 + d - r
    sz = 7 - (x + x // 4 + s) % 7
    oe = 7 - (og - sz) % 7
    os = og + oe
    return os

print Ostern(2020)