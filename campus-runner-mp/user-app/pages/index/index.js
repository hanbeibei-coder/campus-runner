Page({
  data: { type: '', pick: '', receive: '', money: '' },
  setType(e) { this.setData({ type: e.detail.value }) },
  setPick(e) { this.setData({ pick: e.detail.value }) },
  setReceive(e) { this.setData({ receive: e.detail.value }) },
  setMoney(e) { this.setData({ money: e.detail.value }) },
  publish() {
    let order = {
      id: Date.now(),
      type: this.data.type,
      pick: this.data.pick,
      receive: this.data.receive,
      money: this.data.money,
      status: '待接单'
    }
    let list = wx.getStorageSync('orderList') || []
    list.unshift(order)
    wx.setStorageSync('orderList', list)
    wx.showToast({ title: '发布成功' })
  }
})