var myEvent = "keyup";
console.log(typeof myEvent, myEvent);
function on(event, callback) {
    console.log(typeof event, event);
    callback("callback!");
}
on(myEvent, function (message) { return console.log(message); });
