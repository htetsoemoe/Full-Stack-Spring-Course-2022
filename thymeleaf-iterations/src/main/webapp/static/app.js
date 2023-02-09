document.addEventListener('DOMContentLoaded', () => {
	// if upload button was clicked
	document.querySelector("#uploadBtn").addEventListener('click', () => {
		document.querySelector("#uploadInput").click();
	});
	
	// if client upload the multiple files
	document.querySelector("#uploadInput").addEventListener('change', () => {
		document.querySelector("#uploadForm").submit();
	});
});