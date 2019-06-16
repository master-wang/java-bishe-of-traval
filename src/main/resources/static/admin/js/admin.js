$(function(){
    // function GetQueryString(name)
    // {
    //     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    //     var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
    //     if(r!=null)return  unescape(r[2]); return null;
    // }
    //
    // //vue实例
    // var User={
    //     name:GetQueryString('name'),
    //     code:GetQueryString('code'),
    //     bishe_register_id:GetQueryString('bishe_register_id'),
    // };
    // window.localStorage.setItem("userInfo",JSON.stringify(User));

    var routes = [
        {
            path : '/',
            component : {
                template : `
                <div class="jumbotron">
                <h1>hellow,管理员：{{user.object.bishe_register_username}}</h1>
                <p>欢迎进入我的管理系统</p>
                </div>`,
                data:function(){
                    var user=JSON.parse(window.localStorage.getItem("userInfo"));
                    return {
                        user
                    }
                }
            },

        },
        {
            path : '/error',
            component : {
                template : `
                <div class="jumbotron">
                <p>错误</p>
                </div>`
            },

        },
        {
            path : '/success',
            component : {
                template : `
                <div class="jumbotron">
                <p>{{$route.query.msg}}</p>
                </div>`
            },

        },
        {
            path : '/usersList',
            component : {
                template : `
                <div class="jumbotron">
                    <p>用户列表管理</p>
                    <table class="table table-striped table-bordered table-hover">
                        <tbody>
                        <tr>
                            <th>编号</th>
                            <th>ID</th>
                            <th>昵称</th>
                            <th>性别</th>
                            <th>Email</th>
                            <th>操作</th>
                        </tr>
                        <tr v-for="(userInfo,index) in usersList">
                            <td>{{index+1}}</td>
                            <td>{{userInfo.bishe_user_info_id}}</td>
                            <td>{{userInfo.bishe_user_info_nike}}</td>
                            <td v-if="userInfo.bishe_user_info_sex=='m'">男</td>
                            <td v-if="userInfo.bishe_user_info_sex!='m'">女</td>
                            <td>{{userInfo.bishe_user_info_email}}</td>
                            <td>
                            <router-link  :to="{path:'/userDelete',query: {
                                bishe_userInfo_id:userInfo.bishe_user_info_id,
                                bishe_userInfo_nike:userInfo.bishe_user_info_nike,
                            }}">封号</router-link></td>
                        </tr>
                        </tbody>
                    </table>
                </div>`,
                data:function(){
                    return {
                        usersList:[
                            {
                            "bishe_user_info_id":"1",
                            "bishe_user_info_nike":"kuke",
                            "bishe_user_info_sex":"男",
                            "bishe_user_info_email":"2791752775@qq.com",
                            "bishe_user_info_image":"xxx",
                            "bishe_user_info_registerId":"1"
                            },
                            {
                            "bishe_user_info_id":"2",
                            "bishe_user_info_nike":"ssss",
                            "bishe_user_info_sex":"女",
                            "bishe_user_info_email":"2791752775@qq.com",
                            "bishe_user_info_image":"xxx",
                            "bishe_user_info_registerId":"000"
                            }
                        ]
                    }
                },
                methods:{
                    getAll_userlist(){
                        var that = this;
                        $.ajax({
                            url: "http://localhost:8080/userInfo/getList",
                            type: 'get',
                            success: function (data) {
                                console.log(data);
                                that.usersList = data;

                            },
                            error: function (data) {
                                console.log(data);
                            }
                        });
                    }
                },
                created(){
                    this.getAll_userlist();
                }
            }

        },
        {
            path : '/usersUpdate',
            component : {
                template : `
                <div class="jumbotron" id="usersUpdate">
                    <p>{{$route.query.bishe_userInfo_nike}}信息修改</p>
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">用户昵称：</label>
                            <div class="col-sm-10">
                            <input type="text" v-model="updateUsrAllInfo.bishe_userInfo_nike"  class="form-control"  placeholder="输入用户昵称">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">性别：</label>
                            <div class="col-sm-10">
                            <select name="" v-model="updateUsrAllInfo.bishe_userInfo_sex" class="form-control" >
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">邮箱：</label>
                            <div class="col-sm-10">
                            <input v-model="updateUsrAllInfo.bishe_userInfo_email" type="email" placeholder="输入邮箱" class="form-control" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">头像</label>
                            <div class="col-sm-10">
                                <input type="file" id="updateUser_touxiang" accept="image/gif, image/jpeg,image/png,image/jpg" >
                                <p class="help-block">不传头像会默认头像</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                            <button  type="button" class="btn btn-primary" @click="update_userInfo()">确定修改</button>
                            </div>
                        </div>
                    </form>
                    
                
                </div>`,
                data:function(){
                    return {
                        updateUsrAllInfo:{
                            "bishe_userInfo_id":"",
                            "bishe_userInfo_nike":"",
                            "bishe_userInfo_sex":"男",
                            "bishe_userInfo_email":'',
                            "bishe_userInfo_image":"",
                            "bishe_userInfo_registerId":""
                            }
                        
                    }
                },
                methods:{
                    //获取传参
                    getRouterData(){
                        this.updateUsrAllInfo.bishe_userInfo_id= this.$route.query.bishe_userInfo_id;
                        this.updateUsrAllInfo.bishe_userInfo_nike= this.$route.query.bishe_userInfo_nike;
                        this.updateUsrAllInfo.bishe_userInfo_sex= this.$route.query.bishe_userInfo_sex;
                        this.updateUsrAllInfo.bishe_userInfo_email= this.$route.query.bishe_userInfo_email;
                        this.updateUsrAllInfo.bishe_userInfo_image= this.$route.query.bishe_userInfo_image;
                        this.updateUsrAllInfo.bishe_userInfo_registerId= this.$route.query.bishe_userInfo_registerId;
                    },
                    //更新个人信息
                    update_userInfo(){
                        let data={
                            "bishe_userInfo_nike":this.updateUsrAllInfo.bishe_userInfo_nike,
                            "bishe_userInfo_sex":this.updateUsrAllInfo.bishe_userInfo_sex,
                            "bishe_userInfo_email":this.updateUsrAllInfo.bishe_userInfo_email
                        }
                        data=JSON.stringify(data);
                        console.log(data);

                        $.ajax({
                            url:'http://localhost:8080/userInfo/updateUserInfo',
                            type:'post',
                            data:data,
                            contentType: 'application/json',
                            success:function(data){

                            },
                            error:function(data){
                                
                            }
                        });
                    },
                    //更新个人信息的照片上传
                    update_userInfo_img(){
                        let x = document.getElementById('updateUser_touxiang').files[0];
                        console.log(x);
                        let params = new FormData() ; //创建一个form对象
                        params.append('file',x,x.name);  //append 向form表单添加数据
                        console.log(params);
                        //添加请求头  通过form添加的图片和文件的格式必须是multipart/form-data
                        let config = {
                            headers:{'Content-Type':'multipart/form-data'}
                        };
                        axios.post("http://localhost:8080/userInfo/updateUserInfoImage",params,config)
                            .then(function(res){
                                console.log(res);
                                alert("更新成功！");
                            }.bind(this))
                            .catch(function (error) {
                                console.log(error);
                        })
                        
                        
                    }
                },
                created(){
                    this.getRouterData();
                }
                
            },

        },
        {
            path : '/userDelete',
            component : {
                template : `
                <div class="jumbotron">
                <p>确定封号{{$route.query.bishe_userInfo_nike}}的信息？</p>
                <button  type="button" class="btn btn-primary" @click="delete_user()">确定封号</button>
                </div>`,
                methods:{
                    delete_user(){
                        var that = this;
                        var bishe_user_info_id=this.$route.query.bishe_userInfo_id;
                        console.log(bishe_user_info_id);

                        $.ajax({
                            url:'http://localhost:8080/userInfo/deleteUserInfo/'+bishe_user_info_id,
                            type:'get',
                            success:function(data){
                                that.$router.push({
                                    path: '/success',
                                    query: {
                                        "msg":"删除成功！"
                                    }
                                })
                            },
                            error:function(data){

                            }
                        });
                    },
                }
            },

        },
        {
            path : '/usersAdd',
            component : {
                template : `
                <div class="jumbotron">
                    <p>用户添加</p>
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">用户昵称：</label>
                            <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmail3" placeholder="输入用户昵称">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">性别：</label>
                            <div class="col-sm-10">
                            <select name="" id="" class="form-control">
                                <option value="">男</option>
                                <option value="">女</option>
                            </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">邮箱：</label>
                            <div class="col-sm-10">
                            <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">头像</label>
                            <div class="col-sm-10">
                                <input type="file" id="exampleInputFile">
                                <p class="help-block">不传头像会默认头像</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-primary">添加</button>
                            </div>
                        </div>
                    </form>
                
                </div>`
            }

        },
        {
            path : '/roudImgs',
            component : {
                template : `
                <div class="jumbotron">
                <p>轮播图的更新</p>
                <p><label>上传图片: </label><input id="roudImgs"  type="file" name="text6" value="" accept="image/gif, image/jpeg,image/png,image/jpg"  multiple="multiple" /></p>
                <p>最多上传五张图片</p>
                <div>
                        <button type="button"  class="btn btn-primary" @click="roudadd()">上传</button>
                </div>
                </div>`,
                methods:{
                    roudadd(){
                        var that=this;
                        var formData = new FormData();
                        if($('#roudImgs')[0].files.length>5||$('#roudImgs')[0].files[0]==''){
                            alert("图片不能大于五张或为空！")
                        }else{
                            for(var i=0;i<$('#roudImgs')[0].files.length;i++){
                                formData.append('file', $('#roudImgs')[0].files[i]);
                            }
                            $.ajax({
                                url:'http://localhost:8080/lunboImg/addLunboImg',
                                type:'post',
                                cache: false,
                                data:formData,
                                processData: false,
                                contentType: false,
                                success:function(data){
                                    console.log(data);
                                    that.$router.push({
                                        path: '/success',
                                        query: {
                                            "msg":"轮播图上传成功！"
                                        }
                                    })
                                },
                                error:function(data){
                                    console.log(data);
                                    that.$router.push({
                                        path: '/success',
                                        query: {
                                            "msg":"轮播图上传成功！"
                                        }
                                    })
                                }
                            });
                        }
                    }
                }
            },


        },
        {
            path : '/toursList',
            component : {
                template : `
                <div class="jumbotron">
                    <p>旅游查询</p>
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">查询景点</label>
                            <div class="col-sm-5">
                            <input v-model="mohu_seach_cities"  type="text" class="form-control" placeholder="...搜索旅游景点" style="color: rgb(255,157,0);">
                            </div>
                            <div class="col-sm-5">
                            <button type="button" class="btn btn-default "  id="bar-btn" style="color: rgb(255,157,0);" @click="mohuseach_city()">查询</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">景点所在的省份</label>
                            <div class="col-sm-3">
                            <select v-model="tourInfo.bishe_tour_provinceid" @change="getAll_cities()" class="form-control">
                             <option v-for="provence in cities" :value="provence.bishe_province_id">{{provence.bishe_province_name}}</option>
                             </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">景点所在的市</label>
                            <div class="col-sm-3">
                            <select v-model="tourInfo.bishe_tour_cityName" @change="getAll_sights()" name="" id="" class="form-control">
                            <option v-for="city in cli" :value="city.bishe_city_name">{{city.bishe_city_name}}</option>
                        </select>
                            </div>
                        </div>
                        
                    </form>
                    <div class="jumbotron">
                        <p>旅游列表</p>
                        <table class="table table-striped table-bordered table-hover">
                            <tbody>
                            <tr>
                                <th>编号</th>
                                <th>ID</th>
                                <th>景点名称</th>
                                <th>所在省</th>
                                <th>所在市</th>
                                <th>Image</th>
                                <th>简介</th>
                                <th>上传时间</th>
                                <th>操作</th>
                            </tr>
                            <tr v-for="(tour,index) in tours">
                                <td>{{index+1}}</td>
                                <td>{{tour.bishe_tour_id}}</td>
                                <td>{{tour.bishe_tour_name}}</td>
                                <td>{{tour.bishe_tour_province_name}}</td>
                                <td>{{tour.bishe_tour_city_name}}</td>
                                <td><img :src="tour.bishe_tour_image" style="width: 50px;height: 50px"></td>
                                <td>{{tour.bishe_tour_desc}}</td>
                                <td>{{tour.bishe_tour_time}}</td>
                                <td> <router-link  :to="{path:'/tourUpdate',query: {
                                bishe_tour_id:tour.bishe_tour_id,
                                bishe_tour_name:tour.bishe_tour_name,
                                bishe_tour_province_name:tour.bishe_tour_province_name,
                                bishe_tour_city_name:tour.bishe_tour_city_name,
                                bishe_tour_image:tour.bishe_tour_image,
                                bishe_tour_desc:tour.bishe_tour_desc,
                                bishe_tour_registerId:tour.bishe_tour_registerId
                            }}">修改</router-link>|
                            <router-link  :to="{path:'/tourDelete',query: {
                                bishe_tour_id:tour.bishe_tour_id,
                                bishe_tour_name:tour.bishe_tour_name,
                            }}">删除</router-link></td>
                            </tr>
                        </tbody>
                        </table>
                    </div>
                </div>`,
                data:function(){
                    return {
                        tours:[
                            {
                                "bishe_tour_id":"1",
                                "bishe_tour_name":"兵马俑",
                                "bishe_tour_province_name":"陕西省",
                                "bishe_tour_city_name":"西安市",
                                "bishe_tour_image":"xxx",
                                "bishe_tour_desc":"兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑兵马俑",
                                "bishe_tour_time":"2019-11-11",
                                "bishe_tour_registerId":"1"
                              },
                                {
                                "bishe_tour_id":"2",
                                "bishe_tour_name":"壶口瀑布",
                                "bishe_tour_province_name":"陕西省",
                                "bishe_tour_city_name":"延安市",
                                "bishe_tour_image":"xxx",
                                "bishe_tour_desc":"壶口瀑布壶口瀑布壶口瀑布壶口瀑布壶口瀑布壶口瀑布",
                                "bishe_tour_time":"2019-11-11",
                                "bishe_tour_registerId":"1"
                              }
                        ],
                        mohu_seach_cities:'',
                        tourInfo:{
                            "bishe_tour_name":'',
                            "bishe_tour_provinceid":'',
                            "bishe_tour_cityName":'',
                            "bishe_tour_desc":''
                        },
                        cities:[],
                        cli:[]
                    }
                },
                methods: {
                    getAll_tour_list() {
                        var that = this;
                        $.ajax({
                            url: "http://localhost:8080/tour/getTourAll",
                            type: 'get',
                            success: function (data) {
                                console.log(data);
                                that.tours = data;

                            },
                            error: function (data) {
                                console.log(data);
                            }
                        });
                    },
                    mohuseach_city(){
                        var that = this;
                        var info=this.mohu_seach_cities;
                        var seachData={
                            in:info
                        }
                        $.ajax({
                            url: "http://localhost:8080/tour/getTourListByMohuName/"+info,
                            type: 'get',
                            success: function (data) {
                                console.log(data);
                                that.tours = data;

                            },
                            error: function (data) {
                                console.log(data);
                            }
                        });
                    },
                    getAll_provence(){
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
                    getAll_cities(){
                        var that=this;
                        //请求市
                        $.ajax({
                            url:"http://localhost:8080/city/getCityList/"+that.tourInfo.bishe_tour_provinceid,
                            type:'get',
                            success:function(data){
                                console.log(data);
                                that.cli=data;

                            },
                            error:function(data){
                                console.log(data);
                            }
                        });

                    },
                    getAll_sights(){
                        var that=this;
                        var bishe_tour_city_name=this.tourInfo.bishe_tour_cityName;
                        console.log(bishe_tour_city_name);
                        $.ajax({
                            url: "http://localhost:8080/tour/getTourListByCity/"+bishe_tour_city_name,
                            type: 'get',
                            success: function (data) {
                                console.log(data);
                                that.tours = data;

                            },
                            error: function (data) {
                                console.log(data);
                            }
                        });
                    }
                },
                created(){
                    this.getAll_tour_list();
                    this.getAll_provence();
                }
            }

        },
        {
            path : '/tourDelete',
            component : {
                template : `
                <div class="jumbotron">
                <p>确认删除{{$route.query.bishe_tour_name}}的信息？</p>
                <button  type="button" class="btn btn-primary" @click="delete_tour()">确定修改</button>
                </div>`,
                methods:{
                    delete_tour(){
                        var that=this;
                        var bishe_tour_id = this.$route.query.bishe_tour_id;
                        console.log(bishe_tour_id);

                        $.ajax({
                            url:'http://localhost:8080/tour/deleteTour/'+bishe_tour_id,
                            type:'get',
                            success:function(data){
                                that.$router.push({
                                    path: '/success',
                                    query: {
                                        "msg":"删除旅游信息成功！"
                                    }
                                })
                            },
                            error:function(data){

                            }
                        });
                    },
                }
            },

        },
        {
            path : '/tourAdd',
            component : {
                template : `
                <div class="jumbotron">
                <p>旅游景点添加</p>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">景点的名称</label>
                        <div class="col-sm-10">
                        <input v-model="tourInfo.bishe_tour_name" type="text" class="form-control" id="inputEmail3" placeholder="输入景点的名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">景点所在的省份</label>
                        <div class="col-sm-10">
                        <select v-model="tourInfo.bishe_tour_provinceid" @change="getAll_cities()" class="form-control">
                             <option v-for="provence in cities" :value="provence.bishe_province_id">{{provence.bishe_province_name}}</option>
                        </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">景点所在的市</label>
                        <div class="col-sm-10">
                        <select v-model="tourInfo.bishe_tour_cityName"  name="" id="" class="form-control">
                            <option v-for="city in cli" :value="city.bishe_city_name">{{city.bishe_city_name}}</option>
                        </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">景点類型</label>
                        <div class="col-sm-10">
                        <select v-model="tourInfo.bishe_tour_type" class="form-control">
                             <option  value="大山">大山</option>                             
                             <option  value="大河">大河</option>
                             <option  value="地标建筑">地标建筑</option>
                             <option  value="自然景观">自然景观</option>
                             <option  value="革命纪念旅游胜地">革命纪念旅游胜地</option>
                             <option  value="人文景观">人文景观</option>
                             <option  value="其他">其他</option>

                        </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">景点的简介</label>
                        <div class="col-sm-10">
                        <textarea v-model="tourInfo.bishe_tour_desc"  class="form-control" name="" id="" cols="30" rows="10" placeholder="输入景点的简介"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">景点的照片</label>
                        <div class="col-sm-10">
                            <input type="file" id="tourAddImg" accept="image/gif, image/jpeg,image/png,image/jpg" >
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                        <button type="button" class="btn btn-primary" @click="AddTourInfo()">添加</button>
                        </div>
                    </div>
                </form>
                </div>`,
                data:function(){
                    return {
                        tourInfo:{
                            "bishe_tour_name":'',
                            "bishe_tour_provinceid":'',
                            "bishe_tour_cityName":'',
                            "bishe_tour_desc":'',
                            "bishe_tour_type":'大山'
                        },
                        cities:[],
                        cli:[]
                    }
                },
                methods:{
                    getAll_provence(){
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
                    getAll_cities(){
                        var that=this;
                         //请求市
                    $.ajax({
                        url:"http://localhost:8080/city/getCityList/"+that.tourInfo.bishe_tour_provinceid,
                        type:'get',
                        success:function(data){
                            console.log(data);
                            that.cli=data;
                        
                        },
                        error:function(data){
                            console.log(data);
                        }
                    });
                    },
                    AddTourInfo(){
                        var that=this;
                        var obj=JSON.parse(window.localStorage.getItem("userInfo"));
                        var bishe_register_id=obj.object.bishe_register_id;
                        var name='';
                        for(var i=0;i<that.cities.length;i++){
                            if(this.tourInfo.bishe_tour_provinceid==that.cities[i].bishe_province_id){
                                name=that.cities[i].bishe_province_name;
                            }
                        }
                        var data={
                            "bishe_register_id":bishe_register_id,
                            "bishe_tour_name":this.tourInfo.bishe_tour_name,
                            "bishe_tour_province_name":name,
                            "bishe_tour_city_name":this.tourInfo.bishe_tour_cityName,
                            "bishe_tour_desc":this.tourInfo.bishe_tour_desc,
                            "bishe_tour_type":this.tourInfo.bishe_tour_type
                        }
                        data=JSON.stringify(data);
                        console.log(data);
                        $.ajax({
                            url:'http://localhost:8080/tour/addTour',
                            type:'post',
                            data:data,
                            contentType: 'application/json',
                            success:function(data){
                                console.log(data);
                                that.AddTourInfo_img();
                            },
                            error:function(data){
                                
                            }
                        });
                    },
                    AddTourInfo_img(){
                        var that=this;
                        var formData = new FormData();
                        formData.append('file', $('#tourAddImg')[0].files[0]);
                        $.ajax({
                            url:'http://localhost:8080/tour/addTourImage',
                            type:'post',
                            cache: false,
                            data:formData,
                            processData: false,
                            contentType: false,
                            //enctype="multipart/form-data",
                            success:function(data){
                                    console.log(data);
                                    that.$router.push({
                                        path: '/success',
                                        query: {
                                          "msg":"添加旅游信息成功！"
                                        }
                                      })
                            },
                            error:function(data){
                                    
                            }
                        });
                    }
                },
                created(){
                    this.getAll_provence();
                }


            },

        },
        {
            path : '/tourUpdate',
            component : {
                template : `
                <div class="jumbotron">
                <p>{{$route.query.bishe_tour_name}}旅游景点修改</p>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">景点的名称</label>
                        <div class="col-sm-10">
                        <input v-model="tourInfo.bishe_tour_name" type="text" class="form-control" id="inputEmail3" placeholder="输入景点的名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">景点所在的省份</label>
                        <div class="col-sm-10">
                        <select v-model="tourInfo.bishe_tour_provinceid" @change="getAll_cities()" class="form-control">
                             <option v-for="provence in cities" :value="provence.bishe_province_id">{{provence.bishe_province_name}}</option>
                        </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">景点所在的市</label>
                        <div class="col-sm-10">
                        <select v-model="tourInfo.bishe_tour_cityName"  name="" id="" class="form-control">
                            <option v-for="city in cli" :value="city.bishe_city_name">{{city.bishe_city_name}}</option>
                        </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">景点類型</label>
                        <div class="col-sm-10">
                        <select v-model="tourInfo.bishe_tour_type" class="form-control">
                             <option  value="大山">大山</option>                             
                             <option  value="大河">大河</option>
                             <option  value="地标建筑">地标建筑</option>
                             <option  value="自然景观">自然景观</option>
                             <option  value="革命纪念旅游胜地">革命纪念旅游胜地</option>
                             <option  value="人文景观">人文景观</option>
                             <option  value="其他">其他</option>

                        </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">景点的简介</label>
                        <div class="col-sm-10">
                        <textarea v-model="tourInfo.bishe_tour_desc"  class="form-control" name="" id="" cols="30" rows="10" placeholder="输入景点的简介"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">景点的照片</label>
                        <div class="col-sm-10">
                            <img :src="$route.query.bishe_tour_image" alt="" style="width: 100px;height: 100px;">
                            <input type="file" id="tourAddImg" accept="image/gif, image/jpeg,image/png,image/jpg" >
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                        <button type="button" class="btn btn-primary" @click="up_TourInfo()">添加</button>
                        </div>
                    </div>
                </form>
                </div>`,
                data:function(){
                    return {
                        tourInfo:{
                            "bishe_tour_id":this.$route.query.bishe_tour_id,
                            "bishe_tour_name":this.$route.query.bishe_tour_name,
                            "bishe_tour_provinceid":'',
                            "bishe_tour_cityName":this.$route.query.bishe_tour_city_name,
                            "bishe_tour_desc":this.$route.query.bishe_tour_desc,
                            "bishe_tour_province_name":this.$route.query.bishe_tour_province_name,
                            "bishe_tour_type":'大山'
                        },
                        cities:[],
                        cli:[]
                    }
                },
                methods:{
                    getAll_provence(){
                        var that=this;
                        console.log(this.tourInfo);
                        $.ajax({
                            url:"http://localhost:8080/province/getProvinceList",
                            type:'get',
                            success:function(data){
                                that.cities=data;
                                console.log(data);
                                for(var i=0;i<data.length;i++){
                                    if(that.tourInfo.bishe_tour_province_name==data[i].bishe_province_name){
                                        that.tourInfo.bishe_tour_provinceid=data[i].bishe_province_id;
                                        console.log(that.cities[i].bishe_province_id);
                                    }
                                }
                                console.log(that.tourInfo.bishe_tour_provinceid);
                                console.log(that.tourInfo);
                                that.getAll_cities();
                            },
                            error:function(data){
                                console.log(data);
                            }
                        });
                    },
                    getAll_cities(){
                        var that=this;
                        //请求市
                        $.ajax({
                            url:"http://localhost:8080/city/getCityList/"+that.tourInfo.bishe_tour_provinceid,
                            type:'get',
                            success:function(data){
                                console.log(data);
                                that.cli=data;

                            },
                            error:function(data){
                                console.log(data);
                            }
                        });
                    },
                    up_TourInfo(){
                        var that=this;
                        var obj=JSON.parse(window.localStorage.getItem("userInfo"));
                        var bishe_register_id=obj.object.bishe_register_id;
                        var name='';
                        for(var i=0;i<that.cities.length;i++){
                            if(this.tourInfo.bishe_tour_provinceid==that.cities[i].bishe_province_id){
                                name=that.cities[i].bishe_province_name;
                            }
                        }
                        var data={
                            "bishe_tour_register_id":bishe_register_id,
                            "bishe_tour_name":this.tourInfo.bishe_tour_name,
                            "bishe_tour_province_name":name,
                            "bishe_tour_id":this.tourInfo.bishe_tour_id,
                            "bishe_tour_city_name":this.tourInfo.bishe_tour_cityName,
                            "bishe_tour_desc":this.tourInfo.bishe_tour_desc,
                            "bishe_tour_type":this.tourInfo.bishe_tour_type
                        }
                        data=JSON.stringify(data);
                        console.log(data);
                        $.ajax({
                            url:'http://localhost:8080/tour/updateTour',
                            type:'post',
                            data:data,
                            contentType: 'application/json',
                            success:function(data){
                                console.log(data);
                                that.AddTourInfo_img();
                            },
                            error:function(data){

                            }
                        });
                    },
                    AddTourInfo_img(){
                        var that=this;
                        var formData = new FormData();
                        formData.append('file', $('#tourAddImg')[0].files[0]);
                        $.ajax({
                            url:'http://localhost:8080/tour/UpdateTourImage',
                            type:'post',
                            cache: false,
                            data:formData,
                            processData: false,
                            contentType: false,
                            //enctype="multipart/form-data",
                            success:function(data){
                                console.log(data);
                                that.$router.push({
                                    path: '/success',
                                    query: {
                                        "msg":"修改旅游信息成功！"
                                    }
                                })
                            },
                            error:function(data){

                            }
                        });
                    }
                },
                created(){
                    this.getAll_provence();
                },


            },

        },
        {
            path : '/commentsList',
            component : {
                template : `
                <div class="jumbotron">
                    <p>评论列表</p>
                    <div class="jumbotron">
                        <table class="table table-striped table-bordered table-hover">
                            <tbody>
                            <tr>
                                <th>编号</th>
                                <th>ID</th>
                                <th>发布人</th>
                                <th>旅游项目ID</th>
                                <th>内容</th
                                <th>操作</th>
                            </tr>
                            <tr v-for="(com,index) in comments">
                                <td>{{index+1}}</td>
                                <td>{{com.bishe_comment_id}}</td>
                                <td>{{com.bishe_comment_user_info_nick}}</td>
                                <td>{{com.bishe_comment_tour_id}}</td>
                                <td>{{com.bishe_comment_content}}</td>
                                <td> <router-link  :to="{path:'/commentDelete',query: {
                                bishe_comment_id:com.bishe_comment_id
                            }}">删除</router-link></td>
                            </tr>
                        </tbody>
                        </table>
                    </div>
                </div>`,
                data:function(){
                    return {
                        comments:[
                            {
                                "bishe_comment_id":"1",
                                "bishe_comment_content":"啦啦啦啦啦啦",
                                "bishe_comment_registerId":"1",
                                "bishe_comment_userInfoNick":"二哈",
                                "bishe_comment_tourId":"1"
                            },
                            {
                                "bishe_comment_id":"1",
                                "bishe_comment_content":"啦啦啦啦啦啦",
                                "bishe_comment_registerId":"1",
                                "bishe_comment_userInfoNick":"二哈",
                                "bishe_comment_tourId":"1"
                            }
                        ]
                    }
                },
                methods: {
                    getAll_comments(){
                        var that=this;
                        $.ajax({
                            url:"http://localhost:8080/comment/getAllComment",
                            type:'get',
                            success:function(data){
                                that.comments=data;
                                console.log(data,"ok");
                            },
                            error:function(data){
                                console.log(data);
                            }
                        });
                    }
                },
                created(){
                    this.getAll_comments();
                }
            }

        },
        {
            path : '/commentDelete',
            component : {
                template : `
                <div class="jumbotron">
                <p>确认删除{{$route.query.bishe_comment_id}}的一条评论？</p>
                <button  type="button" class="btn btn-primary" @click="delete_com()">确定删除</button>
                </div>`,
                methods:{
                    delete_com(){
                        var that=this;
                        var bishe_comment_id = this.$route.query.bishe_comment_id;
                        console.log(bishe_comment_id);

                        $.ajax({
                            url:'http://localhost:8080/comment/deleteComment/'+bishe_comment_id,
                            type:'get',
                            success:function(data){
                                that.$router.push({
                                    path: '/success',
                                    query: {
                                        "msg":"删除评论成功！"
                                    }
                                })
                            },
                            error:function(data){

                            }
                        });
                    },
                }
            },

        },
    ];
    var router = new VueRouter({
        routes:routes,
    });
    var index= new Vue({
        el:'#app',
        data:{
            isAdmin:false,
            user:{name:'wang',img:'./imgs/user_img.png'},
        },
        router:router,
        //实例化vue时创建的函数 与执行
        created() {

        }
        
    });  
    function updateWangye(){
        index.user=JSON.parse(window.localStorage.getItem("userInfo"));
        
        console.log(index.user);
        if(index.user.code=="2"){//管理员
            // index.is_login=true;
            // index.isAdmin=true;
        }
        else{
            //普通用户
            
            alert("你不是管理员！！！");
            window.location.href="../index/index.html";
        }
    }
    updateWangye();


});
