import 'babel-polyfill'

function loadImg(src) {
	var promise = new Promise(function(resolve, reject) {
		var img = document.createElement('img')
		// Simulate an exception: throw new Error('Custom error!')
		img.onload = function() {
			resolve(img)
		}
		img.onerror = function() {
			reject("Image load fail!")
		}
		img.src = src
	})
	return promise
}
var src1 = 'https://www.imooc.com/static/img/index/logo.png'
//var result1 = loadImg(src1)
var src2 = 'https://img3.mukewang.com/54584ed2000152a202200220-100-100.jpg'
//var result2 = loadImg(src2)

//Async, await
const load = async function() {
    const result1 = await loadImg(src1)
    console.log(result1)
    const result2 = await loadImg(src2)
    console.log(result2)
}
load()
