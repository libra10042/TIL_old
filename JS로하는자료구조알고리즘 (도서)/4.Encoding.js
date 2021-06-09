let DICTIONARY = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".split("");

function encodeId(num){
    let base = DICTIONARY.length; 
    let encoded = "";

    if(num === 0){
        console.log(DICTIONARY[0]);
        return DICTIONARY[0];
    }

    while(num > 0){
        encoded += DICTIONARY[(num % base)];
        num = Math.floor(num / base);
    }
    return reverseWorld(encoded);
}

function reverseWorld(str){
    let reversed = "";
    for(let i = str.length - 1; i>=0; i--){
        reversed += str.charAt(i);
    }
    return reversed; 
}

function decodeId(id){
    let base = DICTIONARY.length; 
    let decoded = 0; 

    for(let index = 0; index < id.split("").length; index++){
        decoded = decoded * base + DICTIONARY.indexOf(id.charAt(index));
    }

    return decoded; 
}

console.log(encodeId(11231230)); // 'VHU2'를 출력한다.
console.log(decodeId('VhU2')); // '11231230'를 출력한다.
