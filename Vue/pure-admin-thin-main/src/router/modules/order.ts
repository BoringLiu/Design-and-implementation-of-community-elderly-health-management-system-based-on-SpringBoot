export default {
  path: "/order",
  redirect: "/order/all",
  meta: {
    icon: "ri:information-line",
    // showLink: false,
    title: "订单管理",
    rank: 8
  },
  children: [
    {
      path: "/order/all",
      name: "order/all",
      component: () => import("@/views/order/orders.vue"),
      meta: {
        title: "订单总览"
      }
    }
  ]
} satisfies RouteConfigsTable;
