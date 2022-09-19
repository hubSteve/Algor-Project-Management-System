window.onload = function () {
    init();
}
function init() {
    menuInitialize();
    dataInitialize();
}

// 菜单初始化
menuInitialize = function () {
    const menuArr = ["首页", "菜单1", "菜单2", "菜单3", "菜单4", "菜单5", "菜单6"];
    const dom = $('.home-menu');
    let htmlTxt = "<li class='home-menu-item home-menu-logo'>Algor</li>";
    for (const ele of menuArr) {
        htmlTxt += "<li class='home-menu-item item-hover'>" + ele + "</li>";
    }
    dom.innerHTML = htmlTxt;
}

dataInitialize = function () {
    const dom = $("#table-content");
    let htmlText = "";
    let companyName = "中国电信科技有限公司（Chinatelecom）";
    for (let i = 0; i < 100; ++i) {
        htmlText += "<tr><td>"+ (i + 1) +"</td><td>oms</td>"
            + txtEllipses(companyName) +
            "<td>"+ (new Date().toLocaleDateString()) +"</td>" +
            "<td>"+ (new Date().toLocaleDateString()) +"</td>" +
            "<td title='点击通过窗口预览' class='table-td-pop'>...?</td>" +
            "<td>"+ finishOrInProgressMark(i) +"</td>" +
            "<td>......？</td><td>" +
            "<a href=\"#\">修改</a></td></tr>";
    }
    dom.innerHTML = htmlText;
}

finishOrInProgressMark = function (num) {
    if ((num & 1) === 0) {
        return "<button class='finish-mark'>完成</button>"
    }
    return "<button class='in-progress-mark'>进行中</button>"
}

createProjectTask = function () {
    const dom = $(".index-pop-cover");
    dom.style.display = "block";
    buildModal();
}

buildModal = function () {
    const dom = $("#index-modal-create");
    dom.style.display = "block";
    dom.innerHTML = "" +
        "<div class='index-modal-header'>" +
        "   <span class='modal-header-exp'>新建项目任务</span>" +
        "   <span onclick='closeModal()' class='modal-header-close'>×</span>" +
        "</div>" +
        "<div class='index-modal-body'>" +
        "   <form>" +
        "       <p class='form-item'>" +
        "          <label for='project-name'>项目名称</label>" +
        "          <input id='project-name' />" +
        "       </p> " +
        "       <p class='form-item'>" +
        "          <label for='company-name'>所属公司</label>" +
        "          <input id='company-name' />" +
        "       </p> " +
        "       <p class='form-item'>" +
        "          <label for='start-time'>开始时间</label>" +
        "          <input type='date' id='start-time' />" +
        "       </p> " +
        "       <p class='form-item'>" +
        "          <label for='end-time'>结束时间</label>" +
        "          <input type='date' id='end-time' />" +
        "       </p> " +
        "       <p class='form-item'>" +
        "          <label for='progress'>当前进度</label>" +
        "          <input id='progress' />" +
        "       </p> " +
        "       <p class='form-item'>" +
        "          <label for='tech-points'>技术要点</label>" +
        "          <textarea id='tech-points'></textarea>" +
        "       </p> " +
        "   </form>" +
        "</div>" +
        "<div class='index-modal-footer'>" +
        "    <button class='button-confirm'>确认</button>" +
        "    <button onclick='closeModal()' class='button-cancel'>取消</button>" +
        "</div>";
}

closeModal = function() {
    $("#index-modal-create").style.display = "none";
    $(".index-pop-cover").style.display = "none";
}

randomColor = function () {

}

// 文本超长截取
function txtEllipses(txt) {
    const title = txt;
    if (txt.length > 10) {
        txt = txt.slice(0, 10);
    }
    return "<td title='" + title + "'>"+ txt +" ···</td>";
}

// dom 获取函数
$ = function (text) {
    const type = text.charAt(0);
    const name = text.slice(1, text.length);
    switch (type) {
        case '.': return document.getElementsByClassName(name)[0];
        case '#': return document.getElementById(name);
        default: break;
    }
}