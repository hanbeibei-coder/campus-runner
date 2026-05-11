<template>
  <view class="container">
    <!-- 顶部用户信息 -->
    <view class="user-header">
      <view class="avatar-box" @click="changeAvatar">
        <view class="default-avatar" v-if="!avatar">👤</view>
        <image :src="avatar" class="img-avatar" v-else mode="aspectFill" />
      </view>
      <view class="nickname-box" @click="editNickname">
        <text class="nickname">{{ nickname }}</text>
        <text class="edit-tip">点击修改昵称</text>
      </view>
    </view>

    <!-- 功能菜单 -->
    <view class="menu-list">

      <!-- 订单拆分 -->
      <view class="menu-item" @click="goMyPublish">
        <text>我发布的订单</text>
        <text class="arrow">></text>
      </view>
      <view class="menu-item" @click="goMyReceive">
        <text>我接到的订单</text>
        <text class="arrow">></text>
      </view>

      <!-- 实用功能 -->
      <view class="menu-item" @click="goWallet">
        <text>我的钱包</text>
        <text class="arrow">></text>
      </view>
      <view class="menu-item" @click="goAddress">
        <text>常用地址</text>
        <text class="arrow">></text>
      </view>
      <view class="menu-item" @click="goMessage">
        <text>消息通知</text>
        <text class="arrow">></text>
      </view>
      <view class="menu-item" @click="goAccount">
        <text>账号安全</text>
        <text class="arrow">></text>
      </view>
      <view class="menu-item" @click="goFeedback">
        <text>意见反馈</text>
        <text class="arrow">></text>
      </view>

      <!-- 退出登录 -->
      <view class="menu-item logout" @click="logout">
        <text>退出登录</text>
        <text class="arrow">></text>
      </view>
    </view>

    <!-- 修改昵称弹窗 -->
    <view class="mask" v-if="showEdit" @click="showEdit=false">
      <view class="dialog" @click.stop>
        <view class="dialog-title">修改昵称</view>
        <input class="dialog-input" v-model="newName" placeholder="请输入新昵称" />
        <view class="dialog-btns">
          <view class="btn-cancel" @click="showEdit=false">取消</view>
          <view class="btn-save" @click="saveNickname">保存</view>
        </view>
      </view>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      avatar: "",
      nickname: "校园用户",
      newName: "",
      showEdit: false
    };
  },
  onLoad() {
    const user = uni.getStorageSync("user");
    const name = uni.getStorageSync("nickname");
    if (name) this.nickname = name;
    else if (user) this.nickname = user.username;
  },
  methods: {
    // 更换头像
    changeAvatar() {
      uni.chooseImage({
        success: (res) => {
          this.avatar = res.tempFilePaths[0];
          uni.setStorageSync("avatar", this.avatar);
          uni.showToast({ title: "更换成功" });
        }
      });
    },

    // 修改昵称
    editNickname() {
      this.newName = this.nickname;
      this.showEdit = true;
    },
    saveNickname() {
      if (!this.newName.trim()) {
        uni.showToast({ title: "昵称不能为空", icon: "none" });
        return;
      }
      this.nickname = this.newName.trim();
      uni.setStorageSync("nickname", this.nickname);
      this.showEdit = false;
      uni.showToast({ title: "修改成功" });
    },

    // ================== 功能跳转 ==================
    goMyPublish() {
      uni.showToast({ title: "我发布的订单", icon: "none" });
    },
    goMyReceive() {
      uni.showToast({ title: "我接到的订单", icon: "none" });
    },
    goWallet() {
      uni.showToast({ title: "我的钱包", icon: "none" });
    },
    goAddress() {
      uni.showToast({ title: "常用地址", icon: "none" });
    },
    goMessage() {
      uni.showToast({ title: "消息通知", icon: "none" });
    },
    goAccount() {
      uni.showToast({ title: "账号安全", icon: "none" });
    },
    goFeedback() {
      uni.showToast({ title: "意见反馈", icon: "none" });
    },

    // 退出登录
    logout() {
      uni.showModal({
        title: "提示",
        content: "确定退出登录？",
        success: (res) => {
          if (res.confirm) {
            uni.clearStorageSync();
            uni.reLaunch({ url: "/pages/login/login" });
          }
        }
      });
    }
  }
};
</script>

<style scoped>
.container {
  background: #f5f7fa;
  min-height: 100vh;
}

/* 顶部渐变 */
.user-header {
  background: linear-gradient(135deg, #36c1ff, #409eff);
  padding: 100rpx 40rpx 60rpx;
  text-align: center;
  border-bottom-left-radius: 80rpx;
  border-bottom-right-radius: 80rpx;
}
.avatar-box {
  margin-bottom: 20rpx;
}
.default-avatar {
  width: 180rpx;
  height: 180rpx;
  border-radius: 50%;
  background: #fff;
  font-size: 76rpx;
  line-height: 180rpx;
  color: #409eff;
}
.img-avatar {
  width: 180rpx;
  height: 180rpx;
  border-radius: 50%;
}
.nickname {
  font-size: 40rpx;
  color: #fff;
  font-weight: 500;
}
.edit-tip {
  font-size: 24rpx;
  color: #e6f2ff;
  margin-top: 8rpx;
  display: block;
}

/* 菜单 */
.menu-list {
  width: 90%;
  margin: 40rpx auto;
}
.menu-item {
  background: #fff;
  border-radius: 20rpx;
  padding: 32rpx 30rpx;
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20rpx;
  font-size: 30rpx;
  color: #333;
  box-shadow: 0 4rpx 12rpx rgba(0, 0, 0, 0.05);
}
.arrow {
  color: #ccc;
  font-size: 32rpx;
}
.logout {
  color: #f56c6c !important;
}

/* 弹窗 */
.mask {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
}
.dialog {
  width: 80%;
  background: #fff;
  border-radius: 24rpx;
  padding: 50rpx 40rpx;
}
.dialog-title {
  font-size: 36rpx;
  text-align: center;
  margin-bottom: 30rpx;
}
.dialog-input {
  border: 1rpx solid #eee;
  border-radius: 16rpx;
  height: 80rpx;
  padding: 0 20rpx;
  font-size: 28rpx;
  margin-bottom: 40rpx;
}
.dialog-btns {
  display: flex;
  justify-content: space-between;
}
.btn-cancel,
.btn-save {
  width: 45%;
  text-align: center;
  padding: 18rpx 0;
  border-radius: 16rpx;
  font-size: 28rpx;
}
.btn-cancel {
  background: #f5f7fa;
}
.btn-save {
  background: #409eff;
  color: #fff;
}
</style>