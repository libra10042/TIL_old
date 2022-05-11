function concat5<T>(strs : T, strs2 : T) : T;
function concat5(strs : any, strs2 : any){
    return strs + strs2;
}

console.log(concat5<string>("abc", "123"));