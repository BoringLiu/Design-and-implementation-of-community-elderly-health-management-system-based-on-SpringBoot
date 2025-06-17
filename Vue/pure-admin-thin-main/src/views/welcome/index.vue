<script setup lang="ts">
import { defineComponent } from "vue";
import image1 from "@/assets/images/image1.jpg";
import image2 from "@/assets/images/image2.jpg";
import image3 from "@/assets/images/image3.png";
import image4 from "@/assets/images/image4.png";
import image5 from "@/assets/images/image5.jpg";
import {
  ArrowRight,
  CaretBottom,
  CaretTop,
  Warning
} from "@element-plus/icons-vue";

const data = {
  images: [image1, image2, image3, image4, image5]
};

const CarouselItem = defineComponent(() => ({
  props: {
    src: String
  }
}));

defineComponent(() => ({
  data,
  components: {
    CarouselItem
  }
}));
</script>

<template>
  <div class="index-container">
    <h1 class="header">欢迎来到XX社区老年人健康管理系统</h1>
    <div class="block text-center" m="t-4">
      <!-- <span class="demonstration">Switch when indicator is clicked</span> -->
      <!-- <el-carousel trigger="click" height="250px">
      <carousel-item v-for="(image, index) in data.images" :key="index" :src="image">
        <img :src="image" alt="carousel-image" style="width: 100%; height: 250px" />
      </carousel-item>
      </el-carousel-item>
    </el-carousel> -->
      <el-carousel trigger="click" height="450px">
        <el-carousel-item v-for="(image, index) in data.images" :key="index">
          <img
            :src="image"
            alt="carousel-image"
            style="width: 100%; height: 450px"
          />
        </el-carousel-item>
      </el-carousel>
    </div>
    <br />
    <el-row :gutter="16">
      <el-col :span="8">
        <div class="statistic-card">
          <el-statistic :value="210">
            <template #title>
              <div style="display: inline-flex; align-items: center">
                每日登录用户
                <el-tooltip
                  effect="dark"
                  content="Number of users who logged into the product in one day"
                  placement="top"
                >
                  <el-icon style="margin-left: 4px" :size="12">
                    <Warning />
                  </el-icon>
                </el-tooltip>
              </div>
            </template>
          </el-statistic>
          <div class="statistic-footer">
            <div class="footer-item">
              <span>相较昨天</span>
              <span class="green">
                24%
                <el-icon>
                  <CaretTop />
                </el-icon>
              </span>
            </div>
          </div>
        </div>
      </el-col>
      <el-col :span="8">
        <div class="statistic-card">
          <el-statistic :value="3700">
            <template #title>
              <div style="display: inline-flex; align-items: center">
                月活用户
                <el-tooltip
                  effect="dark"
                  content="Number of users who logged into the product in one month"
                  placement="top"
                >
                  <el-icon style="margin-left: 4px" :size="12">
                    <Warning />
                  </el-icon>
                </el-tooltip>
              </div>
            </template>
          </el-statistic>
          <div class="statistic-footer">
            <div class="footer-item">
              <span>相较上月</span>
              <span class="red">
                12%
                <el-icon>
                  <CaretBottom />
                </el-icon>
              </span>
            </div>
          </div>
        </div>
      </el-col>
      <el-col :span="8">
        <div class="statistic-card">
          <el-statistic :value="12" title="New transactions today">
            <template #title>
              <div style="display: inline-flex; align-items: center">
                今日新增订单
              </div>
            </template>
          </el-statistic>
          <div class="statistic-footer">
            <div class="footer-item">
              <span>相较昨天</span>
              <span class="green">
                16%
                <el-icon>
                  <CaretTop />
                </el-icon>
              </span>
            </div>
            <div class="footer-item">
              <el-icon :size="14">
                <ArrowRight />
              </el-icon>
            </div>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<style scoped>
.index-container {
  /* 调整缩放比例 */
  position: relative;
  width: 100%;
  max-width: 100%;
  padding: 1px 50px 5px 5px;
  margin: 0 auto;
  overflow: hidden;
  /* height: 5000px; */
}

.demonstration {
  color: var(--el-text-color-secondary);
}

.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
:global(h2#card-usage ~ .example .example-showcase) {
  background-color: var(--el-fill-color) !important;
}

.el-statistic {
  --el-statistic-content-font-size: 28px;
}

.statistic-card {
  height: 100%;
  padding: 20px;
  border-radius: 4px;
  background-color: var(--el-bg-color-overlay);
}

.statistic-footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  font-size: 12px;
  color: var(--el-text-color-regular);
  margin-top: 16px;
}

.statistic-footer .footer-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.statistic-footer .footer-item span:last-child {
  display: inline-flex;
  align-items: center;
  margin-left: 4px;
}

.green {
  color: var(--el-color-success);
}
.red {
  color: var(--el-color-error);
}
</style>
