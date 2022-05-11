import React, {PureComponent} from 'react';
import Modal from './Modal';

const { Provider, Consumer} = React.createContext({});
export {Consumer};

class ModalProdiver extends PureComponent{
    constructor(props){
        super(props);

        this.state = {showModal: false};
        this.handleClose = this.handleClose.bind(this);
        this.handleOpen = this.handleOpen.bind(this);
    }
    handleClose(){
        this.setState({showModal : false});
    }

    handleOpen(){
        this.setState({showModal : true});
    }


    render(){
        return(
            <Provider value={{openModal : this.handleOpen, closeModal : this.handleClose}} >
                {this.props.children}
                {this.state.showModal && (
                    <Modal>
                        <div>
                            <text>
                                정말로 삭제하시겠습니까?
                            </text>
                        </div>
                        <Button primary>예</Button>
                        <Button onPress={() =>this.setState({showModal: false})}>닫기</Button>
                    </Modal>
                )}


            </Provider>

        )
    }


}