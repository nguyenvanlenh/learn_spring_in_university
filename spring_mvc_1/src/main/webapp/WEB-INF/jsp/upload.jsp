<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


	<div class="container">
        <div class="upload-parent">
            <form method="post" action="/upload" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="file">Upload Ảnh</label>
                    <input type="file" class="form-control-file" id="file" name="file" required>
                </div>
                <button type="submit" class="btn btn-primary">Upload</button>
            </form>
        </div>
    </div>

