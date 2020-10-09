import React from 'react';
import PropTypes from 'prop-types';
import Button from '../04/Button';

import {Consumer} from './LoadingProviderWithNewContext';

function ButtonWithNewConsumer({children}){
    return(

        <React.Fragment>
            <Consumer
                children={value =>(
                    <Button onPress={() => value.setLoading('loading', !value.loading)}>
                        {value.loading ? '로딩 중' : children }
                    </Button>
                )}
            />
    
            <Consumer
                children={({loading2 = false, setLoading})=> (
                    <Button onPress={() =>setLoading('loading2', !loading)}>
                        {loading2 ? '로딩중' :children}
                    </Button>
                )}
                    
/>
                <Consumer children={({loading=false, loading2=false})=>{
                    <Button>
                        {loading && loading2 ? '로딩중' : children}
                    </Button>
                }}

                />            
        </React.Fragment>
    )
}