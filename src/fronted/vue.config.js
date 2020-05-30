const path = require('path')
const webpack = require('webpack')
const CompressionPlugin = require('compression-webpack-plugin');

module.exports = {

    outputDir : path.resolve(__dirname,"../"+"main/resources/static"),
    devServer : {
        proxy : {
            '/api' : {
                target : 'http://localhost:9001',
                ws : true,
                changeOrigin: true
            },
        },
    },
    configureWebpack: {
        plugins: [
            new webpack.optimize.LimitChunkCountPlugin({
                maxChunks: 1
            }),
            new CompressionPlugin({
                test: /\.js(\?.*)?$/i,
            }),
        ]
    },
    filenameHashing: false,
    productionSourceMap: false
}