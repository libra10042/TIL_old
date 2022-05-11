// 같은 의약성분을 찾아라!

판콜비 ='ABCDEFGH'
넥타이레놀 = 'EFGHIJKL'

let l = [];

for(let i = 65; i < 91; i++){
    l.push(String.fromCharCode(i));

}

console.log(l);

function randomItem(a){
    let string = []; 

    while(string.length !== 8){
    

        let b = a[Math.floor(Math.random()*a.length)];
        if(!string.includes(b)){
            string.push(b);
        }
    }


    let medicine = string.join('');

    return medicine;
}

let total_medicine = [];

while(total_medicine.length !== 100){
    let m = randomItem(l);
    if(!total_medicine.includes(m)){
        total_medicine.push(m);
    }
}


console.log(total_medicine);
user_input = 'ABCDEFGH 4'.split(' ');
let result = [];

for(let i of total_medicine){
    let setUserData = new Set(user_input[0]);
    let setMedicine = new Set(i);

    let intersection = new Set([...setUserData].filter(x => setMedicine.has(x)));

    console.log(intersection);

    if(intersection.size === parseInt(user_input[1], 10)){
        result.push(i)
    }

}
console.log(result);
console.log(result.length);