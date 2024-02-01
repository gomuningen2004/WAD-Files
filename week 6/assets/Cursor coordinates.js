function findit(evt){
    document.getElementById("xcoord1").value = evt.clientX;
    document.getElementById("ycoord1").value = evt.clientY;
    document.getElementById("xcoord2").value = evt.screenX;
    document.getElementById("ycoord2").value = evt.screenY;
}