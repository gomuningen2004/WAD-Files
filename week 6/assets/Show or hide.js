function toggleImage() {
    var imageContainer = document.getElementById("imageContainer");
    var image = document.getElementById("myImage");

    if (imageContainer.style.display === "none") {
        imageContainer.style.display = "block";
        image.src = "../assets/@Getsesko.jpeg";
    } else {
        imageContainer.style.display = "none";
    }
}