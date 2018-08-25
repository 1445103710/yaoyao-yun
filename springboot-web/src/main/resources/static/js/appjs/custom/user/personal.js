var prefix = "/cust/user"
$(function () {

});
/**
 * 基本信息提交
 */
$("#base_save").click(function () {
    var t = $("#basicInfoForm").serializeArray();
    $.each(t,function(i,item){
        if(item['value'] == '') {
            console.log('信息不可为空');
            parent.layer.alert('信息不可为空');
            flag = 1;
            return false;
        } else {
            flag = 0;
        }
    })

    if($("#basicInfoForm").valid()&&flag==0){
            $.ajax({
                cache : true,
                type : "POST",
                url :"/cust/user/save",
                data : $('#basicInfoForm').serialize(),
                async : false,
                error : function(request) {
                    laryer.alert("Connection error");
                },
                success : function(data) {
                    if (data.code == 0) {
                        parent.layer.msg("新增用户成功！");
                        window.parent.location.reload();
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    } else {
                        parent.layer.alert(data.msg)
                    }
                }
            });
        }

});