import { SET_LOADING, RESET_LOADING } from '../actions/loadingActions';

const initState = false; //1)초기값은 대대부분 false로 정의되므로 초깃값을 따로 정의한다.

export default function reducer(state = initState, action){ //초기값을 리듀서의 기본값으로 전달한다.
    const { type, payload} = action;
    switch(type){
        case 'SET_LOADING' : {
            return payload; //전달받은 loading을 반환한다.
        }
        case 'RESET_LOADING' : {
            return initState; //1)에서 정의한 초깃값을 반환한다.
        }
        default : 
            return state; 
    }
};


//리듀서(또는 액션)도 마찬가지로 데이터의 종류에 맞게 분리하는 것이 코드를 효율적으로 관리할 수 있다.


