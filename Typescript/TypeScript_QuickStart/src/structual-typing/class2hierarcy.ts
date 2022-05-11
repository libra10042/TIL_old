class Person {
    public name : string; 
}

class Member extends Person{
    public grade : number;
}

class Admin extends Member{}

class MemberCard{
    public name : string; 
    public grade : number; 
}

let admin : Admin = new Admin();
admin = new MemberCard();

