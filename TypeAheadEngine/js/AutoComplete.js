var cursor = -1;
var totalResults = 0;
var resultArray = null;


String.prototype.trim = function() {
    return this.replace(/^\s+|\s+$/g, '');
}

function showResult(str, event) {
    var res = true;
    if (res = handleResultTraversal(event)) {
        var previousSearch = document.getElementById('searchInput');
        if (str.trim().length == 0) {
            previousSearch.value = str.trim();
            clearContent();
            return false;
        }
        if ((previousSearch.value.trim() != str.trim()) && (str.trim().length > 0)) {
            clearContent();
            if (window.XMLHttpRequest) { // code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            } else { //code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function() {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    handleResponse(xmlhttp.responseText);
                }
            };
            xmlhttp.open("POST", "search.do", true);
            xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xmlhttp.send("key=" + str.trim());
            previousSearch.value = str.trim();
        }
    }
    return res;
}

function handleResponse(result) {
    resultArray = eval('(' + result + ')');
    if (resultArray.length > 0) {
        var resultDiv = document.getElementById("livesearch");
        resultDiv.innerHTML = "";
        totalResults = resultArray.length;
        for (var i = 0; i < totalResults; i++) {
            var pTag = document.createElement("span");
            pTag.setAttribute("name", "result_" + i);
            pTag.setAttribute("id", "result_" + i);
            pTag.onclick = function() {
                update(this);
            };
            pTag.onmouseover = function() {
                applySelectionTheme(this);
            };
            pTag.style.fontWeight = "bold";
            pTag.style.cursor = "pointer";
            pTag.style.color = "#000000";
            pTag.innerHTML = resultArray[i].file;
            resultDiv.appendChild(pTag);
            var brk = document.createElement("br");
            resultDiv.appendChild(brk);
        }
        resultDiv.width = "30px";
        resultDiv.style.border = "thick solid #E8E8E8";
        resultDiv.style.visibility = "visible";
        resultDiv.style.color = "white";
        resultDiv.style.background = "white";
        resultDiv.style.display = "block";
    }
}

function clearContent() {
    var resultDiv = document.getElementById("livesearch");
    if (resultDiv) {
        resultDiv.style.visibility = "hidden";
        resultDiv.style.display = "none";
    }
    cursor = -1;
    totalResults = 0;
    resultArray = null;
}

function update(choice) {
    var inputBox = document.getElementById("searchBox");
    inputBox.value = choice.innerHTML;
    var index = choice.id.split("_")[1];
    var uniqueDropdown = document.getElementById("fileUniqueness");
    var uniqueDropdownHidden = document.getElementById("fileNameUniquenessHidden");
    /*var opts = uniqueDropdown.length;
    for (var i=0; i<opts; i++){
        if (uniqueDropdown.options[i].value == resultArray[parseInt(index)].isUnique){
            uniqueDropdown.options[i].selected = true;
            break;
        }
    }*/
    uniqueDropdown.value = resultArray[parseInt(index)].isUnique;
    uniqueDropdownHidden.value = resultArray[parseInt(index)].isUnique;
    clearContent();
    return false;
}

function handleResultTraversal(e) {

    var res = true;
    var isResultSetVisible = false;
    var keyCode = null;
    var resultDiv = document.getElementById("livesearch");
    if (resultDiv && resultDiv.style.visibility == "visible") {
        isResultSetVisible = true;
    }
    if (totalResults > 0 && isResultSetVisible) {
        (e.keyCode) ? (keyCode = e.keyCode) : (keyCode = e.which);
        switch (keyCode) {
            case 38:
                if (cursor > 0) {
                    cursor--;
                }
                applySelectionTheme();
                res = false;
                break;
            case 40:
                if (cursor < totalResults - 1) {
                    cursor++;
                }
                applySelectionTheme();
                res = false;
                break;
            case 32:
                selectAnOption();
                res = false;
                e.stopPropagation();
                e.preventDefault();
                break;
        }

    }
    return res;
}

function applySelectionTheme(obj) {
    if (obj) {
        for (var i = 0; i < totalResults; i++) {
            var selection = document.getElementById("result_" + i);
            if (selection.id == obj.id) {
                selection.style.color = "#C0C0C0";
            } else {
                selection.style.color = "#000000";
            }
        }
    } else {
        for (var i = 0; i < totalResults; i++) {
            var selection = document.getElementById("result_" + i);
            if (selection) {
                if (i == cursor) {
                    selection.style.color = "#C0C0C0";
                } else {
                    selection.style.color = "#000000";
                }
            }
        }
    }
}

function selectAnOption() {
    var selection = document.getElementById("result_" + cursor);
    if (selection) {
        update(selection);
    }
}

function captureReturn(e) {
    var keyCode = null;
    (e.keyCode) ? (keyCode = e.keyCode) : (keyCode = e.which);
    var object = e.target || e.srcElement;
    if (keyCode == 13) {
        if (object.id == 'searchBox' && cursor > -1) {
            update(document.getElementById("result_" + cursor));
        }
        return false;
    } else {
        return true;
    }
}

function monitorSearchDivState() {
    clearContent();
}
