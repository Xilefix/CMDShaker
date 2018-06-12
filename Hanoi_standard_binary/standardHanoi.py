print('"There are 10 types of people in the world; Those who understand binary, and those who don\'t."')

def Turm(k,a,b):
    if k==0:
        return
    c = 6-a-b
    #turm k-1 verschieben 
    Turm(k-1, a, c)
    print ("Bewege Disk",k, "von ",a,"nach",b)
    print (k,a,b)
    #Turm k-1 verschieben       
    Turm(k-1, c, b)
    
        
Turm(4, 1, 2)

# https://sbj42.github.io/projects/tower-of-hanoi/dist/
# https://www.youtube.com/watch?v=2SUvWfNJSsM