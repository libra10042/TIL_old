import createModalProvider from './createModalProvider';
import CreateMemberModalContent from './CretaeMemberModalContent';
import DeleteModalContent from './DeleteModalContent';

export const CONFIRM_DELETE_MODAL = 'confirm_delete';
const CONTEXT_MAP ={
    [CONFIRM_DELETE_MODAL] : DeleteModalContent,
    [CREATE_MEMBER_MODAL] : CreateMemberModalContent,
};


export default createModdalProvider(CONTENT_MAP);

