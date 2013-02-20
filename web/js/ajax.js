function populate_cities() {

	var state = document.getElementById("state");
	var stateName = state.options[state.selectedIndex].value;

	if(stateName != "Select") {

		new Ajax.Request("/AjaxSample/cityList", {
			method : "post",
			parameters : {
				stateValue : stateName
			},

			onComplete : function(res){
				var list = eval("("+res.responseText+")");

				clear_cities();

				for(var i=0; i<list.length; i++){
					$("#city").append(new Option(list[i], false));
				}
			}
		});
	}else{
		clear_cities();
	}
}

function clear_cities() {

	$('#city')
	.find('option')
	.remove()
	.end()
	.append('<option>--Choose City--</option>');
}

var listItem = null;

function show_items() {

	new Ajax.Request("/AjaxSample/showItems", {
		method : "get",

		onComplete : function(res){
			listItem = eval("("+res.responseText+")");
			var output='<ul>';
			for (var i=0; i<listItem.length; i++){
				output+='<li>';
				output+=listItem[i];
				output+='</li>';
			}
			output+='</ul>';
			document.getElementById("list").innerHTML=output;
		}
	});
}

(function($,W,D){
	
	var errorMessage = {};

	errorMessage.util = {
			
		validateForm: function()
			{
			
			$("#form1").validate({
				rules: {
					name: {
						required: true,
						minlength: 3
					},
					age: {
						required: true,
						number: true,
						maxlength: 3
					},
					email: {
						required: true,
						email: true
					},
					item: {
						required: true,
						showCheck: true,
						itemCheck: true
					}
				},
				messages: {
					name: {
						required: "Please enter your name",
						minlength: "Enter atleast 3 characters"
					},
					age: {
						required: "Please enter your age",
						number: "Enter numbers only",
						maxlength: "Age can't be more than 3 digit"
					},
					email: "Please enter a valid email address",
					item: {
						required: "Please see the item list and enter it"
					}
				},
				/*submitHandler: function(form) {
					form.submit();
				}*/
			});
		}
	}
	
	$(D).ready(function($) {
		
		$.validator.addMethod("itemCheck", 			
				function validateItems() {
					var itemName = document.getElementById("itemId").value;
					var flag = false;
					
					if(listItem != null){
						for(var i=0; i<listItem.length; i++){
						
							if(listItem[i] == itemName)
								flag = true;
						}
					}
					
					if(flag == false)
						return false;
					else
						return true;
				},
				"Item is not in the List"
		);
		
		$.validator.addMethod("showCheck", 			
				function () {
					if(listItem == null)
						return false;
					else
						return true;
				},
				"Please see the item list first"
		);
		
		errorMessage.util.validateForm();
	});
	
})(jQuery, window, document);