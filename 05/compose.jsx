//compose() 함수로 다중 하이어오더 컴포넌트 사용하기
import compose from 'recompose/compose';
import withLoading from './withLoading';
import withState from 'recompose/withState';
const withLoadData = withState('isLoading', 'setIsLoading', false);

function Component(){
    return '완료(컴포넌트 출력)';
}


const ComponentWithLoading = withLoading('로딩중')(Component);
const ComponentWithLoadData = withLoadData(ComponentWithLoading);

const withLoadDataAndLoading = compose(withLoadData, withLoading('로딩중 '))
//조합이 올바르지 못한 예 : compose(withLoadData, withLoading);
//순서가 올바르지 못한 예 : compose(withLoading('로딩 중'), withLoadData)
const ComponentWithLoadData = withLoadDataAndLoading(ComponentWithLoading);

//혹은 compose(withLoadData, withLoading('로딩중'))(ComponentWithLoading)