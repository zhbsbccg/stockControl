/**
 * 
 */
module.exports = {
  entry: './src/main.js',
  output: {
    path: '/static',
    publicPath: '/static/',
    filename: 'build.js'
  },
  module: {
    // avoid webpack trying to shim process
    noParse: /es6-promise\.js$/,
    loaders: [
      {
        test: /\.vue$/,
        loader: 'vue-loader'
      },
      {
        test: /\.js$/,
        // excluding some local linked packages.
        // for normal use cases only node_modules is needed.
        exclude: /node_modules|vue/,
        loader: 'babel-loader'
      }
    ]
  },
  //热编译不支持template，只支持render,要加上这句转才可以
  resolve: { alias: { 'vue': 'vue/dist/vue.js' } }

}