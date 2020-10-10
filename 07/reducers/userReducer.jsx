export default function reducer(state ={}, action){
    const { type, payload} = action;
    switch(type){
        case 'SET_USER' :{
            return {
                ...state,
                ...payload,
            };
        }
        default :
        return state; 
    }
}


//user 관련 리듀서 분리하기
