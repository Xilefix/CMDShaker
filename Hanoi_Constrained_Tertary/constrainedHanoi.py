print('"There are 10 types of people in this world; those who don\'t understand binary, those who do, and those that understand a base three joke."')

def tertiar(zahl):
    ganz = zahl // 3
    rest = zahl % 3
    if rest == 0:
        zeichen = '0'
    elif rest == 2:
        zeichen = '2'
    else:
        zeichen = '1'
            
    if ganz == 0:
        return zeichen
    else:
        return tertiar(ganz) + zeichen
    

k=3    #Anzahl Disks 3:26 4:80
m=3**k
for n in range(1,m):
    print (tertiar(n))