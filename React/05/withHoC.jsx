import React from 'react';

export default function withHoC(WrappedComponent){

    const { displayName, name} = WrappedComponent;
    const WrappedComponentName = displayName || name; 
    return class WithHoC extends React.Component {
        static displayName = `withHoC(${WrappedComponent.name})`;
        render(){
            return <WrappedComponent {...this.props} />;
        }
    }


  
}