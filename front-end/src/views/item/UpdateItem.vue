<template>
  <main>
    <Navbar />
    <div class="my-5">
      <div class="mx-auto w-25" style="max-width: 100%">
        <h2 class="text-center mb-3">Edit Item</h2>
        <hr />
        <form @submit.prevent="updateItem(item.id)">
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="namaItem" class="form-label">Nama Item</label>
              <input
                id="namaItem"
                type="text"
                name="namaItem"
                class="form-control"
                placeholder="Nama Item"
                required
                v-model="item.namaItem"
              />
            </div>
          </div>

          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="unit" class="form-label">Unit</label>
              <select
                id="unit"
                name="unit"
                class="form-control"
                required
                v-model="item.unit"
              >
                <option value="" disabled selected>Select Unit</option>
                <option value="kg">kg</option>
                <option value="pcs">pcs</option>
              </select>
            </div>
          </div>

          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="stok" class="form-label">Stock</label>
              <input
                id="stok"
                type="text"
                name="stok"
                class="form-control"
                placeholder="Stock"
                required
                v-model="item.stok"
              />
            </div>
          </div>

          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="hargaSatuan" class="form-label">Harga Satuan</label>
              <input
                id="hargaSatuan"
                type="test"
                name="hargaSatuan"
                class="form-control"
                placeholder="Harga Satuan"
                required
                v-model="item.hargaSatuan"
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
              href="/items"
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
  name: "UpdateItem",
  components: {
    Navbar,
  },

  data() {
    return {
      item: {
        id: "",
        namaItem: "",
        unit: "",
        stok: "",
        hargaSatuan: "",
      },
    };
  },

  beforeMount() {
    this.getItem();
  },

  methods: {
    getItem() {
      fetch(`http://localhost:8080/items/${this.$route.params.id}`)
        .then((res) => res.json())
        .then((data) => {
          this.item = data;
          console.log(this.item);
        });
    },
    updateItem(id) {
      fetch(`http://localhost:8080/items/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.item),
      }).then((data) => {
        console.log(data);
        this.$router.push("/items");
      });
    },
  },
};
</script>
