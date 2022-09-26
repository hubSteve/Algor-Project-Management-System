getHttp = function (url, params, dataType, method) {
    const xmlHttp = new XMLHttpRequest();
    xmlHttp.open(method, url, true);
    let application, param;
    if (dataType === 'kv') {
        application = "application/x-www-form-urlencoded";
    } else {
        application = "application/json;charset=UTF-8";
    }
    param = params;
    xmlHttp.setRequestHeader("Content-type", application);
    xmlHttp.send(param);
    return xmlHttp;
}