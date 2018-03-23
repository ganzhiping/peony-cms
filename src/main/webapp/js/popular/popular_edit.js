var pageContext;
$(function() {
    pageContext = $("#pageContext").val();

    $('#editform').ajaxForm();

    $("#editform").Validform({
        btnSubmit:"#subBtn",
        tiptype:1,
        ajaxPost:true,
        postonce:true,
        beforeSubmit: function(curform){
            var options = {
                url: pageContext + "/popular/updatePopular",
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
    f_mask1();
});




function getValue(){
    var userIds ="";
    var userNames="";
    $("#contentDiv").children("div").children("span").children("input").each(function(){
        //$("input [name='checkboxs']").each(function(){
        if($(this).is(":checked")){ //jQuery方式判断
            userIds +=$(this).val() +",";
            userNames += $(this).next("b").html()+",";
        }
    })
    $("#userId").val(userIds.substring(0,userIds.length-1));
    $("#s_f_btn_1").val(userNames.substring(0,userNames.length-1));
    $(".s_f_mask1").hide();
}


//打开用户弹出框
function f_mask1(){
    $("#s_f_btn_1").click(function(){
        $.ajax({
            type:"post",
            url:pageContext + "/popular/userList",
            dataType:"json",
            success:function (data) {

                var json = eval(data);
                var html="";
                var count=2;
                for(var i=0;i<json.length;i++){
                    if(count == 2){
                        html+='<div> ';
                        count =0;
                    }
                    html+='<span><input type="checkbox" name="checkboxs" value="'+json[i].userId+'">'+
                        '<b>'+json[i].loginName+'</b></span>';
                    if(count == 1){
                        html+=' </div>';
                    }
                    count ++;
                }
                $("#contentDiv").append(html);
                $(".s_f_mask1").show();
            }
        })

    });
    $(".s_f_btn_close").click(function(){
        $(".s_f_mask1").hide();
    });
}
function closeWin(){
    window.opener.location.href=window.opener.location.href;
    window.close();

}