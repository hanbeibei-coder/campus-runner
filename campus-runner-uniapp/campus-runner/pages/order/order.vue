<template>
  <view class="wrap">
    <view class="title">我的订单</view>

    <view class="empty" v-if="list.length === 0">暂无订单</view>

    <view class="item" v-for="item in list">
      <view>内容：{{ item.content }}</view>
      <view>电话：{{ item.phone }}</view>
      <view>地址：{{ item.address }}</view>
      <view>酬金：{{ item.money }} 元</view>
    </view>
  </view>
</template>

<script setup>
// 只改这里！把 onLoad 换成 onMounted ✅
import { ref, onMounted } from 'vue'

const list = ref([])

// 页面加载时获取订单列表
onMounted(() => {
  uni.request({
    url: 'http://localhost:8080/order/list',
    success(res) {
      list.value = res.data.data || []
    }
  })
})
</script>

<style scoped>
.wrap { padding: 20rpx; }
.title { font-size: 40rpx; text-align: center; margin: 30rpx 0; }
.empty { text-align: center; color: #999; margin-top: 100rpx; }
.item { background:#fff; padding:30rpx; border-radius:15rpx; margin-bottom:20rpx; }
</style>