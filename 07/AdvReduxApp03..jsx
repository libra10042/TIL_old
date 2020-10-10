import React, { PureComponent} from 'raect';
import {Provider } from 'react-redux';
import configureStore from './configureStore';
import { setCollection } from './actions/collectionActions01';

class AdvReduxApp extends PureComponent{
    store = configuration({ loading : false});

    componentDisMount(){
        this.store.dispatch(
            setCollection([
                {id : 1, name: 'Jon', age: 20},
                {id : 2, name:' Park', age : 35},
            ]),
        );
    }


    redner(){
        return <Provider store={this.store}>리덕스 예제</Provider>;
    }
}


export default AdvReduxApp; 
