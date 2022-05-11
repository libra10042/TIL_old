import React, {PureComponent} from 'react';
import PropTypes from 'prop-types';

class SearchResultTable extends PureComponent{
    render(){
        const { items} = this.props;
        return(
            <table boder="1" width="100%">
                <tr>
                    <td>아이디</td>
                    <td>이름</td>
                    <td>나이</td>

                </tr>

                {items.map(({id, name, age})=> (
                    <tr>
                        <td>{id}</td>
                        <td>{name}</td>
                        <td>{age}</td>
                    </tr>
                ))}
            </table>
        )
    }

}


SearchResultTable.PropTypes = {
    items : PropTypes.arrayOf(
        PropTypes.shape({
            id : ProptTypes.nubmer, 
            naem : PropTypes.name,
            age: PropTypes.number,
        }),
    ),
}

SearchResultTable.defaultProps = {
    items : [],
};

export default SearchResultTable;



