import React from 'react';
import PropTypes from 'prop-types';

export default WrappedComponent =>{
    const { displayName, name : componentName} = WrappedComponent;
    const WrappedComponent = displayName || componentName;


    function WithLoadingContext(props, context){
        const { loading, setLoading} = context; 
        return(

            <WrappedComponent {...props} loading={loading} setLoading={setLoading} />

        );
    };

    WithLoadingContext.displayName  = 'withLoadingContext(${wrappedComponentName})';
    WithLoadingContext.contextType = { 
        loading : PropTypes.bool, 
        setLoading : PropTypes.func,
    };

    return WithLoadingContext;
}

