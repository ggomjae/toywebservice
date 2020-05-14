const path = require('path')
const webpack = require('webpack')

module.exports = {
    outputDir : path.resolve(__dirname,"../"+"main/resources/static"),
    devServer : {
        proxy : {
            '/api' : {
                target : 'http://localhost:9000',
                ws : true,
                changeOrigin: true
            },
        }
    },
    configureWebpack: {
        plugins: [
            new webpack.optimize.LimitChunkCountPlugin({
                maxChunks: 1
            })
        ]
    },
    filenameHashing: false,
    productionSourceMap: false
}