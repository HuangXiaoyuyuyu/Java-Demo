//校验用户名是否存在
function doVerify() {
    var $register_login_name = $("#register_login_name");
    var $register_login_name_text = $("#register_login_name_text");
    if ($register_login_name.val() != "") {
        $.ajax({
            type:"POST",
            url:"/checkLoginName",
            data:{username:$register_login_name.val()},
            success:function (msg) {
                if (msg == "false") {
                    $register_login_name_text.html("<font color='red'>"+"该用户名已经被注册！请重新填写用户名！"+"</font>");
                }else {
                    $register_login_name_text.html("<font color='green'>"+"该用户名还未被注册~请继续往下填写~"+"</font>");
                }
            }
        })
    }
}

//选择格式为.jpg和.png的图片
function pic() {
    var $register_icon = $("#register_icon");
    var $register_icon_text = $("#register_icon_text");
    if ($register_icon.val().indexOf(".jpg") > 0 || $register_icon.val().indexOf(".png") > 0){
        $register_icon_text.html("");
    }else {
        alert("请选择格式为'.jpg'和'.png'的图片");
        $register_icon.val("");
    }

    //获取input file的files文件数组;
    //$('#filed')获取的是jQuery对象，.get(0)转为原生对象;
    //这边默认只能选一个，但是存放形式仍然是数组，所以取第一个元素使用[0];
    var file = $register_icon.get(0).files[0];
    //创建用来读取此文件的对象
    var reader = new FileReader();
    //使用该对象读取file文件
    reader.readAsDataURL(file);
    //读取文件成功后执行的方法函数
    reader.onload = function (ev) {
        //读取成功后返回的一个参数e，整个的一个进度事件
        //选择所要显示图片的img，要赋值给img的src就是e中target下result里面
        //的base64编码格式的地址
        $("#showImg").css({height:'130px',width:'117px',borderWidth:'0px'});
        $("#showImg").get(0).src = ev.target.result;
    }
}