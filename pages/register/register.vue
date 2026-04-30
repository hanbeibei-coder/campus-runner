<template>
  <view class="box">
    <view class="title">用户注册</view>
    <view class="form">
      <input v-model="username" placeholder="请输入账号" class="input" />
      <input v-model="password" placeholder="请输入密码" class="input" password />
      <button type="primary" @click="register">注册</button>
      <view class="tip" @click="goLogin">已有账号？去登录</view>
    </view>
  </view>
</template>

<script setup>
import { ref } from 'vue'

const username = ref('')
const password = ref('')

const register = () => {
  if (!username.value || !password.value) {
    uni.showToast({ title: '请输入完整信息', icon: 'none' })
    return
  }

  uni.request({
    url: 'http://10.27.11.241:8080/user/register',
    method: 'POST',
    data: {
      username: username.value,
      password: password.value
    },
    success(res) {
      if (res.data.code === 200) {
        uni.showToast({ title: '注册成功' })
        setTimeout(() => {
          uni.navigateBack()
        }, 1500)
      } else {
        uni.showToast({ title: '注册失败', icon: 'none' })
      }
    },
    fail() {
      uni.showToast({ title: '网络异常', icon: 'none' })
    }
  })
}

const goLogin = () => {
  uni.navigateBack()
}
</script>

<style scoped>
.box {
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