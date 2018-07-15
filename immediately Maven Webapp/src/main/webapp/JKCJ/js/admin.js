$(function () {
    
    
    //登录页面
    
    //JavaScript代码区域
    layui.use(['element','upload','form'], function () {
        var element = layui.element,
            upload = layui.upload,
            form = layui.form;


        //验证参数
        form.verify({
            password:[
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ],
            cifpassword:function (value,item) {
                if(value != $('.edit-pwd-block input[name="password"]').val()){
                    return '确认密码和新密码必须一致！';
                }
            }
        });


        //用户登录
        form.on('submit(login)',function (data) {

            console.log(data.field);

            return false;
        });
        
        
        //gaogao1
        form.on('submit(imgform1)',function(data){
        	console.log(data);
        	console.log(data.field);
        	
        	
        	
        	
//        	$.ajax({
//        		type:'post',
//        		url:'',
//        		data:data.field,
//        		
//        	});
//        	
//        	
//        	
//        	
//        	return false;
        });
        
        $('.layui-btn-danger').click(function(){
        	
        	
        	console.log(this.id);
        	
//        	alert('123123');
        	
        	
        });
        
        
        //gaogao1
        form.on('submit(imgform2)',function(data){
        	console.log(data);
        	console.log(data.field);
        	
        	
        	
        	
//        	$.ajax({
//        		type:'post',
//        		url:'',
//        		data:data.field,
//        		
//        	});
//        	
//        	
//        	
//        	
//        	return false;
        });
        
        $('.layui-btn-danger').click(function(){
        	
        	
        	console.log(this.id);
        	
//        	alert('123123');
        	
        	
        });
        //gaogao1
        form.on('submit(imgform3)',function(data){
        	console.log(data);
        	console.log(data.field);
        	
        	
        	
        	
//        	$.ajax({
//        		type:'post',
//        		url:'',
//        		data:data.field,
//        		
//        	});
//        	
//        	
//        	
//        	
//        	return false;
        });
        
        $('.layui-btn-danger').click(function(){
        	
        	
        	console.log(this.id);
        	
//        	alert('123123');
        	
        	
        });
        
        
        

        //图片上传```````````````````````````1
        var uploadInst = upload.render({
            elem: '.adv-img-btn1'  //上传按钮
            ,url: 'Upload'    //上传地址
          ,data: {
        	  id: function(){
        		  return $(this).next().val();
        		  } }
            ,before: function(obj){
                var item = this.item;  //获取当前元素
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $(item).prop('src',result); //设置预览图片
                   
                });
            }
            ,done: function(res){
            	

                //如果上传成功
                if(res.code > 0){
                	$("#a1").val(res.name);
                	
                    return layer.msg(res.msg);
                 
               }else{
            	   return layer.msg(res.msg);
               }
                //上传成功
            }
            ,error: function(error){
                console.log(error);
                //演示失败状态，并实现重传
                layer.msg('上传接口不可用');
            }
        });

        
        //图片上传````````````````````````````````2
        var uploadInst = upload.render({
            elem: '.adv-img-btn2'  //上传按钮
            ,url: 'Upload'    //上传地址
          ,data: {
        	  id: function(){
        		  return $(this).next().val();
        		  } }
            ,before: function(obj){
                var item = this.item;  //获取当前元素
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $(item).prop('src',result); //设置预览图片
                   
                });
            }
            ,done: function(res){
            	

                //如果上传成功
                if(res.code > 0){
                	$("#a2").val(res.name);
                    return layer.msg(res.msg);
                 
               }else{
            	   return layer.msg(res.msg);
               }
                //上传成功
            }
            ,error: function(error){
                console.log(error);
                //演示失败状态，并实现重传
                layer.msg('上传接口不可用');
            }
        });
        
        
        
        
        
        //图片上传```````````````````````````````````3
        var uploadInst = upload.render({
            elem: '.adv-img-btn3'  //上传按钮
            ,url: 'Upload'    //上传地址
          ,data: {
        	  id: function(){
        		  return $(this).next().val();
        		  } }
            ,before: function(obj){
                var item = this.item;  //获取当前元素
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $(item).prop('src',result); //设置预览图片
                   
                });
            }
            ,done: function(res){
            	

                //如果上传成功
                if(res.code > 0){
                	
                	$("#a3").val(res.name);
                	
                    return layer.msg(res.msg);
                 
               }else{
            	   return layer.msg(res.msg);
               }
                //上传成功
            }
            ,error: function(error){
                console.log(error);
                //演示失败状态，并实现重传
                layer.msg('上传接口不可用');
            }
        });
        
        
        //图片上传``````````````````````````````````4
        var uploadInst = upload.render({
            elem: '.adv-img-btn4'  //上传按钮
            ,url: 'Upload'    //上传地址
          ,data: {
        	  id: function(){
        		  return $(this).next().val();
        		  } }
            ,before: function(obj){
                var item = this.item;  //获取当前元素
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $(item).prop('src',result); //设置预览图片
                   
                });
            }
            ,done: function(res){
            	

                //如果上传成功
                if(res.code > 0){
                
                	$("#a4").val(res.name);
                	
                    return layer.msg(res.msg);
                 
               }else{
            	   return layer.msg(res.msg);
               }
                //上传成功
            }
            ,error: function(error){
                console.log(error);
                //演示失败状态，并实现重传
                layer.msg('上传接口不可用');
            }
        });
        
        
        
        
        //图片上传
        var uploadInst = upload.render({
            elem: '.adv-img-btn5'  //上传按钮
            ,url: 'Upload'    //上传地址
          ,data: {
        	  id: function(){
        		  return $(this).next().val();
        		  } }
            ,before: function(obj){
                var item = this.item;  //获取当前元素
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $(item).prop('src',result); //设置预览图片
                   
                });
            }
            ,done: function(res){
            	

                //如果上传成功
                if(res.code > 0){
                
                	$("#a5").val(res.name);
                	
                    return layer.msg(res.msg);
                 
               }else{
            	   return layer.msg(res.msg);
               }
                //上传成功
            }
            ,error: function(error){
                console.log(error);
                //演示失败状态，并实现重传
                layer.msg('上传接口不可用');
            }
        });
        
        
        
        //图片上传
        var uploadInst = upload.render({
            elem: '.adv-img-btn6'  //上传按钮
            ,url: 'Upload'    //上传地址
          ,data: {
        	  id: function(){
        		  return $(this).next().val();
        		  } }
            ,before: function(obj){
                var item = this.item;  //获取当前元素
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $(item).prop('src',result); //设置预览图片
                   
                });
            }
            ,done: function(res){
            	

                //如果上传成功
                if(res.code > 0){
                
                	$("#a6").val(res.name);
                
                    return layer.msg(res.msg);
                 
               }else{
            	   return layer.msg(res.msg);
               }
                //上传成功
            }
            ,error: function(error){
                console.log(error);
                //演示失败状态，并实现重传
                layer.msg('上传接口不可用');
            }
        });
        //图片上传
        var uploadInst = upload.render({
            elem: '.adv-img-btn7'  //上传按钮
            ,url: 'Upload'    //上传地址
          ,data: {
        	  id: function(){
        		  return $(this).next().val();
        		  } }
            ,before: function(obj){
                var item = this.item;  //获取当前元素
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $(item).prop('src',result); //设置预览图片
                   
                });
            }
            ,done: function(res){
            	

                //如果上传成功
                if(res.code > 0){
                	
                	$("#a7").val(res.name);
                
                    return layer.msg(res.msg);
                 
               }else{
            	   return layer.msg(res.msg);
               }
                //上传成功
            }
            ,error: function(error){
                console.log(error);
                //演示失败状态，并实现重传
                layer.msg('上传接口不可用');
            }
        }); //图片上传
        var uploadInst = upload.render({
            elem: '.adv-img-btn8'  //上传按钮
            ,url: 'Upload'    //上传地址
          ,data: {
        	  id: function(){
        		  return $(this).next().val();
        		  } }
            ,before: function(obj){
                var item = this.item;  //获取当前元素
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $(item).prop('src',result); //设置预览图片
                   
                });
            }
            ,done: function(res){
            	

                //如果上传成功
                if(res.code > 0){
                	
                	$("#a8").val(res.name);
                
                    return layer.msg(res.msg);
                 
               }else{
            	   return layer.msg(res.msg);
               }
                //上传成功
            }
            ,error: function(error){
                console.log(error);
                //演示失败状态，并实现重传
                layer.msg('上传接口不可用');
            }
        });
        //图片上传
        var uploadInst = upload.render({
            elem: '.adv-img-btn9'  //上传按钮
            ,url: 'Upload'    //上传地址
          ,data: {
        	  id: function(){
        		  return $(this).next().val();
        		  } }
            ,before: function(obj){
                var item = this.item;  //获取当前元素
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $(item).prop('src',result); //设置预览图片
                   
                });
            }
            ,done: function(res){
            	

                //如果上传成功
                if(res.code > 0){
                
                	$("#a9").val(res.name);
                    return layer.msg(res.msg);
                 
               }else{
            	   return layer.msg(res.msg);
               }
                //上传成功
            }
            ,error: function(error){
                console.log(error);
                //演示失败状态，并实现重传
                layer.msg('上传接口不可用');
            }
        });
      
        //修改密码
        $('.edit-password').click(function () {
           var link = $(this);

            var layer_index = layer.open({
                title:'修改密码',
                type:1,
                area:['500px','300px'],
                resize:false,
                content:' <div class="edit-pwd-block">\n' +
                '            <form class="layui-form"  method="POST">\n' +
                '               <div class="layui-form-item">\n' +
                '                   <input class="layui-input" name="password" lay-verify="required|password" type="password" placeholder="请输入新密码">\n' +
                '               </div>\n' +
                '                <div class="layui-form-item">\n' +
                '                    <input class="layui-input" name="cifpassword" lay-verify="cifpassword" type="password" placeholder="请输入确认密码">\n' +
                '                </div>\n' +
                '                <div class="edit-btns"><button class="layui-btn" type="submit" lay-submit lay-filter="edit-submit">确认</button>\n' +
                '                    <button type="button" class="layui-btn layui-btn-danger" id="edit-cancel">取消</button>\n' +
                '                </div>\n' +
                '            </form>\n' +
                '        </div>'
            });

            //验证参数
            // form.verify({
            //     password:[
            //         /^[\S]{6,12}$/
            //         ,'密码必须6到12位，且不能出现空格'
            //     ],
            //     cifpassword:function (value,item) {
            //         if(value != $('.edit-pwd-block input[name="password"]').val()){
            //           return '确认密码和新密码必须一致！';
            //         }
            //     }
            // });


            //点击取消按钮
            $('#edit-cancel').click(function () {

                layer.close(layer_index); //关闭弹窗
                link.parent().removeClass('layui-this');
            });


            //点击确认按钮
            form.on('submit(edit-submit)',function (data) {

                console.log(data.field);
                
                
                
//               return false;

                

            });



        });
        
        
        
        //退出登录前的提示
        $('.login-out').click(function () {

            var link = $(this);

            layer.confirm('确认退出？', {
                btn: ['确认','取消'] //按钮
            }, function(){

              window.location.href = link.attr('href');

            }, function(){
               link.parent().removeClass('layui-this');
                // return false;
            });
            return false;
        });





    });


});