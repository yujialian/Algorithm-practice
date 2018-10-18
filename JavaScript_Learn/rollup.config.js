import babel from 'rollup-plugin-babel'
import resove from 'rollup-plugin-node-resolve'

/*
 * Entry: entry js file
 * umd: support either direct import from html.
 * dest: output target.
 */
export default {
    entry: 'src/index.js',
    format: 'umd',
    plugins: [
        resove(),
        babel({
            exclude: 'mode_modules/**'
        })
    ],
    dest: 'build/bundle.js'
}
