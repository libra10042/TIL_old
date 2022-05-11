import React, {PureComponent} from 'react';
import { Provider} from 'react-redux';
import configureStore from './configureStore';

class AdvReduxApp extends PureComponent{
    store = configureStore({loading : false});
}