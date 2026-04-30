<template>
  <view class="login-box">
    <view class="title">校园跑腿</view>
    <view class="form">
      <input v-model="username" placeholder="请输入账号" class="input" />
      <input v-model="password" placeholder="请输入密码" class="input" password />
      <button type="primary" @click="login">登录</button>
      <view class="tip" @click="goRegister">没有账号？去注册</view>
    </view>
  </view>
</template>

<script setup>
import { ref } from 'vue'

const username = ref('')
const password = ref('')

const login = () => {
  if (!username.value || !password.value) {
    uni.showToast({ title: '请输入账号密码', icon: 'none' })
    return
  }

  uni.request({
    url: 'http://10.27.11.241:8080/user/login',
    method: 'POST',
    data: {
      username: username.value,
      password: password.value
    },
    success: (res) => {
      if (res.data.code === 200) {
        uni.showToast({ title: '登录成功' })
        uni.switchTab({ url: '/pages/index/index' })
      } else {
        uni.showToast({ title: '账号或密码错误', icon: 'none' })
      }
    },
    fail: () => {
      uni.showToast({ title: '请求失败，请检查后端', icon: 'none' })
    }
  })
}

const goRegister = () => {
  uni.navigateTo({ url: '/pages/register/register' })
}
</script>

<style scoped>
.login-box {
  padding: 100rpx 40rpx;
}
.title {
  font-size: 50rpx;
  font-weight: bold;
  text-align: center;
  margin-bottom: 80rpx;
}
.form .input {
  border: 1px solid #eee;
  border-radius: 10rpx;
  padding: 25rpx;
  margin-bottom: 30rpx;
}
.form button {
  margin-top: 20rpx;
}
.tip {
  text-align: center;
  color: #007aff;
  margin-top: 30rpx;
}
</style>