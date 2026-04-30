<template>
  <view class="container">
    <view class="title">发布跑腿订单</view>
    <view class="form">
      <view class="item">
        <text>任务内容</text>
        <input v-model="form.content" placeholder="请输入" />
      </view>
      <view class="item">
        <text>联系电话</text>
        <input v-model="form.phone" placeholder="请输入" />
      </view>
      <view class="item">
        <text>地址</text>
        <input v-model="form.address" placeholder="请输入" />
      </view>
      <view class="item">
        <text>酬金(元)</text>
        <input v-model="form.money" type="number" placeholder="请输入" />
      </view>
      <button type="primary" @click="submit">发布订单</button>
    </view>
  </view>
</template>

<script setup>
import { ref } from 'vue'

const form = ref({
  content: '',
  phone: '',
  address: '',
  money: ''
})

// 发布订单 → 调用后端接口
const submit = () => {
  uni.request({
    url: 'http://localhost:8080/order/add',
    method: 'POST',
    data: form.value,
    success(res) {
      if (res.data.code === 200) {
        uni.showToast({ title: '发布成功' })
        form.value = { content: '', phone: '', address: '', money: '' }
      }
    }
  })
}
</script>

<style scoped>
.container { padding: 30rpx; }
.title { font-size: 40rpx; font-weight: bold; text-align: center; margin: 20rpx 0 40rpx; }
.form .item { margin-bottom: 30rpx; }
.form text { display: block; margin-bottom: 10rpx; }
.form input { border: 1px solid #eee; padding: 20rpx; border-radius: 10rpx; }
</style>