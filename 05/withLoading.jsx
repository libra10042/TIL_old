import React from 'react';

export default function withLoading(WrapperComponent, loadingMessage = '로딩 중'){
    const { displayName, name : componentName} = WrapperComponent;
    const wrappedComponentName = displayName || componentName;

    function WithLoading({isLoading, ...otherProps}){

        if(isLoading) return '로딩 중';



        return(
            <WrapperComponent {...props}/>
        );
    }

    WithLoading.displayName = `withLoading(${wrappedComponentName})`;
    return WithLoading;
}







