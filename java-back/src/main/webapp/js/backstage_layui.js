/**
 * Created by Liu-shuwei on 17.5.2.
 */


layui.use(['element','layer'],function() {

    var $ = layui.jquery,               //内部jQuery模块
            element = layui.element(),  //element模块
            layer = layui.layer;        //layui模块


    //1.欢迎页面
    // layer.msg('欢迎进入后台页面');




    //2.导航[顶部 + 左侧] 和 选项卡切换
    var leftMenu = $(".left-menu");


        //A1-监听头部菜单[点击时调用]
        element.on('nav(top-menu)',function(data) {
            //隐藏左侧菜单 and 展示指定索引的菜单
            leftMenu.hide();
            leftMenu.eq(data.index()).show(); //【eq(index)-将匹配元素集缩减值指定 index 上的一个,index()-返回指定元素相对于其他元素的位置】
        });


        //A2-监听左侧菜单[点击时调用]
        element.on('nav(left-menu)',function(data) {

            //声明变量
            var a	= data.children("a"),     //[.children(selector)-返回匹配元素集合中每个元素的子元素(选择器)]
                id 		= a.data("id"),       //[data-id属性]
                url 	= a.data("url"),      //[data-url属性]
                title 	= a.html(),           //[文本值]
                length 	= $(".layui-tab-title").children("li[lay-id='" + id + "']").length; //存在指定id的数量


            //不存时添加新的选项卡以及内容
            if (length == 0) {

                var iframe = '<iframe id="iframe" src="' + url + '" width="100%" height="620px" frameborder="0"></iframe>';

                element.tabAdd('body-top-tab', {
                    title	: title,        //选项卡标题
                    content	: iframe,       //...内容(支持传入html)
                    id		: id            //...的lay-id的属性值
                });
            }

            //切换选项卡[切换到指定id]
            element.tabChange('body-top-tab', id);

            // loadPage();
        });

        //A3-默认点击左菜单第一个li的第一个
        leftMenu.first().show();
        leftMenu.children("li:first").children("a:first").click();

        //A4-点击事件[点击某个li,取消已经选过的菜单项的选中状态]
        leftMenu.on("click", "li",function() {
            //删除所有选中状态
            $(this).siblings().removeClass("layui-nav-itemed"); //【siblings(selector)-获得匹配集合中每个元素的同胞(选择器)】
        });

        //A5-隐藏左侧滑栏按钮
        $(".hide-left-menu").click(function(){

            var hide = $(".hide-left-menu");
            var icon = hide.children("i").first();
               if(icon.attr("icon") == "left"){
                   icon.attr("icon","right").html("&#xe602;");      //向右按钮
               }else{
                   icon.attr("icon","left").html("&#xe603;");       //向左按钮
               }


            $(".left-menu-all").toggle();//切换侧滑栏


            //判断是否有隐藏元素
            $(".layui-body,.layui-footer")  //[is(selector)-根据选择器检查当前匹配元素集合，如果存在至少一个匹配元素，则返回 true]
                .css("left",($(".left-menu-all").is(":hidden")) ? '0' : '200px'); //移动标签
        });



    //2.刷新按钮
    $(".layui-tab-button").on("click","a",function(){
        reload_content();
    });


    //3.重新载入页面内容
    function reload_content(){
        var index = $(".layui-tab-content").find(".layui-show").index();
        window[index].location.reload();//指定窗口的windows的location对象,reload()重新加载当前文档
    }


    //4.插入内容
    // $(".layui-tab-content").html(" <tr><td>id</td><td>${user.id}</td></tr>");

});


