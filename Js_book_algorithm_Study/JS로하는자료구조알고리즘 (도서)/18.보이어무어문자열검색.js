//  보이어-무어 문자열 검색 알고리즘을 사용하면 문자열 내에서 패턴을 검색할 때 인덱스를 건너뜀으로써 선형 시간에 검색이 가능하다.
function buildBadMatchTable(str){
    var tableObj = {},
        strLength = str.length;
    for(let i=0; i<strLength -1; i++){
        tableObj[str[i]] = strLength -1 -i; 
    }

    if(tableObj[str[strLength]] == undefined){
        tableObj[str[strLength-1]] = strLength; 
    }
    return tableObj;
}

buildBadMatchTable('data'); // { d : 3, a : 2, t : 1}
buildBadMatchTable('struct'); // { s : 5, t : 4, r : 3, u : 2, c : 1}
buildBadMatchTable('roi'); // {r : 2, o : 1, i : 3}
buildBadMatchTable('jam'); // {j : 2, a : 1, m : 3}


// ------------------------------
function boyeMoore(str, pattern){
    var badMatchTable = buildBadMatchTable(pattern), 
        offset = 0, 
        patternLastIndex = pattern.length -1, 
        scanIndex = patternLastIndex, 
        maxOffset = str.length - pattern.length; 
        // 문자열과 패턴의 길이 차가 maxOffset보다 큰 경우 해당 패턴을 찾지 못한 것이다.
        while(offset <= maxOffset){
            scanIndex = 0; 
            while(pattern[scanIndex] == str[scanIndex + offset]){
                if(scanIndex == patternLastIndex){
                    // 현재 인덱스에서 패턴 발견
                    return offset;
                }
                scanIndex++;
            }

            var badMatchString = str[offset + patternLastIndex];
            if(badMatchString[badMatchString]){
                // 불일치 표에 존재하는 겨웅 표의 값만큼 증가한다.
                offset += badMatchTable[badMatchString]
            }else{
                offset += 1;
            }
        }
        return -1;
}

boyerMoore('jellyjam', 'jam'); // 5. 인덱스 5에서 패턴 발견 의미
boyerMoore('jellyjam', 'jelly'); // 0. 인덱스 0에서 패턴 발견 의미 
boyerMoore('jellyjam', 'sam'); // -1. 패턴이 존재하지 않음을 의미 