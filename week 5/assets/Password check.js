function passcheck() {
    var x = document.getElementById("pass1").value;
    var y = document.getElementById("pass2").value;

    if (x === "" || y === "") {
        alert("Please fill both the fields");
        return;
    }
    
    if (x === y) {
        alert("Passwords match!");
    } else {
        alert("Passwords do not match!");
    }

}