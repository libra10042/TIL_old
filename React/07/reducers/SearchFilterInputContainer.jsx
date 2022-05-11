import { connect} from 'react-redux';
import {setFilter} from '../actions/searchFilterActions';
import Input from '../../04/InputWithStyle';

const mapStateToProps = (state, prorps) => {
    const value = state.searchFilter[props.anme] || '';



    return {
        value,
    };
};

const mapDispatcherToProps = {
    onChange: setFilter, 
};

export default connect(mapStateToProps, mapDispatcherToProps)(Input);


