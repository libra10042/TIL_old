import React from 'react';
import PropTypes from 'prop-types';
import Button from '../04/Button';
import createLoadingConsumer from './createLoadingConsumer';

const DefaultLoadingConsumer = createLoadingConsumer();
const Loading2Consumer = createLoadingConsumer('loading2');

function ButtonWithConsumer({children}){
    return (
        <React.Fragment>
            <DefaultLoadingConsumer
                render= {({loading, setLoading})=>(
                    <Button onPress= {() =>setLoading(!loading)}>
                        {loading ? '컨텍스트1 로딩 중'  :children}
                    </Button>
                )}
            />
            <Loading2Consumer   
                render={({loading, setLoading}) => {
                    <Button onPress={() =>setLoading(!loading)}>
                        {loading ? '컨텍스트2로딩 중' :children}
                    </Button>
                }}
            />
        </React.Fragment>

    
    );
}