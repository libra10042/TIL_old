// O(n) 알고리즘의 예 
function exampleLinear(n){
    for(var i=0; i<n ; i++){
        console.log(i);
    }
}


//O(n²) 
function exampleQuadratic(n){
    for(var i=0; i<n; i++){
        console.log(i);
        for(var j =i; j<n; j++){
            console.log(j);
        }
    }
}


//O(n³)
function exampleCubic(n){
    for(var i=0; i<n; i++){
        console.log(i);
        for(var j=i; j<n ; j++){
            for(var k=j; j<n; j++){
                console.log(k);
            }
        }
    }
}



