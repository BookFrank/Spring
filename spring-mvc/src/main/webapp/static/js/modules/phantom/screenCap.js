/**
 * 网页截图JS脚本 jiaer.ly
 */

var page = require('webpage').create();
// var system = require('system');

// console.log('0 ' + system.args[0]);
// console.log('1 ' + system.args[1]);
// console.log('2 ' + system.args[2]);

function getNowFormatDate() {
	var date = new Date();
	var seperator = "-";
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	if (month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	var currentdate = year + seperator + month + seperator + strDate;
	return currentdate;
}


// if (system.args.length !== 3) {
// 	console.log("参数个数错误，请检查参数！");
// 	phantom.exit(1);
// }else{
// 	// 截图URL
// 	var url = system.args[1];
// 	var picPath = system.args[2];

// 	page.open(address, function(status) {
// 		var bb = page.evaluate(function() {
// 			return document.getElementsByTagName('html')[0].getBoundingClientRect();
// 		});
// 		page.clipRect = {
// 			top : bb.top,
// 			left : bb.left,
// 			width : bb.width,
// 			height : bb.height
// 		};
// 		window.setTimeout(function() {
// 			page.render(picPath);
// 			page.close();
// 			console.log('渲染成功...');
// 		}, 1000);
// 	});
// }


//viewportSize being the actual size of the headless browser
page.viewportSize = { width: 1024, height: 768 };
//the clipRect is the portion of the page you are taking a screenshot of
page.clipRect = { top: 0, left: 0, width: 1024, height: 768 };

// page.setEncodeing('UTF-8');

page.open('test.html', function(status) {
	if ( status === "success" ) {
		page.render('github.png');
       console.log(page.title); 
     } else {
        console.log("Page failed to load."); 
     }
	phantom.exit(0);
});