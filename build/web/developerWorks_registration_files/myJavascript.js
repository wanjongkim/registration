var previousInput;
var lastNameFilled = false;
var firstNameFilled = false;
var password = '';
var repassword = '';
var req;

function validate(input) {
	
	switch(input.name) {
		case 'CountryOfRes': {
			var countryInput = input.value;
				
				var url = "http://localhost:8080/Servlet/TestServlet?" + "selected=" + countryInput;
				req = new XMLHttpRequest();
				
				req.onreadystatechange = function() {
					if(req.readyState == 4 && req.status == 200) {
						var countrySpan = document.getElementById('countrySpan');
					
						if(document.getElementById('countryError') != null) {
							var error = document.getElementById("countryError");
							error.parentNode.removeChild(error);
						}
						
						var node = document.createElement("SPAN");
						var text = document.createTextNode(req.responseText);
						node.setAttribute("id", "countryError");
						node.style.color = "red";
						node.appendChild(text);
						countrySpan.appendChild(node);
					}
				}
					
				
				req.open("Get", url, true);
				req.send();
			
			
			break;
		}
	}
}

function securityFunction(input) {
	var x = document.getElementById('security_error');
	if(input.value == '') {
		x.style.display = "inline";
	}
	else {
		x.style.display = "none";
	}
}

function checkRegularInput(input) {
	
	switch(input.name) {
		case 'FName': {
			var x = document.getElementById('NameError');
			if(FName.value == '') {
				x.style.display = "inline";
				x.innerHTML = "The input for first name is missing";
				firstNameFilled = false;
			}
			else {
				if(lastNameFilled) {
					x.style.display = "none";
				}
				else {
					x.style.display = "inline";
					x.innerHTML = "The input for last name is missing";
				}
				firstNameFilled = true;
			}
			previousInput = x;
			break;
		}
		case 'LName': {
			var x = document.getElementById('NameError');
			if(LName.value == '') {
				x.style.display = "inline";
				x.innerHTML = "The input for last name is missing";
				lastNameFilled = false;
			}
			else {
				if(firstNameFilled) {
					x.style.display = "none";
				}
				else {
					x.style.display = "inline";
					x.innerHTML = "The input for first name is missing";
				}
				lastNameFilled = true;
			}
			previousInput = x;
			break;
		}
		case 'UserID': {
			var email_input = input.value;
			
			var x = document.getElementById('userid_error');
			var sign = email_input.indexOf('@');
			if(sign == -1) {
				x.style.display = "inline";
			}
			else {
				x.style.display = "none";
			}
			break;
		}
		case 'Password': {
			var password_input = input.value;
			var x = document.getElementById('password_error');
			if(password_input.length < 8) {
				x.innerHTML = "The password you entered is not valid"
				x.style.display = "inline";
				passwordFilledCorrectly = false;
			}
			else {
				x.style.display = "none";
				password = password_input;
				if(password != repassword) {
					x.innerHTML = "The passwords are not the same";
					x.style.display = "inline";
				}
				else {
					x.style.display = "none";
				}
			}
			break;
		}
		case 'RePassword': {
			var repassword_input = input.value;
			var x = document.getElementById('password_error');
			repassword = repassword_input;
			if(password != repassword) {
				x.innerHTML = "The passwords are not the same";
				x.style.display = "inline";
			}
			else {
				x.style.display = "none";
			}
			break;
		}
		case 'SecurityAns': {
			var security_input = input.value;
			var x = document.getElementById('security_error');
			if(security_input.length < 0) {
				x.style.display = "inline";
			}
			else {
				x.style.display = "none";
			}
			break;
		}
		case 'CountryOfRes': {
			var country_input = input.value;
			var x = document.getElementById('country_error');
			if(country_input == '') {
				x.style.display = "inline";
			}
			else {
				x.style.display = "none";
			}
			break;
		}
		case 'Language': {
			
			var city_input = input.value;
			var x = document.getElementById('language_error');
			if(city_input == '') {
				x.style.display = "inline";
				
			}
			else {
				x.style.display = "none";
			}
			break;
		}
		case 'SecurityQues': {
			var question_input = input.value;
			var x = document.getElementById('security_error2');
			if(question_input == '') {
				x.style.display ="inline";
			}
			else {
				x.style.display = "none";
			}
			break;
		}
		case 'SecurityAns': {
			window.alert("CRAP WORKS");
			var answer_input = input.value;
			var x = document.getElementById('security_error');
			if(answer_input == '') {
				window.alert('someroajs');
				x.style.display = "inline";
			}
			else {
				x.style.display = "none";
			}
			break;
		}
		case 'alias': {
			var alias_input = input.value;
			var x = document.getElementById('display_error');
			if(alias_input == '' || alias_input.length < 3 || alias_input.length > 31) {
				x.style.display = "inline";
			}
			else {
				x.style.display ="none";
			}
			break;
		}
		default: {
			break;
		}
	}
}