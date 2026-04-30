<template>
  <view class="user-box">
    <!-- 顶部用户信息 -->
    <view class="user-top">
      <view class="avatar">👤</view>
      <view class="username">{{ username }}</view>
    </view>

    <!-- 菜单列表 -->
    <view class="menu-list">
      <view class="menu-item" @click="goOrder">
        <text>我的订单</text>
        <text></text>
      </view>

      <view class="menu-item" @click="logout">
        <text class="red">退出登录</text>
      </view>
    </view>
  </view>
</template>

<script setup>
import { ref } from 'vue'

// 用户名（后面对接登录信息时可以动态获取）
const username = ref('校园用户')

// 跳转到我的订单
const goOrder = () => {
  uni.navigateTo({
    url: '/pages/order/order'
  })
}

// 退出登录
const logout = () => {
  uni.showModal({
    title: '提示',
    content: '确定退出登录？',
    success: (res) => {
      if (res.confirm) {
        uni.reLaunch({
          url: '/pages/login/login'
        })
      }
    }
  })
}
</script>

<style scoped>
.user-box {
  background: #f5f5f5;
  min-height: 100vh;
}

/* 顶部 */
.user-top {
  background: #007aff;
  padding: 60rpx 30rpx;
  text-align: center;
  color: white;
  margin-bottom: 30rpx;
}

.avatar {
  font-size: 70rpx;
  margin-bottom: 20rpx;
}

.username {
  font-size: 36rpx;
  font-weight: bold;
}

/* 菜单 */
.menu-list {
  background: white;
}

.menu-item {
  display: flex;
  justify-content: space-between;
  padding: 30rpx;
  font-size: 32rpx;
  border-bottom: 1rpx solid #f0f0f0;
}

.red {
  color: red;
}
</style>