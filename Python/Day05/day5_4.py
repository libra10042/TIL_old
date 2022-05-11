# 파일 쓰기
# 새로운 파일이 생성되면서 내용이 추가된다.
# 기존에 파일이 있다면 덮어쓰기된다.
# 파일변수 = open( 생성파일 경로, 'w', encoding = 'cp949/utf-8')
# 파일변수.write(문자열)
# 파일변수.close()

# # 빈파일 만들기
f = open('c:/pyclass/Day05/test1.txt', 'w', encoding = 'utf-8')
print(' 파일이 생성되었습니다.')
f.close()
# # test1.txt 파일이 생성되었는지 탐색기에서 확인.
print('-'*50)

# 파일 생성후 내용 추가하기
f = open('c:/pyclass/Day05/test1.txt', 'w')
print('파일이 생성되었습니다.')
f.write('1'*100)
f.write('\n 테스트 중입니다.\n')
f.write('-'*10)
# 10줄 추가하기
for i in range(1,11):
    f.write('\n %d 번째 줄입니다.' % (i))
f.close()


# 리스트요소를 정의한 후
# 리스트요소를 파일에 행단위로 저장한다.
myFoodList = ['라면', '김치전', '모밀', '초밥', '샐러드']
line = open('c:/pyclass/Day05/test1.txt','w')
line.write('\n음식메뉴\n')
for i in myFoodList:
    print(i)
    data = i+'\n' # 개행문자 \n삽입
    line.write(data)
    print('내용이 추가되었습니다.')
line.close()

print('-'*50)
#----------------------------
# 파일1의 특정 부분을 파일2에 저장하기
# Yesterday.txt 파일에서 5줄만 추출해서
# resultYesterday.txt파일에 저장하기
# 파일변수1 = open(읽을파일경로, 'r')
# 리스트변수 = f.readlines()
# 파일변수2 = open(저장할파일경로, 'w')
# for i in ?:
#   파일변수2.write(i)
# 파일변수1.close()
# 파일변수2.close()
f1 = open('c:/pyclass/Day05/yesterday.txt','r', encoding ='utf-8')
f2 = open('c:/pyclass/Day05/resultYesterday.txt','w', encoding='utf-8')
resultList = f1.readlines() #리스트에 저장
cnt = 0
for i in resultList[0:5]:
    dataLine = str(cnt) + '행 => ' + i + '\n' #개행문자 삽입
    cnt += 1
    f2.write(dataLine)
    print('내용이 추가 되었습니다.')
f1.close()
f2.close()

print('*'* 30)


#-------------------
# 내용추가하기
# 기존 파일에 내용이 추가된다.
# 파일변수 = open( 생성파일경로, 'a', 'encoding ='cp949/utf-8')
# 파일변수.write(문자열)
# 파일변수.close()

f = open('c:/pyclass/Day05/test1.txt', 'a')
f.write('\n\n 내용 추가 테스트')
print('새로운 내용이 추가되었습니다.')
f.close()


print('-'*30)

#-------------------
# with 문과 파일 입출력
# 파일.close() 를 사용할 필요가 없다. 
# with open(파일경로, 'a'/'w'/'r', encoding='uft-8/cp949')
#   as 파일변수 : 
#       명령문


# with 문으로 파일 읽기
with open('c:/pyclass/Day05/yesterday.txt', 'r') as f :
    result = f.read()
    print(result[:10])

print('\n\n 파일 읽기 테스트 완료 \n\n')
# with문을 이용한 파일쓰기
with open('c:/pyclass/Day05/test2.txt', 'w') as f:
    f.write('파일 쓰기 테스트 \n' *10)
print('\n\n파일 쓰기 테스트 완료 \n\n')

# with문을 이용한 내용 추가
with open('c:/pyclass/Day05/test2.txt', 'a') as f:
    f.write('내용 추가 테스트\n' *3)

print('\n\n 내용 추가 테스트 완료 \n\n')



# Delete 구현 1
# 파일변수.write() => 파일은 존재하고 안에 내용은 삭제
# Delete 구현 2 => 파일 삭제
'''
import os 
os.remove(삭제파일경로)
'''
with open('c:/pyclass/Day05/remove.txt', 'w') as f :
    f.write(' ')
print('\n\n remove.txt 파일 생성 완료 \n\n')
import os
ans = input('remove.txt 파일 삭제(y)? ...').strip()
print(ans)
if ans == 'y':
    os.remove('c:/pyclass/Day05/remove.txt')
    print('파일이 삭제되었습니다.')


