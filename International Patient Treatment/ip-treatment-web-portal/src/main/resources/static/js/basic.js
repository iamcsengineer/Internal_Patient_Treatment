$(function() {
	$('.hide').hide();
})

function view(id) {
	$('#'+id).show();
	console.log($("#" + id).val());
	if ($("#" + id).val() == "") {
		
		return false;
	}
	else{
		return true;
	}
	
}

