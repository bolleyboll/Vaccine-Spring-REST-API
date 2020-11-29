drop database if exists vaccinedb;
Create database vaccinedb;
use vaccinedb;
create table organizations (org_id int primary key, name varchar(50), email varchar(50) unique, password varchar(100), description text(2000), logo text(3000));

CREATE TABLE vaccines (vacc_id int primary key, name varchar(50) unique, disease varchar(50), org_id int, foreign key(org_id) references organizations(org_id) on delete cascade);

create table patients (patient_id int primary key, name varchar(50), email varchar(50) unique, password varchar(100), dob varchar(15), gender varchar(10), disease varchar(50), symptoms text(1000), medical_history text(1000), phone varchar(10), address varchar(50), profile_picture text(3000), vacc_id int, org_id int, foreign key(vacc_id) references vaccines(vacc_id) on delete set null, foreign key(org_id) references organizations(org_id) on delete set null);

create table reports (report_id int primary key, result varchar(20), description varchar(100), org_id int, vacc_id int, patient_id int, foreign key(org_id) references organizations(org_id) on delete cascade, foreign key(vacc_id) references vaccines(vacc_id) on delete cascade, foreign key(patient_id) references patients(patient_id) on delete set null);

insert into organizations values(1001,'Sanofi Pasteur', 'moderator@sanofi.com', 'password', 'Sanofi Pasteur is the vaccines division of the French multinational pharmaceutical company Sanofi. Sanofi Pasteur is the largest company in the world devoted entirely to vaccines. Sanofi Pasteur is one of four global producers of the yellow fever vaccine.', '');
insert into organizations values(1002,'GlaxoSmithKline', 'moderator@gsk.com', 'password', 'GlaxoSmithKline plc is a British multinational pharmaceutical company headquartered in Brentford, England.', '');
insert into organizations values(1003,'Merck & Co., Inc.', 'moderator@merck.com', 'password', 'Merck & Co., Inc., d.b.a. Merck Sharp & Dohme outside the United States and Canada, is an American multinational pharmaceutical company and one of the largest pharmaceutical companies in the world. Merck is incorporated in New Jersey.', '');
insert into organizations values(1004,'Pfizer', 'moderator@pfizer.com', 'password', 'Pfizer Inc. is an American multinational pharmaceutical corporation. It is one of the largest pharmaceutical companies and ranked 57 on the 2018 Fortune 500 list of the largest United States corporations by total revenue.', '');
insert into organizations values(1005,'AstraZeneca', 'moderator@astrazeneca.com', 'password', 'AstraZeneca plc is a Swedish-British multinational pharmaceutical and biopharmaceutical company with its headquarters in Cambridge, England. AstraZeneca has a portfolio of products for major disease areas including cancer, cardiovascular, gastrointestinal, infection, neuroscience, respiratory and inflammation.', '');
insert into organizations values(1006,'Mitsubishi Tanabe Pharma', 'moderator@mtanabepharma.com', 'password', 'Mitsubishi Tanabe Pharma Corporation is a Japanese pharmaceuticals company, a subsidiary of Mitsubishi Chemical Holdings Corporation. Mitsubishi Pharma Corporation was formed in 2001 from the merger of Mitsubishi-Tokyo Pharmaceuticals and Welfide Corporation.', '');
insert into organizations values(1007,'Emergent BioSolutions', 'moderator@emergent.com', 'password', 'Emergent BioSolutions Inc. is an American multinational specialty biopharmaceutical company headquartered in Gaithersburg, Maryland. It develops vaccines and antibody therapeutics for infectious diseases, opioid overdoses, and provides medical devices for biodefense purposes.', '');
insert into organizations values(1008,'Astellas Pharma Inc', 'moderator@astellas.com', 'password', 'Astellas Pharma Inc. is a Japanese multinational pharmaceutical company, formed on 1 April 2005 from the merger of Yamanouchi Pharmaceutical Co., Ltd. and Fujisawa Pharmaceutical Co., Ltd. On February 5, 2020, the company announced management changes effective from April 1, 2020.', '');
insert into organizations values(1009,'Valneva', 'moderator@valneva.com', 'password', 'Valneva SE is a biotech company developing and commercializing vaccines for infectious diseases with major unmet needs. Valneva was founded in 2013 through the merger of Intercell and Vivalis SA. It has been listed on the Vienna Stock Exchange and Euronext since May 28, 2013.', '');
insert into organizations values(1010,'Seqirus', 'moderator@seqirus.com', 'password', 'As part of the CSL Group, Seqirus draws on over a century of experience in influenza vaccines. From 1916 to today, CSL has been driven by the promise to save lives using the latest technologies.', '');


insert into vaccines values(1011,'Dukoral','Cholera', 1001);
insert into vaccines values(1021,'Adacel','Tetanus Toxoid', 1001);
insert into vaccines values(1022,'Hexaxim','Diphtheria', 1001);
insert into vaccines values(1023,'Imovax','Polio', 1001);
insert into vaccines values(1024,'Vaxigrip','Influenza', 1001);
insert into vaccines values(1033,'Coval','COVID-19', 1001);
insert into vaccines values(1012,'Dengvaxia','Dengue', 1002);
insert into vaccines values(1025,'Ambirix','Hepatitis A', 1002);
insert into vaccines values(1026,'Bexsero','Meningitis B', 1002);
insert into vaccines values(1027,'Boostrix','Tetanus Toxoid', 1002);
insert into vaccines values(1028,'Cervarix','Papillomavirus', 1002);
insert into vaccines values(1013,'Influvac','Influenza', 1003);
insert into vaccines values(1029,'ERVEBO','Ebola Zaire', 1003);
insert into vaccines values(1030,'M-M-R','Measles', 1003);
insert into vaccines values(1031,'RECOMBIVAX HB','Hepatitis B', 1003);
insert into vaccines values(1032,'VAQTA','Hepatitis A', 1003);
insert into vaccines values(1015,'Varivax','Chickenpox', 1004);
insert into vaccines values(1016,'JEvax','Japanese encephalitis', 1005);
insert into vaccines values(1017,'MMR II','Measles', 1006);
insert into vaccines values(1018,'Q-Vax','Q fever', 1007);
insert into vaccines values(1019,'Tice BCG','Tuberculosis', 1008);
insert into vaccines values(1014,'Rabivax','Rabies', 1008);
insert into vaccines values(1020,'Typhim Vi','Typhoid fever', 1008);

insert into patients values(1001, 'Alex', 'alex@xyz.com', 'password', '01-01-1990', 'Male', 'Cholera', 'Dysentry', 'Healthy Individuals', '8655660000', '81B Baker Street, London', '', 1011, 1001);
insert into patients values(1013, 'Aishwarya', 'aish@xyz.com', 'password', '01-01-1990', 'Female', 'Cholera', 'Dysentry', 'Healthy Individuals', '8655660000', '81B Baker Street, London', '', 1011, 1001);
insert into patients values(1028, 'Beth', 'beth@xyz.com', 'password', '01-01-1990', 'Female', 'Cholera', 'Dysentry', 'Healthy Individuals', '8655660000', '81B Baker Street, London', '', 1011, 1001);
insert into patients values(1029, 'Anna', 'anna@xyz.com', 'password', '01-01-1990', 'Female', 'Cholera', 'Dysentry', 'Healthy Individuals', '8655660000', '81B Baker Street, London', '', 1011, 1001);
insert into patients values(1011, 'Ravi', 'ravi@xyz.com', 'password', '01-01-1990', 'Male', 'Tetanus Toxoid', 'Fever', 'Healthy Individuals', '8655660000', '81B Baker Street, London', '', 1021, 1001);
insert into patients values(1012, 'Ayush', 'ayush@xyz.com', 'password', '01-01-1990', 'Male', 'Tetanus Toxoid', 'Fever', 'Healthy Individuals', '8655660000', '81B Baker Street, London', '', 1021, 1001);
insert into patients values(1014, 'Manish', 'manish@xyz.com', 'password', '01-01-1990', 'Male', 'Diphtheria', 'Dysentry', 'Healthy Individuals', '8655660000', '81B Baker Street, London', '', 1022, 1001);
insert into patients values(1016, 'Payal', 'payal@xyz.com', 'password', '01-01-1990', 'Female', 'Diphtheria', 'Dysentry', 'Healthy Individuals', '8655660000', '81B Baker Street, London', '', 1022, 1001);
insert into patients values(1015, 'Poulomi', 'poulomi@xyz.com', 'password', '01-01-1990', 'Female', 'Polio', 'Dysentry', 'Healthy Individuals', '8655660000', '81B Baker Street, London', '', 1023, 1001);
insert into patients values(1030, 'John', 'john@xyz.com', 'password', '01-01-1990', 'Male', 'Dengue', 'Cold and Fever', 'Healthy Individuals', '7856650000', 'LA City, USA', '', 1012, 1002);
insert into patients values(1017, 'Akarsh', 'akarsh@xyz.com', 'password', '01-01-1990', 'Male', 'Dengue', 'Cold and Fever', 'Healthy Individuals', '7856650000', 'LA City, USA', '', 1012, 1002);
insert into patients values(1018, 'Arun', 'arun@xyz.com', 'password', '01-01-1990', 'Male', 'Dengue', 'Cold and Fever', 'Healthy Individuals', '7856650000', 'LA City, USA', '', 1012, 1002);
insert into patients values(1019, 'Arman', 'arman@xyz.com', 'password', '01-01-1990', 'Male', 'Dengue', 'Cold and Fever', 'Healthy Individuals', '7856650000', 'LA City, USA', '', 1012, 1002);
insert into patients values(1020, 'Apal', 'apal@xyz.com', 'password', '01-01-1990', 'Male', 'Hepatitis A', 'Cold and Fever', 'Healthy Individuals', '7856650000', 'LA City, USA', '', 1025, 1002);
insert into patients values(1021, 'Mayuri', 'mayuri@xyz.com', 'password', '01-01-1990', 'Female', 'Hepatitis A', 'Cold and Fever', 'Healthy Individuals', '7856650000', 'LA City, USA', '', 1025, 1002);
insert into patients values(1022, 'Jenna', 'jenna@xyz.com', 'password', '01-01-1990', 'Male', 'Meningitis B', 'Cold and Fever', 'Healthy Individuals', '7856650000', 'LA City, USA', '', 1026, 1002);
insert into patients values(1003, 'Carry', 'carry@xyz.com', 'password', '01-01-1990', 'Male', 'Influenza', 'High Fever', 'Healthy Individuals', '3652590000', 'Elmo Street, Canada', '', 1013, 1003);
insert into patients values(1004, 'Ramesh', 'ramesh@xyz.com', 'password', '01-01-1990', 'Male', 'Rabies', 'Fever', 'Healthy Individuals', '5613650000', ' Mumbai, India', '', 1011, 1004);
insert into patients values(1005, 'Suresh', 'suresh@xyz.com', 'password', '01-01-1990', 'Male', 'Chickenpox', 'Fever', 'Healthy Individuals', '7816320000', 'Punjab, India', '', 1015, 1005);
insert into patients values(1006, 'Sonali', 'sonali@xyz.com', 'password', '01-01-1990', 'Female', 'Japanese Encephalitis', 'Loose Motion', 'Healthy Individuals', '7526650000', 'Delhi, India', '', 1016, 1006);
insert into patients values(1007, 'Manpreet', 'manpreet@xyz.com', 'password', '01-01-1990', 'Female', 'Measles', 'Fever', 'Healthy Individuals', '8961450000', 'Pune, India', '', 1017, 1007);
insert into patients values(1008, 'Sameer', 'sameer@xyz.com', 'password', '01-01-1990', 'Male', 'Q Fever', 'High Fever', 'Healthy Individuals', '9872350000', 'Haryana, India', '', 1018, 1008);
insert into patients values(1009, 'Vicky', 'vicky@xyz.com', 'password', '01-01-1990', 'Male', 'Tuberculosis', 'Lost Appetite', 'Healthy Individuals', '6587450000', ' Goa, India', '', 1019, 1009);
insert into patients values(1010, 'Rehan', 'rehan@xyz.com', 'password', '01-01-1990', 'Male', 'Typhoid Fever', 'High Fever', 'Healthy Individuals', '3142650000', 'Vizag, India',  '', 1020, 1010);
insert into patients values(1023, 'Aran', 'aran@xyz.com', 'password', '01-01-1990', 'Male', 'Cholera', 'Dysentry', 'Healthy Individuals', '8655660000', '81B Baker Street, London', '', 1011, 1001);
insert into patients values(1024, 'Manan', 'manan@xyz.com', 'password', '01-01-1990', 'Male', 'Cholera', 'Dysentry', 'Healthy Individuals', '8655660000', '81B Baker Street, London', '', 1011, 1001);
insert into patients values(1025, 'Rani', 'rani@xyz.com', 'password', '01-01-1990', 'Female', 'Cholera', 'Dysentry', 'Healthy Individuals', '8655660000', '81B Baker Street, London', '', 1011, 1001);
insert into patients values(1026, 'Roy', 'roy@xyz.com', 'password', '01-01-1990', 'Male', 'Cholera', 'Dysentry', 'Healthy Individuals', '8655660000', '81B Baker Street, London', '', 1011, 1001);
insert into patients values(1027, 'Raggerd', 'raggerd@xyz.com', 'password', '01-01-1990', 'Male', 'Tetanus Toxoid', 'Dysentry', 'Healthy Individuals', '8655660000', '81B Baker Street, London', '', 1011, 1001);


insert into reports values(1201, 'Pass', 'WBC Count Increased', 1001, 1011, 1001);
insert into reports values(1202, 'Fail', 'Reduced Appetite of Patient', 1002, 1012, 1003);
insert into reports values(1203, 'Pass', 'Haemoglobin Incresed', 1003, 1013, 1003);
insert into reports values(1204, 'Pass', 'Everything Normal', 1004, 1014, 1004);
insert into reports values(1205, 'Fail', 'Condition did not improve', 1005, 1015, 1005);
insert into reports values(1206, 'Pass', 'Patient feels better', 1001, 1011, 1001);
insert into reports values(1207, 'Fail', 'WBC count dangerously low', 1002, 1012, 1004);
insert into reports values(1208, 'Pass', 'Not Available', 1003, 1013, 1003);
insert into reports values(1209, 'Pass', 'Not Available', 1004, 1014, 1004);
insert into reports values(1210, 'Fail', 'Not Available', 1005, 1015, 1005);
insert into reports values(1211, 'Pass', 'Not Available', 1006, 1016, 1006);
insert into reports values(1212, 'Fail', 'Not Available', 1007, 1017, 1007);
insert into reports values(1213, 'Pass', 'Not Available', 1008, 1018, 1008);
insert into reports values(1214, 'Pass', 'Not Available', 1009, 1019, 1009);
insert into reports values(1215, 'Fail', 'Not Available', 1010, 1020, 1010);
insert into reports values(1216, 'Pass', 'Not Available', 1009, 1019, 1009);
insert into reports values(1217, 'Fail', 'Not Available', 1010, 1020, 1010);
insert into reports values(1218, 'Pass', 'Not Available', 1009, 1019, 1009);
insert into reports values(1219, 'Fail', 'Not Available', 1010, 1020, 1010);
insert into reports values(1220, 'Fail', 'Not Available', 1010, 1020, 1010);
