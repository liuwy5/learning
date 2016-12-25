/*-----DataTables初始化选项------*/
var constant = {
  data_tables : {
    options : {
      language: {
        "sZeroRecords": "没有匹配结果",
        "sInfo": "当前显示第 _START_ 至 _END_ 条，共 _TOTAL_ 条。",
        "sInfoEmpty": "当前显示第 0 至 0 条，共 0 条",
        "sEmptyTable": "表中数据为空",
        "oPaginate": {
          "sFirst":    "首页",
          "sPrevious": "上页",
          "sNext":     "下页",
          "sLast":     "尾页"
        }
      },
      sPaginationType: "full_numbers",
      "sDom": "<'row'<'col-xs-6'l><'col-xs-6'f>r>t<'row'<'col-xs-4'i><'col-xs-8'p>>",
      autoWidth: false,	//禁用自动调整列宽
      order: [],			//取消默认排序查询,否则复选框一列会出现小箭头
      processing: false,	//隐藏加载提示,自行处理
      serverSide: true,	//启用服务器端分页
      searching: false,	//禁用原生搜索
      lengthChange: !1,
      ordering: false,
      iDisplayLength: 15,
      retrieve: true
    },
    renderFunc: {
      toPercent: function (data) {
        if(data){
          return (data * 100).toFixed(2);
        }else{
          return "";
        }
      },
      toMoneyForm: function(data){
        if(data != null){
          return parseFloat(data).toLocaleString();
        }else{
          return "";
        }
      }
    }
  }
};