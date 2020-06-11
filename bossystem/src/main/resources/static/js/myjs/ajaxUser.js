function update() {
    var options = {
        success: showResponse,
        resetForm: false//设置页面不刷新
    };

    if($('#ckbox').prop('checked')){
        $('#baseForm').ajaxSubmit(options);
    }else{
        $.notify({
                message: '请勾选确认修改'
        },{
            type: 'warning',
            placement: {
                from: "top",
                align: "center"
            },
            delay: 1000

            }

        );
    }

}

//修改操作后的提示框
function showResponse(data) {
    if(data == 'success'){//如果成功
       //弹出框设置
        $.notify({
            message: '修改成功!'
        },{
            type: 'success',
            placement: {
                from: "top",
                align: "center"
            },
            delay: 1000 //显示时长(毫秒)
        });
    }else if (data == 'failure'){//如果失败
        $.notify({
            message: '修改失败'
        },{
            type: "warning",
            placement: {
                from: "top",
                align: "center"
            },
            delay: 1000
        });
    }

}

//设置文本框是否可被编辑
$('#ckbox').click(function(){
    if($(this).is(":checked")){//如果复选框被选中，则设置可编辑
        $('#exampleInputUsername1').removeAttr("readonly");
        $('#exampleInputEmail1').removeAttr("readonly");
        $('#exampleInputPassword1').removeAttr("readonly");
        $('#exampleInputTelphone').removeAttr("readonly");
        $('#exampleInputPostcode1').removeAttr("readonly");
        $('#exampleInputAddress1').removeAttr("readonly");

    }else{
        //如果没被选中，则设置只读
        $('#exampleInputUsername1').attr("readonly","readonly");
        $('#exampleInputEmail1').attr("readonly","readonly");
        $('#exampleInputPassword1').attr("readonly","readonly");
        $('#exampleInputTelphone').attr("readonly","readonly");
        $('#exampleInputPostcode1').attr("readonly","readonly");
        $('#exampleInputAddress1').attr("readonly","readonly");
    }
});

//表单刚加载出来设置只读
// jQuery(document).ready(
//     function () {
//         $('#exampleInputUsername1').attr("readonly","readonly");
//         $('#exampleInputEmail1').attr("readonly","readonly");
//         $('#exampleInputPassword1').attr("readonly","readonly");
//         $('#exampleInputTelphone').attr("readonly","readonly");
//         $('#exampleInputPostcode1').attr("readonly","readonly");
//         $('#exampleInputAddress1').attr("readonly","readonly");
//     }
// );
//表单刚加载出来设置只读
window.onload = function () {
        $('#exampleInputUsername1').attr("readonly","readonly");
        $('#exampleInputEmail1').attr("readonly","readonly");
        $('#exampleInputPassword1').attr("readonly","readonly");
        $('#exampleInputTelphone').attr("readonly","readonly");
        $('#exampleInputPostcode1').attr("readonly","readonly");
        $('#exampleInputAddress1').attr("readonly","readonly");
}










