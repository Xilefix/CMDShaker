import sys
#für den Printersatz

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

def Osterdatum(x):
    print("Ostern ist am: ")
    if Ostern(x)>31:
        print (Ostern(x)-31, "-ten April")
    else:
        print (Ostern(x),"-ten Maerz")    
        

def schaltjahr(jahr):
    if jahr % 400 == 0 or jahr % 4 == 0 and jahr % 100 != 0:
        return True
    else:
        return False
    
    
def f(monat):
    return {
        1: 31,
        3: 31,
        5: 31,
        7: 31,
        8: 31,
        10: 31,
        12: 31,
        
        4: 30,
        6: 30,
        9: 30,
        11: 30
        
    }[monat]
    
def anzahl(jahr, monat):
    if monat == 2:
        if schaltjahr(jahr) == True:
            return 29
        else:
            return 28
    else:
        return f(monat)

def kennzahl(monat):
    return {
        1: 6,
        2: 2,
        3: 2,
        4: 5,
        5: 0,
        6: 3,
        7: 5,
        8: 1,
        9: 4,
        10: 6,
        11: 2,
        12: 4
        
    }[monat]
def wochentag(jahr, monat, tag):
    j = jahr % 100
    c = jahr // 100
    k = kennzahl(monat)
    if schaltjahr(jahr) == True:
        if monat == 1:
            k = 5
        elif monat == 2:
            k = 1
    d = tag + k + j + j // 4 - 2 * (c % 4)
    if d % 7 == 0:
        return 7
        
    return d % 7


def Monat(monat):
    return {
        1: 'Januar',
        2: 'Februar',
        3: 'Maerz',
        4: 'April',
        5: 'Mai',
        6: 'Juni',
        7: 'Juli',
        8: 'August',
        9: 'September',
        10: 'Oktober',
        11: 'November',
        12: 'Dezember'
     }[monat]
        
# Programmstart
jahr = 2018
print("Jahr: ", jahr)
Osterdatum(jahr)
m = 1

while m != 13:
    d = 1
    
    
    print(Monat(m))
    print("Mo Di Mi Do Fr Sa So")
    
    sys.stdout.write((wochentag(jahr, m, 1)-1)*'*  ') #3 Zeichen Bsp "Mo*Di*..."
    while d != anzahl(jahr, m):
        if wochentag(jahr, m, d) == 7 and d < 10:
            sys.stdout.write( str(d)+ "  " + "\n")
        elif wochentag(jahr, m, d) != 7 and d < 10:
            sys.stdout.write(str(d)+ "  ")
        elif wochentag(jahr, m, d) == 7 and d > 9:
            sys.stdout.write(str(d)+ " " "\n")
        elif wochentag(jahr, m, d) != 7 and d > 9:
            sys.stdout.write(str(d)+ " ")
        
        d = d + 1
    sys.stdout.write("\n\n")
    m = m + 1
    
    #sys.stdout.write() statt print ohne Zeilenumbruch




    
    