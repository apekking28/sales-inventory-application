<template>
  <main>
    <Navbar />
    <div class="my-5">
      <div class="mx-auto w-25" style="max-width: 100%">
        <h2 class="text-center mb-3">Edit Customer</h2>
        <hr />
        <form @submit.prevent="updateCustomer(customer.id)">
          <!--name-->
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="name" class="form-label">Name</label>
              <input
                id="name"
                type="text"
                name="name"
                class="form-control"
                placeholder="Name"
                required
                v-model="customer.nama"
              />
            </div>
          </div>

          <!--Email-->
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="email" class="form-label">Email</label>
              <input
                id="email"
                type="email"
                name="email"
                class="form-control"
                placeholder="email"
                required
                v-model="customer.email"
              />
            </div>
          </div>

          <!--Phone Number-->
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="pNo" class="form-label">Phone Number</label>
              <input
                id="pNo"
                type="text"
                name="pNo"
                class="form-control"
                placeholder="Phone Number"
                required
                v-model="customer.contact"
              />
            </div>
          </div>

          <!--Alamat-->
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="alamat" class="form-label">Alamat</label>
              <input
                id="alamat"
                type="alamat"
                name="alamat"
                class="form-control"
                placeholder="Alamat"
                required
                v-model="customer.alamat"
              />
            </div>
          </div>

          <div class="row">
            <div class="col-md-12 form-group">
              <input
                class="btn btn-primary w-100"
                type="submit"
                value="Submit"
              />
            </div>
          </div>

          <div></div>
        </form>
        <div class="row">
          <div class="col-md-12 form-group">
            <a
              class="btn btn-danger w-100"
              href="/customers"
              style="
                padding: 2px;
                text-align: center;
                display: block;
                text-decoration: none;
                color: white;
              "
            >
              Cancel
            </a>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import Navbar from "../../components/NavBar.vue";

export default {
  name: "UpdateCustomers",
  components: {
    Navbar,
  },

  data() {
    return {
      customer: {
        id: "",
        nama: "",
        email: "",
        contact: "",
        alamat: "",
        tipeDiskon: "",
      },
    };
  },

  beforeMount() {
    this.getCustomer();
  },

  methods: {
    getCustomer() {
      fetch(`http://localhost:8080/customers/${this.$route.params.id}`)
        .then((res) => res.json())
        .then((data) => {
          this.customer = data;
          console.log(this.customer);
        });
    },
    updateCustomer(id) {
      fetch(`http://localhost:8080/customers/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.customer),
      }).then((data) => {
        console.log(data);
        this.$router.push("/customers");
      });
    },
  },
};
</script>
