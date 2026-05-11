<template>
  <view class="wrap">
    <view class="page-title">发布跑腿订单</view>

    <view class="form-card">
      <view class="form-item">
        <text class="label">需求描述</text>
        <textarea v-model="content" placeholder="请输入你需要代办的事情" auto-height></textarea>
      </view>

      <view class="form-item">
        <text class="label">跑腿金额（元）</text>
        <input v-model="money" type="number" placeholder="请输入悬赏金额" />
      </view>

      <view class="form-item">
        <text class="label">联系电话</text>
        <input v-model="phone" type="number" maxlength="11" placeholder="请输入你的手机号" />
      </view>

      <button class="submit-btn" @click="submit">提交订单</button>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      content: "",
      money: "",
      phone: ""
    }
  },
  methods: {
    submit() {
      // 表单校验
      if (!this.content.trim()) {
        uni.showToast({ title: "请输入需求描述", icon: "none" })
        return
      }
      if (!this.money) {
        uni.showToast({ title: "请输入金额", icon: "none" })
        return
      }
      if (!this.phone.trim()) {
        uni.showToast({ title: "请输入联系电话", icon: "none" })
        return
      }
      if (!/^1[3-9]\d{9}$/.test(this.phone)) {
        uni.showToast({ title: "请输入正确的手机号", icon: "none" })
        return
      }

      const userId = uni.getStorageSync("userId")
      if (!userId) {
        uni.showToast({ title: "请先登录", icon: "none" })
        return
      }

      uni.request({
        url: "http://localhost:8080/order/add",
        method: "POST",
        data: {
          userId,
          content: this.content,
          money: this.money,
          phone: this.phone
        },
        success: res => {
          if (res.data.code === 200) {
            uni.showToast({ title: "发布成功" })
            setTimeout(() => {
              uni.switchTab({ url: "/pages/order/order" })
            }, 1000)
          } else {
            uni.showToast({ title: "发布失败", icon: "none" })
          }
        }
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
.page-title {
  font-size: 42rpx;
  font-weight: bold;
  text-align: center;
  margin: 20rpx 0 40rpx;
  color: #333;
}
.form-card {
  background: #fff;
  border-radius: 24rpx;
  padding: 40rpx;
  box-shadow: 0 6rpx 20rpx rgba(64,158,255,0.1);
}
.form-item {
  margin-bottom: 35rpx;
}
.label {
  font-size: 30rpx;
  color: #333;
  display: block;
  margin-bottom: 15rpx;
}
textarea, input {
  border: 1rpx solid #eee;
  border-radius: 16rpx;
  padding: 20rpx;
  font-size: 28rpx;
  background: #fff;
}
textarea {
  min-height: 120rpx;
}
.submit-btn {
  margin-top: 30rpx;
  background: linear-gradient(135deg, #36c1ff, #409eff);
  color: #fff;
  border-radius: 40rpx;
  font-size: 32rpx;
}
</style>