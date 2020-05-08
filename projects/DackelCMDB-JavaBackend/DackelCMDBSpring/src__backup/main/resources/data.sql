-- Test Data for table 'types_of_entity'
INSERT INTO types_of_entity (`id`, `name`,`system_name`,`create_date`,`modification_date`,`create_user`,`modification_user`, `deleted`)
VALUES
       (1001, 'Computer', 'computer', '2019-01-01 09:13:45', '2019-01-01 12:11:10', 'Christina Maier', 'Robert Redford', false),
       (1002, 'Operating System', 'operating_sytem', '2019-01-02 10:55:40', '2019-01-03 16:30:59', 'Will Smith', 'Johnny Depp', false),
       (1003, 'Client software', 'client_software', '2018-12-20 14:45:01', '2019-04-02 11:55:13', 'Silvia Hindenburg', 'Andreas Manheim', false),
       (1004, 'Active Directory Login Data', 'active_directory_login_data', '2018-07-15 08:02:30', '2018-07-15 08:03:33', 'Will Smith', 'Will Smith', false),
       (1005, 'Contract', 'contract', '2019-03-10 11:02:01', '2019-03-10 11:02:01', 'Robert Redford', 'Robert Redford', false);


-- Test data for table 'entities'
INSERT INTO entities (`id`, `type_of_entity_id`, `name`,`system_name`,`create_date`,`modification_date`,`create_user`,`modification_user`)
VALUES
       ( 1001, 1001, 'N2452022', 'n2452022', '2019-04-11 11:34:11', '2019-05-22 21:11:49', 'Christina Maier', 'Christina Maier' ),
       ( 1002, 1001, 'N2322022', 'n2322022', '2019-05-29 09:13:01', '2019-06-11 13:02:28', 'Robert Redford', 'Will Smith' ),
       ( 1003, 1002, 'Windows 7', 'windows_7', '2019-04-15 08:45:23', '2019-04-15 08:45:23', 'Samatha Ewning', 'Samantha Ewning');

-- Test data for table 'typeOfPropertyOfEntity'
INSERT INTO properties_of_entities (`id`, `type`, `name`, `system_name`, `create_date`, `modification_date`, `create_user`, `modification_user`, `deleted`)
VALUES
       ( 1001, 0, 'IP_ADDRESS', 'ip_address', '2020-01-11 23:33:34', '2020-01-11 23:33:56', 'Will Smith', 'Robert Redford', false),
       ( 1002, 0, 'NET_MASK', 'net_mask', '2020-01-11 23:33:54', '2020-01-11 23:35:00', 'Will Smith', 'Robert Redford', false);

-- Test data for value of property of entity
INSERT INTO values_of_property_of_entity (`id`, `create_date`, `modification_date`, `create_user`, `modification_user`, `deleted`,
                                         `entity_id`, `property_id`, `value_str`, `value_num`, `value_sec`, `value_dat`, `value_ent`)
VALUES
       ( 1001, '2020-01-13 20:46:22', '2020-01-13 20:46:33', 'Will Smith', 'Robert Redford', false, 1001, 1001, '192.168.1.1', null, null, null, null),
       ( 1002, '2020-01-13 20:48:24', '2020-01-13 20:49:22', 'Robert Redford', 'Maria Carry', false, 1001, 1002, '255.255.255.0', null, null, null, null);