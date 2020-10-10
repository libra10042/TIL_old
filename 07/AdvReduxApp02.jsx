//리액트 앱 수정하기
import { setLoading, resetLoading } from './actions/loadingActions';


class AdvReduxApp extends PureComponent{
    store = configureStore({loading: false});

    componentDidMount(){
        this.store.dispatch(setLoading(true));
        this.store.dispatch(resetLoading());
        this.store.dispatch({
            type: 'SET_USER',
            payload : {name: 'Park', age : 20},
        });
    }

}