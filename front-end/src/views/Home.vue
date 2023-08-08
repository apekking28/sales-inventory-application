<template>
  <main>
    <Navbar />

    <div class="container">
      <div class="row">
        <h2 class="text-center mb-3">
          Welcome to Aplikasi Inventory Penjualan
        </h2>
        <hr />
        <div>
          <a href="/customers"><h2 class="text-center mb-3">Customer</h2></a>
          <a href="/items"><h2 class="text-center mb-3">Item</h2></a>
          <a href="/sales"><h2 class="text-center mb-3">Sales</h2></a>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import Navbar from "../components/NavBar.vue";

export default {
  name: "Home",
  components: {
    Navbar,
  },
};
</script>
