import calendar
c = calendar.TextCalendar()
m = 1
y = input('year=')
while m != 13:
   str = c.formatmonth(y,m)
   m = m + 1
   print (str)
