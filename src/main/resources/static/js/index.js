window.onload = function () {
    init();
}
function init() {
    menuInitialize();
}

// 菜单初始化
const menuArr = [
    {"key":"首页", "value":"home"},
    {"key":"项目管理", "value":"projectManagement"},
    {"key":"算法学习", "value":"home"},
    {"key":"菜单3", "value":"home"},
    {"key":"菜单4", "value":"home"},
    {"key":"菜单5", "value":"home"},
    {"key":"菜单6", "value":"home"}
];
menuInitialize = function () {
    const dom = $('.home-menu');
    let htmlTxt = "<li class='home-menu-item home-menu-logo'>Algor</li>";
    for (let i = 0; i < menuArr.length; ++i) {
        const ele = menuArr[i];
        htmlTxt += "<li onclick='toMenuPage("+i+")' class='home-menu-item item-hover'>" + ele.key + "</li>";
    }
    dom.innerHTML = htmlTxt;
}

toMenuPage = function(idx) {
    const dom = $(".index-main-body");
    dom.src = "/" + menuArr[idx].value;
    // window.location.href = "http://localhost:8080/menu/" + menuArr[idx].value;
}