### 문자열을 16비트 코드 단위의 시퀀스로 간주하라. 

---

어디에서나 사용할 수 있는 문자열임에도 불구하고 대부분의 프로그래머는 유니코드에 대해 배우려고 하지 않고 최고이긴 하지만 좀 복잡하다고 생각한다. 

하지만 개념적인 단계로 유니코드를 배우는 데는 전혀 걱정할 필요가 없다. 유니코드의 기본은 정말 간단하다.

유니코드는 0부터 1,114,111 까지의 유일한 정수 값, 즉 코드 포인트에 셍상의 모든 글자 체계의 모든 문자 단위를 할당한 것이다. 



다만, ASCII는 각 인덱스가 유일한 바이너리 표현에 매핑되고, 유니코드는 코드 포인트에 서로 다른 여러 개의 바이너리 인코딩을 허용한다는 점이 다르다.

서로 다른 인코딩들은 문자열을 저장하기 위한 저장공간과 문자열을 인덱싱하는 등의 실행 속도에 트레이드오프 관계를 가진다. 





기억할점
- 자바스크립트 문자열은 유니코드 코드 포인트가 아니라 16비트 코드 유닛으로 구성된다.
- 자바스크립트에서 유니코드 포인트 2^16 이상은 대리 쌍이라고 알려진 두 개의 코드 유닛으로 표현된다.
- 대리 쌍은 문자열 요소의 개수를 반환하고, length, charAt, charCodeAt, 메서드와 "." 같은 정규 표현식 패턴에 영향을 미친다.
- 코드 포인트를 다루는 문자열 조작을 하기 위해서는 서드파티 라이브러리를 사용하라. 
- 문자열을 처리하는 라이브러리를 사용할 때 코드 포인트의 전체 범위를 어떻게 처리하는지 해당 라이브러리의 문서를 찾아봐야 한다.
