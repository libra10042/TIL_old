//@desc  기본적인 형태의 웹팩 설정 파일. 
var path = require('path');


module.exports = {
    entry :"./webpack/entry1.js",
    ouput :{ 
        filename : 'build1.js',
        path : path.resolve(__dirname, 'dist')
    }
};

