<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>M站</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="css/element_ui_index.css">
    <script src="js/vue.js"></script>
    <script src="js/element_ui_index.js"></script>
        <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
</head>
<body>
<iframe src="head_bar.jsp" width="100%" height="260px" scrolling="no"></iframe>
<div style="margin-top: -30px">
    <div class="context">
        <div class="context_left">
            <div class="ad" id="ad">
                <template>
                    <div class="block">
                        <el-carousel trigger="click" height="400px">
                            <el-carousel-item v-for="item in t_ad" :key="item.img">
                                <img :src="item.img" @click="handleClick(item)">
                            </el-carousel-item>
                        </el-carousel>
                    </div>
                </template>
            </div>
            <div class="time_resource">
                <div class="title">
                    <div>热门动漫</div>
                </div>
                <div id="resource_hot" class="resource resource_one">
                    <div>
                        <div class="resource_item  hot_resource_item" v-for="item in resourceList"
                             @click="handleClick(item)"><img :src="item.img"></img>
                            <div>{{item.name}}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="context_right" id="resource_new">
            <div style="text-align: center;width: 90%;font-size:18px;
				padding-bottom: 10px;
				margin: 5%; border-bottom: black 1px solid">最近更新
            </div>
            <div class="new_resource_item" v-for="item in resourceList" @click="handleClick(item)">
                <img :src="item.img" class="resource_pic">
                <div class="resource_title">{{item.name}}</div>
            </div>
        </div>
    </div>
</div>
<div id="resource_all">
    <div id="resource_one" class="resource resource_one">
        <div class="title">
            <div>新番放送</div>
            <a href="classily?search=新番放送&page=1" class="more">查看更多</a></div>
        <div>
            <div class="resource_item" v-for="item in resourceList1" @click="handleClick(item)"><img
                    :src="item.img"></img>
                <div>{{item.name}}</div>
            </div>
        </div>
    </div>
    <div class="resource resource_one">
        <div class="title">
            <div>国产动漫</div>
            <a href="classily?search=国产动漫&page=1" class="more">查看更多</a></div>
        <div>
            <div class="resource_item" v-for="item in resourceList2" @click="handleClick(item)"><img
                    :src="item.img"></img>
                <div>{{item.name}}</div>
            </div>
        </div>
    </div>
    <div class="resource resource_one">
        <div class="title">
            <div>剧场版</div>
            <a href="classily?search=剧场动画&page=1" class="more">查看更多</a></div>
        <div>
            <div class="resource_item" v-for="item in resourceList3" @click="handleClick(item)"><img
                    :src="item.img"></img>
                <div>{{item.name}}</div>
            </div>
        </div>
    </div>
    <div class="resource resource_one">
        <div class="title">
            <div>电影</div>
            <a href="classily?search=影视&page=1" class="more">查看更多</a></div>
        <div>
            <div class="resource_item" v-for="item in resourceList4" @click="handleClick(item)"><img
                    :src="item.img"></img>
                <div>{{item.name}}</div>
            </div>
        </div>
    </div>
    <div class="resource resource_one">
        <div class="title">
            <div>用户分享</div>
            <a href="classily?search=用户分享&page=1" class="more">查看更多</a></div>
        <div>
            <div class="resource_item" v-for="item in resourceList5" @click="handleClick(item)"><img
                    :src="item.img"></img>
                <div>{{item.name}}</div>
            </div>
        </div>
    </div>

</div>
<iframe src="bottom_bar.jsp" width="100%" height="auto" scrolling="no"></iframe>
</body>
<script type="text/javascript">
    if (window != top) top.location.href = location.href; //让iframe中的跳转转换成主页跳转
    // 设置获取的数据
    var ad = ${adRes};
    var new_resources = ${newRes};
    var hot_resources = ${ranRes};
    var resource_one =${fanRes};
    var resource_tow =${cnRes};
    var resource_three =${theaterRes};
    var resource_four =${movieRes};
    var resource_five =${shareRes};
    // 绑定轮播图的数据和方法
    const vm = new Vue({
        el: '#ad',
        data: {
            t_ad: ad
        }
        ,
        methods: {
            handleClick(item) {
                console.log(item.id);
                console.log(item.category);
                var link = "resource?id=" + item.id + "&classily=" + item.category;
                window.parent.location.href = link;
            }
        }
    })

    // 绑定主页中各种资源的数据和方法
    const vm1 = new Vue({
        el: '#resource_all',
        data: {
            resourceList1: resource_one,
            resourceList2: resource_tow,
            resourceList3: resource_three,
            resourceList4: resource_four,
            resourceList5: resource_five,

        }, methods: {
            handleClick(item) {
                console.log(item.id);
                console.log(item.category);
                // 设置某个资源的详细页面，携带资源id参数
                var link = "resource?id=" + item.id + "&classily=" + item.category;
                window.parent.location.href = link;
            }
        }
    })

    // 绑定最新资源的数据和方法
    const new_vm1 = new Vue({
        el: '#resource_new',
        data: {
            resourceList: new_resources
        }, methods: {
            handleClick(item) {
                console.log(item.id);
                console.log(item.category);
                // 设置最新资源中某个资源的详细页面，携带资源id参数
                var link = "resource?id=" + item.id + "&classily=" + item.category;
                window.parent.location.href = link;
            }
        }

    })


    // 绑定热门资源的数据和方法
    const hot_vm1 = new Vue({
        el: '#resource_hot',
        data: {
            resourceList: hot_resources
        }, methods: {
            handleClick(item) {
                console.log(item.id);
                console.log(item.category);
                // 设置热门资源中某个资源的详细页面，携带资源id参数
                var link = "resource?id=" + item.id + "&classily=" + item.category;
                window.parent.location.href = link;
            }
        }

    })


</script>
</html>
