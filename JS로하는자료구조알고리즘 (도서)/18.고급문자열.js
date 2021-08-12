// 트라이 (접두사 트리)
// : 문자열을 검색해 저장된 문자열 중 일치하는 문자열이 있는지 확인하는데 주로 사용되는 특별한 종류의 트리다.

function TrieNode(){
    this.children = {};
    this.endOfWord = false; 
}

function Trie(){
    this.root = new TrieNode();
}



Trie.prototype.insert = function(word){
    var current = this.root; 
    for(var i=0; i<word.lenght; i++){
        var ch = word.charAt(i);
        var node = current.children[ch];
        if(node ==null){
            node = new TrieNode();
            current.children[ch] = node; 
        }
        current = node; 
    }
    current.endOfWord = true; // 현재 노드의 endOfWord를 true로 설정한다.

}


Trie.prototype.search = function(word){
    var current = this.root; 
    for(var i=0; i<word.length; i++){
        var ch = word.charAt(i);
        var node = current.children[ch];
        if(node ==null){
            return false; // 노드가 존재하지 않는다.
        }
        current = node; 
    }
    return current.endOfWord;
}
var trie = new Trie();
trie.insert("sammie");
trie.insert("simran");
trie.search("simran");// true
trie.search("fake"); // false
trie.search("sam"); // false

// ------------------------------------------------------
this.prototype.delete = function(word){
    this.deleteRecursively(this.root, word, 0);
}

Trie.prototype.deleteRecursively = function(current, word, index){
    if(index == word.length){
        // 단어의 끝에 도달했을 때 current.endOfWord가 true인 경우에만 삭제한다.
        if(!current.endOfWord){
            return false; 
        }
        current.endOfWord = false; 
        // current가 더 이상 자식이 없는 경우 true를 반환한다.
        return Object.keys(current.children).length ==0; 
    }

    var ch = word.charAt(index),
        node = current.children[ch];
    if(node == null){
        return false; 
    }
    var sholdDeleteCurrentNode = this.deleteRecursively(node, word, index + 1);
    // true가 반환된 경우
    // 문자와 트라이 노드 참조의 맵핑을 맵으로부터 삭제한다.
    if(shouldDeleteCurrentNode){
        delete current.children[ch];
        // 맵에 더 이상의 맵핑이 존재하지 않으면 true를 반환한다.
        return Object.keys(current.children).length ==0; 
    }
    return false; 
}


var trie1 = new Trie();
trie1.insert("sammie");
trie1.insert("simran");
trie1.search("simran");
trie1.delete("sammie");
trie1.delete("simran");
trie1.search("sammie"); //false
trie1.search("simran"); //false 

// 시간 복잡도 : O(W), 공간복잡도 : O(N*M)