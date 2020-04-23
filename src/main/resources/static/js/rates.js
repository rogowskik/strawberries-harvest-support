var editStatus = {
	true: 'Zmień',
	false: 'Anuluj'
}
var inputState = true;
var buttonState = true;

function editRateClicked() {
	var sortArr = ["sorted", "unsorted", "cropped", "kilogram"];
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

function saveRateClicked() {
	testPost();
}

function toggleDisable(name, state) {
	document.getElementById(name).disabled = state;
}

function changeEditStatus(element, changedName) {
	console.log(element);
	document.getElementById(element).textContent = changedName;
}

function testPost() {
	var json = {
		"date": new Date(),
		"sorted": 1,
		"unsorted": 2,
		"cropped": 199,
		"kg": 8
	}
	var http = new XMLHttpRequest();
	var url = 'rest/api/rate';
	var params = 'orem=ipsum&name=binny';
	http.open("POST", url);

	//Send the proper header information along with the request
	http.setRequestHeader('Content-type', 'application/json');

	http.onreadystatechange = function () { //Call a function when the state changes.
		if (http.readyState == 4 && http.status == 200) {
			alert(http.responseText);
		}
	}
	http.send(JSON.stringify(json));
}