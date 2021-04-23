//  지뢰 찾기

let value = "0 1 0 0 0\n0 0 0 0 0\n0 0 0 1 0\n0 0 1 0 0\n0 0 0 0 0";
let sp = value.split("\n");

console.log(value);
console.log(sp);

let count =0; 

for(let i of sp){
    // console.log(i);
    sp[count] = i.replace('1', 'f').split(' ');
    count += 1;
}
console.log(sp);

count =0; 
let search = 0; 

for(let s of sp){
    console.log(s);
    for(let i of s){
        // console.log(count, search);
        search = s.indexOf
        if(i === 'f'){
            if(search > 0){
                s[search -1] = '*';
            }
            if(search < 4){
                s[search+1] ='*';
            }    
            if(count > 0){
                sp[count-1][search] = '*';
            }
            if(count <4){
                sp[count+1][search] = '*';
            }
        }
        search += 1; 
    }
    count += 1;
    search = 0; 
}
