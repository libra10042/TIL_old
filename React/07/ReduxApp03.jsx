import React, { PureComponent} from 'react';
import { Provider} from 'react-redux';
import { createState, createStore} from 'redux';

const reducer = (state, action) =>{
    const { type, payload } = action; //구조 분해 할당으로 { type, payload } 를 분해했다.
    switch(type){ //switch 문으로 맞는 리듀스 작업을 시행했다.
        case 'SET_LOADING' : { //type이 RESET_LOADING 인 경우 스토어 데이터의 loading 값을 무조건 false로 변경했다.
            return {    
                ...state, loading : false
            };
        }
        case 'SET_USER' : { //type이 SET_USER인 경우 payload의 값으로 user의 값을 변경한다.
            return{
                ...state, 
                user : payload,
            }
        
        }
        default :
        return state;
    }
};


class ReduxApp extends PureComponent{
    store = createStore(
        reducer, 
        { loading: false, name: '두잇 리액트'},
        window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
    );



    componentDidMount(){
        this.store.dispatch({   //RESET_LOADING에 해당하는 액션을 호출한다.
            type : 'SET_LOADING'
            
        });
        this.store.dispatch({ //SET_USER에 해당하는 액션을 payload와 함께 호출한다.
            type: 'SET_USER', 
            payload : {name : 'Park', age: 20},
        });
    }
    render(){
        return(
            <Provider store={this.store}>리덕스 예제</Provider>


        )
    }
}

export default ReduxApp; 