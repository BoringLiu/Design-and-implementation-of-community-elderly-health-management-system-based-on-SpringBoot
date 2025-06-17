export default {
  path: "/service",
  redirect: "/service/all",
  meta: {
    icon: "ri:service-line",
    // showLink: false,
    title: "服务管理",
    rank: 7
  },
  children: [
    {
      path: "/service/book",
      name: "service/book",
      component: () => import("@/views/service/servicebook.vue"),
      meta: {
        title: "服务预约"
      }
    },
    {
      path: "/service/manage",
      name: "service/manage",
      component: () => import("@/views/service/servicemanagment.vue"),
      meta: {
        title: "服务管理"
      }
    },
        {
      path: "/service/doctor",
      name: "service/doctor",
      component: () => import("@/views/service/doctor.vue"),
      meta: {
        title: "医护人员监测"
      }
    }
  ]
} satisfies RouteConfigsTable;
