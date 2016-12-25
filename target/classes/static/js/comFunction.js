;(function($) {
    $.extend({
        //验证密码长度
        pwdLength: function(pwd){
            var reg = new RegExp(/^[A-Za-z0-9]{6,20}$/);
            if(!reg.test(pwd)){
                return false;
            }else{
                return true;
            }
        },

        //日历控件
        datePicker: function(domEle){
            $.datetimepicker.setLocale('ch');
            $(domEle).datetimepicker({
                autoclose: true,
                timepicker:false,
                format:"Y-m-d"
            })
        },

        //列表查询参数
        getQueryCondition: function ($form, data) {
            var params = {};

            //查询参数
            $form.find(':input[name]').each(function () {
                var name = $(this).attr("name");
                var value = $(this).val();
                if(value != null){
                    var val = value.trim();
                    if (val != "" && val != -1) {
                        if(name === "amount"){
                            val = parseFloat(val);
                        }
                        params[name] = val;
                    }
                }
            });

            //分页参数
            params.current = (data.start / data.length) + 1;
            params.size = data.length;

            return params;
        },

        //ajax数据请求
        dataAjax: function(url, params, successfn){
            $("body").spinModal();
            $.ajax({
                type: "POST",
                url: url,
                cache: false,
                data: params,
                dataType: "json",
                traditional: true
            }).done(function (result) {
                  if(result.success){
                      $("body").spinModal(false);
                      successfn(result);
                  }else{
                      $("body").spinModal(false);
                      iosOverlay({
                          text: result.message,
                          duration: 2e3,
                          icon: "/assets/img/error.png"
                      });
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
        },

        //分页表格ajax请求数据
        dataTableAjax: function(url, params, callback){
            this.dataAjax(url, params, function(result){
                var data = result.data;
                //封装返回数据
                var returnData = {};
                returnData.current = data.current;
                returnData.recordsTotal = data.total;
                returnData.recordsFiltered = data.total;
                returnData.data = data.records;
                callback(returnData);
            });
        },

        //借据详情
        receiptDetail: function(url, param){
            this.dataAjax(url, param, function(result){
                var data = result.data;
                var tableCons = constant.data_tables;
                if(data) {
                    $("#applyDate").html(data.applyDate);
                    $("#receiptDetail table").find("td:even").each(function (e) {
                        var id = $(this).attr("id");
                        for (var i in data) {
                            if (i == id) {
                                if (id == "interestRate") {
                                    data[i] = tableCons.renderFunc.toPercent(data[i]);
                                }
                                if (id == "amount") {
                                    data[i] = tableCons.renderFunc.toMoneyForm(data[i]);
                                }
                                $(this).next().html(data[i]);
                            }
                        }
                    });
                    $("#receiptDetail").modal("show");
                }
            });
        },

        //input、textarea信息渲染处理
        showDetail: function (domId, dataInfo) {
            var tableCons = constant.data_tables;
            $("#" + domId).find(":input").each(function(){
                var name = $(this).attr("name");
                for(var i in dataInfo){
                    if(i == name){
                        if(i == "interestRate"){
                            dataInfo[i] = tableCons.renderFunc.toPercent(dataInfo[i]);
                        }
                        $(this).val(dataInfo[i]) || $(this).text(dataInfo[i]);
                    }
                }
            })
        },

        //提示
        alert: function(msg){
            bootbox.alert({
                buttons: {
                    ok: {
                        label: '<i class="fa fa-check"></i> 确定',
                        className: 'btn btn-sm btn-success'
                    }
                },
                message: msg
            });
        },

        //确认
        confirm: function(msg, cb){
            bootbox.confirm({
                message: msg,
                buttons: {
                    cancel: {
                        label: '<i class="fa fa-reply"></i> 否',
                        className: 'btn btn-sm btn-default'
                    },
                    confirm: {
                        label: '<i class="fa fa-check"></i> 是',
                        className: 'btn btn-sm btn-success'
                    }
                },
                callback: function(result) {
                    if(result) {
                       cb();
                    }
                }
            });
        },

        //点击列表行事件
        clickTr: function ($table, _table, cb) {
            $("tbody", $table).on("click","tr",function() {
                if(!$(this).find("td").hasClass("dataTables_empty")  && !$(this).find(".repayCollapse").length && !$(this).parents("table").hasClass("repayCollapse")){
                    $(this).addClass("active").siblings().removeClass("active");
                    cb(_table.row($(this).closest('tr')).data());
                }
            });
        },

        //清空提示
        clearAlert: function(){
            $(".warn-info").html("");
            $("input").bind('input', function (){
                $(".warn-info").html("");
            });
        },

        //下载文件(type: 四方协议传0,转让协议传1)
        download: function(url, type){
            var path = window.location.href.split(window.location.pathname)[0];
            return path + "/api/elect/protocol/download?type=" + type + "&filePath=" + url;
        }
    });
}(jQuery));
