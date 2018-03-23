var pageContext;
var pageSize = 10;
$(function() {
    pageContext = $("#pageContext").val();
    var oTable = $('#list_info')
        .dataTable(
            {
                "bProcessing" : true,
                "bServerSide" : true,
                "sServerMethod" : 'POST',
                "sAjaxSource" : pageContext
                + "/popular/selectByPage",
                "bPaginate" : true,
                "bSort" : false,
                "bFilter" : false,
                "bJQueryUI" : false,
                "sPaginationType" : "full_numbers",
                "sDom" : 'rt <"dongao_page"flpi>',
                "iDisplayLength" : 10,
                "aaData" : "list",
                "aLengthMenu" : [ [ 10, 50, 100 ], [ 10, 50, 100 ] ],
                "aoColumns" : [
                    {
                        "mDataProp" : "title"
                    },
                    {
                        "mDataProp" : "writer"
                    },
                    {
                        "mDataProp" : "uploadTime"
                    },
                    {
                        "mDataProp" : "periods"
                    },
                    {
                        "mDataProp" : "userName"
                    },
                    {
                        "mDataProp" : "opt",
                        "bVisible" : true,
                        "fnCreatedCell" : function(nTd, sData,
                                                   oData) {
                            var text = "<a   href='javascript:;'  onclick=\"edit('"
                                + oData.popularId
                                + "')\" class=\"oicon\" title=\"修改\">修改</a>";
                            text += "||<a   href='javascript:;'  onclick=\"del('"
                                + oData.popularId
                                + "')\"  class=\"oicon o2 marAuto\" title=\"删除\">删除</a>";
                            $(nTd).html(text);
                        }
                    }
                ],
                "oLanguage" : {
                    "sLengthMenu" : "每页 _MENU_ 条",
                    "sZeroRecords" : "",
                    "sInfo" : "当前从 _START_ 到 _END_ 条,共 _TOTAL_ 条记录",
                    "sInfoEmpty" : "没有找到记录",
                    "oPaginate" : {
                        "sFirst" : "首页",
                        "sPrevious" : "上一页",
                        "sNext" : "下一页",
                        "sLast" : "尾页"
                    }
                },
                "fnServerParams" : function(aoData) {
                    if ($("#title").val() != '') {
                        aoData.push({
                            'name' : 'title',
                            'value' : $("#title").val()
                        });
                    }

                }
            });


    $("#searchDiv").click(function(evt){
        search();
    });
})

function del(id) {
    var submit = function(v, h, f) {
        if (v == 'ok') {
            $.ajax({
                type : "post",
                url : pageContext + "/popular/deletePopular",
                dataType : "json",
                data : {
                    popularId : id
                },
                success : function(data) {
                    jBox.tip("删除成功", "success");
                    showPop(); //关闭窗体
                    search(); //重新查询


                },
                error : function() {
                    jBox.info("删除失败", "提示");
                }
            });
        }
        return true;
    };

    $.jBox.confirm("您确定要删除吗？", "提示", submit);
}
/**
 * 编辑关键字
 */
function edit(id) {
    var iTop = (window.screen.availHeight-30-700)/2;
    //获得窗口的水平位置
    var iLeft = (window.screen.availWidth-10-1024)/2;
    window.open (pageContext + "/popular/editPopular?popularId="+id,'newwindow','height=700,width=1024,top='+iTop+',left='+iLeft+', toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');


}

/**
 * 添加关键字
 */
$("#add").on("click", function() {
    var iTop = (window.screen.availHeight-30-700)/2;
    //获得窗口的水平位置
    var iLeft = (window.screen.availWidth-10-1024)/2;
    window.open (pageContext + "/popular/addPopular",'newwindow','height=700,width=1024,top='+iTop+',left='+iLeft+', toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');

});

/**
 * 根据条件查询课程
 *
 * @param currentPage
 * @param action
 * @return
 */
function search() {
    var oTable = $('#list_info').dataTable();
    oTable.fnPageChange("first", true);
}
/**
 * 关闭iframe
 *
 * @return
 */
function showPop() {
    $.jBox.close(true);
}
