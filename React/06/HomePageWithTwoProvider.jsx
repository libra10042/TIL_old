import React, {PureComponent} from 'react';
import ButtonWithLoadingContext from './ButtonWithLoadingContext';
import { 

    ButtonWithDefaultLoadingContext, 
    ButtonWithLoading2Context
} from './ButtonWithLoadingContextAndKey';

import LoadingProviderWithKey from './LoadingProviderWithKey';

const LoadingProvider1 = LoadingProviderWithKey();
const LoadingProvider2 = LoadingProviderWithKey('loading2')

function TableComponent(){
    return(
        <table>

            <ButtonWithLoadingContext>컨텍스트1</ButtonWithLoadingContext>
            <ButtonWithLoading2Context>컨텍스트2</ButtonWithLoading2Context>

        </table>

    );
}


class HomePageComponentWithTwoProvider extends PureComponent{
    render(){
        return(
            <LoadingProvider1>
                <LoadingProvider2>
                    <TableComponent />
                </LoadingProvider2>
            </LoadingProvider1>
        )
    }



}


