import React from 'react';
import withStyles, {css} from '../04/withStyles';

export default function(defaultMessage){
    return WrappedComponent =>{
        const { displayName, name : componentName } = WrappedComponent;
        const WrappedComponentName = displayName || componentName;
    }

    function ComponentWithError({
        hasError, 
        errorMessage, 
        styles, 
        ...props, 

    }){
        return(
            <React.Fragment>
                <WrappedComponent {...props} />
                {hasError && <div {...css(styles.error)}>{errorMessage}</div>}
            </React.Fragment>
        );
    };


    ComponentWithError.defaultProps = { 
        errorMessage : defulatMessage
    };

    ComponentWithError.displayName = `withError(${wrappedComponentName})`;
    return withStyles({color}) =>({
        error : {
            color : class.error,
        },
    })(ComponentWithError)


    
}


