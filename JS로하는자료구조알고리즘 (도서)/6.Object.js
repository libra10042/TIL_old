// 객체
let javaScriptObject = {};
let testArray = [1,2,3,4];

javaScriptObject.array = testArray; 
console.log(javaScriptObject); // {array : [1,2,3,4]}

javaScriptObject.title = "Algorithms";
console.log(javaScriptObject); // {array : [1,2,3,4], title : 'Algorithms'}


// 프로토타입 활용 상속
function ExampleClass(){
    this.name = "Javascript"; 
    this.sayName = function(){
        console.log(this.name);
    }
}
// 신규 객체 
let example1 = new ExampleClass();
example1.sayName(); // "Javascript"

// ---------------------------------------------
function ExampleClass(){
    this.array = [1,2,3,4,5];
    this.name = "Javascript";
}
// 신규 객체
let example1 = new ExampleClass();

ExampleClass.prototype.sayName = function(){
    console.log(this.name);
}

example1.sayName(); // Javascript

// ---------------------------------------------
function ExampleClass(name, size){
    let privateName = name; 
    let privateSize = size; 

    this.getName = function() {return privateName;}
    this.setName = function(name) { privateName = name;}

    this.getSize = function() { return privateSize;}
    this.setSize = function(size) { privateSize = size;}

}

let example = new ExampleClass("Samie", 3);
example.setSize(12);
console.log(example.privateName); // undefined
console.log(example.getName()); // "Samie"
console.log(example.size); // undefined
console.log(example.getSize());  12

// ---------------------------------------------
function Animal(name, animalType){
    this.name = name; 
    this.animalType = animalType; 
}

Animal.prototype.sayName = function(){
    console.log(this.name);
}
Animal.prototype.sayAnimalType = function(){
    console.log(this.animalType);
}
