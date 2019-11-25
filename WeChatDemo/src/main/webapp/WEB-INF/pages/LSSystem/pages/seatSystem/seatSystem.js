 // 在需要使用的js文件中，导入js  
 var util = require('../../utils/util.js');  
//获取全局变量
var app = getApp();
 Page({
  data:{
    
    empty:70,
    all:100,
    time : '',
    IndexBannerUrl:[{
      link:'library/library',
      src:'../image/swiper01.jpg'
    },
    {
      link:'library/library',
      src:'../image/swiper02.jpg'
    },
    {
      link:'library/library',
      src:'../image/swiper03.jpg'
    },
    {
      link:'library/library',
      src:'../image/swiper04.jpg'
    }
  ],
  
},
  //点击轮播图跳转
  bindViewTap:function(event){
    wx.navigateTo({
      url: 'library/library'  // 页面跳转地址
    })
  },
  //  点击时间组件确定事件  
  bindTimeChange: function (e) {
    //console.log('picker发送选择改变，携带值为',e.detail.value)
    this.setData({
      time:e.detail.value
    })
  },
  //点击"选座"
  ChooseSeat:function(){
    if(app.data.ifTime===false){
      app.data.ifTime = true;
    }
    if(app.data.Look === 0){
      app.data.Look = 1;
    }
    if(app.data.ifButton==true){
      app.data.ifButton = false;
    }
    
  },
  //点击“预约”改变全局变量ifTime
  ChangeIfTime:function(){
    if(app.data.ifTime===true){
      app.data.ifTime = false;
    }
    if(app.data.Look === 0){
      app.data.Look = 1;
    }
    if(app.data.ifButton===true){
      app.data.ifButton = false;
    }
    
  },
  //点击“查看”改变全局变量look
  lookSeat:function(){
    if(app.data.ifTime===false){
      app.data.ifTime = true;
    }
    if(app.data.Look === 1){
      app.data.Look = 0;
    }
    if(app.data.ifButton===false){
      app.data.ifButton = true;
    }
    
  },
  //更多：
  More:function(){
    wx.showModal({
      title: '',
      content: '敬请期待...',
    })
  }
})
