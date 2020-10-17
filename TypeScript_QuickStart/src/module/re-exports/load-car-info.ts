import { CarInfo} from "./car-info-module";

CarInfo.Hello();

let car = new CarInfo.car("My Car");
console.log(car.name);

let engine = new CarInfo.engine("My engine");
console.log(engine.name);