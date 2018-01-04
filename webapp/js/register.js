function loadHTML(){

    //1.绑定事件
    bindingEvent();

}

/*********************************************************************************************************************/
/*二.绑定事件*/
function bindingEvent(){

        //1.点击事件
        $("#authcodeButton").click(operateSendAuthcodeButton);
        $("#submitButton").click(submitRegisterForm);
        $("#resetButton").click(resetRegisterForm);



        //2.失焦事件【检测输入框】
        $("#username").blur(checkUsername);
        $("#password").blur(checkPassword);
        $("#confirmpassword").blur(checkConfirmpassword);
        $("#email").blur(checkEmail);
        $("#authcode").blur(checkAuthcode);


}
/***************************统一函数*************************************/
/*空判断*/
function nullJudge($obj){ //检擦对象
    var value = $obj.val();

    if(value == "" || value == null){//为空,不满足
        return true;
    }
    return false;
}
/*长度判断*/
function lengthJudge($obj,min,max) {//检查对象,低 ~ 高
    var length = $obj.val().length;

    if(min <= length && length <= max){//长度满足范围
        return false;
    }
    return true;
}
/**************************检测输入框**************************************/

/*全局定义变量*/
var serverAuthcode;  //服务器验证码

/*通过检查【表单提交验证标识】*/
var passUsername = false;
var passPassword = false;
var passConfirmpassword = false;
var passEmail = false;
var passAuthcode = false;



/*检测用户名*/
function checkUsername(){
    var $username = $("#username");
    var $checkUsername = $("#checkUsername");
    var pattern = /^[a-zA-Z]{1}\w*$/;

    $username.next("i:first").remove();//每次检查都删除✓符号

    if(nullJudge($username)){
        $checkUsername.text("用户名不能为空！")
    }else if(lengthJudge($username,3,15)){
        $checkUsername.text("用户名长度超出指定范围(3 ~ 15)！");
    }else if(!pattern.test($username.val())){// 非单词匹配 + 全字符搜索
        $checkUsername.text("用户名不能包含单词类型(a~z,A~Z,0~9,下划线)以外的字符,且字母开头！");
    }else{
        //1.异步判断用户唯一性
        ajaxCheckUsernameOnly($username,$checkUsername);
    }

    // passUsername = false; //默认返回false情况
}


/*检测密码*/
function checkPassword(){
    var $password = $("#password");
    var $checkPassword = $("#checkPassword");
    var pattern =/^[a-zA-Z0-9]{5,15}$/;//密码正则格式(允许英文数字,下划线(_),长度为5-15)

    $password.next("i:first").remove();

    if(nullJudge($password)){
        $checkPassword.text("密码不能为空！")
    }else if(!pattern.test($password.val())){
        $checkPassword.text("密码不符合规定类型(a~z,A~Z,0~9) 或者 长度超出指定范围(5~15)");
    }else{
        $checkPassword.text("");
        $password.after("<i>✓</i>")

        passPassword = true;
        return;
    }

    passPassword = false;
}


/*检测确认密码*/
function checkConfirmpassword(){
    var $password = $("#password");
    var $confirmpassword = $("#confirmpassword");
    var $checkConfirmpassword = $("#checkConfirmpassword");

    $confirmpassword.next("i:first").remove();

    if(nullJudge($confirmpassword)){
        $checkConfirmpassword.text("确认密码不能为空");
    }else if($password.val() != $confirmpassword.val()){
        $checkConfirmpassword.text("两次输入密码不一致,请重新输入！");
    }else{
        $checkConfirmpassword.text("");
        $confirmpassword.after("<i>✓</i>");

        passConfirmpassword = true;
        return;
    }

    passConfirmpassword = false;
}



/*检测邮箱*/
function checkEmail(){
    var $email = $("#email");
    var $checkEmail = $("#checkEmail");
    var pattern =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;//邮箱正则格式

    $email.next("i:first").remove();

    if(nullJudge($email)){
        $checkEmail.text("邮箱不能为空！")
    }else if(!pattern.test($email.val())){
        $checkEmail.text("邮箱格式错误,请按照规范格式输入(xxxxx@xxx.xx)");
    }else{
        $checkEmail.text("");
        $email.after("<i>✓</i>");

        passEmail = true;
        return;
    }

    passEmail = false;
}


/*验证邮箱验证码*/
function checkAuthcode(){
    var $authcode = $("#authcode");
    var $checkAuthcode = $("#checkAuthcode");

    $authcode.next("i:first").remove();

    if(nullJudge($authcode)){
        $checkAuthcode.text("邮箱验证码不能为空！");
    }else  if(serverAuthcode == null){
        $checkAuthcode.text("尚未点击发送邮箱验证码,请输入邮箱后,接收验证码！");
    } else if($authcode.val() != serverAuthcode){
        $checkAuthcode.text("验证码不正确,请重新输入");
    }else{
        $checkAuthcode.text("");
        $authcode.after("<i>✓</i>")

        passAuthcode = true;
        return;
    }

    passAuthcode = false;
}

/**************************功能性操作**************************************/

/*提交注册表单*/
function submitRegisterForm(){

    if(registerFoLastAllCheckSubmit()){
        var sign = confirm('恭喜你通过了全部验证,是否将信息提交至服务器?');
        if(sign = true){
            $("#registerForm").submit();//通过最终检查则提交表单
        }
    }
}


/*重置注册表单*/
function resetRegisterForm(){
    var $registerForm = $("#registerForm");

    $registerForm.find("input").val("");
    $registerForm.find("span").text("");
    $registerForm.find("i").remove();
}


/*操作发送验证码按钮*/
function operateSendAuthcodeButton(){
    var $authcodeButton = $("#authcodeButton");
    var $email = $("#email");


    //1.判断是有输入邮箱
    if(nullJudge($email)){
        checkEmail();
        return;
    }

    //2.按钮点击后,准备状态
    $authcodeButton.text("正在发送...");

    //3.异步发送邮箱验证码
    ajaxSendEmailAuthcode($authcodeButton);
}


/*倒计时*/
var time = 60;
function countDownTime(){
    if(time == 1 ){
        $("#authcodeButton").text("点击获取邮箱验证码");
        return
    }

    time = time - 1;
    $("#countTime").text(time);

    setTimeout("countDownTime()",1000);
}




/**************************异步操作**************************************/

/*异步检测用户名唯一性*/
function  ajaxCheckUsernameOnly($username,$checkUsername){

    $.post(
        "http://localhost:8080/blog/register/onlyUserName",
        {username:$username.val()},
        function (result) {
            if(result == "用户唯一"){
                //唯一通过标识
                $checkUsername.text("");//清空
                $username.after("<i>✓</i>"); //输入框后面添加元素

                passUsername = true;
            }else{

                $checkUsername.text("该用户名已经存在,请重新输入！");
                passUsername = false;
            }
        },
        "text"
    );
}
/*异步发送邮箱验证码*/
function ajaxSendEmailAuthcode($authcodeButton){
    var $email = $("#email");
    var $checkEmail = $("#checkEmail");

    $.post(
        "http://localhost:8080/blog/register/emailVerificationCode",
        {useremail:$email.val()},
        function(result){
            serverAuthcode = result;   //获取验证码,存入全局

            if(serverAuthcode == null){ //JS的undefined相当于null
                $checkEmail.text('发送邮件失败');
            }else{
                // alert("弹框提示验证码：" + serverAuthcode); //测试用

                //1.发送成功
                passAuthcode = true;

                //2.修改按钮样式(不可点击)
                $authcodeButton.remove("removeHover");
                $authcodeButton.attr("disabled",true);
                $authcodeButton.css("opacity",0.5);

                //3.开始倒计时
                $authcodeButton.html("<span id='countTime'>"+time+"</span>后可重新点击发送");
                countDownTime();
            }

	    }, "TEXT");
}


/**********************************注册表单表单最后全部检查提交*****************************************/
function registerFoLastAllCheckSubmit(){

    //1.重新检查所有
        checkUsername();
        checkPassword();
        checkConfirmpassword();
        checkEmail();
        checkAuthcode();

    //2.判断全局状态是否全部通过
    if(passUsername && passPassword && passConfirmpassword && passEmail && passAuthcode){
            return true;
    }else{
        alert('信息填写有误，请根据提示作出相应的修改！');
        return false;
    }
}



