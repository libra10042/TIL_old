//객체 배열 형태의 자료를 스토어에 저장하도록 앱 수정하기
export const SET_COLLECTION = 'collection/SET_COLLECTION';

export const setCollection = collection => ({
    type: SET_COLLECTION, 
    payload : collection, 
})