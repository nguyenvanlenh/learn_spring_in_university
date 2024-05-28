/**
 * @license Copyright (c) 2003-2023, CKSource Holding sp. z o.o. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
	config.filebrowserBrowseUrl = '/spring_mvc_1/ckfinder/ckfinder.html';
    config.filebrowserImageBrowseUrl = '/spring_mvc_1/ckfinder/ckfinder.html?type=Images';
    config.filebrowserUploadUrl = '/spring_mvc_1/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
    config.filebrowserImageUploadUrl = '/spring_mvc_1/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';
};
