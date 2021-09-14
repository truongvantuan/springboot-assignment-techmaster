drop table if exists customers;

create table customers
(
    id         int auto_increment primary key,
    first_name varchar(250) not null,
    last_name  varchar(250) not null,
    email      varchar(250) not null,
    phone      varchar(250) not null,
    job        varchar(250) not null
);

insert into customers (id, first_name, last_name, email, phone, job)
values (1, 'Estele', 'Dearell', 'edearell0@washingtonpost.com', '892-581-4762', 'Office Assistant IV');
insert into customers (id, first_name, last_name, email, phone, job)
values (2, 'Romeo', 'Rudgard', 'rrudgard1@shutterfly.com', '886-504-1261', 'Quality Engineer');
insert into customers (id, first_name, last_name, email, phone, job)
values (3, 'Tymon', 'Munton', 'tmunton2@slideshare.net', '274-139-2365', 'Associate Professor');
insert into customers (id, first_name, last_name, email, phone, job)
values (4, 'Claudia', 'Galle', 'cgalle3@google.com.au', '640-716-2147', 'Registered Nurse');
insert into customers (id, first_name, last_name, email, phone, job)
values (5, 'Dominick', 'Chese', 'dchese4@google.de', '210-257-9181', 'Analyst Programmer');
insert into customers (id, first_name, last_name, email, phone, job)
values (6, 'Caesar', 'Bootland', 'cbootland5@technorati.com', '227-924-9922', 'Engineer III');
insert into customers (id, first_name, last_name, email, phone, job)
values (7, 'Solomon', 'Lurner', 'slurner6@narod.ru', '716-597-5820', 'Financial Advisor');
insert into customers (id, first_name, last_name, email, phone, job)
values (8, 'Shaughn', 'Mansfield', 'smansfield7@ameblo.jp', '387-465-7637', 'Structural Engineer');
insert into customers (id, first_name, last_name, email, phone, job)
values (9, 'Anya', 'Aherne', 'aaherne8@prlog.org', '870-972-3423', 'Senior Editor');
insert into customers (id, first_name, last_name, email, phone, job)
values (10, 'Sully', 'Bain', 'sbain9@elegantthemes.com', '370-561-5196', 'Librarian');
insert into customers (id, first_name, last_name, email, phone, job)
values (11, 'Erma', 'Ivins', 'eivinsa@icq.com', '881-814-2357', 'Pharmacist');
insert into customers (id, first_name, last_name, email, phone, job)
values (12, 'Merry', 'Doley', 'mdoleyb@sciencedaily.com', '473-796-4994', 'Programmer III');
insert into customers (id, first_name, last_name, email, phone, job)
values (13, 'Dulcy', 'Roset', 'drosetc@sciencedirect.com', '245-115-9391', 'Director of Sales');
insert into customers (id, first_name, last_name, email, phone, job)
values (14, 'Erek', 'Bloyes', 'ebloyesd@bing.com', '352-467-1948', 'Geological Engineer');
insert into customers (id, first_name, last_name, email, phone, job)
values (15, 'Carolina', 'Braune', 'cbraunee@pagesperso-orange.fr', '386-425-9306', 'Clinical Specialist');
insert into customers (id, first_name, last_name, email, phone, job)
values (16, 'Merla', 'Busst', 'mbusstf@typepad.com', '354-325-9905', 'Pharmacist');
insert into customers (id, first_name, last_name, email, phone, job)
values (17, 'Bartlet', 'Billingham', 'bbillinghamg@slideshare.net', '787-681-9994', 'VP Product Management');
insert into customers (id, first_name, last_name, email, phone, job)
values (18, 'Alvie', 'Voller', 'avollerh@quantcast.com', '673-434-4429', 'Community Outreach Specialist');
insert into customers (id, first_name, last_name, email, phone, job)
values (19, 'Roseanna', 'Losty', 'rlostyi@dyndns.org', '801-442-2453', 'VP Marketing');
insert into customers (id, first_name, last_name, email, phone, job)
values (20, 'Raoul', 'Danick', 'rdanickj@paypal.com', '797-553-8795', 'Analyst Programmer');