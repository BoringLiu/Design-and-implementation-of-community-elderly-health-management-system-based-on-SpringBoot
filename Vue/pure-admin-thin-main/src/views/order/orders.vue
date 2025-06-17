<template>
  <!-- <h3>hello</h3> -->
  <div class="health-container">
    <el-table
      :data="tableData"
      height="950"
      style="width: 100%"
      :row-class-name="tableRowClassName"
      border
      size="large"
    >
      <el-table-column prop="oid" label="订单号" width="50">
        <!-- <el-icon><message /></el-icon>Navigator One -->
      </el-table-column>
      <el-table-column prop="gid" label="服务id" width="130"> </el-table-column>
      <el-table-column prop="uid" label="下单用户id" width="130">
      </el-table-column>
      <el-table-column
        prop="status"
        label="订单状态"
        width="90"
        column-key="status"
        :filters="[
          { text: '已完成', value: 1 },
          { text: '进行中', value: 0 }
        ]"
        :filter-method="filterTag"
        filter-placement="bottom-end"
      >
        <template v-slot="{ row }">
          <el-tag :type="row.status === 1 ? 'success' : 'danger'">
            {{ row.status === 1 ? "已完成" : "进行中" }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="ordername" label="订单名称"> </el-table-column>
      <el-table-column
        prop="orderdate"
        label="下单时间"
        width="120"
        column-key="date"
        :filters="[
          { text: '2016-05-01', value: '2016-05-01' },
          { text: '2016-05-02', value: '2016-05-02' },
          { text: '2016-05-03', value: '2016-05-03' },
          { text: '2016-05-04', value: '2016-05-04' }
        ]"
        :filter-method="filterHandler"
      >
      </el-table-column>
      <el-table-column fixed="right" label="Operations" width="120">
        <template #default="{ row }">
          <el-button
            link
            type="primary"
            size="small"
            @click="deleteorder(row.oid)"
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
// const tableData1 = ref([]);
// const count = ref([]);
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
  return row.status === value;
};

const filterHandler = (value, row, column) => {
  const property = column["type"];
  return row[property] === value;
};

const fetchData = async () => {
  try {
    const response = await fetch("http://localhost:8088/order/findAll", {
      method: "GET"
    });
    const data = await response.json();
    tableData.value = data;
    console.log(tableData.value);
  } catch (error) {
    console.error("Error fetching data:", error);
  }
};

const deleteorder = async oid => {
  console.log("oid:", oid);
  const data = oid;
  try {
    const response = await fetch(
      `http://localhost:8088/order/delete?oid=${data}`,
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

// const countData = async () => {
//   try {
//     const currentPath = window.location.pathname; // 获取当前页面的路径部分
//     const response = await fetch(`http://localhost:8088/pageAll`, {
//       method: "GET"
//     });

//     const data = await response.json();
//     count.value = data;
//   } catch (error) {
//     console.error("Error fetching data:", error);
//   }
// };

// const getViewsByTid = tId => {
//   const item = count.value.find(item => item.tId === tId);
//   return item ? item.views : "";
// };

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
