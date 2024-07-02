-- CATEGORIES
INSERT INTO categories (`name`, `created_at`, `updated_at`) VALUES ('Electronics', NOW(), NOW());
INSERT INTO categories (`name`, `created_at`, `updated_at`) VALUES ('Jewelery', NOW(), NOW());
INSERT INTO categories (`name`, `created_at`, `updated_at`) VALUES ('Men''s clothing', NOW(), NOW());
INSERT INTO categories (`name`, `created_at`, `updated_at`) VALUES ('Women''s clothing', NOW(), NOW());

-- PRODUCTS: ELECTRONICS
INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES (1, 'WD 2TB Portable External Hard Drive', 'USB 3.0 and USB 2.0 Compatibility Fast data transfers Improve PC Performance High Capacity; Compatibility Formatted NTFS for Windows 10, Windows 8.1, Windows 7; Reformatting may be required for other operating systems; Compatibility may vary depending on user’s hardware configuration and operating system', 64.50, 'https://fakestoreapi.com/img/61U7T1koQqL._AC_SX679_.jpg', 10, 1, NOW(), NOW());
INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES (1, 'SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s', 'Easy upgrade for faster boot up, shutdown, application load and response (As compared to 5400 RPM SATA 2.5” hard drive; Based on published specifications and internal benchmarking tests using PCMark vantage scores) Boosts burst write performance, making it ideal for typical PC workloads The perfect balance of performance and reliability Read/write speeds of up to 535MB/s/450MB/s (Based on internal testing; Performance may vary depending upon drive capacity, host device, OS and application.)', 120, 'https://fakestoreapi.com/img/61U7T1koQqL._AC_SX679_.jpg', 5, 1, NOW(), NOW());
INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES (1, 'WD 4TB Gaming Drive Works with Playstation 4 Portable External Hard Drive', 'Expand your PS4 gaming experience, Play anywhere Fast and easy, setup Sleek design with high capacity, 3-year manufacturer''s limited warranty', 115.90, 'https://fakestoreapi.com/img/61mtL65D4cL._AC_SX679_.jpg', 2, 1, NOW(), NOW());

-- PRODUCTS: JEWELERY
INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES (2, 'Solid Gold Petite Micropave', 'Satisfaction Guaranteed. Return or exchange any order within 30 days.Designed and sold by Hafeez Center in the United States. Satisfaction Guaranteed. Return or exchange any order within 30 days.', 170, 'https://fakestoreapi.com/img/61sbMiUnoGL._AC_UL640_QL65_ML3_.jpg', 4, 1, NOW(), NOW());
INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES (2, 'White Gold Plated Princess', 'Classic Created Wedding Engagement Solitaire Diamond Promise Ring for Her. Gifts to spoil your love more for Engagement, Wedding, Anniversary, Valentine''s Day.', 9.99, 'https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_.jpg', 15, 1, NOW(), NOW());
INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES (2, 'Pierced Owl Rose Gold Plated Stainless Steel Double', 'Rose Gold Plated Double Flared Tunnel Plug Earrings. Made of 316L Stainless Steel', 10.99, 'https://fakestoreapi.com/img/51UDEzMJVpL._AC_UL640_QL65_ML3_.jpg', 3, 1, NOW(), NOW());

-- PRODUCTS: Men's clothing
INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES (3, 'Men''s Casual Premium Slim Fit T-Shirts', 'Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.', 24.50, 'https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg', 5, 1, NOW(), NOW());
INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES (3, 'Men''s Cotton Jacket', 'great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.', 55, 'https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg', 2, 1, NOW(), NOW());
INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES (3, 'Men''s Casual Slim Fit', 'The color could be slightly different between on the screen and in practice. / Please note that body builds vary by person, therefore, detailed size information should be reviewed below on the product description.', 15.99, 'https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg', 6, 1, NOW(), NOW());

-- PRODUCTS: Women's clothing
INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES (4, 'Rain Jacket Women Windbreaker Striped Climbing Raincoats', 'Lightweight perfet for trip or casual wear---Long sleeve with hooded, adjustable drawstring waist design. Button and zipper front closure raincoat, fully stripes Lined and The Raincoat has 2 side pockets are a good size to hold all kinds of things, it covers the hips, and the hood is generous but doesn''t overdo it.Attached Cotton Lined Hood with Adjustable Drawstrings give it a real styled look.', 35.99, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_-2.jpg', 2, 1, NOW(), NOW());
INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES (4, 'MBJ Women''s Solid Short Sleeve Boat Neck V', '95% RAYON 5% SPANDEX, Made in USA or Imported, Do Not Bleach, Lightweight fabric with great stretch for comfort, Ribbed on sleeves and neckline / Double stitching on bottom hem.', 8.50, 'https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg', 3, 1, NOW(), NOW());
INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES (4, 'Opna Women''s Short Sleeve Moisture', '100% Polyester, Machine wash, 100% cationic polyester interlock, Machine Wash & Pre Shrunk for a Great Fit, Lightweight, roomy and highly breathable with moisture wicking fabric which helps to keep moisture away, Soft Lightweight Fabric with comfortable V-neck collar and a slimmer fit, delivers a sleek, more feminine silhouette and Added Comfort.', 9.50, 'https://fakestoreapi.com/img/51eg55uWmdL._AC_UX679_.jpg', 7, 1, NOW(), NOW());

-- CARTS
INSERT INTO carts (`created_at`, `updated_at`) VALUES (NOW(), NOW());

-- WISHLIST
INSERT INTO wishlists (`created_at`, `updated_at`) VALUES (NOW(), NOW());

-- LLENADO DE LA TABLA
INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES 
(1, 'Samsung 49-Inch CHG90 144Hz Curved Gaming Monitor', '49 INCH 32:9 UltraWide Full HD 1080p - Dual Monitor Experience', 999.99, 'https://fakestoreapi.com/img/81Zt42ioCgL._AC_SX679_.jpg', 5, 1, NOW(), NOW()),
(1, 'SanDisk 1TB Extreme Portable SSD', 'High-speed storage for high-res photos, videos and files.', 139.99, 'https://fakestoreapi.com/img/41WhEy9iohL._AC_UY879_.jpg', 20, 1, NOW(), NOW()),
(1, 'Acer Aspire 5 Slim Laptop', '15.6 inches Full HD IPS Display, AMD Ryzen 3 3200U, Vega 3 Graphics, 4GB DDR4, 128GB SSD, Backlit Keyboard, Windows 10 in S Mode.', 364.99, 'https://fakestoreapi.com/img/41vMYgD92xL._AC_SY400_.jpg', 5, 1, NOW(), NOW()),
(1, 'Samsung Galaxy A52 5G', 'Fast and reliable 5G connectivity, quad camera, and a sleek design.', 349.99, 'https://fakestoreapi.com/img/81vkolHxqEL._AC_SL1500_.jpg', 10, 1, NOW(), NOW()),
(1, 'Apple AirPods Pro', 'Active noise cancellation for immersive sound..', 249.99, 'https://fakestoreapi.com/img/71zny7BTRlL._AC_SL1500_.jpg', 5, 1, NOW(), NOW()),
(1, 'Gaming Laptop', 'High performance laptop for gaming and work.', 1500.0, 'https://fakestoreapi.com/img/41WhEy9iohL._AC_UY879_.jpg', 2, 1, NOW(), NOW()),
(1, 'Bluetooth Speaker', 'Portable and waterproof speaker.', 99.99, 'https://fakestoreapi.com/img/61U7T1koQqL._AC_SX679_.jpg', 25, 1, NOW(), NOW()),
(2, 'Solid Gold Petite Micropave', 'Satisfaction Guaranteed. Return or exchange any order within 30 days.', 168.0, 'https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_.jpg', 3, 1, NOW(), NOW()),
(2, 'White Gold Plated Princess', 'Classic Created Wedding Engagement Solitaire Diamond Promise Ring for Her.', 9.99, 'https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg', 6, 1, NOW(), NOW());

INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES 
(2, 'Pierced Owl Rose Gold Plated Stainless Steel Double', 'Rose Gold Plated Double Flared Tunnel Plug Earrings.', 10.99, 'https://fakestoreapi.com/img/51UDEzMJVpL._AC_UL640_QL65_ML3_.jpg', 50, 1, NOW(), NOW()),
(2, 'John Hardy Womens Legends Naga Gold & Silver Dragon Station Chain Bracelet', 'From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the oceans pearl.', 695.0, 'https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg', 4, 1, NOW(), NOW()),
(2, 'Diamond Stud Earrings', '14K White Gold Round-Cut Studs', 399.99, 'https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg', 3, 1, NOW(), NOW()),
(2, 'Luxury Necklace', 'Gold-Plated, Elegant Design', 89.99, 'https://fakestoreapi.com/img/61IBBVJvSDL._AC_UL640_QL65_ML3_.jpg', 7, 1, NOW(), NOW()),
(2, 'Gold Bracelet', 'Elegant bracelet for special occasions.', 129.99, 'https://fakestoreapi.com/img/51eg55uWmdL._AC_UL640_QL65_ML3_.jpg', 8, 1, NOW(), NOW()),

(3, 'Mens Casual Premium Slim Fit T-Shirts', 'Slim-fitting style, contrast raglan long sleeve, three-button henley placket, lightweight & soft fabric for comfortable wear.', 22.3, 'https://fakestoreapi.com/img/71YXzeOuslL._AC_UL640_QL65_ML3_.jpg', 8, 1, NOW(), NOW()),
(3, 'Mens Cotton Jacket', 'Great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors.', 55.99, 'https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg', 12, 1, NOW(), NOW()),
(3, 'Mens Formal Shirt', 'Perfect for office wear or formal events.', 45.0, 'https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg', 11, 1, NOW(), NOW()),
(3, 'Mens Running Shoes', 'Comfortable and durable running shoes for everyday use.', 65.0, 'https://fakestoreapi.com/img/61pHAEJ4NML._AC_UX679_.jpg', 6, 1, NOW(), NOW()),
(3, 'Mens Tuxedo', 'Elegant tuxedo for formal occasions.', 299.99, 'https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg', 3, 1, NOW(), NOW()),
(3, 'Mens Leather Wallet', 'Premium quality leather wallet.', 49.99, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_.jpg', 15, 1, NOW(), NOW()),
(4, 'BIYLACLESEN Womens 3-in-1 Snowboard Jacket Winter Coats', 'Note: The Jackets is Asian size, please choose 1-2 size up. Tips: It is best to wash it by hand.', 56.99, 'https://fakestoreapi.com/img/51Y5NI-I5jL._AC_UX679_.jpg', 7, 1, NOW(), NOW()),
(4, 'Lock and Love Womens Removable Hooded Faux Leather Moto Biker Jacket', '100% Polyurethane, Hand Wash Only.', 29.95, 'https://fakestoreapi.com/img/81XH0e8fefL._AC_UY879_.jpg', 15, 1, NOW(), NOW()),
(4, 'Womens Handbag', 'Stylish and spacious handbag for everyday use.', 75.0, 'https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg', 12, 1, NOW(), NOW()),
(4, 'Womens Winter Coat', 'Warm and comfortable winter coat.', 120.0, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_.jpg', 8, 1, NOW(), NOW());

INSERT INTO products (`category_id`, `name`, `description`, `price`, `image`, `qty`, `visible`, `created_at`, `updated_at`) VALUES 
(4, 'Rain Jacket Women Windbreaker Striped Climbing Raincoats', 'Lightweight perfect for trip or casual wear—Long sleeve with hooded, adjustable drawstring waist design.', 39.99, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_.jpg', 3, 1, NOW(), NOW()),
(4, 'DANVOUY Womens T Shirt Casual Cotton Short', '95% Cotton, 5% Spandex, Features: Casual, Short Sleeve, Letter Print, V-Neck, Fashion Tees.', 12.99, 'https://fakestoreapi.com/img/61pHAEJ4NML._AC_UX679_.jpg', 9, 1, NOW(), NOW()),
(4, 'Opna Womens Short Sleeve Moisture', '100% Polyester, Machine wash, 2-button placket, lightweight, breathable fabric.', 7.95, 'https://fakestoreapi.com/img/51eg55uWmdL._AC_UX679_.jpg', 16, 1, NOW(), NOW()),
(4, 'MBJ Womens Solid Short Sleeve Boat Neck V', '95% RAYON 5% SPANDEX.', 9.85, 'https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg', 24, 1, NOW(), NOW()),
(4, 'Womens High Heels', 'Elegant high heels for formal occasions.', 79.99, 'https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg', 5, 1, NOW(), NOW()),
(4, 'Womens Summer Dress', 'Light and comfortable summer dress.', 29.99, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_.jpg', 7, 1, NOW(), NOW()),
(4, 'Womens Yoga Pants', 'Comfortable and stretchy yoga pants.', 19.99, 'https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg', 20, 1, NOW(), NOW()),
(4, 'Womens Sneakers', 'Stylish and comfortable sneakers.', 49.99, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_.jpg', 10, 1, NOW(), NOW()),
(4, 'Womens Sunglasses', 'Fashionable sunglasses for daily wear.', 15.99, 'https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg', 25, 1, NOW(), NOW()),
(3, 'Mens Watch', 'Classic analog watch for men.', 199.99, 'https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg', 5, 1, NOW(), NOW()),
(3, 'Mens Leather Belt', 'Genuine leather belt with a sleek design.', 29.99, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_.jpg', 15, 1, NOW(), NOW()),
(3, 'Mens Hoodie', 'Comfortable and stylish hoodie.', 39.99, 'https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg', 8, 1, NOW(), NOW()),
(3, 'Mens Jeans', 'Slim fit jeans with a modern look.', 49.99, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_.jpg', 10, 1, NOW(), NOW()),
(3, 'Mens Polo Shirt', 'Casual polo shirt for everyday wear.', 19.99, 'https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg', 12, 1, NOW(), NOW()),
(3, 'Mens Swim Trunks', 'Comfortable swim trunks for the beach or pool.', 24.99, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_.jpg', 20, 1, NOW(), NOW()),
(1, 'Lenovo ThinkPad X1 Carbon', '14 inch FHD, Intel Core i7, 16GB RAM, 512GB SSD, Windows 10 Pro.', 1299.99, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_.jpg', 3, 1, NOW(), NOW()),
(1, 'Dell Ultrasharp 27 Monitor', '27 inch, 4K UHD, USB-C, HDR, 350 cd/m² Brightness.', 549.99, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_.jpg', 4, 1, NOW(), NOW()),
(1, 'Logitech MX Master 3 Mouse', 'Advanced Wireless Mouse, Ultrafast Scrolling, Ergonomic Design.', 99.99, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_.jpg', 20, 1, NOW(), NOW()),
(1, 'HP OfficeJet Pro 9015e', 'All-in-One Wireless Printer with Bonus 6 Months Instant Ink.', 229.99, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_.jpg', 7, 1, NOW(), NOW()),
(1, 'Apple MacBook Pro', '16-inch, Apple M1 Pro chip, 16GB RAM, 512GB SSD.', 2399.99, 'https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_.jpg', 5, 1, NOW(), NOW());
