// pages/register/register.js
var app = getApp()
function isNumber(str){
  if (/^[0-9]+$/.test(str)) {//这是用正则表达检查
    return false;
  } else {
    return true;
  }
}

Page({

  /**
   * 页面的初始数据
   */
  data: {
    Name:'',
    No:'',
    Phone:'',
    QQ:'',
    Sex:'',
    Password:'',
    FinalPassword:''
  },

  tips:{

  },

  /**获取注册信息各个输入框内容 */
  theName:function(e){
    this.setData({
      Name: e.detail.value
    })
  },
  theNo:function(e){
    this.setData({
      No: e.detail.value
    })
  },
  thePhone:function(e){
    this.setData({
      Phone: e.detail.value
    })
  },
  theQQ:function(e){
    this.setData({
      QQ: e.detail.value
    })
  },
  theSex:function(e){
    this.setData({
      Sex: e.detail.value
    })
  },
  thePassword:function(e){
    this.setData({
      Password: e.detail.value
    })
  },
  theFinalPassword:function(e){
    this.setData({
      FinalPassword: e.detail.value
    })
  },
  /**按钮事件 */
  Click:function(e){
    var that = this
    console.log(that.data.FinalPassword);
    console.log(that.data.Password);
    if (that.data.No == '' || that.data.QQ == '' || that.data.Password == '' || that.data.FinalPassword == '' || that.data.Phone == '' || that.data.Sex == '' || that.data.Name == ''){
      wx.showToast({
        title: '全部必填',
        icon: 'fail',
        duration: 2000
      })
    } else if (isNumber(that.data.No)){
      wx.showToast({
        title: '学号只能为数字',
        icon: 'fail',
        duration: 2000
      })
    } else if (isNumber(that.data.Phone)) {
      wx.showToast({
        title: '手机号只能为数字',
        icon: 'fail',
        duration: 2000
      })
    } else if (isNumber(that.data.QQ)) {
      wx.showToast({
        title: 'QQ号只能为数字',
        icon: 'fail',
        duration: 2000
      })
    } else if (that.data.Password != that.data.FinalPassword){
      wx.showToast({
        title: '密码不一致',
        icon: 'fail',
        duration: 2000
      })
    }
    else{
    wx.request({
      url: app.data.url +'studentController/Register',//自己请求的服务器的地址
      data:{
          "no": that.data.No,
          "name": that.data.Name,
          "phone": that.data.Phone,
          "qq": that.data.QQ,
          "sex": that.data.Sex,
          "password": that.data.Password,
        },
      method: 'POST',
      header: {
        'content-type': 'application/json', // 默认值
        'dataType': 'json'
      },
      success: function (req) {
        var getdata = req.data;
        that.setData({
          flag: getdata
        })
        if (that.data.flag) {
          wx.showModal({
            title: '注册成功',
            success: function (res) {
              //console.log('用户点击确定');
              wx.navigateBack({ url: '../login/login' });//返回上一级页面
            }
          })
        }
      }
    })
  }
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