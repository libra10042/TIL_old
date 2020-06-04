# 문자열 함수 p67
# 문자열변수.함수명(옵션)
# 문자열.함수명(옵션)

# 샘플 문자열 만들기
# http://www.lipsum.com   #문자열 긁어다가 사용하는 용도.(편집 디자인)
sampleTxt = '''
It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.
 The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, 
as opposed to using 'Content here, content here', making it look like readable English. 
 Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text,
and a search for 'lorem ipsum' will uncover many web sites still in their infancy. 
 Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).

'''
print('전체 문자열 출력 \n', sampleTxt)
print('-'*30)

# 특정 문자열의 갯수 출력
# 문자열변수.count(찾고자하는문자열)
print('a의 갯수 : ', sampleTxt.count('a'))
print('the의 갯수 :', sampleTxt.count('the'))


# 특정 문자열의 시작인텍스 위치 반환
# 문자열변수.find(찾고자하는 문자열)
# 찾고자 하는 문자열이 없다면 -1 반환
# 문자열변수.index(찾고자하는 문자열)
# 찾고자 하는 문자열이 없다는 에러 발생
print('f의 시작위치 =', sampleTxt.find('f'))
print('f의 시작위치 =', sampleTxt.index('f'))
print('가의 시작위치 =', sampleTxt.find('가'))
# print('가의 시작위치 =', sampleTxt.index('가'))
# ValueError  ... 찾고자하는 값이 없을 때 발생하는 에러

print('-'*30)

# 대소문자 변환하여 반환
# 문자열변수.upper(), 문자열변수.lower()
print(sampleTxt.upper())
print(sampleTxt.lower())
print('!'*30)


# 문자열 교체하기
# 문자열변수.replace(찾고자하는 문자열, 교체문)
# is => was
result = sampleTxt.replace('is', 'was')
print(result)
print('was의 갯수? ', result.count('was'))
print('&'*30)

# '연결문자' .join(문자열변수)
myWord = 'python'
print('*'.join(myWord))
'''
p*y*t*h*o*n
'''



# 좌우공백 제거하기
# 문자열변수.strip()
# 문자열변수.rstrip()
# 문자열변수.ltrip()
myWord2 = '      Python       '
print('*', myWord2, '*')
print('*', myWord2.strip(), '*')
print('*', myWord2.rstrip(), '*')
print('*', myWord2.lstrip(), '*')
'''
*       Python        *
* Python *
*       Python *
* Python        *
'''

print('#'*30)