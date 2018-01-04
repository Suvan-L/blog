function loadHTML() {
    bindingEvent();

    webTabRandomSize();

    hiddenAllPageContent();

    showFirstPageContent();
}
/*****************************************事件***************************************************/
/*班定事件*/
function bindingEvent() {

    //分页模块所有a标签绑定点击事件
    $("#Paging a").each(function () {
        var $page = $(this);//获取点击页数

        $page.click(function () {
            showIndexPageContenxt($page.text());
        });
    });
}
/*网站标签随机大小*/
function webTabRandomSize(){
    var min = 10;
    var max = 30;
    var random;//储存随机数

    $("#webTab a").each(function () {
        random = generateMINMAXRandomNumber(min,max);
       $(this).css("font-size",random).css("margin-left",random).css("margin-top",random-10);
    });
}
/*生成指定范围随机数*/
function generateMINMAXRandomNumber(min,max){//范围
    return Math.floor(Math.random()*(max-min+1) + min); //floor-取整函数
}

/*隐藏所有页内容*/
function hiddenAllPageContent(){
    $(".ma-right-articleList div").each(function () {
        $(this).addClass("hidden");
    });
}

/*展示首页内容*/
function showFirstPageContent() {
    $("#articleList div:first").removeClass("hidden");
}

/*展示指定Index页内容*/
function showIndexPageContenxt(page){//参数：index页

    //1.隐藏所有
    hiddenAllPageContent();

    //2.展示指定页面
    var $pageIndex = $('#pageIndex'+page);
    $pageIndex.removeClass("hidden");
}