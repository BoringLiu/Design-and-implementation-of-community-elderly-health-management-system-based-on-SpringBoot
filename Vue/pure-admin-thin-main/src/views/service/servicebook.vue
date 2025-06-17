<template>
  <!-- <h3>hello</h3> -->
  <div class="health-container">
    <!-- <el-button @click="resetDateFilter">reset date filter</el-button>
    <el-button @click="clearFilter">reset all filters</el-button> -->
    <el-input
      v-model="uid"
      placeholder="请输入UID"
      style="width: 200px"
    ></el-input>
    <el-table
      :data="tableData"
      height="950"
      style="width: 100%"
      :row-class-name="tableRowClassName"
      border
      size="large"
    >
      <el-table-column prop="gid" label="服务id" width="70">
        <!-- <el-icon><message /></el-icon>Navigator One -->
      </el-table-column>
      <el-table-column
        prop="name"
        label="服务名称"
        width="200"
      ></el-table-column>
      <el-table-column
        prop="cond"
        label="支持状态"
        width="100"
        column-key="cond"
        :filters="[
          { text: '支持预约', value: 1 },
          { text: '暂停预约', value: 0 }
        ]"
        :filter-method="filterTag"
        filter-placement="bottom-end"
      >
        <template v-slot="{ row }">
          <el-tag :type="row.cond === 1 ? 'success' : 'danger'">
            {{ row.cond === 1 ? "支持" : "暂停" }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="intro" label="服务简介"> </el-table-column>
      <el-table-column prop="price" label="服务价格" width="100">
      </el-table-column>
      <el-table-column fixed="right" label="Operations" width="120">
        <template #default="{ row }">
          <el-button
            link
            type="primary"
            size="small"
            @click="bookservice(row.gid)"
            >预约服务</el-button
          >
          <el-button link type="primary" size="small">Edit</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- <el-dialog
      title="输入 UID"
      v-model:visible="dialogVisible"
      width="30%"
      :close-on-click-modal="false"
    >
      <el-form :model="form" ref="form" label-width="80px">
        <el-form-item label="UID">
          <el-input v-model="form.uid" placeholder="请输入UID"></el-input>
        </el-form-item>
      </el-form>
      <!-- 使用 v-slot 指令定义插槽 -->
    <!-- <template v-slot:footer class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="bookService">确定</el-button>
      </template> -->
    <!-- </el-dialog> -->
    -->
  </div>
  <!-- <div class="example-pagination-block">
    <div class="example-demonstration">When you have few pages</div>
    <el-pagination layout="prev, pager, next" :total="50" />
  </div> -->
  <div class="example-pagination-block">
    <el-pagination layout="prev, pager, next" :total="1000" />
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { ref, onMounted } from "vue";
const router = useRouter();

defineOptions({
  name: "tips管理edit"
});

// import type { TableColumnCtx, TableInstance } from 'element-plus'

import { InfoFilled } from "@element-plus/icons-vue";

const confirmEvent = () => {
  console.log("confirm!");
};
const cancelEvent = () => {
  console.log("cancel!");
};

const tableData = ref([]);
const tableData1 = ref([]);
const count = ref([]);
const tableRef = ref(null);

const resetDateFilter = () => {
  tableRef.value.clearFilter(["date"]);
};

// TODO: improvement typing when refactor table
const clearFilter = () => {
  // eslint-disable-next-line @typescript-eslint/ban-ts-comment
  // @ts-expect-error
  tableRef.value.clearFilter();
};

const formatter = (row, column) => {
  return row.address;
};

const filterTag = (value, row) => {
  return row.cond === value;
};

const fetchData = async () => {
  try {
    const response = await fetch("http://localhost:8088/service/all", {
      method: "GET"
    });
    const data = await response.json();
    tableData.value = data;
  } catch (error) {
    console.error("Error fetching data:", error);
  }
};

const uid = ref(1); // 用户输入的 UID

const bookservice = async tid => {
  console.log("Tid:", tid);
  console.log("uid", uid.value);
  const data = tid;
  try {
    const response = await fetch(
      `http://localhost:8088/service/book?gid=${data}&uid=${uid.value}`,
      {
        method: "GET"
      }
    );
    alert("预约成功！");
    consle.log("book successful");
    // window.location.reload();
  } catch (error) {
    console.error("Error fetching data:", error);
  }
};

const getViewsByTid = tId => {
  const item = count.value.find(item => item.tId === tId);
  return item ? item.views : "";
};

const showDialog = gid => {
  // 打开弹窗
  console.log("dialog");
  dialogVisible.value = true;
  console.log(dialogVisible.value);
};
const handleDialogVisibleChange = val => {
  dialogVisible.value = val;
};

onMounted(fetchData);
// onMounted(countData);
</script>
<!-- `http://localhost:8088/pageurl?url=${encodeURIComponent(currentPath)}` -->
<style>
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

.example-pagination-block + .example-pagination-block {
  margin-top: 10px;
}
.example-pagination-block .example-demonstration {
  margin-bottom: 16px;
  position: relative;
}
</style>

<!-- // Custom formatter to truncate cell content to 30 characters -->
<!-- const contentFormatter = (row, column) => {
  let content = row[column.property]; // Get cell content
  if (content && content.length > 30) {
    return content.slice(0, 30) + '...'; // Truncate to 30 characters
  }
  return content;
}; -->
