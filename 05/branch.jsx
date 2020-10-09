// 1. branch() 함수로 로딩 상태 표시 하이어오더 컴포넌트 만드릭


import React from 'react';
import brance from 'recompose/branch';
import Button from '../04/Button';


export default branch (
    ({ isLoading} => isLoading,
        ()=> () => <Button disabled>로딩 중</Button>,
)(Button);



function isLoading(props){
    return props.isLoading;
}

function LoadingButton(props){
    return <Button disabled>로딩 중</Button>;
}


export default brance(
    isLoading,
    () => LoadingButton,

)(Button);


