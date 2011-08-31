// This is a test harness for your module
// You should do something interesting in this harness 
// to test out the module and to provide instructions 
// to users on how to use it by example.


// open a single window
var window = Ti.UI.createWindow({
	backgroundColor:'white'
});
var label = Ti.UI.createImageView();
window.add(label);
window.open();

// TODO: write your module tests here
var jpglib = require('com.cashlo.jpglib');

Titanium.Media.showCamera({
	success: function(event){
		label.image = jpglib.compress(event.media);
	},
	cancel: function() {

	},
	error: function(error) {
		// create alert
		var a = Titanium.UI.createAlertDialog({
			title:'Camera'
		});
		// set message
		if (error.code == Titanium.Media.NO_CAMERA) {
			a.setMessage('Device does not have video recording capabilities');
		} else {
			a.setMessage('Unexpected error: ' + error.code);
		}
		// show alert
		a.show();
	}
});

