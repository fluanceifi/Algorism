def problem2675(n):
    result = []
    for _ in range(n):
        a = input()
        idx = a.index(" ")
        num = int(a[:idx])
        ary = a[idx+1:]
        output = ""
        for i in ary:
            output += num * i
        result.append(output)
    return result    
    
seperateAry = problem2675(int(input()))

for out in seperateAry:
    print(out)