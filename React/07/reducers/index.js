//리듀서 묶어주기
//리듀서가 하나처럼 동작하려면 reducer 폴더에 index.js 파일을 추가해야 한다.

import loading from './loadingReducer';
import user from './userReducer';
import collection from './collectionReducer02';
import searchFilter from './searchFilterReducer';
export default {
    collection,
    loading,
    user, 
    searchFilter,
}


