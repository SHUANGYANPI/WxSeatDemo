// pages/psinformation/p_s_i.js
var app = getApp()
Page({


  /**
   * 页面的初始数据
   */

  data: {
    name:"Lisa",
    sex:"女",
    integral:5,
     uno1:''

  },

 //点击扫码图扫码 允许从相机和相册扫码
 clickScnner:function(event){
  wx.scanCode({
    //onlyFromCamera: true,//只允许从相机扫码
    success (res) {
      //console.log(res.result);
      var result = res.result;//将扫描结果存放在result中
      if(result==app.data.no){  //签到成功
        app.data.signIn = true, //签到成功将signIn置true
        
        wx.showModal({
          title: '签到结果：',
          content: '签到成功！',
        })
      }else{
        app.data.signIn = false,
        wx.showModal({
          title: '签到结果：',
          content: '签到失败！是不是扫错位置了？',
        })
      }
    }
  })
},

  /**
   * 生命周期函数--监听页面加载
   */

  data:{
   
  },
  onLoad: function (options) {

    wx.setNavigationBarTitle({title:'个人信息'});

    var uno1 = app.data.no;
    var that = this;
    wx.request({
      url: 'http://localhost:8080/studentController/findOneStudent',//自己请求的服务器的地址
      method: 'POST',
      header: {
        'content-type': 'application/json;charset=UTF-8', // 默认值
        'dataType': 'json'
      },
      data: {
        "uno": uno1
      },
      success: function (req) {
        var list = req.data;
        if (list == null) {
          wx.showToast({
            title: 'ErrorMessage',
            icon: 'false',   //图标
            duration: 1500  //提示的延迟的时间
          })
        } else {
          that.setData({
            user:list
          })
          app.data.name1 = that.data.user.name;
        }
      }
    })
  },

  
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})