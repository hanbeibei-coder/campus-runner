Page({
  data: { user: {} },
  onShow() {
    this.setData({ user: wx.getStorageSync('userInfo') })
  }
})