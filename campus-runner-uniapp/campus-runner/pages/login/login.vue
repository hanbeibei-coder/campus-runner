<template>
  <view class="box">
    <view class="title">用户登录</view>
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

// 登录请求 → 这里就是你要放的后端请求代码
const login = () => {
  uni.request({
    url: 'http://localhost:8080/user/login',
    method: 'POST',
    data: {
      username: username.value,
      password: password.value
    },
    success(res) {
      console.log(res.data)
      if (res.data.code === 200) {
        uni.showToast({ title: '登录成功' })
        uni.switchTab({ url: '/pages/index/index' })
      } else {
        uni.showToast({ title: res.data.msg, icon: 'none' })
      }
    }
  })
}

const goRegister = () => {
  uni.navigateTo({ url: '/pages/register/register' })
}
</script>

<style scoped>
.box { padding: 100rpx 40rpx; }
.title { font-size: 50rpx; font-weight: bold; text-align: center; margin-bottom: 80rpx; }
.form .input { border: 1px solid #eee; border-radius: 10rpx; padding: 25rpx; margin-bottom: 30rpx; }
.tip { text-align: center; color: #007aff; margin-top: 30rpx; }
</style>