interface IFormat { 
    (data : string, toUpper?:boolean) : string; 
}

let format : IFormat = function(str : string, isUpper: boolean){
    if(isUpper){
        return str.toUpperCase();
    }else{
        return str.toLowerCase();
    }
};


console.log(format("1 : happy!"));  //1: happy!
console.log(format("2 : happy!", true)); //2 : HAPPY!
console.log(format("3 : happy!", false)); //3 : happy!
