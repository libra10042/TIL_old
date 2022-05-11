# 자료형의 각 요소 값을 순차적으로 출력
# for 인덱스변수 in 리스트, 문자열, 튜플:
#   명령문

# 리스트 생성하고 아이템을 출력하여라.
myList = ['구로동', '신림동', '서초동', '역삼동']

for i in myList:
    print(f'** {i} **', end=' /')
    
print(' ')
# 문자열을 한줄에 한글자씩 출력하여라.
myText = '가나다라마바사'
for i in myText:
    print(f'**{i}**')



# 사선으로 출력하기
cnt = 1
for i in myText:
    print('\t'*cnt,i)
    cnt +=1


# 퀴즈 : 다음 리스트에서 평균, 합, 최대값, 최소값 출력하기
numList = [95, 77, 56, 100, 85]
count = 0
target = numList[0]
for i in numList:
    count += i
    if target >i:
        target = i


print(f'최대값은 : {target}')
print('평균은 %.2f' %(count/5) )
print('합은 %d' %(count))

print('-'*40)



# for를 이용한 딕셔너리 요소 출력. 
# for 키변수 in 딕셔너리:
#   명령문
myDict = {1:'일', 100:'백', 50:'오십', 1000:'천'}
for key in myDict:
    print(key, '=>',myDict[key])




# 다중 리스트와 for
# 2차원 리스트의 갯수가 같아야 한다.
# for(i, j...) in 다중리스트:
#   명령어

listMulti1 = [[1,2], ['a','b'],['홍길동', '춘향이']]

print(listMulti1[0]) # [1, 2]
print(listMulti1[0][0]) # 1
print(listMulti1[1][1]) # b

print('-'*30)
for(i, j) in listMulti1:
    #각 행별로 출력
    print(i, end=' ' )
    print(j, end=' ')



listMulti2 = [[1,2,3],['a','b','c'],['홍길동','춘향이','이몽룡']]
# listMulti2 = [[1,2,3],['a','b','c'],['홍길동','춘향이']] 이몽룡이 빠지면 value에러가 발생한다.
for(i, j, k) in listMulti2:
    print(f'i ={i}, j={j}, k={k}')



# 퀴즈 : 학생이름, 국어, 영어, 수학으로 구성된
# 2차원 리스트를 생성한다.
# 출력형식은 아래와 같이 한다.
'''
학생이름   국어   영어  수학  합계  평균
김태희     30     40  100    ?    ?
'''
stGradeList = [['김태희', 30, 50, 55],
               ['신민아', 50, 90, 80],
               ['박지민', 50, 90, 40],
               ['김소희', 60, 50, 56],
               ['윤준희', 90, 88, 66]]

print('　　학생이름  　　　　　국어  　　　영어　　　 수학 　　합계 　평균')
for(n, k, e, m) in stGradeList:
    tot = k + e + m
    avg = tot /3
    print('     %s          %d        %d       %d     %d   %.2f' % (n, k, e, m, tot, avg))


