def swapping(n):
    for i in range(n):
        ary = list(input().rstrip().split())
        print(f"Case #{i+1}: {' '.join(ary[::-1])}")  
        
    
swapping(int(input()))