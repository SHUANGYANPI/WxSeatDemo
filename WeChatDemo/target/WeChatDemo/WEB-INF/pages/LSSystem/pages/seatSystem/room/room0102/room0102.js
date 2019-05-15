//获取全局变量
var app = getApp();
//加载util.js文件
var util = require('../../../../utils/util');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    iftime:app.data.ifTime,
    color:[
      ["green","green","green"],
      ["green","red","green"],
      ["green","green","green"]
    ],
    clo:3,
    seatnow:0,
    L:"取消选择",
    time:util.formatHourMinute(new Date())

  },
  /**选座 */
  Click:function(e){
    var th = this;
    var id = e.target.id;
    var y = (id)%this.data.clo;
    var x = (id-y)/this.data.clo;
    var col = 'color[' + x + '][' +y+ ']';
    var color = th.data.color[x][y];
    
    //判断是否是“查看”状态
    if(this.data.look == 0)
    {
      return;
    }

    this.setData({
      col: "blue",
    })

    if(color == 'red'){
      wx.showModal({
        title: '提示：',
        content: '该座位已被占！.',
        success: function (res) {
          console.log('用户点击确定')
        }
      })
    }
    else{
      if (th.data.seatnow == 0) {//是否选择了座位 未选
            this.setData({
              id: id,//
              x: x,//这里的东西我们要用来写离座的函数，直接留下，不用再进行获取了（对此函数无意，先记着我们把选择的座位id，x，y存下了，后面讲为什么）
              y: y,//
            })
        wx.showModal({
          title: '提示：',
          content: '确定选择该座位？ ' + id + '(+1)',
          success: function (res) {
            if (res.confirm) {
              th.setData({
                [col]: 'blue',//选座成功，选择的位置变成蓝色，选座状态变为1
                seatnow: 1
              })
              console.log('用户点击确定')
            } else if (res.cancel) {
              console.log('用户点击取消')
            }
          }
        })
      } else if (color == 'green') {//已选
        wx.showModal({
          title: '提示：',
          content: '你已选择了一个位置',
          success: function (res) {
            console.log('用户点击确定')
          }
        })
      } else {//已选 且为蓝色
        wx.showModal({
          title: 'UserInfo',
          content: 'Username is  ' + 'john',
          success: function (res) {
            if (res.confirm) {
              console.log('用户点击确定')
            } else if (res.cancel) {
              console.log('用户点击取消')
            }
          }
        })
      }
    }

  },
  /** 离座*/
  leave:function(e){
    var th = this;
    var x = this.data.x;//
    var y = this.data.y;//这里我们不再获取，click函数里面我们已经存了起来，直接拿来用（这里就用到了我们上面保存的座位信息，知道为什么了吧。我们需要下标在离座的时候把颜色变回来）
    var id = this.data.id;//
    var col = 'color[' + x + '][' + y + ']';
    this.setData({
      col: "blue",
    })

    wx.showModal({
      title: '提示：',
      content: '您想取消本次选座?',
      success: function (res) {
        if (res.confirm) {
          th.setData({
            [col]: 'green',
            seatnow: 0
          })
          console.log('离开成功')
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
  },
  //  点击时间组件确定事件  
  bindTimeChange: function (e) {
    //console.log('picker发送选择改变，携带值为',e.detail.value)
    this.setData({
      time:e.detail.value
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      iftime:app.data.ifTime,
    });
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