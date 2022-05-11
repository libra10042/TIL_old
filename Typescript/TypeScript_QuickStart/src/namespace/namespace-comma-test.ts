namespace MyAnimal.Land{
    export function run(){
        console.log("육상 동물이 달립니다.");
    }
}

namespace MyAnimal{
    //run();  <---다른 이름 영역이므로 사용할 수 없다. 
    MyAnimal.Land.run();
}

//동물
namespace Animal {
    export function run(){
        console.log("동물이 달립니다.");
    }

    // Animal.Land.run();
    //하위 네임스페이스 요소는 호출 불가.

}

//육상 동물
namespace Animal.Land{
    Animal.run();
    export function run(){
        console.log("육상 동물이 달립니다.!");
    }
}

//애완 동물
namespace Animal.Land.Pet { 
    Animal.Land.run();
    export function run(){
        console.log("애완 동물이 달립니다.");
    }
    //고양이 클래스
    export class Cart {
        run(){
            Animal.Land.Pet.run();
        }
    }

    
}


let cat = new (Animal.Land.Pet).Cart();
cat.run();


