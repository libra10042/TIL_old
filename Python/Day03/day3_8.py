
# p146~148 연습문제 풀기
# day3/Quiz3-1.py
# day3/Quiz3-2.py


# a = "List is too short, you need python"
#
# if "wife" in a: print("wife")
# elif "python" in a and "you" not in a: print("python")
# elif "shirt" not in a: print("shirt")
# elif "need" in a: print("need")
# else: print("none")
#




# i = 0
# while True:
#     i += 1
#     if i>5:
#         break
#     print('*' * i)


A = [70, 60, 55, 75, 95, 90, 80, 80, 85, 100]
total = 0
for score in A:
    total += score
average = total/10
print(average)


numbers = [1, 2, 3, 4, 5]

result = []
for n in numbers:
    if n % 2 ==1:
        result.append(n*2)

numbers = [1, 2, 3, 4, 5]
result = [n*2 for n in numbers if n%2 ==1]
print(result)