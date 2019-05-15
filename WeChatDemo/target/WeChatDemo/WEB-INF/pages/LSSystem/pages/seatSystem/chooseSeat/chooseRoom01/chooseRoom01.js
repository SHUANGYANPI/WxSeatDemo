var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    empty:70,
    all:100,
    floor: '',
    room01:'',
    room02:'',
    room03:'',
    hiddenRoom:true,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log('ifTime',app.data.ifTime,typeof app.data.ifTime);
    /**从上个页面获取参数 */
    
    this.setData({
      floor:options.floorNumber,
      room01:options.rName01,
      room02:options.rName02,
      room03:options.rName03,
      hiddenRoom:options.hid,//Boolean类型的参数传给hiddenRoom后变为string类型，多番尝试无果，坐等大佬解决!
      
      })
      
      /**判断hiddenRoom数据类型,在控制台运行 */ 
      //console.log(' hiddenRoom:' + typeof this.data.hiddenRoom);
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

  },
})