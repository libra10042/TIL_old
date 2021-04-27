//  천하제일 먹기 대회

// 손오공 야모차 메지터 비콜로
// 70 10 55 40 

const name = '손오고 야모챠 매지터 비콜로'.split(' ');
const point = '70 10 55 40'.split(' ');
console.log(point);

const point_int = point.map(a => parseInt(a, 10));
console.log(point_int);

function sol(name, point){
    let temp = [];
    for(let i of name){
        let obj = {};
        obj['name'] = i;
        obj['value'] = point[name.indexOf(i)];
        temp.push(obj);
    }
    // console.log(temp);

    temp.sort(function(a, b){
        return a.value < b.value ? 1 : a.value > b.value ? -1 : 0; 
    })

    console.log(temp);

    let result = {};
    for(let i of temp){
        // console.log(i);
        result[i['name']] = temp.indexOf(i) +1; 
    }
    return result; 
}

console.log(sol(name, point_int));