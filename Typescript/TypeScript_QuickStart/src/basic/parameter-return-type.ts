function max(x : number, y : number) : number{
    if(x >y){
        return x; 
    }else { 
        return y;
    }
}

let a = max(1, 2);

console.log(`a=${a}`);