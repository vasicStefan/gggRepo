<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("button").click(function(){
        $.get("http://localhost:8080/02Rest/rest/impl/kategorije", function(data, status){
            console.log("Data: " + data + "\nStatus: " + status);
	
    		for (var i = 0; i < data.length; i++) {
    			console.log(data[i]);
    			console.log(data[i].naziv);
			}        
        });
    });
});
</script>
</head>
<body>

<button>Send an HTTP GET request to a page and get the result back</button>

</body>
</html>