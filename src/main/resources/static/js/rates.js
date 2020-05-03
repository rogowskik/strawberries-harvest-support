var editStatus = {
    true: 'Zmień',
    false: 'Anuluj'
}
    var daysOfWeek = {
        sat: 1,
        sun: 2,
        mon: 3,
        tu: 4,
        wed: 5,
        th: 6,
        fri: 7
    };
var inputState = true;
var buttonState = true;
var sortArr = ["sorted", "unsorted", "cropped", "kg"];
var rateUrl = 'rest/api/rate';

function editRateClicked() {
    if (inputState) {
        inputState = false;
    } else {
        inputState = true;
    }
    for (var sort in sortArr) {
        for (var i = 0; i < 7; i++) {
            var index = i + 1;
            toggleDisable(sortArr[sort] + index, inputState);
        }
    }
    toggleDisable('saveRateButton', inputState);
    changeEditStatus('editRateButton', editStatus[inputState]);
}

function doOnRatesLoad() {}

function saveRateClicked() {
    for (day in daysOfWeek) {
        var obj = new Object();
        var index = daysOfWeek[day];
        for (var sort in sortArr) {
        console.log(sortArr[sort] + index);
            obj[sortArr[sort]] = document.getElementById(sortArr[sort] + index).innerHTML;
            obj.date = day;
            //doPost(obj,rateUrl);
        }
    }
    //testPost();

}

function toggleDisable(name, state) {
    document.getElementById(name).disabled = state;
}

function changeEditStatus(element, changedName) {
    document.getElementById(element).textContent = changedName;
}