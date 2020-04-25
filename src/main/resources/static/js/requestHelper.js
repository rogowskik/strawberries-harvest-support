
function doPost(params, url) {
console.log(params,url);
	params = {
		"date": new Date(),
		"sorted": 1,
		"unsorted": 2,
		"cropped": 199,
		"kg": 8
	}
	var http = new XMLHttpRequest();
	//var url = 'rest/api/rate';
	//var params = 'orem=ipsum&name=binny';
	http.open("POST", url);

	//Send the proper header information along with the request
	http.setRequestHeader('Content-type', 'application/json');

	http.onreadystatechange = function () { //Call a function when the state changes.
		if (http.readyState == 4 && http.status == 200) {
			alert(http.responseText);
		}
	}
	http.send(JSON.stringify(params));
}