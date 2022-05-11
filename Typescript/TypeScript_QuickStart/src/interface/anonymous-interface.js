var format = function (str, isUpper) {
    if (isUpper) {
        return str.toUpperCase();
    }
    else {
        return str.toLowerCase();
    }
};
console.log(format("1 : happy!"));
console.log(format("2 : happy!", true));
console.log(format("3 : happy!", false));
