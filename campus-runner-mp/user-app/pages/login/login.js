Page({
  login() {
    wx.getUserProfile({
      desc: '登录',
      success: res => {
        wx.setStorageSync('userInfo', res.userInfo)
        wx.switchTab({ url: '/pages/index/index' })
      }
    })
  }
})