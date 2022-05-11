export const SET_FILTER  = 'searchFilter/SET_FILTER';
export const RESET_FILTER = 'searchFilter/RESET_FILTER';

export const setFilter = (filterName, value) => ({ //filterName은 검색항목의 이름에 해당하고 value는 검색값에 해당한다. 예를 들어 나이를 검색하는 경우 filterName은 age 일 것이고, value는 실제 입력한 숫자일 것이다.
    type : SET_FILTER,
    payload : {
        filterName,
        value,
    },
});

export const resetFilter = () => ({
    type: RESET_FILTER,
});

