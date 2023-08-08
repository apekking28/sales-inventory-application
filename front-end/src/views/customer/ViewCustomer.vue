<template>
  <main>
    <Navbar />

    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="text-center">Customer</h1>
          <hr>
          <a href="/customers/add" class="btn btn-primary">Add Customer</a>
          <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Contact</th>
                <th scope="col">Alamat</th>
                <th scope="col">KTP</th>
                <!-- Add other columns here (email, alamat, diskon, tipeDiskon, ktp) -->
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="customer in customers" :key="customer.id">
                <th scope="row">{{ customer.id }}</th>
                <td>{{ customer.nama }}</td>
                <td>{{ customer.email }}</td>
                <td>{{ customer.contact }}</td>
                <td>{{ customer.alamat }}</td>
                <td>{{ customer.ktp }}</td>
                <!-- Display other columns here (email, alamat, diskon, tipeDiskon, ktp) -->
                <td>
                  <a class="btn btn-primary" :href="`/customers/edit/${customer.id}`">Edit</a>
                  <button class="btn btn-danger mx-2" @click="deleteCustomer(customer.id)">
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
  name: "ViewCustomers",
  components: {
    Navbar,
  },
  data() {
    return {
      customers: [],
      showEditModal: false,
      editedCustomer: {},
      editCustomerId: null,
    };
  },

  beforeMount() {
    this.getCustomers(); // Corrected method name from fetchCustomer to getCustomers
  },

  methods: {
    getCustomers() {
      fetch("http://localhost:8080/customers")
        .then((res) => res.json())
        .then((data) => {
          this.customers = data;
          console.log(data);
        });
    },
    deleteCustomer(id) {
      fetch(`http://localhost:8080/customers/${id}`, {
        method: "DELETE",
      }).then((data) => {
        console.log(data);
        this.getCustomers();
      });
    },
  },
};
</script>
