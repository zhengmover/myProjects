

function check() {
    //获取复选框的选中状态,只有选中才可以执行操作
    var isChecked = $('#ifAccept').prop('checked');

    if(isChecked == true){
        return true;
    }else{
        $.notify({
            message: '请勾选同意'
        },{
            type: 'warning',
            placement: {
                from: "top",
                align: "center"
            },
            delay: 1000
        });
        return false;

    }
}