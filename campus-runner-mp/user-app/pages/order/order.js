Page({
  data: { orderList: [] },
  onShow() {
    this.setData({
      orderList: wx.getStorageSync('orderList') || []
    })
  }
})