function loadHTML(){
    //绑定事件
    bindingEvent();


    // var $articleContent = $(".main-content");            //文章内容对象
    // var markedContent = marked($articleContent.text());     //marked转换后内容
    // // alert(markedContent);
    // $articleContent.html(markedContent);


    //【测试用】加载页面后,滚动条自动滚动
    // $("body,html").animate({
    //     scrollTop:3500
    // },"fast");

}
/*****************************************事件***************************************************/
/*绑定事件*/
function bindingEvent(){
    //点赞,反对按钮事件
    $(".me-operate").each(function () {
        operateIconAnimation($(this).find("i:first"));
        operateIconAnimation($(this).find("i:eq(1)"));
    });

    //4.发表评论
    // $(".inputComment-button").click(ajaxInsertComment);     //异步插入评论

}


/*操作Icon图标动画*/
function operateIconAnimation($obj){//点赞,反对操作对象
    $obj.click(function () {
        if($obj.attr("clickStatus") == undefined){//未点击
            //增加节点,记录点击状态
            $obj.attr("clickStatus","clicked");

            //数字动画
            var colour = "red";
            if($obj.attr("type") == "oppose"){
                colour = "blue";
            }
            createNumMoveAnimation($obj,"+1",colour);

            // icon图标变色
            $obj.animate({color:colour},"fast");
        }else{//已点击
            $obj.removeAttr("clickStatus");

            createNumMoveAnimation($obj,"-1","black");

            $obj.animate({color:"black"},"fast");
        }

        // var commentoperateid = $agree.parent().attr("id").replace(/operate/,"");  //评论id
    });
}
/*创建数移动动画*/
function createNumMoveAnimation($obj,arithmetic,colour){//操作对象,运算符,颜色
            //增加前节点
            var preNode = "<span style='position: absolute;color:"+colour+"'>"
                                + arithmetic
                        + "</span>";
            $obj.before(preNode);

            //前节点动画,执行后删除
            var $preNode = $obj.prev();
            $preNode.animate({bottom:"+=20px"},"fast",function () {
               $preNode.remove();
            });
}

/*****************************************ajax操作数据库【操作数据】******************************************/
// /*访问页面阅读量+1*/
// function updatearticleread(){ //参数:文章id
//     $.get(
//         callip +"/blog//article/updatearticlereadinsert1/" + articleid,  //文章id
//         function(){
//             // alert("请求成功,阅读数+1");
//         });
// }
// /*更新评论点赞,反对数*/
// function ajaxupdatecommentcolumnvalue(commentid,colname,colvalue){ //参数:评论id,列名,列值
//     //1.获取独享
//     var $operateid = $("#operate" + commentid);        //评论操作对象
//     var $obj =  $operateid.find(".comment-agree");      //点赞数值对象
//     if(colname == "c_oppose"){
//         $obj = $operateid.find(".comment-oppose");      //反对数值对象
//     }
//
//     //2.异步请求
//     $.get(
//         callip+"/blog/article/updatecommentcolumnvalue",
//         {commentid:commentid, columnname:colname, value:colvalue}, //传输数据
//         function(result){
//             if(result == "更新成功"){
//                 //修改评论的实际点赞(or 反对)值
//                 $obj.text(colvalue);
//             }
//         }, "text"); //接收类型
// }
// /*插入新的评论*/
// function ajaxinsertcomment(){
//
//     //1.获取评论内容
//     var commentcontent = $(".inputcomment-textarea").val();  //评论内容
//     var commentuserid = 4;                                 //评论用户id(暂时设置为1)【得有该用户才能成功】
//
//     //2.异步发表评论
//     $.ajax({
//         url: callip+'/blog/article/insertcomment',
//         data: {commentcontent:commentcontent, articleid:parseint(articleid), commentuserid:commentuserid}, //传输数据
//         type:"get",
//         success:function(result){   //请求成功
//             // alert("发表成功");
//
//             //1.生成一条新评论 + 绑定事件
//             createcomment(result);
//
//         },
//         error:function(){
//             alert('发表评论失败');
//         },
//         datatype: "json"
//     });
// }
// /*生成评论*/
// function createcomment(comment) {
//
//     var commentid = comment.id;
//     var content = comment.content;          //内容
//     var agree = comment.agree;               //点赞数
//     var oppose = comment.oppose;            //反对数
//     var userid = comment.userid;            //评论用户id
//     var publictime = comment.publictime;    //发布时间
//
//     //1.插入评论
//     var $maincomments = $('.main-comments');
//     $maincomments.prepend(
//         '<div class="comment"> ' +
//             '<img  class="comment-userimg" src='+callip+'/blog/img/head.png>' +
//             '<div class="comment-right">' +
//             '<div class="comment-content">' +
//                 '<span class="comment-username" id="user' + userid + '">路人' + commentid + ':</span>' +
//                 '&emsp;&nbsp;' + content +
//             '</div>' +
//             '<div class="comment-date">' + publictime + '</div>' +
//             '<div class="comment-operate" id="operate' + commentid + '">' +
//                 '<i class="icon iconfont icon-dianzandian"></i><span class="agree-insert1">+1</span>' + '<span class="comment-agree">' + agree + '</span>' + '&emsp;' +
//                 '<i class="icon iconfont icon-handagainst"></i><span class="oppose-insert1">+1</span>' + '<span class="comment-oppose">' + oppose + '</span>' + '&emsp;' +
//             '</div>' +
//             '</div>' +
//         '</div>');
//
//
//     //2.绑定事件
//     var $comment = $maincomments.find("div:first");      //评论列表第一个div
//         change_commentagree($comment.find("i:first"));          //点赞icon图标
//         change_commentoppose($comment.find("i:eq(1)"));         //反对icon图标
// }


