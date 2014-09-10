<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.bar {
    height: 18px;
    background: green;
}
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="js/vendor/jquery.ui.widget.js"></script>
<script src="js/jquery.iframe-transport.js"></script>
<script src="js/jquery.fileupload.js"></script>
<script type="text/javascript">           
$(document).ready(function() {
    $('#upFile1 , #upFile2').fileupload({
        url : '/admin/upload', 
        dataType: 'json',
        //replaceFileInput: false,
        add: function(e, data){
            var uploadFile = data.files[0];
            if (!(/png|jpe?g|gif/i).test(uploadFile.name)) {
                alert('png, jpg, gif 만 가능합니다');
                goUpload = false;
            } else if (uploadFile.size > 5000000) { // 5mb
                alert('파일 용량은 5메가를 초과할 수 없습니다.');
            }
            data.submit();
        },
        progressall: function(e,data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .bar').css(
                'width',
                progress + '%'
            );
        },
        done: function (e, data) {
            var code = data.result.code;
            var msg = data.result.msg;
            if(code=='0') {
                alert(msg);
            } else {
                alert(code + " : " + msg);
            } 
        },
        fail: function(){
            alert("서버와 통신 중 문제가 발생했습니다");
        }
    });
}); 
</script> 
</head>
<body>
    <input type="file" name="fileData1" id="upFile1" />

    <div id="progress">
        <div class="bar" style="width: 0%;"></div>
    </div>
</body>
</html>
