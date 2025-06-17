export default {
  path: "/health",
  redirect: "/health/healthmanage",
  meta: {
    icon: "ri:folder-info-line",
    // showLink: false,
    title: "健康知识管理",
    rank: 9
  },
  children: [
    {
      path: "/health/healthmanage",
      name: "health/manage",
      component: () => import("@/views/healthtips/health.vue"),
      meta: {
        title: "Tips编辑"
      }
    },
    {
      path: "/health/healthadd",
      name: "tips/add",
      component: () => import("@/views/healthtips/healthadd.vue"),
      meta: {
        title: "Tips增加"
      }
    }
  ]
} satisfies RouteConfigsTable;
