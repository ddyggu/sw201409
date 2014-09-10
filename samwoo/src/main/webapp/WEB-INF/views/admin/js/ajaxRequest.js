/**
 * 
 */

function deleteFile(num, bbsId) {
	
	var fileNum = num;
	var status = confirm("삭제하시겠습니까?");
	if(status) {
			$.ajax({
				url : "/fileDelete?num="+fileNum+"&bbsId="+bbsId,
				type : "GET",
				success : function(data, status, xhr) {
					alert("삭제가 완료되었습니다.");
					$('#fileItem'+ fileNum).fadeOut(1000);
					
				},
				error : function(response, status, error) {
					alert("오류!");
			}
		});
	}
}