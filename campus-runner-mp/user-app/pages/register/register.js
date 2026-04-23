Page({
  data: {
    username: "",
    password: ""
  },

  // 输入账号
  inputUsername(e) {
    this.setData({
      username: e.detail.value
    })
  },

  // 输入密码
  inputPassword(e) {
    this.setData({
      password: e.detail.value
    })
  },

  // 注册
  register() {
    let { username, password } = this.data;

    if (!username || !password) {
      wx.showToast({
        title: "账号密码不能为空",
        icon: "none"
      })
      return;
    }

    wx.request({
      url: "http://localhost:8080/user/register",
      method: "POST",
      data: {
        username: username,
        password: password
      },
      success: (res) => {
        if (res.data.code === 200) {
          wx.showToast({
            title: "注册成功"
          })
          setTimeout(() => {
            wx.navigateBack()
          }, 1000)
        } else {
          wx.showToast({
            title: res.data.msg,
            icon: "none"
          })
        }
      }
    })
  },

  // 返回登录
  goLogin() {
    wx.navigateBack()
  }
})