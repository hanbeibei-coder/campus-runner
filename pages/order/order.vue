<template>
  <view class="wrap">
    <view class="title">我的订单</view>

    <view class="empty" v-if="orderList.length === 0">
      暂无订单记录
    </view>

    <view class="item" v-for="item in orderList" :key="item.id">
      <view>内容：{{ item.content }}</view>
      <view>地址：{{ item.address }}</view>
      <view>电话：{{ item.phone }}</view>
      <view>酬金：{{ item.money }} 元</view>
    </view>
  </view>
</template>

<script setup>
import { ref } from 'vue'

const orderList = ref([
  // 后面对接后端再替换成接口数据
  {
    id: 1,
    content: "帮我取快递",
    address: "一食堂门口",
    phone: "13800138000",
    money: 5
  }
])
</script>

<style scoped>
.wrap {
  padding: 20rpx;
}
.title {
  font-size: 40rpx;
  font-weight: bold;
  text-align: center;
  margin: 30rpx 0;
}
.empty {
  text-align: center;
  color: #999;
  margin-top: 100rpx;
  font-size: 30rpx;
}
.item {
  background: #fff;
  padding: 30rpx;
  border-radius: 15rpx;
  margin-bottom: 20rpx;
}
</style>