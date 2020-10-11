import React, { PureComponent} from 'raect';
import {Provider } from 'react-redux';
import configureStore from './configureStore';
import { setCollection } from './actions/collectionActions01';
import PresentationComponent from './PresentationComponent';
import ContainerComponent from './containers/ContainerComponent';
import DispatchContainer01 from './containers/DispatchContainer01';


class AdvReduxApp extends PureComponent{
    store = configuration({ loading : false});

    componentDisMount(){
        this.store.dispatch(
            setCollection([
                {id : 1, name: 'Jon', age: 20},
                {id : 2, name:' Park', age : 35},
            ]),
        );
        this.store.dispatch(setAge(2, 55));
        const { collection} = this.store.getState();
        const { ids, entities } = collection;
        const originalPayload = ids.map(id => entites[id]);
        console.log(originalPayload);
    }




    redner(){
        return <Provider store={this.store}>
            화면 컴포넌트 : <PresentationComponent userName="화면 컴포넌트" />
            <br />
            데이터 컴포넌트 : <ContainerComponent id={2} />
            <br />
            액션 컴포넌트 : <DispatchContainer01 />


        </Provider>;
    }
}


export default AdvReduxApp; 
