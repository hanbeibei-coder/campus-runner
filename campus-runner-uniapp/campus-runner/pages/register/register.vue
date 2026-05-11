<template>
  <view class="container">
    <!-- 顶部渐变区域 -->
    <view class="top-banner">
      <view class="logo-text">账号注册</view>
      <view class="sub-text">注册账号 · 开启校园跑腿服务</view>
    </view>

    <!-- 注册卡片 -->
    <view class="register-card">
      <view class="input-row">
        <input v-model="username" placeholder="请设置账号" />
      </view>
      <view class="input-row">
        <input v-model="password" password placeholder="请设置密码" />
      </view>
      <view class="input-row">
        <input v-model="repwd" password placeholder="请再次输入密码" />
      </view>

      <view class="register-btn" @click="register">
        立即注册
      </view>

      <view class="login-txt" @click="goLogin">
        已有账号？去登录
      </view>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      username: "",
      password: "",
      repwd: ""
    }
  },
  methods: {
    register() {
      // 非空校验
      if (!this.username.trim()) {
        uni.showToast({ title: "请输入账号", icon: "none" })
        return
      }
      if (!this.password.trim()) {
        uni.showToast({ title: "请输入密码", icon: "none" })
        return
      }
      if (this.password !== this.repwd) {
        uni.showToast({ title: "两次密码不一致", icon: "none" })
        return
      }

      uni.showToast({ title: "注册成功" })
      setTimeout(() => {
        uni.navigateTo({
          url: "/pages/login/login"
        })
      }, 800)
    },
    goLogin() {
      uni.navigateTo({
        url: "/pages/login/login"
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

/* 顶部渐变 和登录页一模一样 */
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

/* 注册卡片 */
.register-card {
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

.register-btn {
  margin-top: 40rpx;
  height: 84rpx;
  line-height: 84rpx;
  text-align: center;
  background: linear-gradient(135deg, #36c1ff, #409eff);
  color: #fff;
  border-radius: 42rpx;
  font-size: 32rpx;
}

.login-txt {
  text-align: center;
  margin-top: 40rpx;
  font-size: 28rpx;
  color: #409eff;
}
</style>