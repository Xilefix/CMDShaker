def solve(scheibe, quelle, hilfe1, hilfe2, ziel):
    if scheibe == 1:
        print("Von",quelle,"nach", ziel)
    elif scheibe == 2:
        print("Von",quelle,"nach", hilfe1)
        print("Von",quelle,"nach", ziel)
        print("Von",hilfe1,"nach", ziel)
    else:
        solve(scheibe - 2, quelle, hilfe2, ziel, hilfe1)
        print("Von",quelle,"nach", hilfe2)
        print("Von",quelle,"nach", ziel)
        print("Von",hilfe2,"nach", ziel)
        solve(scheibe - 2,  hilfe1, quelle, hilfe2, ziel)

solve(1, 'A', 'B', 'C', 'D')
