var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Account = /** @class */ (function () {
    //기본 적금(balance)액을 설정하기
    function Account(defaultBalance, bankName, interestRate) {
        if (defaultBalance === void 0) { defaultBalance = 0; }
        if (bankName === void 0) { bankName = "happy bank"; }
        if (interestRate === void 0) { interestRate = 0.1; }
        this.bankName = bankName;
        this.interestRate = interestRate;
        this.balance = defaultBalance;
    }
    Object.defineProperty(Account.prototype, "getBalance", {
        //적금액 얻기(get 프로퍼티 이용)
        get: function () {
            return this.balance;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Account.prototype, "setBalance", {
        //적금하기(set 프로퍼티 이용)
        set: function (amount) {
            this.balance += amount;
        },
        enumerable: false,
        configurable: true
    });
    //적금하기(메서드 이용)
    Account.prototype.deposite = function (depositeAmount) {
        this.setBalance = depositeAmount;
    };
    //생성자 매개변수 interestRate는 public으로 설정됐으므로 호출 가능. 
    Account.prototype.getInterestRate = function () {
        return this.interestRate;
    };
    //생성자 매개변수 defaultBalance는 private(ㄱ본 접근 제한자) 이므로 호출 불가
    Account.prototype.getDefaultBalance = function () {
        //return this.defaultBalance
    };
    return Account;
}());
var MyAccount = /** @class */ (function (_super) {
    __extends(MyAccount, _super);
    //테스트
    function MyAccount() {
        var _this = _super.call(this) || this;
        _this.deposite(1000);
        _this.setBalance = 1000;
        console.log("2\uBC88) \uC801\uAE08 : " + _this.balance + "\uC6D0 /\n        \uC774\uC728 :  " + _this.getBalance + ", " + _this.getInterestRate() + "% /\n        \uC740\uD589\uBA85  :" + _this.bankName + " ");
        return _this;
    }
    return MyAccount;
}(Account));
var account = new Account();
console.log("1\uBC88) \uC801\uAE08 : " + account.balance + "\uC6D0, " + account.getBalance + "\uC6D0 /\n                \uC774\uC728 : " + account.interestRate + ". " + account.getInterestRate() + "% ");
var myAccount = new MyAccount();
//preotected는 상속 관계에서만 접근을 허용한다.
