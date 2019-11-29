// pages/forget/forget.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    uno:'',
    Password:'',
  },
  //获取身份证号名和新密码输入框内容
  theUno: function (e) {
  this.setData({
    uno: e.detail.value
  })
},
  theMail: function (e) {
  this.setData({
    newPassword: e.detail.value
  })
},
//确认按钮事件
Click:function(e){
  var that = this
  wx.request({
    url: app.data.url +'studentController/findPassword',//自己请求的服务器的地址
    data: {
      "shenfenzheng": that.data.ID,
      "password": that.data.newPassword
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
      console.log(that.data.flag);
      if (that.data.flag) {
          wx.showModal({
            title: '提示：',
            content: '修改成功！',
            success: function (res) {
              //console.log('用户点击确定');
              wx.navigateBack({ url: '../login/login' });//返回上一级页面
            }
          })
        } else {
          wx.showModal({
            title: '提示：',
            content: '关键信息输入错误！',
          })
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