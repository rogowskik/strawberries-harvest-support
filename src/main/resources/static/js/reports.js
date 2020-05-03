var editStatus = {
    true: 'Zmień',
    false: 'Anuluj'
}

var reportInputState = true;
var reportButtonState = true;
var inputArr = ["sortedInput", "unsortedInput", "croppedInput", "kgInput"];
var reportUrl = 'rest/api/report';

function doOnReportsLoad() {
    console.log('here');
    setPeopleList();
}

function saveSingleReportClicked() {
//POST CALL
}

function editSingleReportClicked() {
if (reportInputState) {
        reportInputState = false;
    } else {
        reportInputState = true;
    }
    for (var sort in inputArr) {
            toggleReportDisable(inputArr[sort], reportInputState);
    }
    toggleReportDisable('saveSingleReportButton', reportInputState);
    changeReportEditStatus('editSingleReportButton', editStatus[reportInputState]);
}

function loadSingleReport() {
//GET CALL
}

function setPeopleList() {
    var temp = ['Kamil Rogowski', 'Magda Wojnarowicz', 'Patrycja Grad'];
    var ul = document.getElementById("peopleList");

    for (var i = 0; i < temp.length; i++) {
        var person = temp[i];

        var listItem = document.createElement("li");
        listItem.textContent = person;
        listItem.onclick = function () {
            var activeElements = document.getElementsByClassName('list-group-item active');
            for (var j = 0; j < activeElements.length; j++) {
                activeElements[j].classList.remove('active');
            }
            this.className = 'list-group-item active'
        };
        if (i === 0) {
            listItem.className = 'list-group-item active'
        } else {
            listItem.className = 'list-group-item';
        }

        ul.appendChild(listItem);
    }
}

function generateDaily() {
}

function generateWeekly() {
}
function toggleReportDisable(name, state) {
    document.getElementById(name).disabled = state;
}

function changeReportEditStatus(element, changedName) {
    document.getElementById(element).textContent = changedName;
}