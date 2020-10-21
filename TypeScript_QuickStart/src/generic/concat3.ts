function concat3<T>(strs : T, strs2 : T){
    console.log(typeof strs, strs);
    console.log(typeof strs2, strs2);

    return String(strs) + String(strs2);
}

concat3("abc", "123");
concat3<string>("abc", "123");