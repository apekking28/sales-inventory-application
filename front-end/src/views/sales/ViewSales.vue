<template>
  <main>
    <Navbar />

    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="text-center">Sales</h1>
          <hr />
          <a href="/sales/add" class="btn btn-primary">Add Sales</a>
          <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">Id</th>
                <th scope="col">Code Transaksi</th>
                <th scope="col">Tanggal Transaksi</th>
                <th scope="col">Customer</th>
                <th scope="col">Qty</th>
                <th scope="col">Total Diskon</th>
                <th scope="col">Total Harga</th>
                <th scope="col">Total Bayar</th>
                <th scope="col">Item</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="sale in sales" :key="sale.id">
                <th scope="row">{{ sale.id }}</th>
                <td>{{ sale.codeTransaksi }}</td>
                <td>{{ formatDate(sale.tanggalTransaksi) }}</td>
                <td>{{ sale.customer.nama }}</td>
                <td>{{ sale.qty }}</td>
                <td>{{ sale.totalDiskon }}</td>
                <td>{{ sale.totalHarga }}</td>
                <td>{{ sale.totalBayar }}</td>
                <td>
                  <ul style="padding-left: 0; list-style: none">
                    <li
                      v-for="item in sale.items"
                      :key="item.id"
                      style="margin-bottom: 5px"
                    >
                      {{ item.namaItem }}
                    </li>
                    <li v-if="sale.items.length === 0">No items</li>
                  </ul>
                </td>
                <td>
                  <a :href="`/sales/${sale.id}`" class="btn btn-primary"
                    >Detail</a
                  >
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import Navbar from "../../components/NavBar.vue";

export default {
  name: "ViewItem",
  components: {
    Navbar,
  },
  data() {
    return {
      sales: [],
    };
  },
  mounted() {
    this.fetchSales();
  },
  methods: {
    async fetchSales() {
      try {
        const response = await fetch("http://localhost:8080/sales");
        const data = await response.json();
        this.sales = data;
      } catch (error) {
        console.error(error);
      }
    },
    formatDate(dateString) {
      const options = {
        year: "numeric",
        month: "2-digit",
        day: "2-digit",
        hour: "2-digit",
        minute: "2-digit",
        second: "2-digit",
      };
      return new Date(dateString).toLocaleDateString("en-US", options);
    },
  },
};
</script>
