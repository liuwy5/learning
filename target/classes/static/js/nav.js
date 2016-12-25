$(function() {

  //点击修改密码
  $("#editPwd").click(function () {
      $("#editPassword").find("input").val("");
      $(".warn-info").html("");
      $("#editPassword").modal("show");
  });

  //保存密码
  $("#savePwd").click(function(){
      var oldPwd = $("#oldPwd").val().trim();
      var newPwd = $("#newPwd").val().trim();
      var confirmPwd = $("#confirmPwd").val().trim();
      var alertIcon = "<i class='fa fa-exclamation-circle'></i>&nbsp;";

      $("input").bind('input', function (){
          $(".warn-info").html("");
      });

      if(oldPwd == ""){
          $(".warn1").html(alertIcon + "密码不能为空");
          return;
      }else{
          if(!$.pwdLength(oldPwd)){
              $(".warn1").html(alertIcon + "密码长度为6到20位");
              return;
          }
      }

      if(newPwd == ""){
          $(".warn2").html(alertIcon + "请输入新密码");
          return;
      }else{
          if(!$.pwdLength(newPwd)){
              $(".warn2").html(alertIcon + "密码长度为6到20位");
              return;
          }
      }

      if (newPwd != confirmPwd) {
          $(".warn3").html(alertIcon + "两次输入新密码不一致");
          return;
      }

      var params = {
          oldLoginPsw: oldPwd,
          loginPsw: newPwd
      };

      $("body").spinModal();
      $.ajax({
          type: "POST",
          url: "/api/passwd/modify",
          data: params,
          dataType: "json"
      }).done(function (result) {
              if(result.success){
                  $("#editPassword").modal("hide");
                  iosOverlay({
                      text: "修改成功",
                      duration: 2e3,
                      icon: "/assets/img/check.png"
                  });
                  $("body").spinModal(false);
                  setTimeout(function(){
                      window.location.href = '/ui/logout';
                  }, 1000);
              }else{
                  $("body").spinModal(false);
                  $(".warn1").html(alertIcon + result.message);
              }
      }).fail(function(){
          setTimeout(function(){
              $("body").spinModal(false);
              iosOverlay({
                  text: '服务异常',
                  duration: 2e3,
                  icon: "/assets/img/error.png"
              });
          },1500);
      });
  });
});