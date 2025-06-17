const { VITE_HIDE_HOME } = import.meta.env;
export default {
  path: "/healthinfo",
  redirect: "/healthinfo/userprofile",
  meta: {
    icon: "ri:health-book-line",
    // showLink: false,
    title: "健康信息",
    rank: 6
  },
  children: [
    {
      path: "/healthinfo/userprofile",
      name: "healthinfo/userprofile",
      component: () => import("@/views/healthinfo/userinfo.vue"),
      meta: {
        title: "用户档案管理",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/healthinfo/usercheck",
      name: "healthinfo/usercheck",
      component: () => import("@/views/healthinfo/usercheck.vue"),
      meta: {
        title: "用户健康数据监测",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/healthinfo/userhistory",
      name: "healthinfo/userhistory",
      component: () => import("@/views/healthinfo/userhistory.vue"),
      meta: {
        title: "用户病史记录",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/healthinfo/store",
      name: "healthinfo/store",
      component: () => import("@/views/error/500.vue"),
      meta: {
        title: "库存统计",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      },
      children: [
        {
          path: "/healthinfo/store/medication",
        name: "healthinfo/store/medication",
        component: () => import("@/views/error/403.vue"),
        meta: {
          title: "药物统计",
          showLink: VITE_HIDE_HOME === "true" ? false : true
      }
        },
        {
          path: "/healthinfo/store/others",
        name: "healthinfo/store/others",
        component: () => import("@/views/error/403.vue"),
        meta: {
        title: "其他"
      }
        },
      ]
    }
  ]
} satisfies RouteConfigsTable;
