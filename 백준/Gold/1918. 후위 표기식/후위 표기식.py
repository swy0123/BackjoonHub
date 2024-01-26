import sys

def solution(string):
    stack = []
    answer = []

    for i in string:
        # print(answer, '   ', stack)
        if i in ('*', '/', '+', '-', '(', ')'):
            if i == ')' and stack:
                while stack:
                    j = stack.pop()
                    if j == '(': break
                    answer.append(j)
            elif (i == '+' or i == '-') and len(stack)>0:
                if stack[-1] != '(':
                    while stack:
                        if stack[-1] == '(': break
                        answer.append(stack.pop())
                    stack.append(i)
                else: stack.append(i)
            elif (i == '/' or i == '*') and len(stack)>0:
                if stack[-1] != '(':
                    if stack[-1] == '/' or stack[-1] == '*':
                        answer.append(stack.pop())
                stack.append(i)
            else: stack.append(i)
        else:
            answer.append(i)
    while stack:
        answer.append(stack.pop())
    
    return str(''.join(answer))

input = sys.stdin.readline().strip()

print(solution(input))