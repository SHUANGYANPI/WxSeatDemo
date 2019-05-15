// pages/seatSystem/floor/floor.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    floor:[
      {
        fNumber:"一楼",
        room01:"钟洢阁(南)",
        room02:"步曾阁(北)"
      },
      {
        fNumber:"二楼",
        room01:"再中阁(南)",
        room02:"宜之阁(北)"
      },
      {
        fNumber:"三楼",
        room01:"时进阁(南)",
        room02:"云森阁(北)"
      },
      {
        fNumber:"四楼",
        room01:"式平阁(南)",
        room02:"彤笙阁(北)",
        room03:"野萝阁(中)",
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //console.log('ifTime',app.data.ifTime,typeof app.data.ifTime);
  },
  /**
   * 实现上个页面的传参
   */
  listClick:function(event){ 
    console.log(event); 
    var p = event.currentTarget.id; 
    var q = this.data.floor[p].fNumber;
    var r01 = this.data.floor[p].room01;
    var r02 = this.data.floor[p].room02;
    var r03 = this.data.floor[p].room03;
    var hid = true;
    // var n = 1;
    if(r03==="野萝阁(中)"){
      hid = false;
    }
    wx.navigateTo({url:'../chooseSeat/chooseRoom01/chooseRoom01?floorNumber='+q+'&rName01='+r01+'&rName02='+r02+'&rName03='+r03+'&hid='+hid}) 
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