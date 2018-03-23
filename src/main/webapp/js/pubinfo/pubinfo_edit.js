$(function() {
		var pageContext = $("#pageContext").val();
	
		$('#editform').ajaxForm();
		
		$("#editform").Validform({
			btnSubmit:"#subBtn",
			tiptype:1,
			ajaxPost:true,
			postonce:true,
			beforeSubmit: function(curform){
				var options = {
					url: pageContext + "/pubInfo/updatePubInfo",
					type: 'post',
					data: null,
					dataType: 'script',
					async: false,
			     	success: function() {
			     		parent.jBox.tip('修改成功', 'success');
			     		setTimeout('closeWin()',1000);
			     	},
					error: function(){
						parent.jBox.tip('修改失败', 'error');
					}
				};
				curform.ajaxSubmit(options);
				
				return false;
			}
		});
	});
function closeWin(){
	window.opener.location.href=window.opener.location.href;
	window.close();
	
}
/**
 * 点击专题单选框
 */
function showSbject(){
	//删除第三行
	$("#table tr:eq(3)").remove();  
	var newRow = '<tr><th><span class="F00">*</span>上传pad长图：736*106</th> <td>	<input type="file" name="longFile" value="上传图片" id="bannerFile" class="input_text"></td></tr>';
	$("#table tr:eq(2)").after(newRow);
	var newRow = ' <tr> <th><span class="F00">*</span>上传pad大图：768*314</th> <td><input type="file" name="bigFile" value="上传图片" id="bannerFile" class="input_text"> </td> </tr>';
	$("#table tr:eq(2)").after(newRow);
	var newRow = ' <tr> <th><span class="F00">*</span>上传pc图片：1000*150</th> <td><input type="file" name="bannerFile" value="上传图片" id="bannerFile" class="input_text"> </td> </tr>';
	$("#table tr:eq(2)").after(newRow);
}
/**
 * 点击专题单选框
 */
function showCase(){
	//删除3、4、5行
	$("#table tr:eq(3)").remove();  
	$("#table tr:eq(3)").remove();  
	$("#table tr:eq(3)").remove();  
	var newRow = '<tr><th><span class="F00">*</span>上传pad小图：140*106</th> <td>	<input type="file" name="smallFile" value="上传图片" id="bannerFile" class="input_text"></td></tr>';
	$("#table tr:eq(2)").after(newRow);
}