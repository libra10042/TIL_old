// 고객 객체를 매개변수로 받아서 선입선출 방식으로 음식 주문을 처리하는 점원 클래스를 설계한다.
/*
    1. 점원은 주문을 위해 고객의 이름과 주문 항목을 요구한다.
    2. 첫 번째를 주문받은 고객을 먼저 처리한다.
*/
function Customer(name, order){
    this.name = name; 
    this.order = order; 
}
function Cashier(){
    this.customers = new Queue();
}
Cashier.prototype.addOrder = function (customer){
    this.customers.enqueue(customer);
}
Cashier.prototype.deliverOrder = function(){
    var finishedCustomer = this.customers.dequeue();

    console.log(finishedCustomer.name + " your" + finishedCustomer.order + " is read!");
}

var cashier = new Cashier();
var customer1 = new Customer('Jim', "Fries");
var customer2 = new Customer('Sammie', "Burger"); 
var customer3 = new Customer('Peter', 'Drink');

cashier.addOrder(customer1);
cashier.addOrder(customer2);
cashier.addOrder(customer3);

cashier.deliverOrder(); // Jim your Fries is realy!
cashier.deliverOrder(); // Sammie, your Burger is ready!
cashier.deliverOrder(); // Peter, your Drink is ready!




