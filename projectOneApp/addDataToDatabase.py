import pandas as pd
import random
import sqlite3
from faker import Faker

from datetime import datetime, timedelta

start_date = datetime(datetime.now().year, 1, 1)
end_date = datetime(datetime.now().year, 12, 31)

conn = sqlite3.connect('storeDB.db')

cursor = conn.cursor()

fake = Faker()


### Data for Adding into Product Database

shoes = ["Air Jordan", "Ultra Boost", "Classic Leather", "Chuck Taylor", "Future Rider", "Old Skool", "990v5", "Gel-Kayano 28", "Disruptor II",
"Go Run Razor 3", "Air Max 270", "Stan Smith", "Club C 85", "One Star", "RS-Fast", "Authentic", "Fresh Foam 1080v11", "Gel-Nimbus 23",
"Ray Tracer", "Arch Fit", "Air Force 1", "NMD_R1", "Zig Kinetica II", "Jack Purcell", "Calibrate Runner", "Sk8-Hi", "327", "Gel-Quantum 180",
"Mindblower", "D'Lites", "Air Max 2090", "Adizero Adios 5", "Nano 9", "Chuck 70", "Future Rider Play", "Slip-On", "574", "Gel-Kayano 27",
"Venom", "Go Walk 5", "Air Force 1", "NMD_R1", "Zig Kinetica II", "Jack Purcell", "Suede Classic", "Sk8-Hi", "327", "Gel-Kayano 28",
"Original Fitness", "Go Walk 5", "Free RN 5.0", "Adilette Cloudfoam", "Nano 9", "Chuck 70", "Clyde All Pro", "Era", "Fresh Foam More v2",
"GT-2000 10", "Mindblower", "Dynamight 2.0", "Air Force 1", "NMD_R1"]

quantity = [1, 2, 3, 4, 5, 6]
shoe_prices_df = pd.read_csv("D:/Vasudev_Agarwal/Work_Fun/1_Texas_AM/1_Spring_2024/CSCE 310/csce310_project_1/projectOneApp/Shoe prices.csv")
# D:\Vasudev_Agarwal\Work_Fun\1_Texas_AM\1_Spring_2024\CSCE 310\csce310_project_1\projectOneApp\Shoe prices.csv

shoe_prices = [float(price.replace('$', '').strip()) for price in shoe_prices_df["Price (USD)"]]
model_list = shoe_prices_df["Model"].tolist()


brand_list = shoe_prices_df["Brand"].tolist()
unique_brands = list(set(brand_list))
random_addresses = [fake.address() for _ in range(10)]
random_numbers = [random.randint(0, 1000000000) for _ in range(10)]

# print(random_numbers)

product_data = []
supplier_data = []
customer_data = []

# Generate product data
shoe_id_price = []

for i in range(100):
    product_id = 100 + i
    shoe_name = model_list[i]
    quantity_sold = random.choice(quantity)
    shoe_price = shoe_prices[i]

    product_data.append((product_id, shoe_name, quantity_sold, shoe_price))
    shoe_id_price.append((product_id, shoe_price))


for i in range(10):
    supplier_id = 1000 + i
    supplier_name = unique_brands[i]
    supplier_address = fake.address()
    supplier_phone = fake.phone_number()

    supplier_data.append((supplier_id, supplier_name, supplier_address, supplier_phone))

customer_ids = []
for i in range(100):
    customer_id = 6000 + i
    customer_ids.append(customer_id)
    customer_name = fake.name()
    customer_address = fake.address()
    customer_phone = fake.phone_number()
    customer_data.append((customer_id, customer_name, customer_address, customer_phone))


current_date = start_date
dates_in_year = []
while current_date <= end_date:
    dates_in_year.append(current_date)
    current_date += timedelta(days=1)

# Print sample product data
# print(product_data[6])
# print(supplier_data[6])
# for date in dates_in_year:
#     print(date.strftime("%Y-%m-%d"))

# NEED TO GET RANDOM QUANTITY (between 1 and 5)
    # Will generate a random number
# NEED TO GET PRODUCT ID WITH PRODUCT COST
    # product_data[i][0] -> here i will be an random number -> PRODUCT ID
    # product_data[i][3] -> here i will be same as above -> PRODUCT COST
# NEED TO GET CUSTOMER ID
    # customer_data[i][0] -> here i will be random number -> CUSTOMER ID
# print(customer_data[4][0])


order_data = []

for i in range(len(dates_in_year)):
    order_id = 10000 + i
    order_date = dates_in_year[i].strftime("%Y-%m-%d")
    for j in range(random.randint(1, 5)):
        order_customer_id = random.choice(customer_ids)
        order_product_id, order_product_price = random.choice(shoe_id_price)
        order_quantity = random.randint(1,5)
        order_cost = order_quantity * order_product_price
        order_data.append((order_id, order_date, order_customer_id, order_product_id, order_quantity, order_cost))


productPayement = []
productOrder = []

paymentOption = ['Credit', 'Debit', 'Cash']

for i in range(5000):
    order_id = 10000 + i
    order_customer_id = random.choice(customer_ids)
    order_date = dates_in_year[random.randint(1,365)].strftime("%Y-%m-%d")
    order_cost = 0
    payment = random.choice(paymentOption)




    for j in range(random.randint(1, 5)):
        order_product_id, order_product_price = random.choice(shoe_id_price)
        order_quantity = random.randint(1,5)
        order_cost += order_quantity * order_product_price
#         order_data.append((order_id, order_date, order_customer_id, order_product_id, order_quantity, order_cost))
        productOrder.append((order_id, order_product_id, order_quantity))

    productPayement.append((order_id, order_date, order_customer_id, order_cost, payment))


# print(productPayement)
# print(productOrder)



# Payement Table - orderID, orderDate, customerID, orderCost, paymentType
# Order Table - OrderID, productID, orderQuantity
# print(order_data)
    

# cursor.executemany('''INSERT INTO Product (productID, productName, productQuantity, productCost)
#                       VALUES (?, ?, ?, ?)''', product_data)

# cursor.executemany('''INSERT INTO Supplier (supplierID, supplierName, supplierAddress, supplierPhone)
#                    VALUES (?, ?, ?, ?)''', supplier_data)

# cursor.executemany('''INSERT INTO Customer (customerID, customerName, customerAddress, customerPhone)
#                    VALUES (?, ?, ?, ?)''', customer_data)
        
# cursor.executemany('''INSERT INTO Orders (orderID, orderDate, customerID, productID, orderQuantity, orderCost)
#                    VALUES (?, ?, ?, ?, ?, ?)''', order_data)

# cursor.executemany('''INSERT INTO ProductOrder (orderID, orderDate, customerID, orderCost, paymentType)
#                      VALUES (?, ?, ?, ?, ?)''', productPayement)

cursor.executemany('''INSERT INTO ProductPayment (orderID, productID, orderQuantity)
                  VALUES (?, ?, ?)''', productOrder)

conn.commit()
conn.close()