create table account (account_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), email varchar(255), mobile_number varchar(255), password varchar(255), user_name varchar(255), primary key (account_id)) engine=InnoDB;
create table account_role (account_role_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), role_name varchar(255), primary key (account_role_id)) engine=InnoDB;
create table admin (admin_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), admin_lastname varchar(255), admin_name varchar(255), account_id integer, university_id integer, primary key (admin_id)) engine=InnoDB;
create table application (created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), application_date datetime(6), student_id integer not null, offer_id varchar(255) not null, primary key (offer_id, student_id)) engine=InnoDB;
create table certificate_student (student_id integer not null, certificate_id integer not null, primary key (student_id, certificate_id)) engine=InnoDB;
create table company (company_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), address1 varchar(255), address2 varchar(255), city varchar(255), region varchar(255), zip_code integer not null, company_email varchar(255), company_name varchar(255), company_phone varchar(255), company_website varchar(255), legal_form_id integer, primary key (company_id)) engine=InnoDB;
create table company_domain (company_id integer not null, domain_id integer not null, primary key (company_id, domain_id)) engine=InnoDB;
create table company_legal_form (legal_form_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), legal_form_name varchar(255), primary key (legal_form_id)) engine=InnoDB;
create table company_responsible (responsible_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), last_name varchar(255), name varchar(255), position varchar(255), account_id integer, company_id integer, primary key (responsible_id)) engine=InnoDB;
create table diploma (diploma_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), diploma_name varchar(255), diploma_type_diploma_type_id integer, establishment_establishment_id integer, primary key (diploma_id)) engine=InnoDB;
create table diploma_speciality (diploma_id integer not null, speciality_id integer not null, primary key (diploma_id, speciality_id)) engine=InnoDB;
create table diploma_type (diploma_type_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), diplaoma_type_name varchar(255), diploma_abbreviation varchar(255), diploma_level integer not null, primary key (diploma_type_id)) engine=InnoDB;
create table domain (domain_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), domain_name varchar(255), primary key (domain_id)) engine=InnoDB;
create table establishment (establishment_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), establishment_email varchar(255), establishment_phone varchar(255), establishment_title varchar(255), establishment_web_site varchar(255), university_id integer, primary key (establishment_id)) engine=InnoDB;
create table experience_student (student_id integer not null, experience_id integer not null, primary key (student_id, experience_id)) engine=InnoDB;
create table hobby_student (student_id integer not null, hobby_id integer not null, primary key (student_id, hobby_id)) engine=InnoDB;
create table language_student (student_id integer not null, language_id integer not null, primary key (student_id, language_id)) engine=InnoDB;
create table licences_student (student_id integer not null, licence_id integer not null, primary key (student_id, licence_id)) engine=InnoDB;
create table offer (offer_id varchar(255) not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), description varchar(255), expiration_date datetime(6), assignment_city varchar(255), offer_name varchar(255), publication_date datetime(6), salary_max float(53) not null, salary_min float(53) not null, company_id integer, primary key (offer_id)) engine=InnoDB;
create table offer_diploma (offer_id varchar(255) not null, domain_id integer not null, diploma_type_id integer not null, language_id integer not null, primary key (offer_id, domain_id, diploma_type_id, language_id)) engine=InnoDB;
create table offer_type (offer_type_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), offer_type_name varchar(255), primary key (offer_type_id)) engine=InnoDB;
create table role_account_role (account_id integer not null, account_role_id integer not null, primary key (account_id, account_role_id)) engine=InnoDB;
create table skill_student (student_id integer not null, skill_id integer not null, primary key (student_id, skill_id)) engine=InnoDB;
create table speciality (speciality_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), speciality_name varchar(255), primary key (speciality_id)) engine=InnoDB;
create table student (student_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), address1 varchar(255), address2 varchar(255), city varchar(255), region varchar(255), zip_code integer not null, last_name varchar(255), name varchar(255), account_account_id integer, primary key (student_id)) engine=InnoDB;
create table student_certificate (certificate_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), certificate_name varchar(255), primary key (certificate_id)) engine=InnoDB;
create table student_diploma (created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), diploma_id integer not null, student_id integer not null, primary key (diploma_id, student_id)) engine=InnoDB;
create table student_experience (experience_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), end_date datetime(6), experience_description varchar(255), start_date datetime(6), primary key (experience_id)) engine=InnoDB;
create table student_hobby (hobby_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), hobbies_name varchar(255), primary key (hobby_id)) engine=InnoDB;
create table student_language (language_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), language_level varchar(255), language_name varchar(255), primary key (language_id)) engine=InnoDB;
create table student_licence (licence_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), licence_name varchar(255), primary key (licence_id)) engine=InnoDB;
create table student_skill (skill_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), skill_name varchar(255), primary key (skill_id)) engine=InnoDB;
create table university (university_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), address1 varchar(255), address2 varchar(255), city varchar(255), region varchar(255), zip_code integer not null, university_email varchar(255), university_phone varchar(255), university_title varchar(255), university_website varchar(255), primary key (university_id)) engine=InnoDB;
alter table admin add constraint FKn2eatyxq78i3wg18tt0jf56lw foreign key (account_id) references account (account_id);
alter table admin add constraint FKfxvtexdxtvf4jjl017d4pfaof foreign key (university_id) references university (university_id);
alter table application add constraint FKigm5jb0xdqnqjelaagm14dcva foreign key (student_id) references student (student_id);
alter table application add constraint FKj8aaepvdtl6nl8sm4oemi2grh foreign key (offer_id) references offer (offer_id);
alter table certificate_student add constraint FKl6jmsvmrecwhw7bhdbjvu95us foreign key (certificate_id) references student_certificate (certificate_id);
alter table certificate_student add constraint FKmpissrbilpm2ekuw0vd1xwbnk foreign key (student_id) references student (student_id);
alter table company add constraint FKgnenypo6qxn9rvwnhsi6m0e0j foreign key (legal_form_id) references company_legal_form (legal_form_id);
alter table company_domain add constraint FKgk2tbx99sf6p7h9tl5cawrshk foreign key (domain_id) references domain (domain_id);
alter table company_domain add constraint FK9p1kah122gjp7grogukw95em foreign key (company_id) references company (company_id);
alter table company_responsible add constraint FK9mvh2j446s853qcr4pk9kusjx foreign key (account_id) references account (account_id);
alter table company_responsible add constraint FKa940me8cdw462wenbdxeon1y5 foreign key (company_id) references company (company_id);
alter table diploma add constraint FK1wj6j06520vw2u10b077hb3q2 foreign key (diploma_type_diploma_type_id) references diploma_type (diploma_type_id);
alter table diploma add constraint FK7qx810a0jv5uc5yp6w0b09npy foreign key (establishment_establishment_id) references establishment (establishment_id);
alter table diploma_speciality add constraint FK63ocfq98tb0ef9k86m0bdpefo foreign key (speciality_id) references speciality (speciality_id);
alter table diploma_speciality add constraint FK1oetakd5lnm6x46jn99rlmgc3 foreign key (diploma_id) references diploma (diploma_id);
alter table establishment add constraint FKj8jd0bc98uf9r8jm3639tlvsn foreign key (university_id) references university (university_id);
alter table experience_student add constraint FK4sdvadwsry89nip5dh5enkn31 foreign key (experience_id) references student_experience (experience_id);
alter table experience_student add constraint FK7hyx6ijxoxxbwcicdjgbcpmt0 foreign key (student_id) references student (student_id);
alter table hobby_student add constraint FKqyd755d0ytlvpptccc84mtffj foreign key (hobby_id) references student_hobby (hobby_id);
alter table hobby_student add constraint FK994pj9xwsj8w9ji7y3ldyq1an foreign key (student_id) references student (student_id);
alter table language_student add constraint FK8hitqbgpc4g8n5ppscfljd1u8 foreign key (language_id) references student_language (language_id);
alter table language_student add constraint FKi6tmq00f6ka9xqon3mswgkdxm foreign key (student_id) references student (student_id);
alter table licences_student add constraint FKshfse612o02dqptna77pkctg2 foreign key (licence_id) references student_licence (licence_id);
alter table licences_student add constraint FKnpvvilpaqersulh51aayj5pok foreign key (student_id) references student (student_id);
alter table offer add constraint FKbmi8uq5jg84sgudvncfjbupw6 foreign key (company_id) references company (company_id);
alter table offer_diploma add constraint FKjsku4wx427uwhjgrrx37s029x foreign key (domain_id) references domain (domain_id);
alter table offer_diploma add constraint FKrbpawh7dk2r5kv9o9pylhusxj foreign key (offer_id) references offer (offer_id);
alter table offer_diploma add constraint FKpy53j0kkv1odc6o5h2oqd9i5w foreign key (diploma_type_id) references diploma_type (diploma_type_id);
alter table offer_diploma add constraint FK1qvbi0wc8f262lno5sm20y4f2 foreign key (language_id) references student_language (language_id);
alter table role_account_role add constraint FKsi9asx4t1ys6mflwkfir36hs0 foreign key (account_role_id) references account_role (account_role_id);
alter table role_account_role add constraint FK7f5ywkr3acm8ayy7gcqy99j0p foreign key (account_id) references account (account_id);
alter table skill_student add constraint FK9wn9an11ciykgyqd98rl7sri0 foreign key (skill_id) references student_skill (skill_id);
alter table skill_student add constraint FK3uk42tl8mnvef3rr19sbnwb3 foreign key (student_id) references student (student_id);
alter table student add constraint FKbyuwjlnmn45x6634hhu7t5qlk foreign key (account_account_id) references account (account_id);
alter table student_diploma add constraint FK86im2yuqm08s63mik2s4g5rjh foreign key (diploma_id) references diploma (diploma_id);
alter table student_diploma add constraint FKkfujpydocryew0aik87q4xb3u foreign key (student_id) references student (student_id);
create table account (account_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), email varchar(255), mobile_number varchar(255), password varchar(255), user_name varchar(255), primary key (account_id)) engine=InnoDB;
create table account_role (account_role_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), role_name varchar(255), primary key (account_role_id)) engine=InnoDB;
create table admin (admin_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), admin_lastname varchar(255), admin_name varchar(255), account_id integer, university_id integer, primary key (admin_id)) engine=InnoDB;
create table application (created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), application_date datetime(6), student_id integer not null, offer_id varchar(255) not null, primary key (offer_id, student_id)) engine=InnoDB;
create table certificate_student (student_id integer not null, certificate_id integer not null, primary key (student_id, certificate_id)) engine=InnoDB;
create table company (company_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), address1 varchar(255), address2 varchar(255), city varchar(255), region varchar(255), zip_code integer not null, company_email varchar(255), company_name varchar(255), company_phone varchar(255), company_website varchar(255), legal_form_id integer, primary key (company_id)) engine=InnoDB;
create table company_domain (company_id integer not null, domain_id integer not null, primary key (company_id, domain_id)) engine=InnoDB;
create table company_legal_form (legal_form_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), legal_form_name varchar(255), primary key (legal_form_id)) engine=InnoDB;
create table company_responsible (responsible_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), last_name varchar(255), name varchar(255), position varchar(255), account_id integer, company_id integer, primary key (responsible_id)) engine=InnoDB;
create table diploma (diploma_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), diploma_name varchar(255), diploma_type_diploma_type_id integer, establishment_establishment_id integer, primary key (diploma_id)) engine=InnoDB;
create table diploma_speciality (diploma_id integer not null, speciality_id integer not null, primary key (diploma_id, speciality_id)) engine=InnoDB;
create table diploma_type (diploma_type_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), diplaoma_type_name varchar(255), diploma_abbreviation varchar(255), diploma_level integer not null, primary key (diploma_type_id)) engine=InnoDB;
create table domain (domain_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), domain_name varchar(255), primary key (domain_id)) engine=InnoDB;
create table establishment (establishment_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), establishment_email varchar(255), establishment_phone varchar(255), establishment_title varchar(255), establishment_web_site varchar(255), university_id integer, primary key (establishment_id)) engine=InnoDB;
create table experience_student (student_id integer not null, experience_id integer not null, primary key (student_id, experience_id)) engine=InnoDB;
create table hobby_student (student_id integer not null, hobby_id integer not null, primary key (student_id, hobby_id)) engine=InnoDB;
create table language_student (student_id integer not null, language_id integer not null, primary key (student_id, language_id)) engine=InnoDB;
create table licences_student (student_id integer not null, licence_id integer not null, primary key (student_id, licence_id)) engine=InnoDB;
create table offer (offer_id varchar(255) not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), description varchar(255), expiration_date datetime(6), assignment_city varchar(255), offer_name varchar(255), publication_date datetime(6), salary_max float(53) not null, salary_min float(53) not null, company_id integer, primary key (offer_id)) engine=InnoDB;
create table offer_diploma (offer_id varchar(255) not null, domain_id integer not null, diploma_type_id integer not null, language_id integer not null, primary key (offer_id, domain_id, diploma_type_id, language_id)) engine=InnoDB;
create table offer_type (offer_type_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), offer_type_name varchar(255), primary key (offer_type_id)) engine=InnoDB;
create table role_account_role (account_id integer not null, account_role_id integer not null, primary key (account_id, account_role_id)) engine=InnoDB;
create table skill_student (student_id integer not null, skill_id integer not null, primary key (student_id, skill_id)) engine=InnoDB;
create table speciality (speciality_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), speciality_name varchar(255), primary key (speciality_id)) engine=InnoDB;
create table student (student_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), address1 varchar(255), address2 varchar(255), city varchar(255), region varchar(255), zip_code integer not null, last_name varchar(255), name varchar(255), account_account_id integer, primary key (student_id)) engine=InnoDB;
create table student_certificate (certificate_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), certificate_name varchar(255), primary key (certificate_id)) engine=InnoDB;
create table student_diploma (created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), diploma_id integer not null, student_id integer not null, primary key (diploma_id, student_id)) engine=InnoDB;
create table student_experience (experience_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), end_date datetime(6), experience_description varchar(255), start_date datetime(6), primary key (experience_id)) engine=InnoDB;
create table student_hobby (hobby_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), hobbies_name varchar(255), primary key (hobby_id)) engine=InnoDB;
create table student_language (language_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), language_level varchar(255), language_name varchar(255), primary key (language_id)) engine=InnoDB;
create table student_licence (licence_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), licence_name varchar(255), primary key (licence_id)) engine=InnoDB;
create table student_skill (skill_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), skill_name varchar(255), primary key (skill_id)) engine=InnoDB;
create table university (university_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), address1 varchar(255), address2 varchar(255), city varchar(255), region varchar(255), zip_code integer not null, university_email varchar(255), university_phone varchar(255), university_title varchar(255), university_website varchar(255), primary key (university_id)) engine=InnoDB;
alter table admin add constraint FKn2eatyxq78i3wg18tt0jf56lw foreign key (account_id) references account (account_id);
alter table admin add constraint FKfxvtexdxtvf4jjl017d4pfaof foreign key (university_id) references university (university_id);
alter table application add constraint FKigm5jb0xdqnqjelaagm14dcva foreign key (student_id) references student (student_id);
alter table application add constraint FKj8aaepvdtl6nl8sm4oemi2grh foreign key (offer_id) references offer (offer_id);
alter table certificate_student add constraint FKl6jmsvmrecwhw7bhdbjvu95us foreign key (certificate_id) references student_certificate (certificate_id);
alter table certificate_student add constraint FKmpissrbilpm2ekuw0vd1xwbnk foreign key (student_id) references student (student_id);
alter table company add constraint FKgnenypo6qxn9rvwnhsi6m0e0j foreign key (legal_form_id) references company_legal_form (legal_form_id);
alter table company_domain add constraint FKgk2tbx99sf6p7h9tl5cawrshk foreign key (domain_id) references domain (domain_id);
alter table company_domain add constraint FK9p1kah122gjp7grogukw95em foreign key (company_id) references company (company_id);
alter table company_responsible add constraint FK9mvh2j446s853qcr4pk9kusjx foreign key (account_id) references account (account_id);
alter table company_responsible add constraint FKa940me8cdw462wenbdxeon1y5 foreign key (company_id) references company (company_id);
alter table diploma add constraint FK1wj6j06520vw2u10b077hb3q2 foreign key (diploma_type_diploma_type_id) references diploma_type (diploma_type_id);
alter table diploma add constraint FK7qx810a0jv5uc5yp6w0b09npy foreign key (establishment_establishment_id) references establishment (establishment_id);
alter table diploma_speciality add constraint FK63ocfq98tb0ef9k86m0bdpefo foreign key (speciality_id) references speciality (speciality_id);
alter table diploma_speciality add constraint FK1oetakd5lnm6x46jn99rlmgc3 foreign key (diploma_id) references diploma (diploma_id);
alter table establishment add constraint FKj8jd0bc98uf9r8jm3639tlvsn foreign key (university_id) references university (university_id);
alter table experience_student add constraint FK4sdvadwsry89nip5dh5enkn31 foreign key (experience_id) references student_experience (experience_id);
alter table experience_student add constraint FK7hyx6ijxoxxbwcicdjgbcpmt0 foreign key (student_id) references student (student_id);
alter table hobby_student add constraint FKqyd755d0ytlvpptccc84mtffj foreign key (hobby_id) references student_hobby (hobby_id);
alter table hobby_student add constraint FK994pj9xwsj8w9ji7y3ldyq1an foreign key (student_id) references student (student_id);
alter table language_student add constraint FK8hitqbgpc4g8n5ppscfljd1u8 foreign key (language_id) references student_language (language_id);
alter table language_student add constraint FKi6tmq00f6ka9xqon3mswgkdxm foreign key (student_id) references student (student_id);
alter table licences_student add constraint FKshfse612o02dqptna77pkctg2 foreign key (licence_id) references student_licence (licence_id);
alter table licences_student add constraint FKnpvvilpaqersulh51aayj5pok foreign key (student_id) references student (student_id);
alter table offer add constraint FKbmi8uq5jg84sgudvncfjbupw6 foreign key (company_id) references company (company_id);
alter table offer_diploma add constraint FKjsku4wx427uwhjgrrx37s029x foreign key (domain_id) references domain (domain_id);
alter table offer_diploma add constraint FKrbpawh7dk2r5kv9o9pylhusxj foreign key (offer_id) references offer (offer_id);
alter table offer_diploma add constraint FKpy53j0kkv1odc6o5h2oqd9i5w foreign key (diploma_type_id) references diploma_type (diploma_type_id);
alter table offer_diploma add constraint FK1qvbi0wc8f262lno5sm20y4f2 foreign key (language_id) references student_language (language_id);
alter table role_account_role add constraint FKsi9asx4t1ys6mflwkfir36hs0 foreign key (account_role_id) references account_role (account_role_id);
alter table role_account_role add constraint FK7f5ywkr3acm8ayy7gcqy99j0p foreign key (account_id) references account (account_id);
alter table skill_student add constraint FK9wn9an11ciykgyqd98rl7sri0 foreign key (skill_id) references student_skill (skill_id);
alter table skill_student add constraint FK3uk42tl8mnvef3rr19sbnwb3 foreign key (student_id) references student (student_id);
alter table student add constraint FKbyuwjlnmn45x6634hhu7t5qlk foreign key (account_account_id) references account (account_id);
alter table student_diploma add constraint FK86im2yuqm08s63mik2s4g5rjh foreign key (diploma_id) references diploma (diploma_id);
alter table student_diploma add constraint FKkfujpydocryew0aik87q4xb3u foreign key (student_id) references student (student_id);
create table account (account_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), email varchar(255), mobile_number varchar(255), password varchar(255), user_name varchar(255), primary key (account_id)) engine=InnoDB;
create table account_role (account_role_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), role_name varchar(255), primary key (account_role_id)) engine=InnoDB;
create table admin (admin_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), admin_lastname varchar(255), admin_name varchar(255), account_id integer, university_id integer, primary key (admin_id)) engine=InnoDB;
create table application (created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), application_date datetime(6), student_id integer not null, offer_id varchar(255) not null, primary key (offer_id, student_id)) engine=InnoDB;
create table certificate_student (student_id integer not null, certificate_id integer not null, primary key (student_id, certificate_id)) engine=InnoDB;
create table company (company_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), address1 varchar(255), address2 varchar(255), city varchar(255), region varchar(255), zip_code integer not null, company_email varchar(255), company_name varchar(255), company_phone varchar(255), company_website varchar(255), legal_form_id integer, primary key (company_id)) engine=InnoDB;
create table company_domain (company_id integer not null, domain_id integer not null, primary key (company_id, domain_id)) engine=InnoDB;
create table company_legal_form (legal_form_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), legal_form_name varchar(255), primary key (legal_form_id)) engine=InnoDB;
create table company_responsible (responsible_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), last_name varchar(255), name varchar(255), position varchar(255), account_id integer, company_id integer, primary key (responsible_id)) engine=InnoDB;
create table diploma (diploma_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), diploma_name varchar(255), diploma_type_diploma_type_id integer, establishment_establishment_id integer, primary key (diploma_id)) engine=InnoDB;
create table diploma_speciality (diploma_id integer not null, speciality_id integer not null, primary key (diploma_id, speciality_id)) engine=InnoDB;
create table diploma_type (diploma_type_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), diplaoma_type_name varchar(255), diploma_abbreviation varchar(255), diploma_level integer not null, primary key (diploma_type_id)) engine=InnoDB;
create table domain (domain_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), domain_name varchar(255), primary key (domain_id)) engine=InnoDB;
create table establishment (establishment_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), establishment_email varchar(255), establishment_phone varchar(255), establishment_title varchar(255), establishment_web_site varchar(255), university_id integer, primary key (establishment_id)) engine=InnoDB;
create table experience_student (student_id integer not null, experience_id integer not null, primary key (student_id, experience_id)) engine=InnoDB;
create table hobby_student (student_id integer not null, hobby_id integer not null, primary key (student_id, hobby_id)) engine=InnoDB;
create table language_student (student_id integer not null, language_id integer not null, primary key (student_id, language_id)) engine=InnoDB;
create table licences_student (student_id integer not null, licence_id integer not null, primary key (student_id, licence_id)) engine=InnoDB;
create table offer (offer_id varchar(255) not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), description varchar(255), expiration_date datetime(6), assignment_city varchar(255), offer_name varchar(255), publication_date datetime(6), salary_max float(53) not null, salary_min float(53) not null, company_id integer, primary key (offer_id)) engine=InnoDB;
create table offer_diploma (offer_id varchar(255) not null, domain_id integer not null, diploma_type_id integer not null, language_id integer not null, primary key (offer_id, domain_id, diploma_type_id, language_id)) engine=InnoDB;
create table offer_type (offer_type_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), offer_type_name varchar(255), primary key (offer_type_id)) engine=InnoDB;
create table role_account_role (account_id integer not null, account_role_id integer not null, primary key (account_id, account_role_id)) engine=InnoDB;
create table skill_student (student_id integer not null, skill_id integer not null, primary key (student_id, skill_id)) engine=InnoDB;
create table speciality (speciality_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), speciality_name varchar(255), primary key (speciality_id)) engine=InnoDB;
create table student (student_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), address1 varchar(255), address2 varchar(255), city varchar(255), region varchar(255), zip_code integer not null, last_name varchar(255), name varchar(255), account_account_id integer, primary key (student_id)) engine=InnoDB;
create table student_certificate (certificate_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), certificate_name varchar(255), primary key (certificate_id)) engine=InnoDB;
create table student_diploma (created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), diploma_id integer not null, student_id integer not null, primary key (diploma_id, student_id)) engine=InnoDB;
create table student_experience (experience_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), end_date datetime(6), experience_description varchar(255), start_date datetime(6), primary key (experience_id)) engine=InnoDB;
create table student_hobby (hobby_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), hobbies_name varchar(255), primary key (hobby_id)) engine=InnoDB;
create table student_language (language_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), language_level varchar(255), language_name varchar(255), primary key (language_id)) engine=InnoDB;
create table student_licence (licence_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), licence_name varchar(255), primary key (licence_id)) engine=InnoDB;
create table student_skill (skill_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), skill_name varchar(255), primary key (skill_id)) engine=InnoDB;
create table university (university_id integer not null auto_increment, created_at datetime(6), created_by varchar(255), updated_at datetime(6), updated_by varchar(255), address1 varchar(255), address2 varchar(255), city varchar(255), region varchar(255), zip_code integer not null, university_email varchar(255), university_phone varchar(255), university_title varchar(255), university_website varchar(255), primary key (university_id)) engine=InnoDB;
alter table admin add constraint FKn2eatyxq78i3wg18tt0jf56lw foreign key (account_id) references account (account_id);
alter table admin add constraint FKfxvtexdxtvf4jjl017d4pfaof foreign key (university_id) references university (university_id);
alter table application add constraint FKigm5jb0xdqnqjelaagm14dcva foreign key (student_id) references student (student_id);
alter table application add constraint FKj8aaepvdtl6nl8sm4oemi2grh foreign key (offer_id) references offer (offer_id);
alter table certificate_student add constraint FKl6jmsvmrecwhw7bhdbjvu95us foreign key (certificate_id) references student_certificate (certificate_id);
alter table certificate_student add constraint FKmpissrbilpm2ekuw0vd1xwbnk foreign key (student_id) references student (student_id);
alter table company add constraint FKgnenypo6qxn9rvwnhsi6m0e0j foreign key (legal_form_id) references company_legal_form (legal_form_id);
alter table company_domain add constraint FKgk2tbx99sf6p7h9tl5cawrshk foreign key (domain_id) references domain (domain_id);
alter table company_domain add constraint FK9p1kah122gjp7grogukw95em foreign key (company_id) references company (company_id);
alter table company_responsible add constraint FK9mvh2j446s853qcr4pk9kusjx foreign key (account_id) references account (account_id);
alter table company_responsible add constraint FKa940me8cdw462wenbdxeon1y5 foreign key (company_id) references company (company_id);
alter table diploma add constraint FK1wj6j06520vw2u10b077hb3q2 foreign key (diploma_type_diploma_type_id) references diploma_type (diploma_type_id);
alter table diploma add constraint FK7qx810a0jv5uc5yp6w0b09npy foreign key (establishment_establishment_id) references establishment (establishment_id);
alter table diploma_speciality add constraint FK63ocfq98tb0ef9k86m0bdpefo foreign key (speciality_id) references speciality (speciality_id);
alter table diploma_speciality add constraint FK1oetakd5lnm6x46jn99rlmgc3 foreign key (diploma_id) references diploma (diploma_id);
alter table establishment add constraint FKj8jd0bc98uf9r8jm3639tlvsn foreign key (university_id) references university (university_id);
alter table experience_student add constraint FK4sdvadwsry89nip5dh5enkn31 foreign key (experience_id) references student_experience (experience_id);
alter table experience_student add constraint FK7hyx6ijxoxxbwcicdjgbcpmt0 foreign key (student_id) references student (student_id);
alter table hobby_student add constraint FKqyd755d0ytlvpptccc84mtffj foreign key (hobby_id) references student_hobby (hobby_id);
alter table hobby_student add constraint FK994pj9xwsj8w9ji7y3ldyq1an foreign key (student_id) references student (student_id);
alter table language_student add constraint FK8hitqbgpc4g8n5ppscfljd1u8 foreign key (language_id) references student_language (language_id);
alter table language_student add constraint FKi6tmq00f6ka9xqon3mswgkdxm foreign key (student_id) references student (student_id);
alter table licences_student add constraint FKshfse612o02dqptna77pkctg2 foreign key (licence_id) references student_licence (licence_id);
alter table licences_student add constraint FKnpvvilpaqersulh51aayj5pok foreign key (student_id) references student (student_id);
alter table offer add constraint FKbmi8uq5jg84sgudvncfjbupw6 foreign key (company_id) references company (company_id);
alter table offer_diploma add constraint FKjsku4wx427uwhjgrrx37s029x foreign key (domain_id) references domain (domain_id);
alter table offer_diploma add constraint FKrbpawh7dk2r5kv9o9pylhusxj foreign key (offer_id) references offer (offer_id);
alter table offer_diploma add constraint FKpy53j0kkv1odc6o5h2oqd9i5w foreign key (diploma_type_id) references diploma_type (diploma_type_id);
alter table offer_diploma add constraint FK1qvbi0wc8f262lno5sm20y4f2 foreign key (language_id) references student_language (language_id);
alter table role_account_role add constraint FKsi9asx4t1ys6mflwkfir36hs0 foreign key (account_role_id) references account_role (account_role_id);
alter table role_account_role add constraint FK7f5ywkr3acm8ayy7gcqy99j0p foreign key (account_id) references account (account_id);
alter table skill_student add constraint FK9wn9an11ciykgyqd98rl7sri0 foreign key (skill_id) references student_skill (skill_id);
alter table skill_student add constraint FK3uk42tl8mnvef3rr19sbnwb3 foreign key (student_id) references student (student_id);
alter table student add constraint FKbyuwjlnmn45x6634hhu7t5qlk foreign key (account_account_id) references account (account_id);
alter table student_diploma add constraint FK86im2yuqm08s63mik2s4g5rjh foreign key (diploma_id) references diploma (diploma_id);
alter table student_diploma add constraint FKkfujpydocryew0aik87q4xb3u foreign key (student_id) references student (student_id);
