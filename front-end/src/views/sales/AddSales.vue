<template>
  <main>
    <Navbar />

    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="text-center">Tambah Penjualan</h1>
          <hr />
          <form @submit.prevent="submitSale">
            <div class="form-group">
              <label for="customer">Customer:</label>
              <select
                v-model="selectedCustomer"
                class="form-control"
                id="customer"
              >
                <option
                  v-for="customer in customers"
                  :key="customer.id"
                  :value="customer.id"
                >
                  {{ customer.nama }}
                </option>
              </select>
            </div>
            <div class="form-group">
              <label for="item">Item:</label>
              <select v-model="selectedItem" class="form-control" id="item">
                <option v-for="item in items" :key="item.id" :value="item.id">
                  {{ item.namaItem }}
                </option>
              </select>
            </div>
            <div class="form-group">
              <label for="qty">Quantity:</label>
              <input
                v-model="qty"
                type="number"
                class="form-control"
                id="qty"
                min="1"
              />
            </div>
            <button type="submit" class="btn btn-primary">
              Tambah Penjualan
            </button>
            <a href="/sales" class="btn btn-danger">Cancel</a>
          </form>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import Navbar from "../../components/NavBar.vue";

export default {
  name: "AddSale",
  components: {
    Navbar,
  },
  data() {
    return {
      customers: [],
      items: [],
      selectedCustomer: null,
      selectedItem: null,
      qty: 1,
    };
  },
  methods: {
    async submitSale() {
      try {
        const customerResponse = await fetch(
          `http://localhost:8080/customers/${this.selectedCustomer}`
        );
        const itemResponse = await fetch(
          `http://localhost:8080/items/${this.selectedItem}`
        );

        if (!customerResponse.ok) {
          console.error("Gagal mendapatkan data customer");
          return;
        }

        if (!itemResponse.ok) {
          console.error("Gagal mendapatkan data item");
          return;
        }

        const customerData = await customerResponse.json();
        const itemData = await itemResponse.json();

        // Update quantity of the item
        const updatedItem = { ...itemData, qty: this.qty };
        await fetch(`http://localhost:8080/items/${this.selectedItem}`, {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(updatedItem),
        });

        const saleData = {
          customer: {
            id: customerData.id,
          },
          items: [
            {
              id: itemData.id,
            },
          ],
          qty: this.qty,
        };

        const response = await fetch("http://localhost:8080/sales", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(saleData),
        });

        if (response.ok) {
          console.log("Penjualan berhasil ditambahkan");
          this.$router.push("/sales");
        } else {
          console.error("Gagal menambahkan penjualan");
        }
      } catch (error) {
        console.error(error);
      }
    },

    async fetchCustomersAndItems() {
      try {
        const customersResponse = await fetch(
          "http://localhost:8080/customers"
        );
        const itemsResponse = await fetch("http://localhost:8080/items");

        this.customers = await customersResponse.json();
        this.items = await itemsResponse.json();
      } catch (error) {
        console.error(error);
      }
    },
  },
  created() {
    this.fetchCustomersAndItems();
  },
};
</script>

<style scoped>
/* Gaya sesuaikan dengan kebutuhan desain Anda */
</style>
