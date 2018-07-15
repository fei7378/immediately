$(function () {

   //点击回到顶部
    $('body').on('click', '.top-back', function () {
        $('.body-content').animate({
            scrollTop: 0
        }, 700);
    });

    //定义分页初始参数
    var ctxpage = 1;

    //快讯详情 看多 看少 点击事件
    $('.kx-detail-bar a').click(function () {

        //获取数量
        var numebr = parseInt($(this).find('.kx-number').text());

        //当处于选择时 移除选中 并将数量减一
        if($(this).attr('class') == 'active'){
            $(this).removeClass('active');
            $(this).find('.kx-number').text(numebr - 1);

            return false;
        }

        //判断另一个是否有选中
        if($('.kx-detail-bar .active').length > 0){
            var number2 = parseInt($('.kx-detail-bar .active').find('.kx-number').text());

            $('.kx-detail-bar .active').find('.kx-number').text(number2 - 1);

            $('.kx-detail-bar .active').removeClass('active');
        }

        //当前选中项增加样式
        $(this).addClass('active');
        $(this).find('.kx-number').text(numebr + 1);
        
//        var thisid = this.id;
        var number1 = $('#number1').text();
        var number2 = $('#number2').text();
        var id = $(this).parent().attr('id');
        
        
        $.ajax({
        	type:'POST',
        	url:'UpDown',
        	data:{number1:number1,number2:number2,id:id},
        	success:function(data){
        		console.log(data);
        	},error:function(){
        		
        	}
        		
        });



    });

    //快讯页面加载
    $('#kx-load').click(function () {

        console.log('点击元素');
        var thisLink = $(this);

        //获取当前元素父元素在 父视图的位置
       var top_off = thisLink.parent().position().top;



        ctxpage += 1;

        $.ajax({
            type:'GET',
            url:'Paging',
            data:{page:ctxpage,type:1},
            success:function (res) {
                //成功的回调
                console.log(res);

                var result = res;
                var jsonObj = JSON.parse(res);//转换为json对象
                
          //   alert("~~~~~~~~~~~~~~~~~"+jsonObj.code)
                
//               alert('请求成功'+res);
                if(jsonObj.code == -1){
                	alert("以上为所有数据");
                }else{
                	 
                    //设置页面
                    var kxhtml = '';
                    //遍历数组
                    $.each(jsonObj.data,function (index,value) {

                        kxhtml += '<a class="left-list-block" href="GoldenContext?new_id='+value.new_id+'">';

                        kxhtml += '<span class="time-text">'+value.time+'</span><span class="title-text">'+value.title+'</span>';

                        kxhtml += ' <p class="content-text">'+value.content+'</p>';

                        kxhtml += ' <label class="list-bottom"><span><i class="iconfont icon-tubiaoshangshengqushi"></i>看多'+value.up+'</span><span><i class="iconfont icon-tubiaoshangshengqushi1"></i>看空'+value.down+'</span></label></a>';


                    });
                  //  alert(kxhtml);
                 //   console.log(kxhtml);
                    //将kxhtml 插入到加载更多之前
                 //   alert(kxhtml);
                    
                    thisLink.parent().before(kxhtml);

                    //滚动到当前加载的位置
                    $(".body-content").animate({ scrollTop: top_off }, 1000);

                }

            },
            error:function (error) {
                console.log(error);
            }
            
        });
    });



    //政策页面加载更多
    $('#zc-load').click(function () {

        console.log('点击元素');
        var thisLink = $(this);

        //获取当前元素父元素在 父视图的位置
        var top_off = thisLink.parent().position().top;

        ctxpage += 1;

        $.ajax({
            type:'GET',
            url:'Paging',
            data:{page:ctxpage,type:2},
            success:function (res) {
                //成功的回调
                console.log(res);

                var result = res;

 
                var jsonObj = JSON.parse(res);//转换为json对象
              // alert("~~~~~~~~~~~~~~~~~"+jsonObj.code)
                if(jsonObj.code == -1){
                	 alert("没有更多了");
                  
                }else{
                	 
                    //设置页面
                    var kxhtml = '';
                    //遍历数组
                    $.each(jsonObj.data,function (index,value) {
                   
                        kxhtml += '<div class="yw-list-block" >';

                        kxhtml += '<span class="yw-tag tag-zz">转载</span>';

                        kxhtml += ' <img class="yw-left-img" src="'+value.image_big+'" >';

                        kxhtml += '<div class="yw-list-right">';

                        kxhtml +=' <a class="yw-title" href="PolicyContext?id='+value.id+'">'+value.title+'</a>';
                        kxhtml +='  <p  class=comment_inner  title="'+value.summary+'"> '+value.summary+'</p>';
                        kxhtml +='  <label><span></span><span>'+value.source+'</span><span><i class="iconfont icon-yanjing"></i>'+value.look+'</span></label></div> </div>';
                        
                        	

                    });
                  //  alert(kxhtml);
                 //   console.log(kxhtml);
                    //将kxhtml 插入到加载更多之前
                 //   alert(kxhtml);
                    
                    thisLink.parent().before(kxhtml);

                    //滚动到当前加载的位置
                    $(".body-content").animate({ scrollTop: top_off }, 1000);

                }
            },
            error:function (error) {
                console.log(error);
            }

        });
    });
    
    



});