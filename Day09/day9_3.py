# 교재 p291 참조
# 정규표현식 (Regular Expression)
# 유효성 검사
# 특정 문자열이 특정 조건(패턴)에 맞는지 검사

# 파이썬에서 정규표현식 모듈 => re (내장모듈)
import re

# re 객체의 속성과 메소드 확인
print(dir(re))
for i in dir(re):
    print(i)

# ---------------------------------------
# 방식1
# 패턴변수 = re.compile(패턴식)
# 패턴변수.정규표현식메소드(문자열)

# 정규표현식메소드
# match(문자열) : 문자열 처음부터 검색 => 문자열 / None
# search(문자열) : 문자열 전체 검색 => 문자열 / None
# findall(문자열) : 정규식과 매치되는 문자열을 리스트로 반환
# => 리스트 / []
# finditer(문자열)
# : 정규식과 매치되는 문자열을 반복가능한 객체로 반환
# => 반복가능한객체. for문으로 개별 결과 확인
print('-'*100)
patten1 = re.compile('^ab')
print(patten1.findall('above')) # ['ab']
print(patten1.findall('word')) # []
print(patten1.search('above'))
# <re.Match object; span=(0, 2), match='ab'>
print(patten1.search('word')) # None
print(patten1.finditer('above'))
print(patten1.finditer('word'))
# <callable_iterator object at 0x02E12FA0>
obj1 = patten1.finditer('above')
obj2 = patten1.finditer('word')
for i in obj1:
    print(i)
# <re.Match object; span=(0, 2), match='ab'>
for i in obj2:
    print(i)
# ---------------------------------------
# 방식2
# 문자열변수 = 문자열값
# re.정규표현식메소드(패턴식, 문자열변수)
# re.match(패턴식, 문자열변수) => 문자열
# re.search(패턴식, 문자열변수) => 문자열
# re.findall(패턴식, 문자열변수) => 리스트
# re.finditer(패턴식, 문자열변수) => 반복가능객체

# 정규표현식 패턴 - 대문자, 소문자, 숫자, 한글
# [문자클래스스타일]  => 한글씩
# [문자클래스스타일]+ => 단어단위
# [a-z] : 영어소문자
# [A-Z] : 영어대문자
# [0-9] : 숫자
# [가-힣] : 한글

txt1 = "가나다 009 python ?### 7834 파이썬 java WORD 784 ENGLISH"
print(re.findall('[가-힣]', txt1))
print(re.findall('[가-힣]+', txt1))
print(re.findall('[a-z]', txt1))
print(re.findall('[A-Z]+', txt1))
print(re.findall('[0-9]+', txt1))
print(re.findall('[a-zA-Z]+', txt1))
# ['가', '나', '다', '파', '이', '썬']
# ['가나다', '파이썬']
# ['p', 'y', 't', 'h', 'o', 'n', 'j', 'a', 'v', 'a']
# ['WORD', 'ENGLISH']
# ['009', '7834', '784']
# ['python', 'java', 'WORD', 'ENGLISH']
print(re.finditer('[a-zA-Z]+', txt1))
for i in re.finditer('[a-zA-Z]+', txt1):
    print(i)
    print(i.group()) # match 문자열
    print(i.span()) # match 문자열의 시작과 끝 인덱스
    print(i.start()) # match 문자열의 시작 인덱스
    print(i.end()) # match 문자열의 끝 인덱스
    print('-'*5)
# <re.Match object; span=(8, 14), match='python'>
# <re.Match object; span=(29, 33), match='java'>
# <re.Match object; span=(34, 38), match='WORD'>
# <re.Match object; span=(43, 50), match='ENGLISH'>

# Match object 메서드
# group() : 매치된 문자열을 리턴한다.
# start() : 매치된 문자열의 시작 위치를 돌려준다.
# end() : 매치된 문자열의 끝 위치를 돌려준다.
# span() : 매치된 문자열의 시작,끝 위치를 튜플 형태로 돌려준다.


# -----------------------------------------------
# 정규표현식 패턴 - 대문자, 소문자, 숫자 : \지원문자
# [\d] : 10진수, [0-9]와같음
# [\D]: 10진수외 [^0-9]
# [\s] :공백문자, [ \t\n\r\f\v]
# [\S]: 공백 문자 외, [ \t\n\r\f\v]
# [\w] : 영문자숫자 , [a-zA-Z0-9]
# [\W]: 영문자숫자외 , [^a-zA-Z0-9]

txt2 = '''
            가나다 $ 009 python ?#
            7834 파이썬 java WORD _+
            784 ENGLISH'''
print(re.findall('[\d]', txt2))
print(re.findall('[\d]+', txt2))
# ['0', '0', '9', '7', '8', '3', '4', '7', '8', '4']
# ['009', '7834', '784']
print(re.findall('[\s]', txt2))
print(re.findall('[\S]+', txt2))
['\n', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\n', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\n', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ']
['가나다', '$', '009', 'python', '?#', '7834', '파이썬', 'java', 'WORD', '_+', '784', 'ENGLISH']

print(re.findall('[\w]+', txt2))
print(re.findall('[\W]+', txt2))
# ['가나다', '009', 'python', '7834', '파이썬', 'java', 'WORD', '_', '784', 'ENGLISH']
# ['\n            ', ' $ ', ' ', ' ?#\n            ', ' ', ' ', ' ', ' ', '+\n            ', ' ']
# -----------------------------------------------
# 비밀번호 유효성 검사
# 비밀번호 조건
# 전체길이는 6~12
# 영어대소문자|숫자

# checkPwd('abcd') => 비밀번호 길이가 적당하지 않다.
# checkPwd('abcd+가나다') => 영어대소문자와 숫자만가능

def checkPwd(pwd):
    pattern = re.compile('[a-zA-Z0-9]+')
    # print(pattern.findall(pwd))
    # print(pattern.match(pwd))
    # print(pattern.match(pwd).group())
    # print(pattern.search(pwd))
    # print(pattern.search(pwd).group())
    # 전체길이 체크
    if len(pwd)<6 or len(pwd)>12:
        print('비밀번호 길이가 적당하지 않다.')
        # return False
        return '비밀번호 길이가 적당하지 않다.'
    # 대소문자숫자 체크
    elif pwd == pattern.match(pwd).group():
         return '비밀번호 완료'
         # return True
    else:
        return '영어대소문자와 숫자만가능'
        # return False


print(checkPwd('abcd'))
# 비밀번호 길이가 적당하지 않다.
# False
print(checkPwd('abcd+가나다 ggg')) # 영어대소문자와 숫자만가능
print(checkPwd('abc123gogo')) # True

# -----------------------------------------------
# 자릿수 지정 패턴 {}
# [문자열]{n} n번 반복됨
# {n,} n번 이상 반복됨
# {n, m} 최소 n번 이상 최대 m 번 이하로 반복됨
# x* : 문자열X가 0번이상 반복

str = "abc 00ab 000abcd 00000abcd 012340abcd"
print(re.findall('[0]{2}[a-bA-B]+', str))
print(re.findall('[0]{2,}[a-bA-B]+', str))
print(re.findall('[0]{0,3}[a-bA-B]+', str))
# ['00ab', '00ab', '00ab']
# ['00ab', '000ab', '00000ab']
# ['ab', '00ab', '000ab', '000ab', '0ab']

# -----------------------------------------------
# 정규표현식 메타문자
# | : OR 또는
# +:바로 앞의 문자가 하나 이상 있음
# ^:문자열의 처음을 나타냄
# $:문자열의 끝
# . :임의의 문자가 와도 됨
# *:바로 앞의 문자가 없거나 하나 이상 있음
# ?:앞의 문자가 없거나 하나임
# 휴대폰번호 유효성검사
# 숫자3자리-숫자4자리-숫자4자리

txt2 = '''010-7777-1234 00-6785-가나다 
        011-5678-8989 01156788989
        333-123 abc-9990-0000 554-8488-7878 
        045-5678-4567 016-8888-9090
        017-7785-7775'''

# 숫자3자리-숫자4자리-숫자4자리
print(re.findall('[0-9]{3}-[0-9]{4}-[0-9]{4}', txt2))

# 숫자3자리(010/011/016/017)-숫자4자리-숫자4자리
print(re.findall('01[0|1|6|7]-[0-9]{4}-[0-9]{4}', txt2))
'''
['010-7777-1234', '011-5678-8989', '554-8488-7878', '045-5678-4567', '016-8888-9090', '017-7785-7775']
['010-7777-1234', '011-5678-8989', '016-8888-9090', '017-7785-7775']
'''

# 입력받은 번호가 모바일폰형식이면 메세지 출력

userPhone = input('핸드폰 번호를 입력해주세요. '
                  '\n(예:000-0000-0000)\n')
mobilePattern = '01[0|1|6|7]-[0-9]{4}-[0-9]{4}'
# print(re.search(mobilePattern, userPhone))
obj = re.search(mobilePattern, userPhone)
if obj != None:
    print(obj.group())
else:
    print('모바일폰 번호 양식이 아니다.')

# 퀴즈 : 리스트에서 주민등록번호 양식에 맞는 데이타를 출력하여라
# 주민등록번호 패턴
# 6자리숫자-[1|2|3|4]6자리숫자
quizList = [ '020-28261', '564873-3300998',
'가나다-3300998', '564873-8800998',
'123456-1234567', 'abc456-1234567']

juminPattern = '[0-9]{6}-[1|2|3|4][0-9]{6}'
print('-'*20)
for i in quizList:
    # print(i)
    result = re.match(juminPattern, i)
    if result != None:
        print(result.group())

# 564873-3300998
# 123456-1234567
# -----------------------------------------------
# 그룹핑이용
# 정규표현식의 패턴을 그룹화 : group(index)
juminPattern = '([0-9]{6})-([1|2|3|4][0-9]{6})'
result = re.match(juminPattern, '123456-1234567')
print(result)
print(result.group())
print(result.group(1))
print(result.group(2))
# <re.Match object; span=(0, 14), match='123456-1234567'>
# 123456-1234567
# 123456
# 1234567

# 퀴즈 : 주민번호데이타에서 주민번호뒷자리는 '*******' 마킹하기
quizList2 = [ '123456-1234567', '883456-3234567',
               '가나다-3300998', '6666653423-3300998'
               '673456-3234567', '903156-3234567']

juminPattern2 = '([0-9]{6})-([1|2|3|4][0-9]{6})'
print('-'*20)
for i in quizList2:
    result = re.match(juminPattern2, i)
    if result != None:
        print(result.group(1),' - ', '*******' )



# -----------------------------------------------
# 정규표현식 컴파일 옵션
# re.compile(정규표현식, re.컴파일옵션)
# S : dotall 줄바꿈문자 포함
# I : ignorecase  대소문자 관계없이 매치
# M : multiline 여러줄과 매치한다
# v : verbose 모드 이용. 여러줄 정규식과 주석 사용 가능






