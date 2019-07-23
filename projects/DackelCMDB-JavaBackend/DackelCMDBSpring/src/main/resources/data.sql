-- Test Data for table 'types_of_entity'
INSERT INTO types_of_entity (`id`, `name`,`system_name`,`create_date`,`modification_date`,`create_user`,`modification_user`)
VALUES
       ( 1, 'Computer', 'computer', '2019-01-01 09:13:45', '2019-01-01 12:11:10', 'Christina Maier', 'Robert Redford'),
       ( 2, 'Operating System', 'operating_sytem', '2019-01-02 10:55:40', '2019-01-03 16:30:59', 'Will Smith', 'Johnny Depp'),
       ( 3, 'Client software', 'client_software', '2018-12-20 14:45:01', '2019-04-02 11:55:13', 'Silvia Hindenburg', 'Andreas Manheim'),
       ( 4, 'Active Directory Login Data', 'active_directory_login_data', '2018-07-15 08:02:30', '2018-07-15 08:03:33', 'Will Smith', 'Will Smith'),
       ( 5, 'Operating System', 'operating_system', '2019-03-10 11:02:01', '2019-03-10 11:02:01', 'Robert Redford', 'Robert Redford');


-- Test data for table 'entities'
INSERT INTO entities (`id`, `type_of_entity_id`, `name`,`system_name`,`create_date`,`modification_date`,`create_user`,`modification_user`)
VALUES
       ( 1, 1, 'N2452022', 'n2452022', '2019-04-11 11:34:11', '2019-05-22 21:11:49', 'Christina Maier', 'Christina Maier' ),
       ( 2, 1, 'N2322022', 'n2322022', '2019-05-29 09:13:01', '2019-06-11 13:02:28', 'Robert Redford', 'Will Smith' )