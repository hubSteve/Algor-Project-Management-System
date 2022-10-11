confirmDo = function (yesCallback, noCallBack) {
    popCover();

    const dom = popModal(100,200,"white",200,45);
    dom.innerHTML = "" +
        "<div class='index-modal-header'>" +
        "   <span class='modal-header-exp'>确认要执行此操作码?</span>" +
        "   <span onclick='closeBox()' class='modal-header-close'>×</span>" +
        "</div>" +
        "<div class='index-modal-body'></div>" +
        "<div class='index-modal-footer'>" +
        "    <button id='confirm-do' class='button-confirm'>确认</button>" +
        "    <button id='not-do' class='button-cancel'>取消</button>" +
        "</div>";

    $p('#confirm-do').onclick = function () {
        dom.innerHTML = "";
        yesCallback();
    }

    $p('#not-do').onclick = function () {
        dom.innerHTML = "";
        noCallBack();
    }
}

popCover = function () {
    $p(".index-pop-cover").style.display = "block";
}

closeCover = function () {
    $p(".index-pop-cover").style.display = "none";
}

// 关闭 modal
closeBox = function() {
    closeCover();
    closeModal();
}

popModalByResult = function (type, msg) {
    popCover();
    const dom = popModal(100,200,"white",200,45);
    dom.innerHTML = "" +
        "<div class='index-modal-header'>" +
        "   <span class='"+ type +"'></span>" +
        "   <span style='margin-left: 10px' class='modal-header-exp'>"+ msg +"</span>" +
        "   <span onclick='closeBox()' class='modal-header-close'>×</span>" +
        "</div>" +
        "<div style='text-align: center' class='index-modal-body'>" +
        "</div>" +
        "<div class='index-modal-footer'>" +
        "    <button id='confirm-do' class='button-confirm'>确认</button>" +
        "</div>";

    $p('#confirm-do').onclick = function () {
        closeBox();
    }
}

popModal = function(height, width, background, top, left) {
    const dom = $p("#index-modal");
    dom.style.height = height + "px";
    dom.style.width = width + "px";
    dom.style.background = background;
    dom.style.top = top + "px";
    dom.style.left = left + "%";
    dom.style.display = "block";
    return dom;
}

closeModal = function () {
    $p("#index-modal").innerHTML = "";
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

// 获取 class 元素列表
$s = function (text) {
    const name = text.slice(1, text.length);
    return document.getElementsByClassName(name);
}

$p = function (text) {
    const type = text.charAt(0);
    const name = text.slice(1, text.length);
    const parent = window.parent.document;
    switch (type) {
        case '.': return parent.getElementsByClassName(name)[0];
        case '#': return parent.getElementById(name);
        default: break;
    }
}