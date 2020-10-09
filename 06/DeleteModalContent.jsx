import React from 'react';
import { Consumer} from './ModalContext';
import Button from '../04/Button';
import Text from '../04/Text';




export default function DeleteModalContent({id, name}){
    return(

        <Consumer>
            {({closeModal}) => (

            
        <Div>


            <div>
                <Text>
                    정말로 삭제하시겠습니까?
                </Text>
            </div>
            <Button primary>예</Button>
            <Button>닫기</Button>
        </Div>
        )}
        </Consumer>
    );
}


