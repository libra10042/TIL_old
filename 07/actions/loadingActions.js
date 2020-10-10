export const SET_LOADING = 'loading/SET_LOADING';

export const REEST_LAODING = 'loading/RSET_LOADING';

export const setLoading = loading =>({
    type: SET_LOADING,
    payload : loading, 
});

export const resetLoading = () => ({ //1. 초기화 기능에는 payload가 필요하지 않으므로 type만 반환했다.
    type: RESET_LOADING, 
})


