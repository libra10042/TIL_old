class Cube { 
    // #1 생성자 매개변수 선언
    constructor(public width : number, private length : number, protected height : number){

    }
    // #2 직육면체 부피 구하기
    getVolumn(){
        return this.width * this.length * this.height; //length, height에 대한 접근은 허용하지 않는다.
    }
}


let [cWidth, cLength, cHeight] = [1, 2, 3];
let cube = new Cube(cWidth, cLength, cHeight);
console.log("1번 세로 : ", cube.width , "cm");
console.log("2번 부피 : ", cube.getVolumn(), "ml");



