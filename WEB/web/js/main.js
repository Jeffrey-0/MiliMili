function btnClick(id, urlPath) {
    Swal.fire({
        title: '操作确认',
        text: "你正在进行敏感操作,请点击确认进行下一步!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#007bff',
        cancelButtonColor: '#dc3545',
        confirmButtonText: '确认!',
        cancelButtonText: '取消',
    }).then((result) => {
        if (result.value) {
            $.ajax({
                url: urlPath,
                type: "post",
                data: {"id": id},
                success: function () {
                    Swal.fire({
                        type: 'success',
                        title: '操作成功!',
                        allowOutsideClick: false,
                        showConfirmButton: false,
                        timer: 1500
                    }).then((result)=>{
                        location.reload();
                    });
                    
                },
                error: function () {
                    Swal.fire({
                        type: 'error',
                        title: '操作失败!',
                        allowOutsideClick: false,
                    })
                }
            })

        }
    })
}
function checkSelect(which) {
    setTimeout(function(){
        var checkList = $("input[name=id]");
		var count = 0;
		for(var i=0;i<checkList.length;i++){
			if(checkList[i].checked) count++;
		}
		if(count > 0){
			$("#allDelete").prop('disabled', false);
		}else{
			$("#allDelete").prop('disabled', true);
		}
	},5);
}
function allDelete(urlPath){
	var checkList = $("input[name=id]");
	var dataList = new Array();
	for(var i=0;i<checkList.length;i++){
		if(!checkList[i].checked) continue;
		var tmp = new Object();
		tmp = checkList[i].value;
		dataList.push(tmp);
    }
    btnClick(dataList,urlPath);
	
}
$(function(){
    $("#selectAll").click(function() {
        if($(this).prop("checked")){
                $("input[name=id]").prop("checked", true)
        }else{
                $("input[name=id]").prop("checked", false)
        }
    });
    
})
function deleteProductImg(imgName) {
    let imgCard = '#'+imgName;
    Swal.fire({
        title: '操作确认',
        text: "你确定删除该图片吗!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#007bff',
        cancelButtonColor: '#dc3545',
        confirmButtonText: '确认!',
        cancelButtonText: '取消',
    }).then((result) => {
        if (result.value) {
            $.ajax({
                url: 'AdminServlet?method=deleteProductImg',
                type: "post",
                data: {"imgName": imgName},
                success: function (data) {
                	Swal.fire({
                        type: 'success',
                        title: '操作成功!',
                        allowOutsideClick: false,
                    }).then((result)=>{
                    	location.reload();
                    });
//                    $(imgCard).remove();
                	
                },
                error: function () {
                    Swal.fire({
                        type: 'error',
                        title: '操作失败!',
                        allowOutsideClick: false,
                    })
                }
            })

        }
    })
}
function checkPwd() {
    let p = $('#aPassword').val()
    let p1 = $('#password').val()
    let p2 = $('#password2').val()
    if (p1 != p2) {
        Swal.fire({
            type: 'error',
            title: '两次密码不正确',
            confirmButtonColor: '#007bff',
            confirmButtonText: '确认!'
        })
        return false
    }
    if (p == "") {
        Swal.fire({
            type: 'error',
            title: '请输入原密码',
            confirmButtonColor: '#007bff',
            confirmButtonText: '确认!'
        })
        return false
    }
    if (p1=== "" || p2=== "") {
        Swal.fire({
            type: 'error',
            title: '密码不能为空',
            confirmButtonColor: '#007bff',
            confirmButtonText: '确认!'
        })
        return false
    }
    return true
}
