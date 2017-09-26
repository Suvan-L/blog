/*加载页面(body标签的onload="loadHTML())*/



var musicSign = true;           //加载页面后第一次点击

//最后验证标识
var passName = false;
var passPhone = false;
var passCity = false;
var passArea = true;
var passPostCode = false;
var passJoin = false;
var passTraffic = false;
var passMoney = false;


function loadHTML(){

    //一.绑定事件
    bindingEvent();

}
/**********************************表单最后验证*****************************************/
function checkAll(){
    checkName();
    checkPhone();
    checkCity();
    checkPostCode();
    checkJoin();
    checkTraffic();
    checkMoney();


    if(passName && passPhone && passCity && passArea && passPostCode && passJoin && passTraffic && passMoney){
        return confirm('恭喜你通过了全部验证,是否将信息提交至服务器?');
    }


    alert('信息填写有误，请根据提示作出相应的修改！');
    return false;
}

/*****************************************************************************************/
/*一.绑定事件*/
function bindingEvent(){

    //1.触摸事件【触摸播放音乐】
    $("html").click(function () {
        if(musicSign == true){
            document.getElementById("music").play();
            musicSign = false;
        }
    });

    //2.点击事件
    $("#reset").click(function () {     //重置按钮
        $("#classMastesForm").find(":input[class=form-control]").val("");  //清空表单内所有输入框
        $("#classMastesForm").find("span[class=checkFont]").text("");    //清空提示信息

        //验证标识重置
            passName = false;
            passPhone = false;
            passCity = false;
            passArea = false;
            passPostCode = false;
            passJoin = false;
            passTraffic = false;
    });

    $("#musicButton").click(function () {  //2.音乐按钮
        var audioEle = document.getElementById("music");
        var $music = $("#music");
        if($music.attr("play") == "yes"){
            $("#musicButton").animate({color:"white",backgroundColor:"black"},"fast"); //按钮变色动画

            $music.attr("play","no");
            audioEle.pause();    //暂停
            setTimeout(function(){
                audioEle.pause();    //5毫秒后再次暂停【第一次需要点击2下才能成功暂停】
            },1);
        }else if($music.attr("play") == "no"){
            $("#musicButton").animate({color:"rgb(120, 63, 4)",backgroundColor:"white"},"fast");

            $music.attr("play","yes");
            audioEle.play();    //播放
        }
    });
    movement_musicButton() //音乐按钮运动


    //2.失焦事件【blur(function)】
    $("#name").blur(checkName);                         //检测名字
    $("#phone").blur(checkPhone);                       //检测手机号
    $("#city").blur(checkCity);                         //检测当前居住城市
    // $("#area").blur(checkArea);                      //检测详细地址
    $("#postCode").blur(checkPostCode);                 //检测邮编
    $("#join").blur(checkJoin);                         //检测是否参与同学会
    $("#traffic").blur(checkTraffic);                   //检测回埔方式
    $("#money").blur(checkMoney);                       //赞助金额

}


/**************************失焦事件**************************************/
/*上下移动的音乐按钮*/
var moveSign = "goTop";
function movement_musicButton() {
    var $button =  $("#musicButton");

    //2，运动动画
    if(!$button.is(":animated")){  //按钮不在动画状态
        if(moveSign == "goTop"){
            $button.animate({top:'+=5px'},350);
            moveSign = "goBottom";
        }
        else if(moveSign == "goBottom"){
            $button.animate({top:'-=5px'},500);
            moveSign = "goTop";
        }
    }

    //循环调用[1s后调用函数]
    setTimeout("movement_musicButton()",850);
}
/**************************失焦事件**************************************/

/**************************自定义函数*/
/*获取值*/
function getValue(object){
    return object.val();
}
/*添加和删除样式*/
function insertCss(object,css){
    object.addClass(css);
}
function deleteCss(object,css) {
    object.removeClass(css);
}
/*非空判定,长度判定,正则判定,异步验证用户名唯一性*/
function notNull(str,checkObj,warmInfo){ //内容,检查对象，警告信息
    if(str == "" || str == null){
        checkObj.text(warmInfo);
        return true;
    }
    return false;
}
/**************************各项验证*/
/*检测姓名*/
function checkName(){
    //1.定义
    var name = getValue($("#name"))
    var $checkName = $("#checkName");           //检查用户信息
    var pattern =/^[\u4E00-\u9FA5]/;            //正则[属于汉字]
    deleteCss($checkName,"success-green");      //删除样式【防止输入框内容信息正确 -> 错误时,仍为绿色】

    //2.检验
    if(notNull(name,$checkName,"姓名不能为空")){return;}
    else if(!pattern.test(name)){
        $checkName.text("姓名只能为汉字,请重新输入");
    }else{
        passName = true;                               //验证通过
        $checkName.text("✓");
        insertCss($checkName,"success-green");
    }
}

/*检测手机号*/
function checkPhone(){
    //1.定义
    var phone = getValue($('#phone'));
    var $checkPhone = $('#checkPhone');
    var pattern =/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;//正则
    deleteCss($checkPhone,"success-green");

    //2.检验
    if(notNull(phone,$checkPhone,"手机号不能为空")){}
    else if(!pattern.test(phone)){                      //正则检测手机格式
        $checkPhone.text("手机格式错误，正确格式为130-139,150-159,180-189号码段的手机号码,共11位数");
    }else{
        passPhone = true;                               //验证通过
        $checkPhone.text("✓");
        insertCss($checkPhone,"success-green");
    }
}
/*检测居住城市*/
function checkCity(){
    //1.定义
    var city = getValue($('#city'));
    var $checkCity = $('#checkCity');

    deleteCss($checkCity,"success-green");

    //2.检验
    if(notNull(city,$checkCity,"居住城市不能为空")){}
    else{
        passCity = true;                               //验证通过
        $checkCity.text("✓");
        insertCss($checkCity,"success-green");
    }
}
/*检测详细地址*/
function checkArea(){
    //1.定义
    var area = getValue($('#area'));
    var $checkArea =  $('#checkArea');
    deleteCss($checkArea,"success-green");

    //2.检验
    // if(notNull(area,$checkArea,"详细地址地区不能为空")){}
    // else{
        passArea = true;                       //验证通过
        $checkArea.text("✓");
        insertCss($checkArea,"success-green");
    // }
}
/*检测邮编*/
function checkPostCode(){
    //1.定义
    var postCode = getValue($('#postCode'));
    var $checkPostCode =  $('#checkPostCode');
    var pattern =/^[1-9][0-9]{5}$/;  //正则[开头不能为0,共6位]
    deleteCss($checkPostCode,"success-green");

    //2.检验
    if(notNull(postCode,$checkPostCode,"邮编不能为空")){}
    else if(!pattern.test(postCode)){
        $checkPostCode.text("邮编格式错误,请重新输入[\"开头不能为0,共6位\"]");
    } else{
        passPostCode = true;                       //验证通过
        $checkPostCode.text("✓");
        insertCss($checkPostCode,"success-green");
    }
}
/*检测参加同学(是/否)*/
function checkJoin(){
    //1.定义
    var join = getValue($('#join'));
    var $checkJoin =  $('#checkJoin');
    deleteCss($checkJoin,"success-green");

    //2.检验
    if(notNull(join,$checkJoin,"选项不能为空,请输入是/否")){}
    else{
        passJoin = true;                       //验证通过
        $checkJoin.text("✓");
        insertCss($checkJoin,"success-green");
    }
}
/*检测交通出行情况(自驾/大巴)*/
function checkTraffic(){
    //1.定义
    var traffic = getValue($('#traffic'));
    var $checkTraffic =  $('#checkTraffic');
    deleteCss($checkTraffic,"success-green");

    //2.检验
    if(notNull(traffic,$checkTraffic,"选项不能为空,请输入自驾/大巴")){}
    else{
        passTraffic = true;                       //验证通过
        $checkTraffic.text("✓");
        insertCss($checkTraffic,"success-green");
    }
}
/*检测交通出行情况(自驾/大巴)*/
function checkMoney(){
    //1.定义
    var money = getValue($('#money'));
    var $checkMoney =  $('#checkMoney');
    var pattern =/^[0-9]+$/;        //正则[只能为数字]
    deleteCss($checkMoney,"success-green");

    //2.检验
    if(notNull(money,$checkMoney,"请输入赞助金额")){}
    else if(!pattern.test(money)){
        $checkMoney.text("赞助金额只能为数字");
    }else{
        passMoney = true;                       //验证通过
        $checkMoney.text("✓");
        insertCss($checkMoney,"success-green");
    }
}


