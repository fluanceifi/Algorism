def ovenTimer(h, m, s, getSec):
    getHour = getSec // 3600
    getSec %= 3600
    getMinute = getSec // 60
    getSecond = getSec % 60
       
    sec = s + getSecond
    if sec >= 60:
        m += sec // 60
        sec %= 60
    min = m + getMinute
    if min >= 60:
        h += min // 60
        min %= 60 
    hour = h + getHour
    if hour >= 24:
        hour %= 24
    
    print(f"{hour} {min} {sec}")
    
    return 
    
    
hour, minute, second = map(int,input().split())
input_Seconds = int(input())
ovenTimer(hour, minute, second, input_Seconds)
