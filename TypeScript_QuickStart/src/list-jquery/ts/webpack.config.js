var path = require('path');
var webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    devtool : 'source-map',
    entry : ['./src/ts/app.ts'],
    output : {
        path : path.resolve(__dirname, 'dist/js'),
        filename : 'app.js'
    },
    module : {
        loaders : [{
            test : /\.tsx?$/,
            loader : 'ts-loader'
        }]
    },
    plugins : [
        new webpack.optimize.UglifyJsPlugin({
            compress : {
                warnings : false
            }
        }),
        new HtmlWebpackPlugin({ title : 'Customer template', 
                                template :'./src/ts/index.html' })
    ],
    resolve: {
        extensions : [".ts", "js"]
    }
};

