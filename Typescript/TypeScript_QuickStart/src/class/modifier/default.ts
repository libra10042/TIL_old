class Account {
    balance : number;

    //적금액 얻기(get 프로퍼티 이용)
    get getBalance(){
        return this.balance;
    }

    //적금하기(set 프로퍼티 이용)
    set setBalance(amount : number){
        this.balance += amount;
    }

    //적금하기(메서드 이용)
    deposite(depositeAmount : number){
        this.setBalance = depositeAmount;
    }

    //기본 적금(balance)액을 설정하기
    constructor(defaultBalance : number =0, protected  bankName : string = "happy bank", readonly interestRate : number = 0.1){
        this.balance = defaultBalance;
    }

    //생성자 매개변수 interestRate는 public으로 설정됐으므로 호출 가능. 
    getInterestRate(){
        return this.interestRate;
    }

    //생성자 매개변수 defaultBalance는 private(ㄱ본 접근 제한자) 이므로 호출 불가
    getDefaultBalance(){
        //return this.defaultBalance
    }

}



class MyAccount extends Account { 
    //테스트
    constructor(){
        super();
        this.deposite(1000);
        this.setBalance = 1000; 
        console.log(`2번) 적금 : ${this.balance}원 /
        이율 :  ${this.getBalance}, ${this.getInterestRate()}% /
        은행명  :${this.bankName} `);
    }
}


let account = new Account();
console.log(`1번) 적금 : ${account.balance}원, ${account.getBalance}원 /
                이율 : ${account.interestRate}. ${account.getInterestRate()}% `);


let myAccount = new MyAccount();
//preotected는 상속 관계에서만 접근을 허용한다.