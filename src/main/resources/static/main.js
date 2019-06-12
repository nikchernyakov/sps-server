$(document).ready(function () {

    $("#btn-upload").click(function () {

        var fd = new FormData();
        var files = $("#file-input")[0].files[0];
        fd.append('file', files);

        $.ajax("upload", {
            data: fd,
            method: "POST",
            contentType: false,
            processData: false
        }).done(function (res) {
            console.log(res);
        });
    });

});