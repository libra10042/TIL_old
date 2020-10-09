import React from 'react';
import Proptypes from 'prop-types';

class LoadingProvider extends React.Component{
    constructor(props){
        super(props);

        this.state = { loading: false};
        this.setLoading  = this.setLoading.bind(this);

    }

    getChildContext(){
        return{
            loading : this.state.loading, 
            setLoading : this.setLoading,

        };
    }

    setLoading(loading){
        this.setState({loading});
    }

    render(){
        return this.props.children;
    }

}


LoadingProvider.childContextTypes = { 
    loading : Proptypes.bool, 
    setLoading : Proptypes.func,
};

export default LoadingProvider; 





