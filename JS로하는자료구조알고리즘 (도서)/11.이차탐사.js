// 이차 탐사
HashTable.prototype.put = function(key, value){
    if(this.limit >= this.size) throw 'hash table is full'

    var hashedIndex = this.hash(key), squareIndex = 1; 

    // 이차 탐사 
    while(this.keys[hashedIndex % this.size] != null){
        hashedIndex += Math.pow(squareIndex, 2);
        squareIndex++;
    }

    this.keys[hashIndex % this.size] = key; 
    this.values[hashedIndex % this.size] = value; 
    this.limit++; 
}

HashTable.prototype.get = function(key){
    let hashedIndex = this.hash(key), squareIndex = 1; 

    while ( this.keys[hashedIndex % this.size] != key) {
        hashedIndex += Math.pow(squareIndex, 2);

        hashedIndex = hashedIndex % this.size;
        squareIndex++;
    }

    return this.values[hashedIndex % this.size];
}


// 선형 탐사를 활용한 이중 해싱 
HashTable.prototype.put = function(key, value){
    if(this.limit >= this.size) throw 'hash table is full'

    let hashedIndex = this.hash(key);

    while(this.keys[hashedIndex] != null){
        hashedIndex++;

        hashedIndex = hashedIndex % this.size;
    }

    this.keys[hashedIndex] = key;
    this.value[hashedIndex] = value; 
    this.limit++; 
}

hashTable.prototype.get = function(key){
    var hashedIndex = this.hash(key);

    while(this.keys[hashedIndex] != key){
        hashedIndex++;

        hashedIndex = hashedIndex % this.size; 
    } 
    return this.values[hashedIndex];
}

HashTable.prototype.hash = function(key){
    if(!Number.isInteger(key)) throw 'must be int'; // 정수인지 확인한다.
    return this.secondHash(key);
}
HashTable.prototype.secondHash = function(hashedKey){
    var R = this.size -2; 
    return R - hashedKey % R; 
}