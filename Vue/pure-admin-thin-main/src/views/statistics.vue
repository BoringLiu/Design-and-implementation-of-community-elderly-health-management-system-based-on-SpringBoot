<script setup lang="ts">
import { use } from "echarts/core";
import { CanvasRenderer } from "echarts/renderers";
import { PieChart } from "echarts/charts";
import { Line } from "vue-chartjs";
import {
  TitleComponent,
  TooltipComponent,
  LegendComponent
} from "echarts/components";
import VChart, { THEME_KEY } from "vue-echarts";
import { ref, provide } from "vue";

use([
  CanvasRenderer,
  PieChart,
  TitleComponent,
  TooltipComponent,
  LegendComponent
]);

provide(THEME_KEY, "dark");

const option = ref({
  title: {
    text: "健康状况一览",
    left: "center"
  },
  tooltip: {
    trigger: "item",
    formatter: "{a} <br/>{b} : {c} ({d}%)"
  },
  legend: {
    orient: "vertical",
    left: "left",
    data: ["很好", "良好", "一般", "不太好", "不好"]
  },
  backgroundColor: "",
  textStyle: {
    fontSize: 16, // 设置整个图表的字体大小为16px
    color: "black"
  },

  series: [
    {
      name: "健康状况一览",
      type: "pie",
      radius: "55%",
      center: ["50%", "60%"],
      data: [
        { value: 53, name: "很好" },
        { value: 236, name: "良好" },
        { value: 134, name: "一般" },
        { value: 23, name: "不太好" },
        { value: 8, name: "不好" }
      ],
      emphasis: {
        itemStyle: {
          shadowBlur: 10,
          shadowOffsetX: 0,
          shadowColor: "rgba(0, 0, 0, 0.5)"
        }
      }
    }
  ]
});
import { Check } from "@element-plus/icons-vue";

const MyLineChart = {
  extends: Line,
  data() {
    return {
      data: {
        labels: [
          "January",
          "February",
          "March",
          "April",
          "May",
          "June",
          "July"
        ],
        datasets: [
          {
            label: "Data One",
            backgroundColor: "#f87979",
            data: [40, 39, 10, 40, 39, 80, 40]
          }
        ]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false
      }
    };
  },
  mounted() {
    this.renderChart(this.data, this.options);
  }
};
</script>

<template>
  <div
    class="sta-container"
    style="display: flex; justify-content: space-between"
  >
    <el-card style="width: 300px">
      <template #header>整体健康状况</template>
      <!-- <h1>健康人数:236</h1>
       -->
      <el-progress type="dashboard" :percentage="279" status="success">
        <template #default="{ percentage }">
          <span class="percentage-value">{{ percentage }}</span>
          <span class="percentage-label">健康人数</span>
        </template>
      </el-progress>
      <el-progress type="dashboard" :percentage="35" status="exception">
        <template #default="{ percentage }">
          <span class="percentage-value">{{ percentage }}</span>
          <span class="percentage-label">生病人数</span>
        </template>
      </el-progress>
      <hr />
      <el-progress type="dashboard" :percentage="13" status="danger">
        <template #default="{ percentage }">
          <span class="percentage-value">{{ percentage }}</span>
          <span class="percentage-label">留守人数</span>
        </template>
      </el-progress>
      <el-progress type="dashboard" :percentage="67" status="warning">
        <template #default="{ percentage }">
          <span class="percentage-value">{{ percentage }}%</span>
          <span class="percentage-label">幸福感</span>
        </template>
      </el-progress>
    </el-card>
    <el-card style="width: 300px">
      <template #header>医师在线人数</template>
      <el-progress
        :text-inside="true"
        :stroke-width="24"
        :percentage="33"
        status="success"
        ><span>空闲中:23</span></el-progress
      >
      <div style="margin: 15px" />
      <hr />
      <div style="margin: 15px">
        <el-progress
          :percentage="30"
          :stroke-width="24"
          :text-inside="true"
          status="warning"
          striped
          striped-flow
          ><span>忙中:37</span></el-progress
        >
      </div>
      <hr />
      <div style="margin: 15px" />
      <el-progress
        :text-inside="true"
        :stroke-width="24"
        :percentage="50"
        status="exception"
      >
        <span>离线:10</span>
      </el-progress>
    </el-card>
    <el-card style="width: 300px">
      <template #header>在线服务数量</template>
      <div class="demo-progress">
        <el-progress :text-inside="true" :stroke-width="26" :percentage="70">
          <span>进行中订单:24</span>
        </el-progress>
        <el-progress
          :text-inside="true"
          :stroke-width="24"
          :percentage="100"
          status="success"
        >
          <span>可预约服务:7</span></el-progress
        >
        <el-progress
          :text-inside="true"
          :stroke-width="22"
          :percentage="80"
          status="warning"
        >
          <span>服务人员可用:8</span></el-progress
        >
        <el-progress
          :text-inside="true"
          :stroke-width="20"
          :percentage="50"
          status="exception"
          ><span>不可预约服务:13</span></el-progress
        >
      </div>
    </el-card>
  </div>
  <el-divider content-position="left">图表展示</el-divider>
  <div>
    <h3 style="margin-left: 20px; back">健康状况一览</h3>
    <v-chart class="chart" :option="option" autoresize />
  </div>
  <el-divider content-position="left">病例趋势</el-divider>
  <line-chart :chart-data="data" :options="options"></line-chart>
</template>

<style lang="scss" scoped>
.sta-container {
  /* 调整缩放比例 */
  position: relative;
  width: 100%;
  max-width: 100%;
  padding: 15px 50px 5px 15px;
  margin: 0 auto;
  overflow: hidden;
  /* height: 5000px; */
}
.chart {
  height: 300px;
}
.percentage-value {
  display: block;
  margin-top: 10px;
  font-size: 28px;
}
.percentage-label {
  display: block;
  margin-top: 10px;
  font-size: 12px;
}
.demo-progress .el-progress--line {
  margin-bottom: 15px;
  max-width: 600px;
}
.demo-progress .el-progress--circle {
  margin-right: 15px;
}
</style>
