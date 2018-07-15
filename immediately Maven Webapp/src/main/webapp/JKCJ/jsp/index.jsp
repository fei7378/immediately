<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Jquery Test</title>
    <!-- 导入Jquery文件 -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
    
    <script type="text/javascript">
        //这里的内容会在文档加载完毕时执行 
        $(function(){
            $("#xxx").blur(function(){  //当xxx失去焦点时 
                var value=$("#xxx").val();
                //alert(value);
                $.ajax({
                    url:"/Up",//要请求的服务器url 
                    //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取 
                    //data:{method:"ajaxTest",val:value},  
                    data:{email:value},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
                    async:true,   //是否为异步请求
                    cache:false,  //是否缓存结果
                    type:"POST", //请求方式为POST
                    dataType:"json",   //服务器返回的数据是什么类型 
                    success:function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是json类型) 
                        if(result){
                            $("label").text("好人");
                        }else{
                            $("label").text("坏人");
                        }
                    }
                })
            })
            
        });
    </script>
  </head>
  
  <body>
     email:<input type="text" name="email" id="xxx"/><label></label><br/>
     密码:<input type="text" name="age" /><br/>
  
  </body>
</html>