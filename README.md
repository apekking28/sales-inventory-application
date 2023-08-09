# Sales Inventory Application

## Project Description
Sales Inventory Application (Administrator) is a simple application to manage inventory and sales transactions. This application is built using Vue.js for the frontend and Spring Boot for the backend. The application has three main modules: Item, Customer, and Sales. The purpose of this application is to help administrators in managing stock items, customer information, and recording sales transactions easily.


## Item Module

The Item module enables administrators to manage available stock items.

- **Item Name**: The name of the item to be sold.
- **Unit**: The unit of the item (kg/pcs) selected via a selectbox.
- **Stock**: The quantity of the item's stock available.
- **Unit Price**: The price per unit of the item.

**Customer Module:**

The Customer module allows administrators to manage customer information.

- **Name**: The full name of the customer.
- **Contact**: The customer's contact number.
- **Email**: The customer's email address.
- **Address**: The complete address of the customer.
- **Discount**: The discount percentage offered to the customer (if applicable).
- **Discount Type**: The type of customer discount, either percentage or fixed discount.
- Two types of discounts are available: percentage and fixed discounts.

**Sales Module:**

The Sales module enables administrators to record sales transactions.

- **Transaction Code**: A unique code for each sales transaction.
- **Transaction Date**: The date of the transaction.
- **Customer**: The customer making the purchase.
- **Items**: The items being purchased (multiple items are allowed).
- **Quantity**: The quantity of the item being purchased.
- **Total Discount**: The total discount applied to the transaction (automatically filled based on customer discount).
- **Total Price**: The total price of all purchased items (automatically calculated).
- **Total Payment**: The total price after discount (automatically calculated).

## Total Price Calculation

The total price is calculated based on the quantity of items purchased and the unit price of each item. If a discount is applicable to the customer, the total price will be reduced according to the discount.

##Quantity and Stock

The system checks whether the requested quantity (qty) by the customer exceeds the available stock. If it exceeds, the transaction will not be accepted. The stock of items will be reduced after each purchase transaction.

## Application Objective

The application aims to simplify and facilitate the process of managing stock items, customer information, and recording sales transactions. With this application, administrators can easily track stock items, provide discounts to customers, and record sales transactions in an organized and efficient manner.

## Technology Stack

- Frontend: Vue.js, Javascript, Npm
- Backend: Spring Boot, Java, Maven
- Database: PostgreSQL

## API

**Item Module:**
- GET `http://localhost:8080/items` -> List items
- GET `http://localhost:8080/items/{id}` -> detail item
- POST `http://localhost:8080/items` -> Add new item
  - Request body :
 
    ```json
    {
      "namaItem":"Nama_item",
      "unit":"Unit",
      "stok":"Stock",
      "hargaSatuan":"Harga_satuan"
    }
    ```
    
- PUT `http://localhost:8080/items/{id}` -> Update item
  - Request body :
 
    ```json
    {
      "namaItem":"Nama_item",
      "unit":"Unit",
      "stok":"Stock",
      "hargaSatuan":"Harga_satuan"
    }
    ```
    
- DELETE `http://localhost:8080/items/{id}` -> Delete item

**Customer Module:**
- GET `http://localhost:8080/customers` -> List customers
- GET `http://localhost:8080/customers/{id}` -> Detail customer
- POST `http://localhost:8080/customers` -> Add new customer
  - Request body :
 
    ```json
    {
      "nama":"Customer_name",
      "contact":"Customer_contact",
      "email":"Customer_email",
      "alamat":"Customer_address",
      "tipeDiskon":"Customer_tipe"
    }
    ```
- PUT `http://localhost:8080/customers/{id}` -> Update customer
  - Request body :
 
    ```json
    {
      "nama":"Customer_name",
      "contact":"Customer_contact",
      "email":"Customer_email",
      "alamat":"Customer_address",
      "tipeDiskon":"Customer_tipe"
    }
    ```
- DELETE `http://localhost:8080/customers/{id}` -> Delete Customer

**Sales Module:**
- GET `http://localhost:8080/sales` -> List sales
- GET `http://localhost:8080/sales/{id}` -> Detail sale
- POST `http://localhost:8080/sales` -> Add new sale
  - Request body :
 
    ```json
    {
      "customer": {
          "id": "Customer_id"
      },
      "items": [
          {
              "id": "Item_id"
          },
          {
              "id": "Item_id"
          }
      ],
      "qty": "Item_qty"
    }
    ```

With the Simple Sales Inventory Application (Administrator), users can manage stock items, customer information, and record sales transactions more effectively and efficiently. This application helps administrators run their businesses in a more organized and streamlined manner.
