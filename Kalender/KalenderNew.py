1 import sys
2 #für den Printersatz
3 
4 def Ostern(x):
5     k = x // 100
6     m = 15 + (3 * k + 3) // 4 - (8 * k + 13) // 25
7     s = 2 - (3 * k + 3) // 4
8     a = x % 19
9     d = (19 * a + m) % 30
10     r = d // 29 + (d // 28 - d // 29) * (a // 11)
11     og = 21 + d - r
12     sz = 7 - (x + x // 4 + s) % 7
13     oe = 7 - (og - sz) % 7
14     os = og + oe
15     return os
16 
17 def Osterdatum(x):
18     print("Ostern ist am: ")
19     if Ostern(x)>31:
20         print (Ostern(x)-31, "-ten April")
21     else:
22         print (Ostern(x),"-ten Maerz")    
23         
24 
25 def schaltjahr(jahr):
26     if jahr % 400 == 0 or jahr % 4 == 0 and jahr % 100 != 0:
27         return True
28     else:
29         return False
30     
31     
32 def f(monat):
33     return {
34         1: 31,
35         3: 31,
36         5: 31,
37         7: 31,
38         8: 31,
39         10: 31,
40         12: 31,
41         
42         4: 30,
43         6: 30,
44         9: 30,
45         11: 30
46         
47     }[monat]
48     
49 def anzahl(jahr, monat):
50     if monat == 2:
51         if schaltjahr(jahr) == True:
52             return 29
53         else:
54             return 28
55     else:
56         return f(monat)
57 
58 def kennzahl(monat):
59     return {
60         1: 6,
61         2: 2,
62         3: 2,
63         4: 5,
64         5: 0,
65         6: 3,
66         7: 5,
67         8: 1,
68         9: 4,
69         10: 6,
70         11: 2,
71         12: 4
72         
73     }[monat]
74 def wochentag(jahr, monat, tag):
75     j = jahr % 100
76     c = jahr // 100
77     k = kennzahl(monat)
78     if schaltjahr(jahr) == True:
79         if monat == 1:
80             k = 5
81         elif monat == 2:
82             k = 1
83     d = tag + k + j + j // 4 - 2 * (c % 4)
84     if d % 7 == 0:
85         return 7
86         
87     return d % 7
88 
89 
90 def Monat(monat):
91     return {
92         1: 'Januar',
93         2: 'Februar',
94         3: 'Maerz',
95         4: 'April',
96         5: 'Mai',
97         6: 'Juni',
98         7: 'Juli',
99         8: 'August',
100         9: 'September',
101         10: 'Oktober',
102         11: 'November',
103         12: 'Dezember'
104      }[monat]
105         
106 # Programmstart
107 jahr = 2018
108 print("Jahr: ", jahr)
109 Osterdatum(jahr)
110 m = 1
111 
112 while m != 13:
113     d = 1
114     
115     
116     print(Monat(m))
117     print("Mo Di Mi Do Fr Sa So")
118     
119     sys.stdout.write((wochentag(jahr, m, 1)-1)*'*  ') #3 Zeichen Bsp "Mo*Di*..."
120     while d <= anzahl(jahr, m):
121         if wochentag(jahr, m, d) == 7 and d < 10:
122             sys.stdout.write( str(d)+ "  " + "\n")
123         elif wochentag(jahr, m, d) != 7 and d < 10:
124             sys.stdout.write(str(d)+ "  ")
125         elif wochentag(jahr, m, d) == 7 and d > 9:
126             sys.stdout.write(str(d)+ " " "\n")
127         elif wochentag(jahr, m, d) != 7 and d > 9:
128             sys.stdout.write(str(d)+ " ")
129         
130         d = d + 1
131     sys.stdout.write("\n\n")
132     m = m + 1
133     
134     #sys.stdout.write() statt print ohne Zeilenumbruch
135 
136 
137 
138 
139     
140     