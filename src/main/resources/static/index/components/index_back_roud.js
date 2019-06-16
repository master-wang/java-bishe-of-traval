var main =`
<!-- 轮播图 -->
        <div class="round">
            <div class="slide" v-on:mouseover="stop()" v-on:mouseout="move()">
                <div class="slideshow">
                <transition-group tag="ul" name="image">
                    <li v-for="(img, index) in roundImgs" v-show="index===mark || index===(mark%4+1)" :key="index">
                    <a href="#">
                        <img :src='img'>
                    </a>
                    </li>
                </transition-group>
                </div>

                <div class="bullet">
                <img v-for="(item, index) in roundImgs" :class="{ 'active':index===mark+1 }"
                @click="change(index-1)" :key="index" :src="item"></img>
                </div>

            </div>

            <div class="round-find center-block">
                    <form class="navbar-form navbar-left">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="...搜索旅游景点" style="color: rgb(255,157,0);">
                        </div>
                        <button type="submit" class="btn btn-default " id="bar-btn" style="color: rgb(255,157,0);">查询</button>
                    </form>
            </div>
        </div>


        <div class="weather">
            <a href="#">
            <div class="jijie" v-for="img in jijieImgs">
                <div class="kind">春天</div>
                <img :src="img" alt="">
            </div>
            </a>
        </div>
`
console.log(111)
module.exports = main;