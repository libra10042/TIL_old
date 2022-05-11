let person = {
    name : "Happy",
    hello : function(name2 : string){
        console.log("hello," + this.name + name2);
    }
};
person.hello("world");