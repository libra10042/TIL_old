import React from 'react';
import ProTypes from 'prop-types';
import { DEFAULT_KEY, contextPropTypes} from './LoadingProviderWithKey';

export default (contextKey = DEFAULT_KEY) =>{
    function LoadingConsumer({render}, context){
        return render(context[contextKey]);
    };
    LoadingConsumer,contextTypes = { 
        [contextKey]  : contextPropTypes,

    };

    LoadingConsumer.contextTypes = {
        render : contextPropTypes.func.isRequired, 

    };
    return LoadingConsumer; 

}