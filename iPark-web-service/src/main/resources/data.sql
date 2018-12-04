


-- --------------------------------------------------------

--
-- Table structure for table parking
--



INSERT INTO company (id, name, address, message, currency) VALUES
(1, 'ITC Infotech India Ltd', 'Banaswadi Main Road', '*****Have a happy day*****', 'USD');

INSERT INTO u_groups (id, group_name, permission_name) VALUES
(1, 'Super Administrator', 'a:28:{i:0;s:10:\"createUser\";i:1;s:10:\"updateUser\";i:2;s:8:\"viewUser\";i:3;s:10:\"deleteUser\";i:4;s:11:\"createGroup\";i:5;s:11:\"updateGroup\";i:6;s:9:\"viewGroup\";i:7;s:11:\"deleteGroup\";i:8;s:14:\"createCategory\";i:9;s:14:\"updateCategory\";i:10;s:12:\"viewCategory\";i:11;s:14:\"deleteCategory\";i:12;s:11:\"createRates\";i:13;s:11:\"updateRates\";i:14;s:9:\"viewRates\";i:15;s:11:\"deleteRates\";i:16;s:11:\"createSlots\";i:17;s:11:\"updateSlots\";i:18;s:9:\"viewSlots\";i:19;s:11:\"deleteSlots\";i:20;s:13:\"createParking\";i:21;s:13:\"updateParking\";i:22;s:11:\"viewParking\";i:23;s:13:\"deleteParking\";i:24;s:13:\"updateCompany\";i:25;s:13:\"updateSetting\";i:26;s:11:\"viewReports\";i:27;s:11:\"viewProfile\";}'),
(5, 'Staff', 'a:7:{i:0;s:12:\"viewCategory\";i:1;s:9:\"viewRates\";i:2;s:9:\"viewSlots\";i:3;s:13:\"createParking\";i:4;s:13:\"updateParking\";i:5;s:11:\"viewParking\";i:6;s:11:\"viewReports\";}');


INSERT INTO parking_area(id,parking_area_name) VALUES
(1,"Pragathi"),
(2, "Behind LC"),
(3, "Main Parking");

INSERT INTO users (id, username, password, email, firstname, lastname, phone, gender,arn,) VALUES
(1, 'admin', '$2y$10$yfi5nUQGXUZtMdl27dWAyOd/jMOmATBpiUvJDmUu9hJ5Ro6BE5wsK', 'admin@admin.com', 'john', 'doe', '80789998', 1),
(4, 'messi', '$2y$10$KjI92qdZIgvqcZVu7aO1p.qxaImsGuoLdP3Zn5/yCC8FGyDutI3sa', 'leo@messi.com', 'leo', 'messi', '55757575', 1);


INSERT INTO user_group (id, user_id, group_id) VALUES
(1, 1, 1),
(3, 2, 4),
(4, 3, 4),
(5, 4, 5);
-- --------------------------------------------------------


