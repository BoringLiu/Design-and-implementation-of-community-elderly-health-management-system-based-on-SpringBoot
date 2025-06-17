<template>
  <div class="health-container">
    <h1>新增服务项目</h1>
    <div class="mt-4">
      <h3>服务名称</h3>
      <el-input
        v-model="formData.name"
        style="max-width: 600px"
        placeholder="Please input"
      >
        <template #prepend>名称</template>
      </el-input>
    </div>
    <div class="mt-4">
      <!-- <el-input
        v-model="formData.type"
        style="max-width: 600px"
        placeholder="Please input"
      >
        <template #prepend>类型</template>
      </el-input> -->
      <!-- <div>
        <h3>服务价格</h3>
        <el-radio-group v-model="radio1" size="large">
          <el-radio-button label="饮食" value="Nmeal" />
          <el-radio-button label="运动" value="sports" />
          <el-radio-button label="习惯" value="habit" />
          <el-radio-button label="科普" value="scientific" />
        </el-radio-group>
      </div> -->
    </div>
    <div class="mt-4">
      <h3>服务价格</h3>
      <el-input
        v-model="formData.price"
        style="max-width: 600px"
        placeholder="Please input"
      >
        <template #prepend>Price</template>
      </el-input>
    </div>
    <div style="margin: 20px 0" />
    <h3>服务介绍</h3>
    <el-input
      v-model="formData.intro"
      style="width: 750px"
      maxlength="50"
      placeholder="Please input"
      show-word-limit
      type="text"
    />
    <div style="margin: 20px 0" />
  </div>
  <div class="mb-4">
    <el-popconfirm
      confirm-button-text="Yes"
      cancel-button-text="No"
      :icon="InfoFilled"
      icon-color="#626AEF"
      title="确定上传？"
      @confirm="addservice"
      @cancel="cancelEvent"
    >
      <template #reference>
        <el-button type="primary">上传</el-button>
      </template>
    </el-popconfirm>
    <el-popconfirm
      confirm-button-text="Yes"
      cancel-button-text="No"
      :icon="InfoFilled"
      icon-color="#626AEF"
      title="确定重置?"
      @confirm="reback"
      @cancel="cancelEvent"
    >
      <template #reference>
        <el-button type="danger">重置</el-button>
      </template>
    </el-popconfirm>
  </div>
</template>

<script setup lang="ts">
import { useRouter } from "vue-router";
import { InfoFilled } from "@element-plus/icons-vue";
const router = useRouter();
defineOptions({
  name: "tips管理add"
});

const radio1 = ref("New York");
const confirmEvent = () => {
  console.log("confirm!");
};
const cancelEvent = () => {
  console.log("cancel!");
};

import {
  Check,
  Delete,
  Edit,
  Message,
  Search,
  Star
} from "@element-plus/icons-vue";

import { ref } from "vue";
const formData = ref({
  gid: "",
  name: "123",
  price: "123",
  intro: "123",
  cond: 0
});

const addservice = async () => {
  // const tableData = ref([]);
  const res = ref(null);
  // formData.type = radio1;
  console.log(formData.value);
  try {
    const response = await fetch(`http://localhost:8088/service/newservice`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(formData.value)
    });
    const data = await response.json();
    res.value = data;
    // 处理响应...
    if (res.value === 1) {
      alert("上传成功!");
    } else {
      alert("上传失败!");
    }
  } catch (error) {
    console.error("Error fetching data:", error);
  }
};

const reback = () => {
  // 重置表单数据
  formData.value = {
    type: "",
    title: "",
    author: "",
    intro: "",
    content: ""
  };
  alert("重置成功!");
};
</script>

<style>
.input-with-select .el-input-group__prepend {
  background-color: var(--el-fill-color-blank);
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
}
</style>
