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
     uno1:'',
  },

 //点击扫码图扫码 允许从相机和相册扫码
 clickScnner:function(event){
   var that = this;
   wx.scanCode({
    //onlyFromCamera: true,//只允许从相机扫码
    success (res) {
       
      var result = res.result;//将扫描结果存放在result中
       //console.log(result);
      if(result==app.data.no){  //签到成功
        app.data.signIn = true, //签到成功将signIn置true
        that.data.count++;
           that.setData({
              count:that.data.count
           })
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
     count: 0
  },
  onLoad: function (options) {

    wx.setNavigationBarTitle({title:'个人信息'});

    var uno1 = app.data.uno;
    var that = this;
    wx.request({
      url: app.data.url+'studentController/findOneStudent',//自己请求的服务器的地址
      method: 'POST',
      header: {
        'content-type': 'application/json;charset=UTF-8', // 默认值
        'dataType': 'json'
      },
      data: {
        "uno": uno1
      },
      success: function (req) {
         app.data.no = req.data.noId;
        console.log(app.data.no)
         that.data.count = req.data.count;
         console.log(that.data.count);
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
    this.onLoad();//每次进入此页面要重新加载
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