<template>
  <!-- <h3>hello</h3> -->
  <div class="health-container">
    <el-button @click="resetDateFilter">reset date filter</el-button>
    <el-button @click="clearFilter">reset all filters</el-button>
    <!-- <el-button @click="location.reload()">刷新页面</el-button> -->
    <el-button @click="refresh">刷新页面</el-button>
    <el-table
      :data="tableData"
      height="950"
      style="width: 100%"
      :row-class-name="tableRowClassName"
      border
      size="large"
    >
      <el-table-column prop="ssid" label="病例id" width="50"> </el-table-column>
      <el-table-column prop="uid" label="用户id" width="50"> </el-table-column>
      <el-table-column prop="sid" label="疾病号" width="100">
        <!-- <el-icon><message /></el-icon>Navigator One -->
      </el-table-column>
      <el-table-column prop="sname" label="病例名称" width="200">
      </el-table-column>
      <!-- <el-table-column prop="f_date" label="首次发作日期" width="100"> -->
      <!-- </el-table-column> -->
      <!-- <el-table-column prop="l_date" label="最后发作日期" width="300"> -->
      <!-- </el-table-column> -->
      <el-table-column prop="level" label="日期"> </el-table-column>
      <!-- <el-table-column prop="h_count" label="总发作次数"> </el-table-column> -->
      <el-table-column fixed="right" label="Operations" width="120">
        <template #default="{ row }">
          <el-button
            link
            type="primary"
            size="small"
            @click="deletetips(row.ssid)"
            >Delete</el-button
          >

          <el-button link type="primary" size="small">Edit</el-button>
        </template>
      </el-table-column>
    </el-table>
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
  return row.type === value;
};

const filterHandler = (value, row, column) => {
  const property = column["type"];
  return row[property] === value;
};
const refresh = () => {
  window.location.reload();
};

const fetchData = async () => {
  try {
    const response = await fetch("http://localhost:8088/user/historyAll", {
      method: "GET"
    });
    const data = await response.json();
    tableData.value = data;
    console.log(tableData.value);
  } catch (error) {
    console.error("Error fetching data:", error);
  }
};

const deletetips = async ssid => {
  console.log("Tid:", ssid);
  const data = ssid;
  try {
    const response = await fetch(
      `http://localhost:8088/user/deletehistory?ssid=${data}`,
      {
        method: "POST"
      }
    );
    alert("删除成功！");
    consle.log("Deleteion successful");
    window.location.reload();
  } catch (error) {
    console.error("Error fetching data:", error);
  }
};
onMounted(fetchData);
</script>
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
