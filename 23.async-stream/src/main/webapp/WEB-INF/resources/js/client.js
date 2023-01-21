window.addEventListener('load', () => {
	console.log('Start JS');
	
	document.getElementById('streamTrigger').addEventListener('click', async () => {
		console.log('Starting Loading Stream Data...');
		
		const output = document.getElementById('output');
		output.innerText = '';
		
		const response = await fetch('http://localhost:8080/stream');
		const reader = response.body.pipeThrough(new TextDecoderStream).getReader();
		
		while(true) {
			const{value, done} = await reader.read();
			
			if(done) {
				break;
			}
			
			console.log(value);
			
			let item = document.createElement('li');
			item.innerText = value;
			
			output.appendChild(item);
		}
	});
	
	// If we use SSE, no need to async in callback of addEventListener
	document.getElementById('sseTrigger').addEventListener('click',() => {
		console.log('Connecting to SSE...');
		
		const output = document.getElementById('output');
		output.innerText = '';
	
		var eventSource = new EventSource('http://localhost:8080/sse');
		
		eventSource.onmessage = message => {
			let item = document.createElement('li');
			item.innerText = message.data;
			console.log(item);
			
			output.appendChild(item);
		};
		
		// When SSE is complete in @Controller class, it gets an error (Reconnect to SSE again).
		// We need to close the EventSource() object.
		eventSource.onerror = error => {
			console.log(error);
			eventSource.close();
		};

	});
	
})