drop database if exists vaccinedb;
Create database vaccinedb;
use vaccinedb;
create table organization (org_id int primary key, name varchar(50), email varchar(50) unique, password varchar(100), description text(2000), logo varchar(100) default './assets/img/defaultorg.jpg');

CREATE TABLE vaccine (vacc_id int primary key, name varchar(50) unique, disease varchar(50), org_id int, foreign key(org_id) references organization(org_id) on delete cascade);

create table patient (patient_id int primary key, name varchar(50), email varchar(50) unique, password varchar(100), dob varchar(15), disease varchar(50), symptoms text(1000), medical_history text(1000), phone varchar(10), address varchar(50), profile_picture varchar(100) default './assets/img/defaultpatient.jpg', vacc_id int, org_id int, foreign key(vacc_id) references vaccine(vacc_id) on delete set null, foreign key(org_id) references organization(org_id) on delete set null);

create table report (report_id int primary key, result varchar(20), description varchar(100), org_id int, vacc_id int, patient_id int, foreign key(org_id) references organization(org_id) on delete cascade, foreign key(vacc_id) references vaccine(vacc_id) on delete cascade, foreign key(patient_id) references patient(patient_id) on delete set null);

-- ALTER TABLE organization ADD CONSTRAINT FK_Org_vacc FOREIGN KEY (vacc_id) REFERENCES vaccine(vacc_id);
-- CREATE TABLE org_vacc(pk_vacc int primary key, vacc_id int, org_id int, foreign key(org_id) references organization(org_id), foreign key(vacc_id) references vaccine(vacc_id));

-- insert into org_vacc values(1,11,1);
-- insert into org_vacc values(2,11,1);
-- insert into org_vacc values(3,12,3);
-- insert into org_vacc values(4,13,4);
-- insert into org_vacc values(5,14,5);
-- insert into org_vacc values(6,15,6);
-- insert into org_vacc values(7,16,7);
-- insert into org_vacc values(8,17,8);
-- insert into org_vacc values(9,18,9);
-- insert into org_vacc values(10,19,10);


-- insert into organization values(1,'Sanofi Pasteur', 'moderator@sanofi.com', 'password', 'Sanofi Pasteur is the vaccines division of the French multinational pharmaceutical company Sanofi. Sanofi Pasteur is the largest company in the world devoted entirely to vaccines. Sanofi Pasteur is one of four global producers of the yellow fever vaccine.', '');
-- insert into organization values(2,'GlaxoSmithKline', 'moderator@gsk.com', 'password', 'GlaxoSmithKline plc is a British multinational pharmaceutical company headquartered in Brentford, England.', '');
-- insert into organization values(3,'Merck & Co., Inc.', 'moderator@merck.com', 'password', 'Merck & Co., Inc., d.b.a. Merck Sharp & Dohme outside the United States and Canada, is an American multinational pharmaceutical company and one of the largest pharmaceutical companies in the world. Merck is incorporated in New Jersey.', '');
-- insert into organization values(4,'Pfizer', 'moderator@pfizer.com', 'password', 'Pfizer Inc. is an American multinational pharmaceutical corporation. It is one of the largest pharmaceutical companies and ranked 57 on the 2018 Fortune 500 list of the largest United States corporations by total revenue.', '');
-- insert into organization values(5,'AstraZeneca', 'moderator@astrazeneca.com', 'password', 'AstraZeneca plc is a Swedish-British multinational pharmaceutical and biopharmaceutical company with its headquarters in Cambridge, England. AstraZeneca has a portfolio of products for major disease areas including cancer, cardiovascular, gastrointestinal, infection, neuroscience, respiratory and inflammation.', '');
-- insert into organization values(6,'Mitsubishi Tanabe Pharma', 'moderator@mtanabepharma.com', 'password', 'Mitsubishi Tanabe Pharma Corporation is a Japanese pharmaceuticals company, a subsidiary of Mitsubishi Chemical Holdings Corporation. Mitsubishi Pharma Corporation was formed in 2001 from the merger of Mitsubishi-Tokyo Pharmaceuticals and Welfide Corporation.', '');
-- insert into organization values(7,'Emergent BioSolutions', 'moderator@emergent.com', 'password', 'Emergent BioSolutions Inc. is an American multinational specialty biopharmaceutical company headquartered in Gaithersburg, Maryland. It develops vaccines and antibody therapeutics for infectious diseases, opioid overdoses, and provides medical devices for biodefense purposes.', '');
-- insert into organization values(8,'Astellas Pharma Inc', 'moderator@astellas.com', 'password', 'Astellas Pharma Inc. is a Japanese multinational pharmaceutical company, formed on 1 April 2005 from the merger of Yamanouchi Pharmaceutical Co., Ltd. and Fujisawa Pharmaceutical Co., Ltd. On February 5, 2020, the company announced management changes effective from April 1, 2020.', '');
-- insert into organization values(9,'Valneva', 'moderator@valneva.com', 'password', 'Valneva SE is a biotech company developing and commercializing vaccines for infectious diseases with major unmet needs. Valneva was founded in 2013 through the merger of Intercell and Vivalis SA. It has been listed on the Vienna Stock Exchange and Euronext since May 28, 2013.', '');
-- insert into organization values(10,'Seqirus', 'moderator@seqirus.com', 'password', 'As part of the CSL Group, Seqirus draws on over a century of experience in influenza vaccines. From 1916 to today, CSL has been driven by the promise to save lives using the latest technologies.', 'seqi');


-- insert into vaccine values(11,'Dukoral','Cholera', 1);
-- insert into vaccine values(12,'Dengvaxia','Dengue', 2);
-- insert into vaccine values(13,'Influvac','Influenza', 3);
-- insert into vaccine values(14,'RabAvert','Rabies', 3);
-- insert into vaccine values(15,'Varivax','Chickenpox', 4);
-- insert into vaccine values(16,'JEvax','Japanese encephalitis', 5);
-- insert into vaccine values(17,'MMR II','Measles', 6);
-- insert into vaccine values(18,'Q-Vax','Q fever', 7);
-- insert into vaccine values(19,'Tice BCG','Tuberculosis', 8);
-- insert into vaccine values(20,'Typhim Vi','Typhoid fever', 8);

-- insert into patient values(1001, 'Alex', 'alex23@xyz.com', 'password', '01-01-1990', 'Cholera', 'None', 'Healthy Individuals', '8655660000', '81B Baker Street, London', './assets/profile/', 11, 1);
-- insert into patient values(1002, 'John', 'john97@xyz.com', 'password', '01-01-1990', 'Dengue', 'None', 'Healthy Individuals', '7856650000', 'LA City, USA', './assets/profile/', 12, 2);
-- insert into patient values(1003, 'Carry', 'carry89@xyz.com', 'password', '01-01-1990', 'Influenza', 'None', 'Healthy Individuals', '3652590000', 'Elmo Street, Canada', './assets/profile/', 13, 3);
-- insert into patient values(1004, 'Ramesh', 'ramesh01@xyz.com', 'password', '01-01-1990', 'Rabies', 'None', 'Healthy Individuals', '5613650000', ' Mumbai, India', './assets/profile/', 14, 4);
-- insert into patient values(1005, 'Suresh', 'suresh99@xyz.com', 'password', '01-01-1990', 'Chickenpox', 'None', 'Healthy Individuals', '7816320000', 'Punjab, India', './assets/profile/', 15, 5);
-- insert into patient values(1006, 'Rahul', 'rahul55@xyz.com', 'password', '01-01-1990', 'Japanese Encephalitis', 'None', 'Healthy Individuals', '7526650000', 'Delhi, India', './assets/profile/', 16, 6);
-- insert into patient values(1007, 'Rohan', 'rohan66@xyz.com', 'password', '01-01-1990', 'Measles', 'None', 'Healthy Individuals', '8961450000', 'Pune, India', './assets/profile/', 17, 7);
-- insert into patient values(1008, 'Sameer', 'sameer69@xyz.com', 'password', '01-01-1990', 'Q Fever', 'None', 'Healthy Individuals', '9872350000', 'Haryana, India', './assets/profile/', 18, 8);
-- insert into patient values(1009, 'Vicky', 'vicky10@xyz.com', 'password', '01-01-1990', 'Tuberculosis', 'None', 'Healthy Individuals', '6587450000', ' Goa, India', './assets/profile/', 19, 9);
-- insert into patient values(1010, 'Rehan', 'rehan87@xyz.com', 'password', '01-01-1990', 'Typhoid Fever', 'None', 'Healthy Individuals', '3142650000', 'Vizag, India',  './assets/profile/', 20, 10);


-- insert into report values(201, 'Pass', 'Not Available', 1, 11, 1001);
-- insert into report values(202, 'Fail', 'Not Available', 2, 12, 1002);
-- insert into report values(203, 'Pass', 'Not Available', 3, 13, 1003);
-- insert into report values(204, 'Pass', 'Not Available', 4, 14, 1004);
-- insert into report values(205, 'Fail', 'Not Available', 5, 15, 1005);
-- insert into report values(206, 'Pass', 'Not Available', 1, 11, 1001);
-- insert into report values(207, 'Fail', 'Not Available', 2, 12, 1002);
-- insert into report values(208, 'Pass', 'Not Available', 3, 13, 1003);
-- insert into report values(209, 'Pass', 'Not Available', 4, 14, 1004);
-- insert into report values(210, 'Fail', 'Not Available', 5, 15, 1005);
-- insert into report values(211, 'Pass', 'Not Available', 6, 16, 1006);
-- insert into report values(212, 'Fail', 'Not Available', 7, 17, 1007);
-- insert into report values(213, 'Pass', 'Not Available', 8, 18, 1008);
-- insert into report values(214, 'Pass', 'Not Available', 9, 19, 1009);
-- insert into report values(215, 'Fail', 'Not Available', 10, 20, 1010);
