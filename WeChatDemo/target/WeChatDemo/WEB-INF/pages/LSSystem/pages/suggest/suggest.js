// pages/suggest/suggest.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    value:'',
    suggest:"吐槽",
    yourContactWay:"联系方式：",
    textContent:"邮箱、qq、手机号...",
    theContent:"你的建议或吐槽：",
    textareaContent:"我觉得......",
    BUuttonName:"提交",
    max: 140,
  },
//字数限制  
Inputs: function (e) {
  // 获取输入框的内容
  this.data.value = e.detail.value;
  // 获取输入框内容的长度
  var len = parseInt( this.data.value.length);

  //最多字数限制
  if(len > this.data.max) return;
      // 当输入框内容的长度大于最大长度限制（max)时，终止setData()的执行
      this.setData({
         currentWordNumber: len, //当前字数  
        });
},

/**提交事件 未实现输入空的判断！！！！？*/
Submit:function(){
  console.log("点击提交之后"+this.data.value);
  if(this.data.value!=null){
    wx.showModal({
      title: '提示：',
      content: '提交成功！',
      success: function (res) {
        //console.log('用户点击确定')
      }
    })
  }else{
    wx.showModal({
      title: '提示：',
      content: '请输入内容！',
      success: function (res) {
        //console.log('用户点击确定')
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