1 def solve(scheibe, quelle, hilfe1, hilfe2, ziel):
2     if scheibe == 1:
3         print("Von",quelle,"nach", ziel)
4     elif scheibe == 2:
5         print("Von",quelle,"nach", hilfe1)
6         print("Von",quelle,"nach", ziel)
7         print("Von",hilfe1,"nach", ziel)
8     else:
9         solve(scheibe - 2, quelle, hilfe2, ziel, hilfe1)
10         print("Von",quelle,"nach", hilfe2)
11         print("Von",quelle,"nach", ziel)
12         print("Von",hilfe2,"nach", ziel)
13         solve(scheibe - 2,  hilfe1, quelle, hilfe2, ziel)
14 
15 solve(4, 'A', 'B', 'C', 'D')