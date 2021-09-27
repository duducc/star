<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加笔记</title>
<link rel="stylesheet"  href="layui/css/layui.css" >
<script type="text/javascript" src="layui/layui.all.js" ></script>
<script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
</head>
<style>
  
  body {
     min-width: 1920px;
  }

  #datalist,.layui-form-item {
     margin-bottom: 40px;
   }
   .layui-form-label {
    padding: 6px 0px;
    width:60px;
   }
   
  .top {
    margin-bottom:10px;
  }
  
  h1 {
    line-height:70px;
    text-align: center;
    color: white;
  }
  
  .top_add {
    height:50px;
    
  }
  .top_data {
     height:40px;
     margin-left: 20px;
  }
  .top_data input {
    height:33px;
  }
  #data-list {
      margin-right:35px;
      
  }
  .wrapper {
    height:730px;
  }  
  .addinfo {
     width:35%;
     margin:15px 30px;
     float:left;
  }

  .datatable {
     margin-left:25px;
	 float:left;
   }
   .btnsub {
     background-color: #1E9FFF;
   } 
   #type {
     display:none;
   }
</style>
<body>
   
	<div class="wrapper">
	  <div class="top">
	    <ul class="layui-nav" lay-filter="">
	      <li class="layui-nav-item"><a href="" style="color:red;">典韦</a></li>
	      <li class="layui-nav-item layui-this"><a href="">地址</a></li>
	      <li class="layui-nav-item"><a href="">安装</a></li>
	      <li class="layui-nav-item">
	        <a href="javascript:;">笔记</a>
	        <dl class="layui-nav-child"> <!-- 二级菜单 -->
	         <dd><a href="">移动模块</a></dd>
	         <dd><a href="">后台模版</a></dd>
	         <dd><a href="">电商平台</a></dd>
	        </dl>
	      </li>
	      <li class="layui-nav-item"><a href="">SQL</a></li>
	      <li class="layui-nav-item"><a href="">杂项</a></li>
        </ul>
	  </div>
	  
	  
	   <div class="datatable">
		   <div class="top_data">
					<div class="layui-form-item">
				  		<label class="layui-form-label">分类：</label>
						<div class="layui-input-inline">
				    		<input type="text" class="layui-input " name="name" id="name" placeholder="请输入地址" autocomplete="off">
				  		</div>
				  		<label class="layui-form-label">类型：</label>
						<div class="layui-input-inline">
							<input type="hidden" id="deptid" name="deptid" value=""/>
				    		<input type="text" class="layui-input" autocomplete="off" placeholder="请选择类型">
				  		</div>
				  		<div class="layui-inline">
					  		<input type="hidden" name="tempproid" id="tempproid" value="" />
				  			<button class="layui-btn layui-btn-sm btnsub " type ="button" onclick="getListDate();"><i class="layui-icon">&#xe615;</i>查询</button>
				  		</div>
			  		</div>
	        </div>
			<div id="data-list">
				<table class="layui-hide" id="listdata" lay-filter="listdata"></table>
			</div>
	   </div>
	    <div class="addinfo">
	     <div class="top_add"></div>
	     <form class="layui-form layui-form-pane" action="" method="post" autocomplete="off">
			  <div class="layui-form-item layui-form-text">
			    <label class="layui-form-label">地址</label>
			    <div class="layui-input-block">
			      <textarea id="address" name="address" placeholder="请输入地址" class="layui-textarea"  lay-verify="required"></textarea>
			    </div>
			  </div>
			  <div class="layui-form-item layui-form-text">
			    <label class="layui-form-label">描述</label>
			    <div class="layui-input-block">
			      <textarea id="desc" name="desc" placeholder="请输入描述" class="layui-textarea" lay-verify="required"></textarea>
			    </div>
			  </div>
              <div class="layui-form-item">
			    <label class="layui-form-label">分类</label>
			    <div class="layui-input-block">
			      <input type="text" id="category" name="category"  placeholder="请输入分类"  class="layui-input" lay-verify="required">
			    </div>
			  </div>
			  <div class="layui-form-item">
                <label class="layui-form-label">类型</label>
			    <div class="layui-input-block">
			      <input type="radio" name="type" lay-filter="type" value="网站" title="网站" checked>
			      <input type="radio" name="type" lay-filter="type" value="百度网盘" title="百度网盘" >
			      <input type="radio" name="type" lay-filter="type" value="SQL" title="SQL">
			    </div>
              </div>
              <div id="type" class="layui-form-item">
			    <label class="layui-form-label">提取码</label>
			    <div class="layui-input-block">
			      <input type="text" id="extractcode" name="extractcode"  placeholder="请输入提取码"  class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			      <button class="layui-btn layui-btn-fluid btnsub" lay-submit lay-filter="submitform">立即提交</button>
			  </div>
          </form>
	   </div>
	</div>
</body>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs layui-btn-primary" style="background-color:#5BC0DE;color:white;" lay-event="jump">闪现</a>
</script>
<script type="text/javascript">
var form;
$(function(){
	getListDate();
	layui.use('form' ,function(){
		 form = layui.form;
		 var element = layui.element;
		 form.render();
	});
});


function getListDate(){

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
	if(width3 < 160){
		width3 = 160;
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
        url:'all.do',
        cellMinWidth: 100,
        cols: [[
            {field:'id', width:width4,title: '编号'},
            {field:'type', title: '类型', width:width5,templet:function(data){
            	 return data.type;
            }},
            {field:'category', title: '分类',width:width6},
            {field:'desc', title: '描述', width:width3},	            
            {field:'extractcode', title: '提取码',width:width5},
	        {field:'obt', title: '操作',align:'center',width:width1,toolbar: '#barDemo',fixed:'right'}
      	]],

  	});
    //闪现
	table.on('tool(listdata)',function(obj){
		var data = obj.data;
		if(obj.event=='jump'){
			 var url = data.address;
			 window.open(url,"_blank");
		}
	});
  }
  
  layui.use('form', function(){
	  var form = layui.form;

	  form.on('radio(type)', function(data){
		  $("#type").css("display","none");
		  if("百度网盘"==data.value){
			 $("#type").css("display","block"); 
		  }		
	  });  
	  
	  //监听提交
	  form.on('submit(submitform)', function(data){
		  addWkAddress(data);
	  });

	  
   });
  
  function addWkAddress(data){
	  var jsonData = JSON.stringify(data.field);
	  var url = "addWkAddress.do";
      $.post(url,{jsonData:jsonData},function (data, status) {
          if( status=="success" ){
              var json = eval(data);
              switch (json.errorMsg) {
                  case "success":		//成功
                        layer.msg("添加成功!");
                        getListDate();
                        break;
                  case "failed":		//成功
                        layer.msg("添加失败！");
                        break; 
                  case "error":		//成功
                        layer.msg("服务器异常，稍后再试！");
                        break;       
              }
          }else{
          	layer.alert("操作失败！", {title: '警告'});
          }
      },"json");
  }
  
  
</script>
</html>