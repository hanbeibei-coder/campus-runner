Page({
  data: {
    username: "",
    password: ""
  },

  // 账号输入
  inputUsername(e) {
    this.setData({
      username: e.detail.value
    })
  },

  // 密码输入
  inputPassword(e) {
    this.setData({
      password: e.detail.value
    })
  },

  // 登录
  login() {
    let { username, password } = this.data;

    // 简单校验
    if (!username || !password) {
      wx.showToast({
        title: "账号密码不能为空",
        icon: "none"
      })
      return;
    }

    // 关键：请求后端接口
    wx.request({
      url: "http://127.0.0.1:8080/user/login", // 用127.0.0.1更稳定
      method: "POST",
      header: {
        "content-type": "application/json"
      },
      data: {
        username: username,
        password: password
      },
      success: (res) => {
        console.log("登录接口返回：", res.data); // 调试用，看返回结果

        if (res.data.code === 200) {
          wx.showToast({
            title: "登录成功"
          })
          // 保存用户信息
          wx.setStorageSync("user", { username })
          // 跳转到带tabBar的首页
          wx.switchTab({
            url: "/pages/index/index"
          })
        } else {
          wx.showToast({
            title: res.data.msg || "登录失败",
            icon: "none"
          })
        }
      },
      fail: (err) => {
        console.error("请求失败：", err); // 调试用，看错误信息
        wx.showToast({
          title: "网络请求失败，请检查后端是否启动",
          icon: "none"
        })
      }
    })
  },

  // 跳转到注册页
  goRegister() {
    wx.navigateTo({
      url: "/pages/register/register"
    })
  }
})