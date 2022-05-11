// 얕은 복사  Object.assign()


// Object.assign() 얕은 복사. 
const company = { 
    name : "naver",
    department : "dev",
    location : ['경기도 성남시 분당구 불정로 6']
}

const copyCompany = Object.assign({}, company); 
console.log(copyCompany)

company.name = 'kakao';
console.log('company', company);
console.log('coopyCompany', copyCompany); // 불변. 



// 얕은 복사  Spead 연산자. 불변성 지켜짐.
const company2 = { 
    name : 'kas',
    department : 'civil',
    location : ['대구 광역시']
}

const copyCompany2 = {...company2};
console.log(company2 === copyCompany2); // false -> 불변성 지켜지는 중. 


// 얕은 복사  Spead 연산자. 불변성 안지켜짐. 
const company3 = {
    name : 'kas',
    department : 'civil',
    location : ['대구 광역시']
}

const copyCompany3 = {...company3};
company3.department = 'dev';

company3.location.push("충남 당진");
console.log(copyCompany3.location === company3.location); // true : 불변성 안지켜짐.
console.log(copyCompany3);
console.log(company3);