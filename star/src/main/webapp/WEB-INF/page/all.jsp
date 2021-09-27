<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<link rel="stylesheet"  href="layui/css/layui.css" >
<script type="text/javascript" src="layui/layui.all.js" ></script>
<script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
</head>
<body>
<div id="data-list">
		<table class="layui-hide" id="listdata" lay-filter="listdata"></table>
	</div>
	<div id="pages"></div>

	
</body>
<script type="text/javascript">
var form;
$(function(){
	refresh();
	layui.use('form' ,function(){
		 form = layui.form;
		 form.render();
	});
});


function refresh(){
    alert("sss");
	var height= $("body").height();
	var rows =Math.floor(height/38);
	var width= $("body").width();
	var width0 = Math.floor(width * 0.1);
	if(width0 < 120){
		width0 = 120;
	}
	var width1 = Math.floor(width * 0.06);
	if(width1 < 80){
		width1 = 80;
	}
	var width2 = Math.floor(width * 0.13);
	if(width2 < 130){
		width2 = 130;
	}
	var width3 = Math.floor(width * 0.2);
	if(width3 < 150){
		width3 = 150;
	}
	var width4 = Math.floor(width * 0.04);
	if(width4 < 40){
		width4 = 40;
	}
	var width5 = Math.floor(width * 0.05);
	if(width5 < 60){
		width5 = 60;
	}
	var width6 = Math.floor(width * 0.08);
	if(width6 < 100){
		width6 = 100;
	}
	var width7 = Math.floor(width * 0.07);
	if(width7 < 90){
		width7 = 90;
	}
    table = layui.table;
    /* ------------------------------------------加载数据表格--------------------------------------- */
    table.render({
        elem: '#listdata',
        height:height,
        url:'/all.do',
        cellMinWidth: 100,
        cols: [[
            {type:'numbers'},
            {field:'id', width:width1,title: '编号'},
            {field:'address', title: '地址',minwidth:width1},
            {field:'desc', title: '描述', minwidth:width6},	            
            {field:'type', title: '类型', width:width1,templet:function(data){
            	console.log(JSON.stringify(data));
            	/* if(data.teacert==1) return "<span style='color:green'>有</span>";
            	     return "<span style='color:red'>无</span>"; */
            }},
        
	        {field:'obt', title: '操作',align:'center', width:width6,toolbar: '#barDemo',fixed:'right'}
      	]],

  	});
  }
</script>
</html>