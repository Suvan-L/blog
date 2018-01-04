/*加载login.html页面body的时候调用*/
function bodywelcome(){
   
}
/*通用函数，获取ID*/
function $(id){
    obj =document.getElementById(id);
    return obj;
}

/*表单提交按钮-----用户a标签以post方式提交form表单*/
function formSubmit(){ 
    if(checkall()){//检测
         $('userlogin').submit();
    }else{
        alert('登录失败!');
    }
}


var username_valid=false;
var userpassword_valid=false;
/*
    1.用户名验证
*/
function checkusername(){
    var username=$('username').value;

    if(username=="" || username==null){
        $('checkusername').innerHTML="用户名不能为空";
        return;
    }else{
       $('checkusername').innerHTML="";
        username_valid=true;
    }
}


/*
   2.用户密码验证
*/
function checkuserpassword(){
    var userpassword=$('userpassword').value;

    if(userpassword=="" || userpassword==null){
        $('checkuserpassword').innerHTML="密码不能为空";
        return;
    }
    else{
        $('checkuserpassword').innerHTML="";
        userpassword_valid=true;
    }
}

/*
    3.用户密码综合检测，返回检测结果
*/
function checkall(){
    checkusername();checkuserpassword(); //调用函数
     
    if(userpassword_valid==false | username_valid==false){  //验证密码和用户名
        return false;
    }

    if(username_valid && userpassword_valid){
        return true;
    }else{
        username_valid=false;
        userpassword_valid=false;
        return false;
    }
}

