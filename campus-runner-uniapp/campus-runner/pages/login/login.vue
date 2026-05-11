<template>
  <view class="container">
    <!-- 顶部渐变区域 -->
    <view class="top-banner">
      <view class="logo-text">校园跑腿</view>
      <view class="sub-text">便捷校园 · 即时服务</view>
    </view>

    <!-- 登录卡片 -->
    <view class="login-card">
      <view class="input-row">
        <input v-model="username" placeholder="请输入账号" />
      </view>
      <view class="input-row">
        <input v-model="password" password placeholder="请输入密码" />
      </view>
      <view class="login-btn" @click="login">
        立即登录
      </view>
      <!-- 跳注册 -->
      <view class="reg-txt" @click="goRegister">
        没有账号？去注册
      </view>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      username: "",
      password: ""
    }
  },
  methods: {
    login() {
      if (!this.username.trim()) {
        uni.showToast({ title: "请输入账号", icon: "none" })
        return
      }
      if (!this.password.trim()) {
        uni.showToast({ title: "请输入密码", icon: "none" })
        return
      }

      const user = {
        id: 1,
        username: "校园用户"
      }
      uni.setStorageSync("user", user)
      uni.setStorageSync("userId", user.id)

      uni.showToast({ title: "登录成功" })
      setTimeout(() => {
        uni.switchTab({ url: "/pages/index/index" })
      }, 800)
    },
    // 跳转注册页
    goRegister() {
      uni.navigateTo({
        url: "/pages/register/register"
      })
    }
  }
}
</script>

<style scoped>
.container {
  background-color: #f5f7fa;
  min-height: 100vh;
}

.top-banner {
  height: 420rpx;
  background: linear-gradient(135deg, #36c1ff, #409eff);
  border-bottom-left-radius: 80rpx;
  border-bottom-right-radius: 80rpx;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.logo-text {
  font-size: 52rpx;
  color: #fff;
  font-weight: bold;
  letter-spacing: 6rpx;
}
.sub-text {
  font-size: 26rpx;
  color: #e8f4ff;
  margin-top: 12rpx;
}

.login-card {
  width: 84%;
  margin: -100rpx auto 0;
  background: #fff;
  border-radius: 28rpx;
  padding: 60rpx 40rpx;
  box-shadow: 0 10rpx 30rpx rgba(64,158,255,0.15);
}

.input-row {
  border-bottom: 1rpx solid #eee;
  margin-bottom: 30rpx;
}
.input-row input {
  height: 86rpx;
  font-size: 30rpx;
}

.login-btn {
  margin-top: 40rpx;
  height: 84rpx;
  line-height: 84rpx;
  text-align: center;
  background: linear-gradient(135deg, #36c1ff, #409eff);
  color: #fff;
  border-radius: 42rpx;
  font-size: 32rpx;
}

.reg-txt {
  text-align: center;
  margin-top: 36rpx;
  font-size: 28rpx;
  color: #409eff;
}
</style>