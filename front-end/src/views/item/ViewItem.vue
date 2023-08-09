<template>
  <main>
    <Navbar />

    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="text-center">Item</h1>
          <hr />
          <a href="/items/add" class="btn btn-primary">Add Item</a>
          <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">Id</th>
                <th scope="col">Nama Item</th>
                <th scope="col">Unit</th>
                <th scope="col">Stok</th>
                <th scope="col">Harga</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="item in items" :key="item.id">
                <th scope="row">{{ item.id }}</th>
                <td>{{ item.namaItem }}</td>
                <td>{{ item.unit }}</td>
                <td>{{ item.stok }}</td>
                <td>{{ item.hargaSatuan }}</td>
                <td>
                  <a class="btn btn-primary" :href="`/items/edit/${item.id}`"
                    >Edit</a
                  >
                  <button
                    class="btn btn-danger mx-2"
                    @click="deleteCustomer(item.id)"
                  >
                    Delete
                  </button>
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
      items: [],
      showEditModal: false,
      editedCustomer: {},
      editCustomerId: null,
    };
  },

  beforeMount() {
    this.getItems(); // Corrected method name from fetchCustomer to getItems
  },

  methods: {
    getItems() {
      fetch("http://localhost:8080/items")
        .then((res) => res.json())
        .then((data) => {
          this.items = data;
          console.log(data);
        });
    },
    deleteCustomer(id) {
      fetch(`http://localhost:8080/items/${id}`, {
        method: "DELETE",
      }).then((data) => {
        console.log(data);
        this.getItems();
      });
    },
  },
};
</script>
