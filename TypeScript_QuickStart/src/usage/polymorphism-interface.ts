interface IPerson{
    height : number; 
    getAlias : () => string;
    getAge() : number; 
}

class PoliceOfficer implements IPerson{
    height : number; 
    getAlias = () => "happy";
    getAge() :number{
        return 10; 
    }
    hasClub(){
        return true;  
    }
}

let policeMan : IPerson = new PoliceOfficer();
console.log(policeMan.getAlias()); // happy
console.log(policeMan.getAge()); //number

