<template>
  <main>
    <Navbar />

    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="back-link">
            <router-link to="/sales" class="btn btn-primary"
              >Kembali ke Daftar Penjualan</router-link
            >
          </div>
          <h1 class="text-center">Sales Detail</h1>
          <hr />
          <div class="card">
            <div class="card-header">
              <h4 class="mb-0">Code Transaksi: {{ sale.codeTransaksi }}</h4>
            </div>
            <div class="card-body">
              <h5 class="card-title">Customer: {{ customer.nama }}</h5>
              <div class="details">
                <p class="detail">Qty: {{ sale.qty }}</p>
                <p class="detail">
                  Tanggal Transaksi: {{ sale.tanggalTransaksi }}
                </p>
                <p class="detail">Total Diskon: {{ sale.totalDiskon }}</p>
                <p class="detail">Total Harga: {{ sale.totalHarga }}</p>
                <p class="detail">Total Bayar: {{ sale.totalBayar }}</p>
              </div>
              <h5 class="card-title mt-4">Items:</h5>
              <ul class="item-list">
                <li v-for="item in sale.items" :key="item.id">
                  {{ item.namaItem }}
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import Navbar from "../../components/NavBar.vue";

export default {
  name: "SaleDetail",
  components: {
    Navbar,
  },
  data() {
    return {
      sale: {},
      customer: {},
    };
  },
  mounted() {
    const saleId = this.$route.params.id;
    this.fetchSaleDetail(saleId);
  },
  methods: {
    async fetchSaleDetail(saleId) {
      try {
        const response = await fetch(`http://localhost:8080/sales/${saleId}`);
        const data = await response.json();
        this.customer = data.customer;
        this.sale = data;
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>

<style scoped>
.card {
  margin-top: 20px;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.card-header {
  background-color: #f0f0f0;
  font-weight: bold;
  padding: 10px 20px;
  border-bottom: 1px solid #e0e0e0;
  border-top-left-radius: 8px;
  border-top-right-radius: 8px;
}

.card-title {
  font-size: 1.25rem;
  margin-top: 10px;
}

.details {
  margin-bottom: 10px;
}

.detail {
  margin-bottom: 5px;
}

.item-list {
  padding-left: 20px;
  list-style: none;
}

.item-list li {
  margin-bottom: 5px;
}
</style>
