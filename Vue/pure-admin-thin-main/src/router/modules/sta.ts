const { VITE_HIDE_HOME } = import.meta.env;
const Layout = () => import("@/layout/index.vue");

export default {
  path: "/sta",
  name: "sta",
  component: Layout,
  redirect: "/sta",
  meta: {
    icon: "ri:database-line",
    title: "数据统计",
    rank: 1
  },
  children: [
    {
      path: "/sta",
      name: "sta",
      component: () => import("@/views/statistics.vue"),
      meta: {
        title: "数据统计",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    }
  ]
} satisfies RouteConfigsTable;