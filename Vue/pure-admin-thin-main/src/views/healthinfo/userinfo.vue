<template>
  <div class="user-container">
    <el-radio-group v-model="size">
      <el-radio value="large">Large</el-radio>
      <el-radio value="default">Default</el-radio>
      <el-radio value="small">Small</el-radio>
    </el-radio-group>
    <el-divider content-position="left" style="background-color: grey"
      >用户信息</el-divider
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
            v-model="searchname"
            style="max-width: 600px"
            placeholder="Please input"
            class="input-with-select"
          >
            <template #append>
              <el-button @click="searchuser" :icon="Search" />
            </template>
          </el-input>
          <div style="width: 2cqmax"></div>
          <el-button type="primary" @click="newuser">新增</el-button>
          <el-button type="primary" @click="changeuser">修改</el-button>
          <el-button type="primary" @click="deleteuser">删除</el-button>
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
        {{ TableData.id }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <user />
            </el-icon>
            用户名
          </div>
        </template>
        {{ TableData.username }}
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
            手机/电话
          </div>
        </template>
        {{ TableData.phone }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <location />
            </el-icon>
            密码
          </div>
        </template>
        {{ TableData.password }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <tickets />
            </el-icon>
            健康状况
          </div>
        </template>
        <el-tag size="small">{{ TableData.condition }}</el-tag>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <office-building />
            </el-icon>
            地址
          </div>
        </template>
        {{ TableData.address }}
      </el-descriptions-item>
    </el-descriptions>
    <div style="background-color: grey">
      <el-divider content-position="left" style="background-color: grey"
        >健康信息</el-divider
      >
    </div>
    <div class="demo-collapse">
      <el-collapse v-model="activeNames" @change="handleChange">
        <el-collapse-item title="健康数据" name="1">
          <div>
            Consistent within interface: all elements should be consistent, such
            as: design style, icons and texts, position of elements, etc.
          </div>
          <div>
            <el-button
              v-motion
              size="small"
              type="primary"
              :initial="{
                opacity: 0,
                y: 100
              }"
              :enter="{
                opacity: 1,
                y: 0,
                transition: {
                  delay: 160
                }
              }"
              @click="router.push('/')"
            >
              查看
            </el-button>
          </div>
        </el-collapse-item>
        <el-collapse-item title="病史查看" name="2">
          <div>
            Operation feedback: enable the users to clearly perceive their
            operations by style updates and interactive effects;
          </div>
          <div>
            Visual feedback: reflect current state by updating or rearranging
            elements of the page.
          </div>
          <div>
            <el-button
              v-motion
              size="small"
              type="primary"
              :initial="{
                opacity: 0,
                y: 100
              }"
              :enter="{
                opacity: 1,
                y: 0,
                transition: {
                  delay: 160
                }
              }"
              @click="router.push('/health/usercheck')"
            >
              查看
            </el-button>
          </div>
        </el-collapse-item>
        <el-collapse-item title="订单相关" name="3">
          <div>
            Simplify the process: keep operating process simple and intuitive;
          </div>
          <div>
            Definite and clear: enunciate your intentions clearly so that the
            users can quickly understand and make decisions;
          </div>
          <div>
            Easy to identify: the interface should be straightforward, which
            helps the users to identify and frees them from memorizing and
            recalling.
          </div>
          <div>
            <el-button
              v-motion
              size="small"
              type="primary"
              :initial="{
                opacity: 0,
                y: 100
              }"
              :enter="{
                opacity: 1,
                y: 0,
                transition: {
                  delay: 160
                }
              }"
              @click="router.push('/health/usercheck')"
            >
              查看
            </el-button>
          </div>
        </el-collapse-item>
        <el-collapse-item title="备注" name="4">
          <div>用户订单尽可能每日早去</div>
          <div>无药物过敏史</div>
        </el-collapse-item>
      </el-collapse>
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
const searchname = ref("luming");

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
const TableData = ref([]);
const searchuser = async () => {
  console.log("searchname:", searchname.value);
  const data = searchname.value;
  try {
    const response = await fetch(
      `http://localhost:8088/user/find?username=${data}`,
      {
        method: "GET"
      }
    );
    const data1 = await response.json();
    console.log("data", data1);
    TableData.value = data1;
    alert("查询成功!");
  } catch (error) {
    console.error("Error fetching data:", error);
    alert("查询失败!");
  }
};
const formData = ref({
  username: "",
  password: "",
  reg_date: "",
  address: "",
  phone: "",
  sex: "",
  condition: ""
});

const changeuser = async () => {
  const res = ref(null);
  try {
    const response = await fetch(`http://localhost:8088/user/change`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(formData.value)
    });
    const data = await response.json();
    res.value = data;
    // 处理响应...
    if (res.value === 1) {
      alert("更改成功!");
    } else {
      alert("更改失败!");
    }
  } catch (error) {
    console.error("Error fetching data:", error);
  }
};

const createuser = async () => {
  const res = ref(null);
  try {
    const response = await fetch(`http://localhost:8088/user/create`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(formData.value)
    });
    const data = await response.json();
    res.value = data;
    // 处理响应...
    if (res.value === 1) {
      alert("创建成功!");
    } else {
      alert("创建失败!");
    }
  } catch (error) {
    console.error("Error fetching data:", error);
  }
};
const deleteuser = async () => {
  console.log("searchname:", searchname.value);
  const data = TableData.id;
  const res = ref(null);
  try {
    const response = await fetch(
      `http://localhost:8088/user/delete?uid=${data}`,
      {
        method: "GET"
      }
    );
    const data1 = await response.json();
    console.log("data", data1);
    res.value = data1;
    if (res.value === 1) {
      alert("上传成功!");
    } else {
      alert("上传失败!");
    }
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
