function moveit(img, newtop, newleft){
    var image = document.getElementById(img).style;
    image.top = newtop + 'px';
    image.left = newleft + 'px';
}