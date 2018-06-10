#IntegerExponent[Range[2^8 - 1], 2] + 1
def dual(zahl):
    ganz = zahl // 2
    rest = zahl % 2
    if rest == 0:
        zeichen = '0'
    else:
        zeichen = '1'
    if ganz == 0:
        return zeichen
    else:
        return dual(ganz) + zeichen
    

k=3    #Anzahl Disks
m=2**k
for n in range(1,m):
    print (dual(n))
    
#letztes Bit: Disk 1(kleinste)
#vorletzte Bit: Disk 2
#...
#erste Bit: Disk k (groeste Disk)