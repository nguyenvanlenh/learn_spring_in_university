<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div style="min-height: 700px">
    <h1>Hello Spring MVC</h1>
    <div class="form-group col-md-12">
        <label class="control-label">Nội dung bài viết</label>
        <textarea class="form-control" id="content" name="content" height="90"></textarea>
    </div>

    <!-- Include CKEditor library -->
    <script src="https://cdn.ckeditor.com/4.16.2/full/ckeditor.js"></script>

    <!-- Include CKFinder library -->
    <script src="<c:url value="/ckeditor/ckeditor.js"/>"></script>

    <script>
        CKEDITOR.replace(
            'content',
            {
                filebrowserBrowseUrl: '/spring_mvc_1/ckfinder/ckfinder.html',
                filebrowserImageBrowseUrl: '/spring_mvc_1/ckfinder/ckfinder.html?type=Images',
                filebrowserUploadUrl: '/spring_mvc_1/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',
                filebrowserImageUploadUrl: '/spring_mvc_1/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images'
            });

        function openCKFinder() {
            CKFinder.popup({
                chooseFiles: true,
                width: 800,
                height: 600,
                onInit: function (finder) {
                    finder.on('files:choose', function (evt) {
                        var file = evt.data.files.first();
                        var output = document.getElementById('output');
                        output.innerHTML = '<p>Selected file: ' + file.getUrl() + '</p>';
                    });

                    finder.on('file:choose:resizedImage', function (evt) {
                        var output = document.getElementById('output');
                        output.innerHTML = '<p>Resized image: ' + evt.data.resizedUrl + '</p>';
                    });
                }
            });
        }
    </script>
</div>
