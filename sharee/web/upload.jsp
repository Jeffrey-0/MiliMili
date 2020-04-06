<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>上传</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="css/element_ui_index.css">
    <script src="js/vue.js"></script>
    <script src="js/element_ui_index.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">

    <style type="text/css">
        #layout {
            margin-top: -40px;
        }

        .upload_title {
            width: 1200px;
            height: 40px;
            background-color: #fff;
            border: 1px solid #00000040;
            margin: 10px auto;
            text-align: center;
            line-height: 40px;
            font-size: 20px;
            margin-top: -20px;

        }

        .layout, .pic {

            width: 1200px;
            height: 700px;
            background-color: #fff;
            border: 1px solid #00000040;
            margin: 10px auto;
        }

        .pics {
            width: 1000px;
            margin: 10px auto;
            height: 200px;
            border: 1px solid #00000040;
        }

        form div {
            width: 800px;
            margin: 30px auto;
            height: 40px;

            /*border:1px solid #00000040;*/
        }

        .pics div {
            margin: 10px;
            width: 180px;
            height: 180px;
            border: 1px solid #f2f2f2;
            position: relative;
            display: inline-block;
            margin-left: 30px;
            background-size: 100% 100%;
            /*display: none;*/
            /*	top: 10px;*/
            float: left;
        }

        .pics input {
            width: 100%;
            height: 100%;
            text-align: center;
            line-height: 100%;
            opacity: 0;
            position: absolute;
            top: 0px;
            left: 0px;
        }

        .pics .file {
            font-size: 22px;
            text-align: center;
            line-height: 180px;
            display: inline-block;
        }

        .title {
            width: 85%;
            font-size: 18px;
            border: black 0px solid;
        }

        input, textarea {
            width: 85%;
            margin-left: 8%;
            font-size: 18px;
            padding: 10px;
            border: #f2f2f2 1px solid;
            margin-bottom: 20px;
        }

        select {
            width: 87%;
            margin-left: 8%;
            font-size: 18px;
            padding: 10px;
            border: #f2f2f2 1px solid;
            margin-bottom: 20px;
        }


    </style>

</head>
<body>
<iframe src="head_bar.jsp" width="100%" height="260px" scrolling="no"></iframe>
<div class="upload_title">分享视频</div>
<div class="layout">
    <form action="/upload" method="post" enctype="multipart/form-data">
        <div class="pics" style="background-color: #ffffff ; position: relative; overflow: hidden;">
            <div class="file">
                + 上传图片
                <input id="file" class="add_file" type="file" name="img">
            </div>
            <div id="show_pic"></div>
        </div>
        <div class="title">视频标题</div>
        <input type="text" name="name">
        <div class="title" style="height: 50px;">简介</div>
        <textarea name="descn" cols="180" rows="3" style="OVERFLOW:hidden"></textarea>
        <div class="title">上传视频</div>
        <input type="file" name="code">
        <input type="submit" style="width: 87%;margin-top: 20px;">
    </form>
</div>
<iframe src="bottom_bar.jsp" width="100%" height="auto"></iframe>
</body>
<script>
    //在页面显示上次的图片
    $("#file").change(function () {
        var objUrl = getObjectURL(this.files[0]);
        console.log("objUrl = " + objUrl);
        if (objUrl) {
            // $("#show_pic").css("background-color", "black");
            $("#show_pic").css("background-image", "url(" + objUrl + ")");
            // $("#show_pic").attr("src", objUrl);
            $("#show_pic").removeClass("hide");
        }
    });

    //建立一個可存取到該file的url
    function getObjectURL(file) {
        var url = null;
        if (window.createObjectURL != undefined) { // basic
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) {
            // mozilla(firefox)
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) {
            // webkit or chrome
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }
</script>

</html>

