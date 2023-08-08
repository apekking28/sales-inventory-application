<template>
  <main>
    <Navbar />
    <div class="my-5">
      <div class="mx-auto w-25" style="max-width: 100%">
        <h2 class="text-center mb-3">Add Item</h2>
        <hr />
        <form @submit.prevent="addItems">
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
                v-model="items.namaItem"
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
                v-model="items.unit"
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
                v-model="items.stok"
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
                v-model="items.hargaSatuan"
              />
            </div>
          </div>

          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="barang" class="form-label">Barang</label>
              <input
                id="barang"
                type="file"
                name="barang"
                class="form-control"
                @change="onFileChange"
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
  name: "AddItem",
  components: {
    Navbar,
  },

  data() {
    return {
      items: {
        namaItem: "",
        unit: "",
        stok: "",
        hargaSatuan: "",
        barang: "",
      },
    };
  },

  methods: {
    addItems() {
      fetch("http://localhost:8080/items", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.items),
      }).then((data) => {
        console.log(data);
        this.$router.push("/items");
      });
    },
    // onFileChange(event) {
    //   const file = event.target.files[0];
    //   if (file) {
    //     this.items.barang = file;
    //   } else {
    //     this.items.barang = null;
    //     console.log("salah ya..");
    //   }
    // },
  },
};
</script>
