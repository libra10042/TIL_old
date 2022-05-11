import React, {PureComponent} from 'react';
import ButtonWithLoadingContext from './ButtonWithLoadingContext';
import LoadingProvider from './LoadingProvider';

function RowBComponent(){
    return <Button>버튼</Button>
}

function RowCComponent(){
    return(
        <table>
            <RowBComponent />
            <RowBComponent />
        </table>

    )
}

const TableComponent = () => <ButtonWithLoadingContext label="버튼" />

class HomePageComponent extends PureComponent{
    render(){
        return(
            <LoadingProvider>
                <TableComponent />
                
                <ButtonWithLoadingContext>상태변경 </ButtonWithLoadingContext>    
            </LoadingProvider>
        )
    }
}