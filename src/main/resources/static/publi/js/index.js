$(function(){
    //vue实例

    var index= new Vue({
        el:'#app',
        data:{
            roundImgs:['/index/imgs/01.jpeg','/index/imgs/02.jpeg','/index/imgs/03.jpeg','/index/imgs/04.jpeg','/index/imgs/05.jpeg'],
            jijieImgs:[{
                url:'/index/imgs/01.jpg',
                derection:`春季 春天，当然是美的，但每个人眼中的春天也各不一样。有人爱这杨柳菲菲，有人爱这细雨绵绵，也有人爱这清风徐徐。所幸的是生在诗香中国，在诗词佳作迭出的这片土地，我们每个人都能找到自己心中所喜的春。

                    关于“春”的诗句有那么多，我却独爱韩愈的一首《早春呈水部张十八员外》。每每读来，眼前便是一片清晰可见的早春好景。`
            },{
                url:'/index/imgs/02.jpg',
                derection:"夏季 收获前的一个季节，是一个充满生命力与活力的时候。玉米和小麦，黄澄澄亮晶晶就让人感到温馨.."
            },{
                url:'/index/imgs/03.jpg',
                derection:"秋季 秋天一到，果子的芳香扑鼻而来，醉人心脾。且不说黄澄澄的鸭梨压弯了树枝，红红的苹果像小灯笼挂满枝头。单那绿色走廊一样的葡萄架，就够我陶醉的了。"
            },{
                url:'/index/imgs/04.jpg',
                derection:"冬季 天空一碧如洗，灿烂的阳光正从密密的松针的缝隙间射下来，形成一束束粗粗细细的光柱，把飘荡着轻纱般薄雾的林荫照得通"
            }],
            cities:[],
            city_cis:[],
            mohu_seach_name:'',
            sights:     [],
            collections:[],
            a_xiangqing_sight:{
            },
            collected:false,
            shoucang_colle:'/index/imgs/sel.png',
            shoucang_colled:'/index/imgs/seled.png',
            IP:'',
            city:'陕西',
            city_ci:'西安',
            weather:[],
            mark:0,
            masg:'',
            timer:null,
            is_login:false,
            is_login_stadus:false,
            isAdmin:true,
            user_touxiang:'/index/imgs/user_img.png',
            user:{longin_id:'',name:'wang',img:'/index/imgs/user_img.png',user_type:100},
            user_comment:'',
            user_comments:[],
            //季节和主页面 我的收藏切换
            index_stadus:true,
            jijie_stadus:false,
            my_collection_stadus:false,
            my_cities_stadus:false,
            all_cities_stadus:false,
            //我的收藏下面宗页面和单个旅游景点的
            shoucangortuijian:'',
            a_sight_view:false,
            inco_a_sight_view:false,
            //登陆和注册  修改密码 退出登陆的模态框切换
            login_stadus:true,
            regest_stadus:false,

            update_password_view_stadus:false,
            login_out_view_stadus:false,
            update_userInfo_stadus:false,
            login_regest_view_stadus:true,

            dutu_view_stadus:false,
            ditu_view_name:'',
            dutu_view_url:'',
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
                "bishe_userInfo_sex":'m',
                "bishe_userInfo_email":''
            },
            kefuchat:'',
            chatsarr:[],
            toushudtadus:'文字',
            toushu_info:'',

            zixun_acti:'top',
            zixun_info:{
                data:[{
                    "uniquekey":"d26d25715bf009b307ab7605b0c5323f",
                    "title":"搞笑内涵笑话：女上司让我帮她修理电脑，她还不让我看！",
                    "date":"2019-04-11 13:49",
                    "category":"头条",
                    "author_name":"夫学须静才须学",
                    "url":"http://mini.eastday.com/mobile/190411134939733.html",
                    "thumbnail_pic_s":"http://07imgmini.eastday.com/mobile/20190411/2019041113_21cd9acd6dbf4e20a9619d42f7576823_5902_cover_mwpm_03200403.jpg",
                    "thumbnail_pic_s02":"http://07imgmini.eastday.com/mobile/20190411/2019041113_c60fc1de2b3c493dbf4bed6b13b149f0_2526_cover_mwpm_03200403.jpg",
                    "thumbnail_pic_s03":null
                }]
            },
        },
        filters:{
            sub:function (value) {
                var str=value.slice(0,20);
                return str;
            }
        },
        // router:router,
        methods: {
            zixun_acti_selece(val){
                var that = this;
                this.zixun_acti=val;
                $.ajax({
                    url:"http://localhost:8080/xinwen/getXinwenResponseByName/"+val,
                    type:'get',
                    success:function(data){
                        console.log(data);
                        that.zixun_info.data=data.result.data;
                        console.log(that.zixun_info)
                    },
                    error:function(data){
                        console.log(data,'12');
                    }
                });
            },
            toushu_wenzi_post(){
                var that = this;
                var data={
                    "bishe_complain_content":that.toushu_info
                }
                data=JSON.stringify(data);
                console.log(data);
                $.ajax({
                    url:'http://localhost:8080/complain/addComplain',
                    type:'post',
                    data:data,
                    dataType:'json',
                    contentType: 'application/json',
                    success:function(data){
                        console.log(data);
                        if(data=='1'){
                            alert("感谢您的投诉，我们会尽快处理！");
                        }
                        that.toushu_info=''

                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            },
            toushu_tupian_post(){

                var that=this;
                var formData = new FormData();
                formData.append('file', $('#toushu_img')[0].files[0]);
                $.ajax({
                    url:'http://localhost:8080/baiduImg/getBaiduImg',
                    type:'post',
                    cache: false,
                    data:formData,
                    processData: false,
                    contentType: false,
                    //enctype="multipart/form-data",
                    success:function(data){
                        console.log(data);
                        alert("感谢您的投诉，我们会尽快处理！");
                        that.toushu_tupian_post_path(data.toString());
                    },
                    error:function(data){

                    }
                });
            },
            toushu_tupian_post_path(picUrl){
                console.log(picUrl)
                var that = this;
                $.ajax({
                    url:"http://localhost:8080/baiduOcr/getBaiduOcr/"+picUrl,
                    type:'get',
                    success:function(data){
                        console.log(data);
                    },
                    error:function(data){
                        console.log(data,'12');
                    }
                });
            },
            showtou_shuimg(){
                $("[name='photo']").siblings('img').attr('src',URL.createObjectURL($("#toushu_img")[0].files[0]))
            },
            chatost(){
                var that = this;
                var data={
                    "bishe_register_username":this.user.object.bishe_register_username,
                    "com":that.kefuchat
                }
                data=JSON.stringify(data);
                console.log(data);
                $.ajax({
                    url:'http://localhost:8080/collect/addCollect',
                    type:'post',
                    data:data,
                    dataType:'json',
                    contentType: 'application/json',
                    success:function(data){
                        console.log(data);
                        that.getAllchatslist();
                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            },
            getAllchatslist(){
                var that = this;
                $.ajax({
                    url:"http://localhost:8080/tour/getTourById/"+bishe_tour_id,
                    type:'get',
                    success:function(data){
                        console.log(data);
                    },
                    error:function(data){
                        console.log(data,'12');
                    }
                });
            },
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
                var that =this;
                // Lambda写法
                this.$http.get('http://localhost:8080/lunboImg/getLunboImg').then(function (value) {
                    var arr = [];
                    value.body.forEach(function (item) {
                        arr.push(item.bishe_lunboimg_image);
                    })
                    that.roundImgs = arr;
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
            my_collection_view(val){
                this.shoucangortuijian = val;
                this.index_stadus=false;
                this.jijie_stadus=false;
                this.my_collection_stadus=true;
                this.all_cities_stadus=false;
                this.my_all_sellectsights(val);
            },
            //lvyou详情页面
            asight_view(bishe_tour_id){

                var that=this;
                //that.comments_lvyou(bishe_tour_id);
                $.ajax({
                    url:'http://localhost:8080/comment/showTourComment/'+bishe_tour_id,
                    type:'get',
                    success:function(data){
                        console.log(data,"ok");
                        that.user_comments=data;
                        console.log(that.user_comments);

                        that.a_sight_view=true;
                        $.ajax({
                            url:"http://localhost:8080/tour/getTourById/"+bishe_tour_id,
                            type:'get',
                            success:function(data){
                                console.log(data);
                                that.a_xiangqing_sight=data;
                                that.collected=false;
                                that.collections.forEach(function (bb) {
                                    if(that.a_xiangqing_sight.bishe_tour_id==bb.bishe_tour_id){
                                        that.collected=true;
                                    }
                                })
                                that.tour_view_time(bishe_tour_id)

                            },
                            error:function(data){
                                console.log(data,'12');
                            }
                        });

                    },
                    error:function(data){
                        console.log(data);
                    }
                });


            },
            tour_view_time(tour_id){

                var that = this;
                var data={
                    "bishe_hitcount_tour_id":tour_id
                }
                data=JSON.stringify(data);
                $.ajax({
                    url:'http://localhost:8080/hitCount/saveHitCount',
                    type:'post',
                    data:data,
                    dataType:'json',
                    contentType: 'application/json',
                    success:function(data){
                        console.log(data);

                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            },
            //详情页面的点击名字现实地图
            sight_ditu(name){
                this.ditu_view_name=name;

                this.login_regest_view_stadus=false;
                this.update_password_view_stadus=false;
                this.login_out_view_stadus=false;
                this.update_userInfo_stadus=false;
                this.is_login_stadus=false;
                this.dutu_view_stadus=true;

                var that=this;
                $.ajax({
                    url:"http://localhost:8080/map/getMapURL/"+name,
                    type:'get',
                    success:function(data){
                        console.log(data,"ok");
                        that.dutu_view_url=data;

                    },
                    error:function(data){
                        console.log(data,'12');
                    }
                });
            },
            //收藏页面的详情  转到旅游业面
            cp_asight_view(bishe_tour_id){
                this.all_cities_view();
                this.asight_view(bishe_tour_id);
            },
            //点击收藏旅游信息
            postcollect_city_info(bishe_tour_id){
                this.collected=true;
                var that = this;
                var data={
                    "bishe_register_id":this.user.object.bishe_register_id,
                    "bishe_collect_tour_id":bishe_tour_id
                }
                data=JSON.stringify(data);
                console.log(data);
                $.ajax({
                    url:'http://localhost:8080/collect/addCollect',
                    type:'post',
                    data:data,
                    dataType:'json',
                    contentType: 'application/json',
                    success:function(data){
                        console.log(data);
                        alert("收藏成功！");
                        that.sights.forEach(function (item) {
                            if(item.bishe_tour_id==bishe_tour_id){
                                item.collect=true;
                            }
                        })
                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            },
            //提交经典评论
            comment_comit_inlvyou(tour_id){
                var that=this;
                var data={
                    "bishe_comment_tour_id":tour_id,
                    "bishe_comment_content":this.user_comment,
                    "bishe_register_id":this.user.object.bishe_register_id
                }
                data=JSON.stringify(data);
                console.log(data);
                if(!this.user.code||this.user.code==100){
                    alert("您还没有登录，请先登录！");
                }else{

                    $.ajax({
                        url:'http://localhost:8080/comment/addComment',
                        type:'post',
                        data:data,
                        dataType:'json',
                        contentType: 'application/json',
                        success:function(data){
                            console.log(data,"ok");
                            alert("评论成功！");
                            that.user_comment='';
                            that.comments_lvyou(tour_id);
                        },
                        error:function(data){
                            console.log(data,"err");
                        }
                    });

                }
            },
            //评论的列表
            comments_lvyou(tour_id){
                var that=this;
                $.ajax({
                    url:'http://localhost:8080/comment/showTourComment/'+tour_id,
                    type:'get',
                    success:function(data){
                        console.log(data,"ok");
                        that.user_comments=data;
                        console.log(that.user_comments);
                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            },
            //我的收藏接口
            my_all_sellectsights(val){
                if(val=='系统推荐'){
                    var that = this;
                    var bishe_collect_register_id=this.user.object.bishe_register_id;
                    var city = this.city_ci;
                    var data = {
                        bishe_collect_register_id,
                        city
                    }
                    data=JSON.stringify(data);
                    console.log(data);
                    $.ajax({
                        url:'http://localhost:8080/recommend/getTourEntityByRecommend/',
                        type:'post',
                        data:data,
                        dataType:'json',
                        contentType: 'application/json',
                        success:function(data){
                            console.log(data,"11111111111111");
                            that.collections=data;
                            that.collections.forEach(function (item) {
                                item.collect=true;
                            });

                            that.sights.forEach(function (item) {
                                that.collections.forEach(function (bb) {
                                    if(item.bishe_tour_id==bb.bishe_tour_id){
                                        item.collect=true;
                                    }
                                })
                            })
                        },
                        error:function(data){
                            console.log(data);
                        }
                    });
                }else{
                    var that = this;
                    var bishe_register_id=this.user.object.bishe_register_id;
                    $.ajax({
                        url:'http://localhost:8080/collect/showCollect/'+bishe_register_id,
                        type:'get',
                        success:function(data){
                            console.log(data,"shoucangall");
                            that.collections=data;
                            that.collections.forEach(function (item) {
                                item.collect=true;
                            });

                            that.sights.forEach(function (item) {
                                that.collections.forEach(function (bb) {
                                    if(item.bishe_tour_id==bb.bishe_tour_id){
                                        item.collect=true;
                                    }
                                })
                            })
                        },
                        error:function(data){
                            console.log(data);
                        }
                    });
                }

            },
            //取消收藏
            un_collect_sight(bishe_tour_id){
                this.collected=false;
                var that = this;
                var data={
                    "bishe_collect_tour_id":bishe_tour_id,
                    "bishe_collect_register_id":this.user.object.bishe_register_id
                }
                data=JSON.stringify(data);
                $.ajax({
                    url:'http://localhost:8080/collect/deleteCollect',
                    type:'post',
                    data:data,
                    dataType:'json',
                    contentType: 'application/json',
                    success:function(data){
                        console.log(data);
                        alert("已取消收藏！");
                        that.sights.forEach(function (item) {
                            if(item.bishe_tour_id==bishe_tour_id){
                                item.collect=false;
                            }
                        })
                        that.my_all_sellectsights();
                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            },
            //塞选以及收藏或没有收藏的旅游
            saixuanlcyou_sights(arr){
                var that=this;
                this.my_all_sellectsights('我的收藏');
                arr.forEach(function (item) {
                    that.collections.forEach(function (bb) {
                        if(item.bishe_tour_id==bb.bishe_tour_id){
                            item.collect=true;
                        }
                    })
                });
                this.sights=arr;

            },
            //判断所有旅游列表那些是收藏里面有的
            alllvyouinfo_cp_cosighi(){

            },
            //自动获取ip
            getIp(){
                var that=this;
                $.ajax({
                    url:"http://localhost:8080/ip/getIp",
                    type:'get',
                    success:function(data){
                        that.IP=data.response.ip;
                        that.getCityByIp(that.IP);
                    },
                    error:function(data){
                        console.log(data,'12');
                    }
                });
            },
            //ip获取地理位置
            getCityByIp(ip){
                var that=this;
                $.ajax({
                    url:"http://localhost:8080/address/getAddress/"+ip,
                    type:'get',
                    success:function(data){

                        that.city=data.province;
                        that.city_ci=data.city;
                        that.$http.get("http://localhost:8080/weather/cityName/"+data.city).then((response) => {
                            // 响应成功回调

                            response=JSON.parse(response.bodyText);

                        that.weather=response.data;
                        console.log(that.weather)
                    }, (response) => {
                            // 响应错误回调

                            console.log(000);
                        });
                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            },
            //获得所有省份的接口
            getAllProvence(){
                var that=this;
                $.ajax({
                    url:"http://localhost:8080/province/getProvinceList",
                    type:'get',
                    success:function(data){
                        that.cities=data;

                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            },
            //切换省
            cities_cp(val,id){
                this.city=val;
                var bishe_city_provence_id=id;
                var that=this;
                //请求市
                $.ajax({
                    url:"http://localhost:8080/city/getCityList/"+bishe_city_provence_id,
                    type:'get',
                    success:function(data){
                        console.log(data);
                        that.city_cis=data;

                    },
                    error:function(data){
                        console.log(data);
                    }
                });

            },
            city_ci_cp(val){
                this.city_ci=val;
                this.all_cities_view();
                var that=this;
                this.a_sight_view=false;
                this.$http.get("http://localhost:8080/weather/cityName/"+val).then((response) => {
                    // 响应成功回调

                    response=JSON.parse(response.bodyText);
                that.weather=response.data;
                console.log(that.weather)
            }, (response) => {
                    // 响应错误回调

                    console.log(000);
                });
                this.click_city_getAll_sights(val);
            },
            //通过点击city获取旅游信息
            click_city_getAll_sights(bishe_tour_city_name){
                var that=this;
                console.log(bishe_tour_city_name);
                $.ajax({
                    url: "http://localhost:8080/tour/getTourListByCity/"+bishe_tour_city_name,
                    type: 'get',
                    success: function (data) {
                        var arr=data;
                        arr.forEach(function (item) {
                            item.collect=false;
                        });
                        that.saixuanlcyou_sights(arr);
                    },
                    error: function (data) {
                        console.log(data);
                    }
                });
            },
            //查询城市
            all_cities_view(){
                this.sights=[];
                var that=this;
                this.index_stadus=false;
                this.jijie_stadus=false;
                this.my_collection_stadus=false;
                this.all_cities_stadus=true;
                this.a_sight_view=false;
                var info=this.mohu_seach_name;
                $.ajax({
                    url: "http://localhost:8080/tour/getTourListByMohuName/"+info,
                    type: 'get',
                    success: function (data) {
                        var arr=data;
                        arr.forEach(function (item) {
                            item.collect=false;
                        });
                        that.saixuanlcyou_sights(arr);

                    },
                    error: function (data) {
                        console.log(data);
                    }
                });
                if(info==''){
                    $.ajax({
                        url: "http://localhost:8080/tour/getTourAll",
                        type: 'get',
                        success: function (data) {

                            var arr=data;
                            arr.forEach(function (item) {
                                item.collect=false;
                            });
                            that.saixuanlcyou_sights(arr);

                        },
                        error: function (data) {
                            console.log(data);
                        }
                    });
                }
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
                this.is_login_stadus=false;
                this.dutu_view_stadus=false;
            },
            update_password_view(){
                this.login_regest_view_stadus=false;
                this.update_password_view_stadus=true;
                this.login_out_view_stadus=false;
                this.update_userInfo_stadus=false;
                this.is_login_stadus=false;
                this.dutu_view_stadus=false;
            },
            login_out_view(){
                this.login_regest_view_stadus=false;
                this.update_password_view_stadus=false;
                this.login_out_view_stadus=true;
                this.update_userInfo_stadus=false;
                this.is_login_stadus=false;
                this.dutu_view_stadus=false;
            },
            upadete_userinfo_view(){
                this.login_regest_view_stadus=false;
                this.update_password_view_stadus=false;
                this.login_out_view_stadus=false;
                this.update_userInfo_stadus=true;
                this.is_login_stadus=false;
                this.dutu_view_stadus=false;
            },
            //城市列表的显示与消失
            my_cities_view(){
                this.my_cities_stadus=true;
            },
            my_cities_hide_view(){
                this.my_cities_stadus=false;
            },
            //注册的接口
            register(){
                var that=this;
                let data={
                    "bishe_register_username":this.registerInfo.bishe_register_username,
                    "bishe_register_password":this.registerInfo.bishe_register_password,
                    "bishe_register_repassword":this.registerInfo.bishe_register_repassword
                }
                data=JSON.stringify(data);
                console.log(data);
                $.ajax({
                    url:'http://localhost:8080/register/regis',
                    type:'post',
                    data:data,
                    dataType:'json',
                    contentType: 'application/json',
                    success:function(data){
                        console.log(data);
                        alert("登陆成功！返回登陆界面！");
                        that.registerInfo.bishe_register_username;
                        that.registerInfo.bishe_register_password;
                        that.registerInfo.bishe_register_repassword;
                        that.login_view();
                    },
                    error:function(data){
                        console.log(data);
                    }
                });

            },
            paidfor(){
                var that = this;
                var money = 50;
                $.ajax({
                    url: "http://localhost:8080/alipay/getAlipay/"+money,
                    type: 'get',
                    success: function (data) {
                        console.log(data,"ok222222222222");
                        window.localStorage.setItem("paidInfo",data);
                        window.location.href="./paid.html";
                    },
                    error: function (data) {
                    }
                });
            },
            //登录的接口
            login(){
                var that=this;
                let data={
                    "bishe_register_username":this.loginInfo.bishe_register_username,
                    "bishe_register_password":this.loginInfo.bishe_register_password,
                }
                data=JSON.stringify(data);
                $.ajax({
                    url:'http://localhost:8080/register/login',
                    type:'post',
                    data:data,
                    dataType:'json',
                    contentType: 'application/json',
                    success:function(data){
                        console.log(data);
                        if(data==1){
                            that.masg="账号密码错误！";
                            that.login_regest_view_stadus=false;
                            that.is_login_stadus=true;
                        }else{
                            that.user=data;
                            if(data.code==2){//管理员
                                that.is_login=true;
                                that.isAdmin=true;
                            }
                            if(data.code==3){//普通用户
                                that.is_login=true;
                                that.isAdmin=false;
                            }
                            that.masg="登陆成功";
                            that.login_regest_view_stadus=false;
                            that.is_login_stadus=true;
                            savaLOginUserInfo(data);
                        }

                    },
                    error:function(data){
                        console.log(data,'sssss');
                    }
                });
            },
            //修改密码的接口
            updateUserPassword(){
                var that=this;
                let data={
                    "bishe_register_id":this.user.object.bishe_register_id,
                    "bishe_register_password":this.updateUserInfo.bishe_register_password,
                    "bishe_register_newpassword":this.updateUserInfo.bishe_register_newpassword,
                    "bishe_register_renewpassword":this.updateUserInfo.bishe_register_renewpassword
                }
                //将data的json转换成字符串
                data=JSON.stringify(data);
                $.ajax({
                    url:'http://localhost:8080/register/updatePassword',
                    type:'post',
                    data:data,
                    dataType:'json',
                    contentType: 'application/json',
                    success:function(data){
                        console.log(data);
                        if(data==1){
                            that.masg="原密码不能为空！";
                            that.update_password_view_stadus=false;
                            that.is_login_stadus=true;
                        }
                        if(data==2){
                            that.masg="新密码不能为空！";
                            that.update_password_view_stadus=false;
                            that.is_login_stadus=true;
                        }
                        if(data==3){
                            that.masg="重复密码不能为空！";
                            that.update_password_view_stadus=false;
                            that.is_login_stadus=true;
                        }
                        if(data==4){
                            that.masg="原密码不正确";
                            that.update_password_view_stadus=false;
                            that.is_login_stadus=true;
                        }
                        if(data==5){
                            that.masg="重复密码不一致！";
                            that.update_password_view_stadus=false;
                            that.is_login_stadus=true;
                        }
                        if(data==6){
                            that.masg="修改密码成功！";
                            that.update_password_view_stadus=false;
                            that.is_login_stadus=true;
                        }
                    },
                    error:function(data){
                        console.log(data);
                    }
                });


            },
            //退出登录接口
            loginOut(){
                var that=this;
                this.$http.get('http://localhost:8080/register/logout').then((response) => {
                    // 响应成功回调

                    that.masg="退出登陆成功！";
                that.login_out_view_stadus=false;
                that.is_login_stadus=true;
                tuichudenglu();

            }, (response) => {
                    // 响应错误回调
                    console.log(000);
                    that.masg="退出登陆成功！";
                    that.login_out_view_stadus=false;
                    that.is_login_stadus=true;
                    tuichudenglu();
                });

            },
            //更新个人信息
            update_userInfo(){
                var that=this;
                let data={
                    "bishe_register_id":this.user.object.bishe_register_id,
                    "bishe_user_info_nike":this.updateUsrAllInfo.bishe_userInfo_nike,
                    "bishe_user_info_sex":this.updateUsrAllInfo.bishe_userInfo_sex,
                    "bishe_user_info_email":this.updateUsrAllInfo.bishe_userInfo_email
                }
                data=JSON.stringify(data);
                console.log(data);

                $.ajax({
                    url:'http://localhost:8080/userInfo/addUserInfo',
                    type:'post',
                    data:data,
                    contentType: 'application/json',
                    success:function(data){

                        console.log("1111");
                        console.log(data);
                        addUser_Info_Img();
                        //that.update_userInfo_img();
                    },
                    error:function(data){
                        console.log("00000");

                    }
                });
            },
            //更新个人信息的照片上传
            update_userInfo_img(){
                var that=this;
                let x = document.getElementById('updateUser_touxiang').files[0];
                console.log(x);
                let params = new FormData() ; //创建一个form对象
                params.append('file',x,x.name);  //append 向form表单添加数据
                console.log(params);

                //添加请求头  通过form添加的图片和文件的格式必须是multipart/form-data
                // let config = {
                //     headers:{'enctype':'multipart/form-data'}
                // };
                // const instance=axios.create({
                //     withCredentials: true,
                //     headers:{'Content-Type':'multipart/form-data'}
                //    }) 
                // instance.post("http://localhost:8080/userInfo/addUserInfoImage",params)
                //     .then(function(res){
                //         console.log(res);
                //         this.masg="个人信息更新成功！";
                //         this.update_userInfo_stadus=false;
                //         this.is_login_stadus=true;
                //     }).catch(function (error) {
                //         console.log(error);
                //    });


                axios({
                    method: 'post',
                    url: '/user/12345',
                    data: {
                        firstName: 'Fred',
                        lastName: 'Flintstone'
                    }
                }).then(function (response) {
                    console.log(response);
                }).catch(function (error) {
                    console.log(error);
                });
            },
            enterBackweb(){
                window.location.href="../admin/admin.html?name="+this.user.object.bishe_register_username+
                    "&code="+this.user.code+"&bishe_register_id="+this.user.object.bishe_register_id;
            },

            //战死ACAT二维码
            shouAcatimg(){
                $('.ACATimg').show();
            },
            //小时二维码
            hideAcatimg(){
                $('.ACATimg').hide();
            }
        },
        //实例化vue时创建的函数 与执行
        created(){
            this.roundImgsGet();
            this.getIp();
            this.play();
            this.getAllProvence();
            this.cities_weather_Info();
            this.zixun_acti_selece('top');

        }

    });
    function savaLOginUserInfo(data){
        window.localStorage.setItem("userInfo",JSON.stringify(data));
    }
    function updateWangye(){
        index.user=JSON.parse(window.localStorage.getItem("userInfo"));
        // var str=window.localStorage.getItem("touxiang");
        // if(str!='none'){
        //     index.user_touxiang=window.localStorage.getItem("touxiang");
        // }
        console.log(index.user);
        if(index.user.code==2){//管理员
            index.is_login=true;
            index.isAdmin=true;
        }
        if(index.user.code==3){//普通用户
            index.is_login=true;
            index.isAdmin=false;
        }
    }
    updateWangye();
    function tuichudenglu(){
        window.localStorage.setItem("userInfo",JSON.stringify({
            "code":100
        }));
        window.location.reload();
    }
    function addUser_Info_Img(){
        var formData = new FormData();
        formData.append('file', $('#updateUser_touxiang')[0].files[0]);
        $.ajax({
            url:'http://localhost:8080/userInfo/addUserInfoImage',
            type:'post',
            cache: false,
            data:formData,
            processData: false,
            contentType: false,
            //enctype="multipart/form-data",
            success:function(data){
                console.log(data);
                window.localStorage.setItem("touxiang","http://localhost:8080"+data);
                index.user_touxiang=window.localStorage.getItem("touxiang");
                index.masg="个人信息更新成功！";
                index.update_userInfo_stadus=false;
                index.is_login_stadus=true;
            },
            error:function(data){

            }
        });
    }

});
