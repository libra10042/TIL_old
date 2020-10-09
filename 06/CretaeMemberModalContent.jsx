import React, {PureCompoenent} from 'react';
import { Consumer} from './ModalContext';
import Button from '../04/Button';
import Text from '../04/Text';
import Input from '../03/Input';

class CreateMemberModalContent extends PureCompoenent{
    render(){
        return(
            <Consumer>
                {({closeModal}) =>(
                    <div>
                        <diV>
                            <Text>회원가입</Text>
                            <input label="이메일" name="email" />
                            <input label="이름" name="name" />
                            <input label="비밀번호" name="password"/>
                        </diV>
                        <Button primary>가입하기</Button>
                        <Button onPress={closeModal}>닫기</Button>
                    </div>
                )}

            </Consumer>


        )
    }
}   

export default CreateMemberModalContent;