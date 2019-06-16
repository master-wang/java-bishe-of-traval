$(function(){
    alert(111);
    var index= new Vue({
        el:'#app',
        data:{
            roundImgs:['./imgs/01.jpeg','./imgs/02.jpeg','./imgs/03.jpeg','./imgs/04.jpeg','./imgs/05.jpeg'],
            jijieImgs:[{
                    url:'./imgs/01.jpg',
                    derection:`春季 春天，当然是美的，但每个人眼中的春天也各不一样。有人爱这杨柳菲菲，有人爱这细雨绵绵，也有人爱这清风徐徐。所幸的是生在诗香中国，在诗词佳作迭出的这片土地，我们每个人都能找到自己心中所喜的春。

                    关于“春”的诗句有那么多，我却独爱韩愈的一首《早春呈水部张十八员外》。每每读来，眼前便是一片清晰可见的早春好景。`
                },{
                    url:'./imgs/02.jpg',
                    derection:"夏季 收获前的一个季节，是一个充满生命力与活力的时候。玉米和小麦，黄澄澄亮晶晶就让人感到温馨.."
                },{
                    url:'./imgs/03.jpg',
                    derection:"秋季 秋天一到，果子的芳香扑鼻而来，醉人心脾。且不说黄澄澄的鸭梨压弯了树枝，红红的苹果像小灯笼挂满枝头。单那绿色走廊一样的葡萄架，就够我陶醉的了。"
                },{
                    url:'./imgs/04.jpg',
                    derection:"冬季 天空一碧如洗，灿烂的阳光正从密密的松针的缝隙间射下来，形成一束束粗粗细细的光柱，把飘荡着轻纱般薄雾的林荫照得通"
                }],
            cities:["北京","天津","上海","重庆","河北","山西","辽宁","吉林","黑龙江","江苏","浙江","安徽","福建","江西","山东","河南","湖北","湖南","广东","海南","四川","贵州","云南","陕西","甘肃","青海","台湾","内蒙古","广西","西藏","宁夏","新疆","香港","澳门"],
            city_cis:["北京","西安","天津","上海","重庆","河北","山西","辽宁","吉林","黑龙江","江苏","浙江","安徽","福建"],
            sights:     [
                {
                "bishe_tour_id":"1",
                "bishe_tour_name":"兵马俑",
                "bishe_tour_provinceName":"陕西省",
                "bishe_tour_cityName":"西安市",
                "bishe_tour_image":"./imgs/sight.jpg",
                "bishe_tour_desc":"兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑",
                "bishe_tour_time":"2019-11-11",
                "bishe_tour_registerId":"1"
              },
                {
                "bishe_tour_id":"2",
                "bishe_tour_name":"壶口瀑布",
                "bishe_tour_provinceName":"陕西省",
                "bishe_tour_cityName":"延安市",
                "bishe_tour_image":"./imgs/sight.jpg",
                "bishe_tour_desc":"壶口瀑布壶口瀑布壶口瀑布壶口瀑布壶口瀑布壶口瀑布",
                "bishe_tour_time":"2019-11-11",
                "bishe_tour_registerId":"1"
              },
              {
                "bishe_tour_id":"1",
                "bishe_tour_name":"兵马俑",
                "bishe_tour_provinceName":"陕西省",
                "bishe_tour_cityName":"西安市",
                "bishe_tour_image":"./imgs/sight.jpg",
                "bishe_tour_desc":"兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑",
                "bishe_tour_time":"2019-11-11",
                "bishe_tour_registerId":"1"
              },
                {
                "bishe_tour_id":"2",
                "bishe_tour_name":"壶口瀑布",
                "bishe_tour_provinceName":"陕西省",
                "bishe_tour_cityName":"延安市",
                "bishe_tour_image":"./imgs/sight.jpg",
                "bishe_tour_desc":"壶口瀑布壶口瀑布壶口瀑布壶口瀑布壶口瀑布壶口瀑布",
                "bishe_tour_time":"2019-11-11",
                "bishe_tour_registerId":"1"
              },
              {
                "bishe_tour_id":"1",
                "bishe_tour_name":"兵马俑",
                "bishe_tour_provinceName":"陕西省",
                "bishe_tour_cityName":"西安市",
                "bishe_tour_image":"./imgs/sight.jpg",
                "bishe_tour_desc":"兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑",
                "bishe_tour_time":"2019-11-11",
                "bishe_tour_registerId":"1"
              },
                {
                "bishe_tour_id":"2",
                "bishe_tour_name":"壶口瀑布",
                "bishe_tour_provinceName":"陕西省",
                "bishe_tour_cityName":"延安市",
                "bishe_tour_image":"./imgs/sight.jpg",
                "bishe_tour_desc":"壶口瀑布壶口瀑布壶口瀑布壶口瀑布壶口瀑布壶口瀑布",
                "bishe_tour_time":"2019-11-11",
                "bishe_tour_registerId":"1"
              },
              {
                "bishe_tour_id":"1",
                "bishe_tour_name":"兵马俑",
                "bishe_tour_provinceName":"陕西省",
                "bishe_tour_cityName":"西安市",
                "bishe_tour_image":"./imgs/sight.jpg",
                "bishe_tour_desc":"兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑",
                "bishe_tour_time":"2019-11-11",
                "bishe_tour_registerId":"1"
              },
                {
                "bishe_tour_id":"2",
                "bishe_tour_name":"壶口瀑布",
                "bishe_tour_provinceName":"陕西省",
                "bishe_tour_cityName":"延安市",
                "bishe_tour_image":"./imgs/sight.jpg",
                "bishe_tour_desc":"壶口瀑布壶口瀑布壶口瀑布壶口瀑布壶口瀑布壶口瀑布",
                "bishe_tour_time":"2019-11-11",
                "bishe_tour_registerId":"1"
              },
            ],
            collections:[  {
                "bishe_tour_id":"2",
                "bishe_tour_name":"壶口瀑布",
                "bishe_tour_provinceName":"陕西省",
                "bishe_tour_cityName":"延安市",
                "bishe_tour_image":"./imgs/sight.jpg",
                "bishe_tour_desc":"壶口瀑布壶口瀑布壶口瀑布壶口瀑布壶口瀑布壶口瀑布",
                "bishe_tour_time":"2019-11-11",
                "bishe_tour_registerId":"1"
              },
              {
                "bishe_tour_id":"1",
                "bishe_tour_name":"兵马俑",
                "bishe_tour_provinceName":"陕西省",
                "bishe_tour_cityName":"西安市",
                "bishe_tour_image":"./imgs/sight.jpg",
                "bishe_tour_desc":"兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑",
                "bishe_tour_time":"2019-11-11",
                "bishe_tour_registerId":"1"
              },
                {
                "bishe_tour_id":"2",
                "bishe_tour_name":"壶口瀑布",
                "bishe_tour_provinceName":"陕西省",
                "bishe_tour_cityName":"延安市",
                "bishe_tour_image":"./imgs/sight.jpg",
                "bishe_tour_desc":"壶口瀑布壶口瀑布壶口瀑布壶口瀑布壶口瀑布壶口瀑布",
                "bishe_tour_time":"2019-11-11",
                "bishe_tour_registerId":"1"
              }
            ],
            collected:false,
            city:'陕西',
            city_ci:'西安',
            mark:0,
            timer:null,
            is_login:false,
            isAdmin:true,
            user:{name:'wang',img:'./imgs/user_img.png'},
            //季节和主页面 我的收藏切换
            index_stadus:true,
            jijie_stadus:false,
            my_collection_stadus:false,
            my_cities_stadus:false,
            all_cities_stadus:false,
            //登陆和注册  修改密码 退出登陆的模态框切换
            login_stadus:true,
            regest_stadus:false,

            update_password_view_stadus:false,
            login_out_view_stadus:false,
            update_userInfo_stadus:false,
            login_regest_view_stadus:true,
            //登陆下面的账号密码登陆和微信登陆切换
            zhanghao_login:true,
            weixin_login:false,
            //注册的信息
            registerInfo:{
                "bishe_register_username":'',
                "bishe_register_password":'',
                "bishe_register_repassword":''
            },
            //登录的信息
            loginInfo:{
                "bishe_register_username":'',
                "bishe_register_password":''
            },
            //修改密码信息
            updateUserInfo:{
                "bishe_register_password":'',
                "bishe_register_newpassword":'',
                "bishe_register_renewpassword":''
            },
            //更新个人信息
            updateUsrAllInfo:{
                "bishe_userInfo_nike":'',
                "bishe_userInfo_sex":'男',
                "bishe_userInfo_email":''
            }
        },
        // router:router,
        methods: {
            //首页的轮播效果
            autoPlay () {
              this.mark++;
              if (this.mark === 4) {
                this.mark = -1
              }
            },
            play () {
              this.timer = setInterval(this.autoPlay, 2500)
            },
            change (i) {
              this.mark = i
            },
            stop () {
              clearInterval(this.timer)
            },
            move () {
              this.timer = setInterval(this.autoPlay, 2500)
            },
            //获取轮播图的imgs
            roundImgsGet(){
                // Lambda写法
                this.$http.get('').then((response) => {
                    // 响应成功回调
                    console.log(JSON.parse(response.bodyText));

                }, (response) => {
                    // 响应错误回调
                    console.log(000);
                });
            },
            //获取几个季节的imgs
            jijieImgsGet(){

            },
            //主页季节点击显示季节页面  消灭主页面 收藏
            jijie_view(){
                this.index_stadus=false;
                this.jijie_stadus=true;
                this.my_collection_stadus=false;
                this.all_cities_stadus=false;
            },
            //显示主页面，消灭季节页面和收藏
            index_view(){
                this.index_stadus=true;
                this.jijie_stadus=false;
                this.my_collection_stadus=false;
                this.all_cities_stadus=false;
            },
            //显示收藏页面 消灭季节页面和主页面
            my_collection_view(){
                this.index_stadus=false;
                this.jijie_stadus=false;
                this.my_collection_stadus=true;
                this.all_cities_stadus=false;
            },

                 //切换省
            cities_cp(val){
                this.city=val;
                 //请求市
                 this.$http.get('https://home.firefoxchina.cn/res/areas.js?callback=W_GetLocaleInfo&_=1552579590363').then((response) => {
                    // 响应成功回调
                    console.log(JSON.parse(response.bodyText));

                }, (response) => {
                    // 响应错误回调
                    console.log(000);
                });
            },
            city_ci_cp(val){
                this.city_ci=val;
                this.all_cities_view();
            },
                //查询城市
            all_cities_view(){
                this.index_stadus=false;
                this.jijie_stadus=false;
                this.my_collection_stadus=false;
                this.all_cities_stadus=true;
            },
            //获取体格城市的天气信息
            cities_weather_Info(){
            },
            //登陆 注册页面
            login_view(){
                this.login_stadus=true;
                this.regest_stadus=false;
            },
            regise_view(){
                this.regest_stadus=true;
                this.login_stadus=false;
            },
            zhanghao_login_view(){
                this.zhanghao_login=true;
                this.weixin_login=false;
            },
            weixin_login_view(){
                this.weixin_login=true;
                this.zhanghao_login=false;
            },

            login_resist_view(){
                this.login_regest_view_stadus=true;
                this.update_password_view_stadus=false;
                this.login_out_view_stadus=false;
                this.update_userInfo_stadus=false;
            },
            update_password_view(){
                this.login_regest_view_stadus=false;
                this.update_password_view_stadus=true;
                this.login_out_view_stadus=false;
                this.update_userInfo_stadus=false;
            },
            login_out_view(){
                this.login_regest_view_stadus=false;
                this.update_password_view_stadus=false;
                this.login_out_view_stadus=true;
                this.update_userInfo_stadus=false;
            },
            upadete_userinfo_view(){
                this.login_regest_view_stadus=false;
                this.update_password_view_stadus=false;
                this.login_out_view_stadus=false;
                this.update_userInfo_stadus=true;
            },
            //城市列表的显示与消失
            my_cities_view(){
                this.my_cities_stadus=true;
            },
            my_cities_hide_view(){
                this.my_cities_stadus=false;
            },
        },
        //实例化vue时创建的函数 与执行
        created(){
            alert(11);
            this.play();
            this.cities_weather_Info();
        }
        
    });
})