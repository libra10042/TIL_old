# 캐스팅
# 문자열 => 리스트
# 문자열변수.split() : 공백을 기준으로 해서 리스트화
# 문자열변수.split(구분문자) : 구분문자를 기준으로 해서 리스트화
# list(문자열변수)
# : 공백도 모두 리스트화. 낱글자가 아이템 요소로 변경.

sampleTxt1 = '사과 포도 수박 딸기'
sampleTxt2 = '사과, 포도, 수박, 딸기'
print(f'samleTxt1 = {sampleTxt1}')
print(f'sampleTxt1의 데이타형은? {type(sampleTxt1)}')
# print(f'sampleTxt2 = {sampleTxt2}')
'''
samleTxt1 = 사과 포도 수박 딸기
sampleTxt1의 데이타형은? <class 'str'>
'''

sampleTxt1List = sampleTxt1.split()
print(f'sampleTxtList = {sampleTxt1List}')
print(f'sampleTxtList의 데이타형은? {type(sampleTxt1List)}')
print(sampleTxt1List)
'''
sampleTxtList = ['사과', '포도', '수박', '딸기']
sampleTxtList의 데이타형은? <class 'list'>
['사과', '포도', '수박', '딸기']
'''


sampleTxt1List = list(sampleTxt1)
print(f'sampleTxtList의 데이타형은? {type(sampleTxt1List)}')
print(sampleTxt1List)
'''
sampleTxtList의 데이타형은? <class 'list'>
['사', '과', ' ', '포', '도', ' ', '수', '박', ' ', '딸', '기']
'''


sampleTxt1List2 = list(sampleTxt1)
print(f'sampleTxt1List2 = {sampleTxt1List2}')
print(f'sampleTxt1List2의 데이타형은? {type(sampleTxt1List2)}')
print(f'sampleTxt2 = {sampleTxt2}')
sampleTxt1List2 = sampleTxt2.split(',')
print(f'sampleTxt2List = {sampleTxt1List2}')



print('-'*30)

# 리스트 -> 문자열
# str(리스트이름)
# : [], 쉼표(,)도 포함해서 모두 문자열화
# '구분자'.join(리스트이름)
# : 구분자가 아이템요소 사이에 모두 추가된 후 문자열화
jobList = ['파이썬', 'DB', '플라스크']
print(f'jobList = {jobList}')
result1 = str(jobList)
result2 = '/'.join(jobList)         #join이 더 깔끔해서 더 많이 사용한다.
print(f'result1 = {result1}')
print(f'result1의 데이터형은? = {type(result1)}')
print(f'result2 = {result2}')
print(f'result2의 데이터형은? = {type(result2)}')
'''
jobList = ['파이썬', 'DB', '플라스크']
result1 = ['파이썬', 'DB', '플라스크']
result1의 데이터형은? = <class 'str'>
result2 = 파이썬/DB/플라스크
result2의 데이터형은? = <class 'str'>
'''

# 중첩 리스트 구조
# 리스트안에 리스트가 있다.
# 중첩리스트의 인덱싱은?
# 리스트 이름[index1][index2]
# 초기값으로 중첩 리스트 생성.
# 리스트변수 = [[값1, 값2...], [값1, 값2...]]
listMulti1 = [1,2, ['a','b','c'],['포도','수박']]
print(f'listMulti1 = {listMulti1}')
print(f'listMulti1[0] = {listMulti1[0]}')
print(f'listMulti[2] = {listMulti1[2]}')
print(f'listMulti1[2][0] = {listMulti1[2][0]}')
print(f'listMulti1[3][-1] = {listMulti1[3][-1]}')
'''
listMulti1 = [1, 2, ['a', 'b', 'c'], ['포도', '수박']]
listMulti1[0] = 1
listMulti[2] = ['a', 'b', 'c']
listMulti1[2][0] = a
listMulti1[3][-1] = 수박
'''



# 중첩리스트 구조
# 1차원 리스트 정의 후 1차원 리스트를 다시 리스트로 구성.
userName= ['홍길동', '박지민', '이미연']
userAge = [20, 25, 34]
userGender = ['남', '남', '여']
userAddr = [userName, userAge, userGender]
print(f' userName = {userName}')
print(f' userAge = {userAge}')
print(f' userGender = {userGender}')
print(f' userAddr ={userAddr}')
print(f' userAddr[2][1] = {userAddr[2][1]}')
print(f' userAddr[-1][-1] = {userAddr[-1][-1]}')
'''
 userName = ['홍길동', '박지민', '이미연']
 userAge = [20, 25, 34]
 userGender = ['남', '남', '여']
 userAddr =[['홍길동', '박지민', '이미연'], [20, 25, 34], ['남', '남', '여']]
 userAddr[2][1] = 남
 userAddr[-1][-1] = 여
 '''



#퀴즈 :

'''
아래의 리스트를 이용하여 grade 리스트를 생성하고 합계와 평균을 과목별로 출력한다. 
평균은 소숫점 2번째 자리까지 출력한다. 

kor = [100, 80, 85]
math = [55, 70, 35]
eng = [80, 80, 100]
python = [90, 70, 88]
---------
result 
kor : 합계 =?, 평균 = ?
math : 합계 =?, 평균 =?
eng : 합계 =?, 평균 =?
python : 합계 =?, 평균 =?
'''

kor = [100, 80, 85]
math = [55, 70, 35]
eng = [80, 80, 100]
python = [90, 70, 88]
# print(f'result\n')
# print(f' kor : 합계 ={kor[0]+kor[1]+kor[2]}, 평균 = {(kor[0]+kor[1]+kor[2])/3}')
# print(f' mat : 합계 ={math[0]+math[1]+math[2]}, 평균 = {(math[0]+math[1]+math[2])/3}')
# print(f' eng : 합계 ={eng[0]+eng[1]+eng[2]}, 평균 = {(eng[0]+eng[1]+eng[2])/3}')
# print(f' python : 합계 ={python[0]+python[1]+python[2]}, 평균 = {(python[0]+python[1]+python[2])/3}')
#
grade = [kor, math, eng, python]

