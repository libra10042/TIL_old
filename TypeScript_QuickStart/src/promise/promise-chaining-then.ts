let chainingPromise = new Promise(function (resolve, reject){
    resolve(1);
}).then(function ( value){
    console.log(value);
    return 2; 
}).then(function ( value){
    console.log(value);
    throw "Exception!";
}).catch(function (e){
    console.log(e);
});