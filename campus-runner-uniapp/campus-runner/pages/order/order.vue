<template>
  <view class="container">
    <view class="page-title">我的订单</view>

    <view class="empty-box" v-if="list.length === 0">
      暂无订单记录
    </view>

    <view class="order-item" v-for="item in list" :key="item.id">
      <view class="order-row">
        <text class="label">订单内容</text>
        <text class="price">￥{{ item.money }}</text>
      </view>
      <view class="order-desc">{{ item.content }}</view>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      list: []
    }
  },
  onShow() {
    const userId = uni.getStorageSync("userId")
    if (!userId) return
    uni.request({
      url: "http://localhost:8080/order/list",
      data: { userId },
      success: res => {
        this.list = res.data.data || []
      }
    })
  }
}
</script>

<style scoped>
.container {
  background: #f5f7fa;
  min-height: 100vh;
  padding: 30rpx;
}
.page-title {
  font-size: 42rpx;
  font-weight: bold;
  text-align: center;
  margin: 20rpx 0 40rpx;
  color: #333;
}
.empty-box {
  text-align: center;
  color: #999;
  font-size: 28rpx;
  margin-top: 120rpx;
}
.order-item {
  background: #fff;
  border-radius: 20rpx;
  padding: 35rpx;
  margin-bottom: 25rpx;
  box-shadow: 0 4rpx 15rpx rgba(64,158,255,0.08);
}
.order-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 15rpx;
}
.label {
  font-size: 32rpx;
  color: #333;
}
.price {
  font-size: 32rpx;
  color: #f56c6c;
  font-weight: bold;
}
.order-desc {
  font-size: 28rpx;
  color: #666;
  line-height: 1.6;
}
</style>