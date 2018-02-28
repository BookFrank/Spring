var page = require('webpage').create();

//viewportSize being the actual size of the headless browser
page.viewportSize = { width: 1024, height: 768 };
//the clipRect is the portion of the page you are taking a screenshot of
page.clipRect = { top: 0, left: 0, width: 1024, height: 768 };


page.open('http://www.tazine.com/', function() {
    page.render('github.png');
    phantom.exit();
});