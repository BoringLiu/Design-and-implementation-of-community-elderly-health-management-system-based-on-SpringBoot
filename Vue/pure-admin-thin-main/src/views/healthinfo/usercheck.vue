<template>
  <div class="user-container">
    <el-radio-group v-model="size">
      <el-radio value="large">Large</el-radio>
      <el-radio value="default">Default</el-radio>
      <el-radio value="small">Small</el-radio>
    </el-radio-group>
    <el-divider content-position="left" style="background-color: grey"
      >用户健康信息</el-divider
    >
    <el-descriptions
      class="margin-top"
      title=""
      :column="3"
      :size="size"
      border
    >
      <template #extra>
        <div style="display: flex; align-items: center">
          <el-input
            v-model="searchid"
            style="max-width: 600px"
            placeholder="Please input"
            class="input-with-select"
          >
            <template #append>
              <el-button @click="search" :icon="Search" />
            </template>
          </el-input>
          <div style="width: 2cqmax"></div>
          <el-button type="primary" @click="changecheck">修改</el-button>
        </div>
      </template>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <user />
            </el-icon>
            用户id
          </div>
        </template>
        {{ TableData.uId }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <user />
            </el-icon>
            姓名
          </div>
        </template>
        {{ TableData.name }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <iphone />
            </el-icon>
            性别
          </div>
        </template>
        {{ TableData.sex }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <iphone />
            </el-icon>
            年龄
          </div>
        </template>
        {{ TableData.old }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <iphone />
            </el-icon>
            生日
          </div>
        </template>
        {{ TableData.birthday }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <location />
            </el-icon>
            使用药物
          </div>
        </template>
        <!-- {{ TableData.using_medications }}
         -->
        孟鲁司特钠，布地奈德混悬液
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <tickets />
            </el-icon>
            生活状况
          </div>
        </template>
        <!-- {{ TableData.living_condition }} -->
        熬夜，酗酒
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <office-building />
            </el-icon>
            过敏源
          </div>
        </template>
        粉尘螨
      </el-descriptions-item>
    </el-descriptions>
    <div style="background-color: grey">
      <el-divider content-position="left" style="background-color: grey"
        >检查信息</el-divider
      >
    </div>
    <div class="user-container">
      <el-descriptions
        class="margin-top"
        title=""
        :column="3"
        :size="size"
        border
      >
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon :style="iconStyle">
                <user />
              </el-icon>
              检查id
            </div>
          </template>
          {{ TableData1.id }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon :style="iconStyle">
                <user />
              </el-icon>
              检查日期
            </div>
          </template>
          {{ TableData1.checkdate }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon :style="iconStyle">
                <iphone />
              </el-icon>
              次数
            </div>
          </template>
          {{ TableData1.steps }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon :style="iconStyle">
                <iphone />
              </el-icon>
              最高血压
            </div>
          </template>
          {{ TableData1.xyh }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon :style="iconStyle">
                <location />
              </el-icon>
              最低血压
            </div>
          </template>
          {{ TableData1.xyl }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon :style="iconStyle">
                <tickets />
              </el-icon>
              眼睛状况
            </div>
          </template>
          <el-tag size="small">{{ TableData1.eyes }}</el-tag>
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon :style="iconStyle">
                <office-building />
              </el-icon>
              平均心率
            </div>
          </template>
          {{ TableData1.avgheart }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon :style="iconStyle">
                <office-building />
              </el-icon>
              医生建议
            </div>
          </template>
          {{ TableData1.advice }}
        </el-descriptions-item>
      </el-descriptions>
    </div>
  </div>
</template>

<script setup lang="ts">
import { Search } from "@element-plus/icons-vue";
import { useRouter } from "vue-router";
import { StarFilled } from "@element-plus/icons-vue";
import { computed, ref } from "vue";
import {
  Iphone,
  Location,
  OfficeBuilding,
  Tickets,
  User
} from "@element-plus/icons-vue";

const router = useRouter();
const searchid = ref("1");

const goToUserCheck = () => {
  router.push("/health/usercheck");
};

const size = ref("default");
const iconStyle = computed(() => {
  const marginMap = {
    large: "8px",
    default: "6px",
    small: "4px"
  };
  return {
    marginRight: marginMap[size.value] || marginMap.default
  };
});
const blockMargin = computed(() => {
  const marginMap = {
    large: "32px",
    default: "28px",
    small: "24px"
  };
  return {
    marginTop: marginMap[size.value] || marginMap.default
  };
});

const activeNames = ref(["1"]);
const handleChange = (val: string[]) => {
  console.log(val);
};
// import { ref } from 'vue';

// 定义 TableData 为一个 ref 对象
const TableData = ref([]);
const TableData1 = ref([]);
const search = async () => {
  console.log("searchid:", searchid.value);
  const data = searchid.value;
  try {
    const response = await fetch(
      `http://localhost:8088/user/healthinfo?uid=${data}`,
      {
        method: "GET"
      }
    );
    const data1 = await response.json();
    const response1 = await fetch(
      `http://localhost:8088/user/healthcheck?uid=${data}`,
      {
        method: "GET"
      }
    );
    // alert("search成功！");

    const data2 = await response1.json();
    TableData.value = data1;
    TableData1.value = data2;
    // consle.log("Deleteion successful");
    // window.location.reload();
    alert("查询成功!");
  } catch (error) {
    console.error("Error fetching data:", error);
  }
};
</script>

<style scoped>
.el-descriptions {
  margin-top: 20px;
}
.cell-item {
  display: flex;
  align-items: center;
}
.margin-top {
  margin-top: 20px;
}
.health-container {
  /* 调整缩放比例 */
  position: relative;
  width: 100%;
  max-width: 100%;
  padding: 5px 50px 5px 5px;
  margin: 0 auto;
  overflow: hidden;
  /* height: 5000px; */
  background-color: white;
}
</style>
