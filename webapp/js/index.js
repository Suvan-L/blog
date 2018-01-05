/**
 * Created by Liu-shuwei on 17.5.28.
 */

/*加载HTML*/
function loadHTML(){
    //1.页面启动动画
    pageAnimation();
}

/*****************************************事件***************************************************/
/*页面动画*/
function pageAnimation() {

    //1.小球跑动动画(注意:三个小球是异步的)
    ballSport($(".ballFirst"),500);
    ballSport($(".ballSecond"),600);
    ballSport($(".ballThird"),700);


    //2.显示主页(根据随机数,指定毫秒后执行)
    var random = (1+Math.random()*1500);
    setTimeout(showIndexPage,random);


}
    /*单个小球运动*/
    function ballSport($ball,beginSpeed){//开始速度
        var speed = 500;                     //设置速度
        var size = 130;                      //设置跑圈面积
        var beginSign= true;                 //开始标志(起步时间不同)

        var cutTop =  {top: '-=' + size + 'px', opacity: '0.4'};  //四种条件(上,右,下,左)
        var addLeft =  {left: '+=' + size + 'px', opacity: '0.4'};
        var addTop =  {top: '+=' + size + 'px', opacity: '0.4'};
        var cutLeft =  {left: '-=' + size + 'px', opacity: '0.4'};

        for (var i = 0; i < 5; i++) {
            if (beginSign) {
                $ball.animate(cutTop,beginSpeed);
                beginSign = false;
            } else {
                $ball.animate(cutTop,speed);
            }
            $ball.animate(addLeft,speed);
            $ball.animate(addTop,speed);
            $ball.animate(cutLeft,speed);
        }
    }
    /*隐藏动画模块,显示正常*/
    function showIndexPage(){
        $(".animationScope").css("display","none");

        $(".container").fadeIn();
    }


