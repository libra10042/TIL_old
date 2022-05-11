import { connect}  from 'react-redux';
import PresentationComponent from '../PresentationComponent';

const mapStateToProps = (state, props) => {
    return{
        userName : state.user.name, //스토어 user 객체의 name 항목에 접근하여 userName 프로퍼티값으로 변환한다.
        entity : state.collection.entites[props.id], //데이터 컴포넌트에 프로퍼티로 전달된 id값을 참조하여 그래프 db의 자료를 추출한다.
    };
};

export default connect(mapStateToProps)(PresentationComponent)

