/**
 * Created by ubuntu on 16-12-21.
 */
$(document).ready(function () {
    // 显示登录模态框
    $('#login').click(function () {
        $('#loginForm').find("input").val("");
        $('.login-alert').html('');
    });

    // 显示注册模态框
    $('#register').click(function () {
        $('#registerForm').find("input").val("");
        $('.register-alert').html('');
    });

    // 点击登录按钮
    $('#loginButton').click(function () {
        var loginName = $('#loginName').val();
        var loginPwd = $('#loginPwd').val();

        if ('' == loginName) {
            $('.login-alert').html('用户名不能为空');
            return false;
        } else if ('' == loginPwd) {
            $('.login-alert').html('密码不能为空');
            return false;
        }
        $.ajax({
            url:"/customer/login/auth",
            type:'post',
            data:$('#loginForm').serialize(),
            success:function (data) {
                if (data == 1) {
                    $('.login-alert').html("登录名不存在");
                } else if (data == 2) {
                    $('.login-alert').html("登录密码不正确");
                } else if (data == 0) {
                    location.href = "/";
                }
            }
        })
    });

    // 修改密码
    $('#editPwd').click(function () {
        $("#editPassword").find("input").val("");
        $("#editPasswordAlert").html("");
        $("#editPassword").modal("show");
    });

    //保存密码
    $("#savePwd").click(function(){
        var oldPwd = $("#oldPwd").val().trim();
        var newPwd = $("#newPwd").val().trim();
        var confirmPwd = $("#confirmPwd").val().trim();
        var alertIcon = "<i class='fa fa-exclamation-circle'></i>&nbsp;";

        $("input").bind('input', function (){
            $("#editPasswordAlert").html("");
        });

        if(oldPwd == ""){
            $("#editPasswordAlert").html(alertIcon + "密码不能为空");
            return;
        }

        if(newPwd == ""){
            $("#editPasswordAlert").html(alertIcon + "请输入新密码");
            return;
        }

        if (newPwd != confirmPwd) {
            $("#editPasswordAlert").html(alertIcon + "两次输入新密码不一致");
            return;
        }

        var params = {
            oldLoginPsw: oldPwd,
            loginPsw: newPwd
        };

        // $("body").spinModal();
        $.ajax({
            type: "POST",
            url: "/customer/login/changePwd",
            data: params,
            dataType: "json"
        }).done(function (result) {
            console.log(result);
            if(result.code == 0){ // 修改成功
                $("#editPassword").modal("hide");
                alert('修改成功，请重新登录');
                setTimeout(function(){
                    window.location.href = '/';
                }, 1000);
            }else{
                $("#editPasswordAlert").html(alertIcon + result.desc);
            }
        }).fail(function(){
            setTimeout(function(){
                // $("body").spinModal(false);
                iosOverlay({
                    text: '服务异常',
                    duration: 2e3,
                    icon: "/assets/img/error.png"
                });
            },1500);
        });
    });
});