def FiveisGod(num):
    sum = 0
    for _ in range(5):
        sum += (num % 10) ** 5
        num //= 10
    return sum
        
    

print(FiveisGod(int(input())))
