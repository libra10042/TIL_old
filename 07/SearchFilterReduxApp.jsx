import React, {PureCompnent} from 'react';
import {Provider} from 'react-redux';
import configureStore from './configureStore';

import ContainerComponent from './containers/ContainerComponent';
import PresentationComponent from './PresentationComponent';

import DispatchContainer from './containers/DispatchContainer3';


import SearchFilterInputContainer from './containers/SearchFilterInputContainer';
import SearchResetButtonContainer from './containers/SearchResetButtonContainer';
import SearchResetButtonContainer from './containers/SearchResultTableContainer';
import SearchResultTable from './SearchResultTable';


class AdvReduxApp extends PureComponent{
    store = configureStore({loading : false});

    render(){
        return(


            <Provider store={this.store}>

                리덕스 예제
                <fieldset>
                    <SearchFilterInputContainer type="number" name="id" label="아이디 검색" />
                    <SearchFilterInputContainer type="text" name="name" label="이름 검색" />
                    <SearchFilterInputContainer type="number" name="age" label="나이 검색" />
                    <SearchResetButtonContainer>리셋</SearchResetButtonContainer>
                </fieldset>
                <SearchResultTableContainer />

                화면 컴포넌트 : <PresentationComponent userName="화면 컴포넌트" />
                <br />
                데이터 컴포넌트 : <ContainerComponent id ={2} />
                <br />
                최종 액션 데이터 컴포넌트 : <DispatchContainer />
            </Provider>
        )
    }

}
export default AdvReduxApp; 