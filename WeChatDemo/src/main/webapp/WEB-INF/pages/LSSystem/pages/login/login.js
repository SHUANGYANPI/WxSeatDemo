// pages/register/register.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userNo:'',
    userPwd:'',
    flag:''
  },

// 用户名和密码输入框事件
userNoInput: function (e) {
  this.setData({
    uno: e.detail.value
  })
},
pasWInput: function (e) {
  this.setData({
    password: e.detail.value
  })
},
loginBtnClick: function (e) {
  var that = this
  app.data.no = that.data.uno;
  wx.request({
    url: 'http://localhost:8080/studentController/Login',//自己请求的服务器的地址
      data:{
        "uno":that.data.uno,
        "password":that.data.password
        },
      method: 'POST',
      header: {
        'content-type': 'application/json;charset=UTF-8', // 默认值
        'dataType':'json'
      },
      success: function (req) {
        var getdata = req.data;
        that.setData({
         flag: getdata
        })
        if (that.data.flag){
          wx.switchTab({
            url: '../person/person'
          });
        }
      }
    })
},
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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