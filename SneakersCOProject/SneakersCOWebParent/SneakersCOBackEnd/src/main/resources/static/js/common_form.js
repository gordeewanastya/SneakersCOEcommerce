$(document).ready(function () {
    $("#buttonCancel").on("click", function () {
        window.location = moduleURL;
    });

    $("#fileImage").change(function (){
        fileSize = this.files[0].size;

        if (fileSize > 1048576) { //if is > than 1 MB
            this.setCustomValidity("You must choose an image less than 1MB!");
            this.reportValidity(); //prevent the form from being submitted and show the error message
        } else {
            this.setCustomValidity("");
            showImageThumbnail(this);
        }
    });
});

function showImageThumbnail(fileInput){
    var file = fileInput.files[0];
    var reader = new FileReader();
    reader.onload = function (e){
        $("#thumbnail").attr("src", e.target.result);
    };

    reader.readAsDataURL(file);
}