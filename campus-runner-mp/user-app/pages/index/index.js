Page({
  data: {
    typeList: ["代取快递", "代买饭"],
    typeIndex: 0,
    pickAddr: "",
    receiveAddr: "",
    money: ""
  },

  selectType(e) {
    this.setData({ typeIndex: e.detail.value })
  },

  inputPickAddr(e) {
    this.setData({ pickAddr: e.detail.value })
  },

  inputReceiveAddr(e) {
    this.setData({ receiveAddr: e.detail.value })
  },

  inputMoney(e) {
    this.setData({ money: e.detail.value })
  },

  publishOrder() {
    // 这里等后端订单接口写完，再改成 wx.request
    wx.showToast({ title: "订单发布成功", icon: "success" })
  }
})