import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import ViewCustomer from "../views/customer/ViewCustomer.vue";
import AddCustomer from "../views/customer/AddCustomer.vue";
import UpdateCustomer from "../views/customer/UpdateCustomer.vue";
import ViewItem from "../views/item/ViewItem.vue";
import AddItem from "../views/item/AddItem.vue";
import UpdateItem from "../views/item/UpdateItem.vue";
import ViewSales from "../views/sales/ViewSales.vue";
import DetailSales from "../views/sales/DetailSales.vue";
import AddSales from "../views/sales/AddSales.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "Home",
      component: Home,
    },
    {
      path: "/customers",
      name: "viewCustomers",
      component: ViewCustomer,
    },
    {
      path: "/customers/add",
      name: "addCustomer",
      component: AddCustomer,
    },
    {
      path: "/customers/edit/:id",
      name: "editCustomer",
      component: UpdateCustomer,
    },
    {
      path: "/items",
      name: "viewItems",
      component: ViewItem,
    },
    {
      path: "/items/add",
      name: "addItem",
      component: AddItem,
    },
    {
      path: "/items/edit/:id",
      name: "editItem",
      component: UpdateItem,
    },
    {
      path: "/sales/",
      name: "viewSales",
      component: ViewSales,
    },
    {
      path: "/sales/:id",
      name: "detailSales",
      component: DetailSales,
    },
    {
      path: "/sales/add",
      name: "addSales",
      component: AddSales,
    },
  ],
});

export default router;
