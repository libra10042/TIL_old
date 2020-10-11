//스토어 설정 파일
// 여러 개의 리듀서는 combineReducers() 함수로 묶어 createStore() 함수의 인자로 전달하면 된다.
import { createStore, combineReducers } from 'redux';
import { composeWithDevTools} from 'redux-devtools-extension';
import  reducers from './reducers';

export default initStates => createStore(
    combineReducers(reducers),
    initStates,
    composeWithDevTools(),
);

