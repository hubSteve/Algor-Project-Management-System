window.onload = function () {
    getData();
}


// 查询数据
getData = function () {
    const url = "http://localhost:8080/pro/findAll"
    const proInfo = {};
    const http = getHttp(url, JSON.stringify(proInfo), "json", "POST");
    http.onreadystatechange = function () {
        if (http.readyState === 4 && http.status === 200) {
            const res = JSON.parse(http.responseText);
            if (res.code === 200) {
                dataInitialize(res.obj);
            } else {
                popModalByResult("failed-mark", "查询失败！")
            }
        }
    }
}

// 数据渲染
dataInitialize = function (dataList) {
    const dom = $("#table-content");
    let htmlText = "";
    for (let i = 0; i < dataList.length; ++i) {
        const data = dataList[i];
        htmlText += "<tr><td>"+ (i + 1) +"</td><td>"+ data.proName +"</td>"
            + txtEllipses(data.companyName) +
            "<td>"+ (data.createTime) +"</td>" +
            "<td>"+ (data.deadline) +"</td>" +
            "<td title='点击通过窗口预览' class='table-td-pop'><button class='question-mark'>?</button></td>" +
            "<td>"+ progressMark(data.deadline, data.overTime, data.createTime) +"</td>" +
            "<td><button class='question-mark'>?</button></td><td>" +
            "<div class='button-group'><a href='#' onclick='buildModalForUpdate("+ JSON.stringify(data) +")'>修改</a>" +
            "<a href='#' onclick='deleteProInfo("+ data.id +")'>删除</a></div>" +
            "</td></tr>";
    }
    dom.innerHTML = htmlText;
}

// 进度渲染
progressMark = function (deadline, overTime, beginTime) {
    const cur = new Date();
    const begin = new Date(beginTime);
    const overMill = overTime ? new Date(overTime).getTime() : null;
    const deadlineTime = new Date(deadline);
    if (cur.getTime() >= deadlineTime.getTime() || (overMill && cur.getTime() >= overMill)) {
        return "<button style='background: greenyellow' class='finish-mark'>完成</button>"
    }
    let background;
    if (begin.getTime() > cur.getTime()) {
        background = "white";
    } else {
        const daysOfMonth = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
        const curYear = cur.getFullYear();
        if ((curYear % 100 === 0 && curYear % 400 === 0) || (curYear % 100 !== 0 && curYear % 4 === 0)) {
            daysOfMonth[2] = 29;
        }
        const monthDif = deadlineTime.getMonth() - begin.getMonth();
        const beginDay = begin.getDate(), deadDay = deadlineTime.getDate();
        let total, percent;
        if (monthDif === 0) {
            total = deadlineTime.getDate() - begin.getDate();
            percent = ((cur.getDate() - begin.getDate()) / total) * 100;
        } else {
            total = daysOfMonth[begin.getMonth()] - beginDay + deadDay;
            for (let i = begin.getMonth() + 1; i <= deadlineTime.getMonth() - 1; ++i) {
                total += daysOfMonth[i];
            }
            if (cur.getMonth() === begin.getMonth()) {
                percent = (cur.getDate() - beginDay) / total * 100;
            } else {
                let progress = daysOfMonth[begin.getMonth()] - beginDay + cur.getDate();
                for (let i = begin.getMonth() + 1; i <= cur.getMonth() - 1; ++i) {
                    progress += daysOfMonth[i];
                }
                percent = progress / total * 100;
            }
        }
        background = "linear-gradient(to right, greenyellow "+ percent +"%, white 0)";
    }
    return "<button style='background: "+ background +"' class='in-progress-mark'>进行中</button>"
}

deleteProInfo = function (id) {
    confirmDo(
        function () {
            closeBox();
            popModalByResult("failed-mark", "操作失败!");
            const url = "http://localhost:8080/pro/delete/"+ id;
            const http = getHttp(url, null, "kv", "GET");
            http.onreadystatechange = function () {
                if (http.readyState === 4 && http.status === 200) {
                    const res = JSON.parse(http.responseText);
                    if (res.code === 200) {
                        popModalByResult("success-mark", "恭喜！操作成功!");
                        getData();
                    } else {
                        popModalByResult("failed-mark", "操作失败!");
                    }
                }
            }
        },
        function () {
            closeBox();
        }
    )

}

createProjectTask = function () {
    buildModalForCreate();
}

buildModalForCreate = function () {
    buildModal(null);
}

buildModalForUpdate = function (data) {
    buildModal(data);
}

buildModal = function (data) {
    popCover();
    const isCreate = data === null;
    const title = isCreate ? "新建项目任务" : "修改项目任务";
    const dom = popModal(500, 500, "cornsilk", 10, 35);
    dom.innerHTML = "" +
        "<div class='index-modal-header'>" +
        "   <span class='modal-header-exp'>"+ title +"</span>" +
        "   <span onclick='closeBox()' class='modal-header-close'>×</span>" +
        "</div>" +
        "<div class='index-modal-body'>" +
        "   <form>" +
        "       <p class='form-item'>" +
        "          <label for='proName'>项目名称</label>" +
        "          <input id='proName' value='"+ (isCreate ? '' : data.proName) +"'/>" +
        "       </p> " +
        "       <p class='form-item'>" +
        "          <label for='companyName'>所属公司</label>" +
        "          <input id='companyName' value='"+ (isCreate ? '' : data.companyName) +"'/>" +
        "       </p> " +
        "       <p class='form-item'>" +
        "          <label for='createTime'>开始时间</label>" +
        "          <input type='date' id='createTime' value='"+ (isCreate ? '' : data.createTime) +"'/>" +
        "       </p> " +
        "       <p class='form-item'>" +
        "          <label for='deadline'>交付时间</label>" +
        "          <input type='date' id='deadline' value='"+ (isCreate ? '' : data.deadline) +"' />" +
        "       </p> " +
        "       <p style='display: "+ (isCreate ? 'none' : '') +"' class='form-item'>" +
        "          <label for='overTime'>结束时间</label>" +
        "          <input type='date' id='overTime' />" +
        "       </p> " +
        "       <p class='form-item'>" +
        "          <label for='techPoints'>技术要点</label>" +
        "          <textarea id='techPoints'>"+ (isCreate ? '' : data.techPoints) +"</textarea>" +
        "       </p> " +
        "   </form>" +
        "</div>" +
        "<div class='index-modal-footer'>" +
        "    <button onclick='submitProjectInfo("+ (isCreate ? null : JSON.stringify(data)) +")' class='button-confirm'>确认</button>" +
        "    <button onclick='closeBox()' class='button-cancel'>取消</button>" +
        "</div>";
}

submitProjectInfo = function (data) {
    if (!data) {
        collectProjectInfo("http://localhost:8080/pro/create", null);
    } else {
        collectProjectInfo("http://localhost:8080/pro/update", data);
    }
}

collectProjectInfo = function (url, data) {
    const clz = $s(".form-item");
    let proInfo = {};
    for (const d of clz) {
        if (d instanceof HTMLElement) {
            for (const e of d.childNodes) {
                if (isFormItemElement(e)) {
                    if (e.id !== 'progress') {
                        if (data) { data[e.id] = e.value; }
                        else { proInfo[e.id] = e.value; }
                        break;
                    }
                }
            }
        }
    }
    request(url, data ? data : proInfo, "json", "POST");
}

isFormItemElement = function (e) {
    return e instanceof HTMLElement &&
        (
            e instanceof HTMLInputElement ||
            e instanceof HTMLTextAreaElement
        );
}

// 请求后端
request = function (url, entity, dataType, method) {
    const http = getHttp(url, JSON.stringify(entity), dataType, method);
    let ret;
    http.onreadystatechange = function () {
        if (http.readyState === 4 && http.status === 200) {
            const res = JSON.parse(http.responseText);
            closeBox();
            if (res.code === 200) {
                popModalByResult("success-mark", "恭喜！操作成功!")
                getData();
            } else {
                popModalByResult("failed-mark", "操作失败!")
            }
        }
    }
}

// 文本超长截取
function txtEllipses(txt) {
    const title = txt;
    if (txt.length > 10) {
        txt = txt.slice(0, 10) + " ...";
    }
    return "<td title='" + title + "'>"+ txt +"</td>";
}