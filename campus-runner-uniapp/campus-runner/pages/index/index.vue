<template>
  <view class="wrap">
    <view class="home-header">
      <text class="title">校园跑腿服务</text>
      <text class="sub">随时随地 · 帮你代办</text>
    </view>

    <view class="card-box">
      <!-- 我要下单 → 跳发布订单 -->
      <view class="func-card" @click="goPublish">
        <view class="icon">📦</view>
        <view class="name">我要下单</view>
      </view>

      <!-- 帮我跑腿 -->
      <view class="func-card" @click="goRun">
        <view class="icon">🏃</view>
        <view class="name">帮我跑腿</view>
      </view>
    </view>

    <view class="desc-card">
      <view class="desc-title">服务介绍</view>
      <view class="desc-text">
        校园内取快递、买奶茶、代排队、代办琐事，一键下单，专人速达。
      </view>
    </view>
  </view>
</template>

<script>
export default {
  methods: {
    // ✅ 去发布订单（100%能跳）
    goPublish() {
      uni.switchTab({
        url: "/pages/publish/publish"
      })
    },

    // ✅ 帮我跑腿（有提示）
    goRun() {
      uni.showToast({
        title: "欢迎使用跑腿服务",
        icon: "none"
      })
    }
  }
}
</script>

<style scoped>
.wrap {
  background: #f5f7fa;
  min-height: 100vh;
  padding: 30rpx;
}

.home-header {
  background: linear-gradient(135deg, #36c1ff, #409eff);
  border-radius: 30rpx;
  padding: 60rpx 40rpx;
  text-align: center;
  margin-bottom: 40rpx;
}
.title {
  font-size: 44rpx;
  color: #fff;
  font-weight: bold;
}
.sub {
  font-size: 26rpx;
  color: #e6f2ff;
  margin-top: 10rpx;
  display: block;
}

.card-box {
  display: flex;
  justify-content: space-between;
}
.func-card {
  width: 47%;
  background: #fff;
  border-radius: 24rpx;
  text-align: center;
  padding: 40rpx 20rpx;
  box-shadow: 0 6rpx 20rpx rgba(64,158,255,0.1);
}
.icon {
  font-size: 60rpx;
  margin-bottom: 20rpx;
}
.name {
  font-size: 30rpx;
  color: #333;
}

.desc-card {
  margin-top: 40rpx;
  background: #fff;
  border-radius: 24rpx;
  padding: 40rpx;
  box-shadow: 0 6rpx 20rpx rgba(64,158,255,0.1);
}
.desc-title {
  font-size: 34rpx;
  font-weight: bold;
  margin-bottom: 20rpx;
  color: #333;
}
.desc-text {
  font-size: 28rpx;
  color: #666;
  line-height: 1.7;
}
</style>