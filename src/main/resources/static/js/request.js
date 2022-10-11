getHttp = function (url, params, dataType, method) {
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open(method, url, true);
    let application;
    if (dataType === 'kv') {
        application = "application/x-www-form-urlencoded";
    } else {
        application = "application/json;charset=UTF-8";
    }
    xmlHttp.setRequestHeader("Content-type", application);
    xmlHttp.send(params);
    return xmlHttp;
}