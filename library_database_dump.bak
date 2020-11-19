--
-- PostgreSQL database dump
--

-- Dumped from database version 12.5 (Ubuntu 12.5-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.5 (Ubuntu 12.5-0ubuntu0.20.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: uuid-ossp; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;


--
-- Name: EXTENSION "uuid-ossp"; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: book; Type: TABLE; Schema: public; Owner: alex
--

CREATE TABLE public.book (
    bookid uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    title text,
    checkoutdate date,
    duedate date,
    format character varying(50),
    isadult boolean,
    readlevel character varying(2),
    author text,
    isbn character varying(17),
    checkedoutby character varying(12),
    genrecode character varying(3)
);


ALTER TABLE public.book OWNER TO alex;

--
-- Name: card; Type: TABLE; Schema: public; Owner: alex
--

CREATE TABLE public.card (
    cardnumber character varying(12) NOT NULL,
    pin integer NOT NULL,
    issuedate date
);


ALTER TABLE public.card OWNER TO alex;

--
-- Name: cardholder; Type: TABLE; Schema: public; Owner: alex
--

CREATE TABLE public.cardholder (
    cardholderid uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    name text,
    age integer,
    cardnumber character varying(12)
);


ALTER TABLE public.cardholder OWNER TO alex;

--
-- Name: genre; Type: TABLE; Schema: public; Owner: alex
--

CREATE TABLE public.genre (
    genrecode character varying(3) NOT NULL,
    type text
);


ALTER TABLE public.genre OWNER TO alex;

--
-- Name: movie; Type: TABLE; Schema: public; Owner: alex
--

CREATE TABLE public.movie (
    movieid uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    title text,
    checkoutdate date,
    duedate date,
    format character varying(50),
    isadult boolean,
    year integer,
    rating character varying(9),
    checkedoutby character varying(12),
    genrecode character varying(3)
);


ALTER TABLE public.movie OWNER TO alex;

--
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: alex
--

COPY public.book (bookid, title, checkoutdate, duedate, format, isadult, readlevel, author, isbn, checkedoutby, genrecode) FROM stdin;
f6be8d12-2a86-4682-9ec6-b84d863cee45	1984	\N	\N	Print	f	A	George Orwell	978-0451524935	\N	004
b90425d0-4555-446d-890f-badfcd297346	1984	\N	\N	Digital	f	A	George Orwell	978-0451524935	\N	004
154ae616-e0e0-4e21-84fe-24138c4ca157	1984	\N	\N	Audiobook	f	A	George Orwell	978-0451524935	\N	004
34b201b6-4a67-47a1-bc8e-e9f7c1b0e576	A Clash of Kings	\N	\N	Print	t	A	George R. R. Martin	978-1984821157	\N	000
a8558cfd-9bb3-44ef-84d5-a1ed3e55c42c	A Clash of Kings	\N	\N	Digital	t	A	George R. R. Martin	978-1984821157	\N	000
2822cb28-1511-40a1-9a1b-8aff844f79f2	A Dance with Dragons	\N	\N	Print	t	A	George R. R. Martin	978-0553385953	\N	000
0d578e2c-4927-4a52-9712-31234e6cb079	A Dance with Dragons	\N	\N	Digital	t	A	George R. R. Martin	978-0553385953	\N	000
998331dd-07fb-44bb-8674-e76949786c5c	A Discovery of Witches	\N	\N	Print	f	YA	Deborah Harkness	978-0755374045	\N	008
b17033f1-c0cc-4613-9813-9cfe993c0a38	A Discovery of Witches	\N	\N	Digital	f	YA	Deborah Harkness	978-0755374045	\N	008
adcefa09-326b-40b4-afc9-55c4d660bc2a	A Feast of Crows	\N	\N	Print	t	A	George R. R. Martin	978-0553801507	\N	000
99fca8da-23c8-4b3c-b265-df1d25f228ac	A Feast of Crows	\N	\N	Digital	t	A	George R. R. Martin	978-0553801507	\N	000
1326eb06-dbf5-4bf0-9209-f7e7004bdfe3	A Game of Thrones	\N	\N	Print	t	A	George R. R. Martin	978-0553808049	\N	000
67dc9a36-4b11-4b06-869b-ca3e9cdfa64a	A Game of Thrones	\N	\N	Digital	t	A	George R. R. Martin	978-0553808049	\N	000
e8697ede-17a2-4a54-91de-b8d119776895	A Storm of Swords	\N	\N	Print	t	A	George R. R. Martin	978-0593158951	\N	000
bb3693db-471a-4e93-98ab-8bf1916d7b26	A Storm of Swords	\N	\N	Digital	t	A	George R. R. Martin	978-0593158951	\N	000
9c0d72d3-6db2-4176-a9f4-03540100d7e2	Alice's Adevntures in Wonderlands Adevntures in Wonderland	\N	\N	Print	f	C	Lewis Carroll	978-1420952520	\N	000
f8ca24ef-71f4-438f-bb3a-05713b95645e	Alice's Adevntures in Wonderlands Adevntures in Wonderland	\N	\N	Digital	f	C	Lewis Carroll	978-1420952520	\N	000
0366ebcb-cc15-4936-a26a-3b0796db92b0	Atonement	2020-09-28	2020-10-12	Print	t	A	Ian McEwan	978-0385721790	812958120357	002
37113805-779d-4286-851a-af4bc5bd13f5	Atonement	\N	\N	Digital	t	A	Ian McEwan	978-0385721790	\N	002
181a080b-d6d0-4bb4-a2cb-ca8a84fef1f2	Because of Winn-Dixie	\N	\N	Print	f	C	Kate DiCamillo	978-0763680862	\N	023
3d7981ae-2890-410b-92d7-6f024e7c1ef4	Brave New World	\N	\N	Print	f	YA	Aldous Huxley	978-0060850524	\N	004
33a2d82a-f91f-4dcb-9efb-306d28666de6	Brave New World	\N	\N	Audiobook	f	YA	Aldous Huxley	978-0060850524	\N	004
31315c5a-f07e-42cc-a402-5a751e203752	Brave New World	\N	\N	Digital	f	YA	Aldous Huxley	978-0060850524	\N	004
bcacaf53-3d73-4c9e-985f-81cf1222b8a1	Carrying the Fire: An Astronaut's Journeys Journey	\N	\N	Print	f	A	Michael Collins	978-0374531942	\N	011
c97545eb-19ac-4609-9190-93797c1f611f	Carrying the Fire: An Astronaut's Journeys Journey	\N	\N	Audiobook	f	A	Michael Collins	978-0374531942	\N	011
63e419c9-b6c0-4a76-8c30-f584a7832756	Catching Fire	\N	\N	Print	f	YA	Suzanne Collins	978-0545586177	\N	004
6638688b-4510-4a30-8ae6-e1b4f508c358	Catching Fire	\N	\N	Digital	f	YA	Suzanne Collins	978-0545586177	\N	004
e101052d-07fa-4fcd-be51-8042068eceaf	Catching Fire	\N	\N	Audiobook	f	YA	Suzanne Collins	978-0545586177	\N	004
4f97630a-0f58-447c-820b-691ac91ec5ad	Charlotte's Webs Web	\N	\N	Digital	f	C	E. B. White	978-0061124952	\N	023
8eca4d8a-2706-4c10-977f-478e65faa0b9	Charlotte's Webs Web	\N	\N	Print	f	C	E. B. White	978-0061124952	\N	023
88a3bdb6-243b-4cb1-8be5-c284bf3ed17d	Divergent	\N	\N	Print	f	YA	Veronica Roth	978-0007420421	\N	004
cbbda852-18e3-428f-b7cf-329113699d33	Divergent	\N	\N	Digital	f	YA	Veronica Roth	978-0007420421	\N	004
771774d6-51ae-4840-95b6-b9f19c414cbd	Doctor De Soto	\N	\N	Print	f	C	William Steig 	978-0312611897	\N	023
59ee6468-7738-48c8-aac2-e3e7cfa9aa17	Doctor De Soto	\N	\N	Digital	f	C	William Steig 	978-0312611897	\N	023
c0ee3453-8b65-45ff-81ae-25174bd5bf1a	Dr Seuss's Sleep Books Sleep Book	\N	\N	Print	f	C	Dr. Seuss	978-0394800912	\N	023
c2f303f1-ab1f-4f2a-8caa-a3b829c3aeb5	Dr Seuss's Sleep Books Sleep Book	\N	\N	Digital	f	C	Dr. Seuss	978-0394800912	\N	023
bc98e081-eb20-4e3c-ac7f-79fdf03beb99	Each Peach Pear Plum	\N	\N	Audiobook	f	C	Janet and Allan ahlberg	978-0670882786	\N	023
9c6fe3bb-1d6f-49ea-8ac5-10784e39eace	Each Peach Pear Plum	\N	\N	Print	f	C	Janet and Allan ahlberg	978-0670882786	\N	023
bcca5221-831a-46f4-b749-9539f4dca29b	Emma	\N	\N	Print	f	A	Jane Austen	978-0141439587	\N	002
4585b752-646a-4875-9129-c80c9959d45d	Emma	\N	\N	Digital	f	A	Jane Austen	978-0141439587	\N	002
d58970ed-359d-464e-a1ce-f03589490a08	Fahrenheit 451	\N	\N	Digital	f	A	Ray Bradbury	978-1451673319	\N	004
53a3f3fd-137e-4fb9-9850-c655ae3ece6b	Fantastic Beasts and Where to Find Them	\N	\N	Print	f	YA	J. K. Rowling	978-1338132311	\N	000
7cc86966-0f41-4a74-bb53-81ca0eaf38d8	Fantastic Beasts and Where to Find Them	\N	\N	Digital	f	YA	J. K. Rowling	978-1338132311	\N	000
b92f66ea-f77e-4e75-ad62-429c3e02b0ae	Fantastic Beasts and Where to Find Them	\N	\N	Audiobook	f	YA	J. K. Rowling	978-1338132311	\N	000
6b351841-130d-44fd-b2cb-b78df83e9755	Fifty Shades of Grey	2020-10-12	2020-10-26	Audiobook	t	A	E. L. James	978-0099579939	762578252335	002
68c28378-c005-41de-aeb6-1347f2a7c0b0	Fifty Shades of Grey	\N	\N	Print	t	A	E. L. James	978-0099579939	\N	002
dff48ac7-93a1-4d26-be00-80cc5947a5b2	Flying to the Moon: An Astronaut's Storys Story	\N	\N	Print	f	A	Michael Collins	978-0374312022	\N	011
94fbfda0-d903-4cd8-9003-e23ce7628838	Flying to the Moon: An Astronaut's Storys Story	\N	\N	Audiobook	f	A	Michael Collins	978-0374312022	\N	011
49a2a87d-489f-4f93-aea1-c5d36a56d3cb	Forever Young: A Life of Adventure in Air and Space	\N	\N	Digital	f	A	John W. Young	978-0813049335	\N	011
ec97e015-cb57-4d01-b890-293752944160	Forever Young: A Life of Adventure in Air and Space	\N	\N	Audiobook	f	A	John W. Young	978-0813049335	\N	011
562b9488-1cc5-4634-9626-4a9dadec2dff	Gathering Blue	\N	\N	Print	f	YA	Lois Lowry	978-0547904146	\N	004
1921e680-841e-49ab-9548-b6f2b5ca351d	Gathering Blue	\N	\N	Digital	f	YA	Lois Lowry	978-0547904146	\N	004
39a4ff6d-e76c-4fbc-a059-96acbc169142	Gone Girl	2020-09-28	2020-10-12	Digital	t	A	Gillian Flynn 	978-0307588371	353889623571	007
833f995a-ac14-4adf-9409-39a36b5a8922	Gone Girl	\N	\N	Print	t	A	Gillian Flynn 	978-0307588371	\N	007
3bf818bf-0f2a-4e7d-9050-9c6e426efa2a	Green Eggs and Ham	\N	\N	Print	f	C	Dr. Seuss	978-0394800165	\N	023
e132a8c8-639e-43a8-82bb-106cb8d8c471	Green Eggs and Ham	\N	\N	Digital	f	C	Dr. Seuss	978-0394800165	\N	023
874215e7-4835-466f-b5f6-499c5118ede1	Harry Potter and the Chamber of Secrets	2020-09-28	2020-10-12	Digital	f	YA	J. K. Rowling	978-0439064873	566257542721	000
4aada41a-6826-453f-bb01-443f8552426f	Harry Potter and the Chamber of Secrets	\N	\N	Audiobook	f	YA	J. K. Rowling	978-0439064873	\N	000
4c425f03-c8d2-48f3-a98f-7bbfbf4405c4	Harry Potter and the Chamber of Secrets	\N	\N	Print	f	YA	J. K. Rowling	978-0439064873	\N	000
19aa2ac9-9ea7-4978-8a75-a24fa354338b	Harry Potter and the Deathly Hallows	\N	\N	Print	f	YA	J. K. Rowling	978-0545139700	\N	000
81e2f809-70d0-4961-8ff2-1e90bd9df7aa	Harry Potter and the Deathly Hallows	\N	\N	Digital	f	YA	J. K. Rowling	978-0545139700	\N	000
76270ced-8b8a-4394-8add-cfafaee998a3	Fahrenheit 451	2020-11-02	2020-11-16	Print	f	A	Ray Bradbury	978-1451673319	959027290311	004
09ef564e-00c8-4fc4-a082-9e4c9ec1c528	Because of Winn-Dixie	2020-11-19	2020-12-03	Digital	f	C	Kate DiCamillo	978-0763680862	959027290311	023
b3de17ae-1604-460f-aa3e-c4807c5a9c06	Harry Potter and the Goblet of Fire	\N	\N	Print	f	YA	J. K. Rowling	978-0439139601	\N	000
da029562-a2f3-4343-bdd2-e529a4b1169c	Harry Potter and the Goblet of Fire	\N	\N	Audiobook	f	YA	J. K. Rowling	978-0439139601	\N	000
12ece4d7-248c-4922-b3a4-27a2245a8316	Harry Potter and the Half-Blood Prince	\N	\N	Print	f	YA	J. K. Rowling	978-0439784542	\N	000
5b620537-8a4a-4b0d-ad96-ac144140045b	Harry Potter and the Half-Blood Prince	\N	\N	Digital	f	YA	J. K. Rowling	978-0439784542	\N	000
03757e64-86b9-49f6-a6be-0e8756948bdf	Harry Potter and the Half-Blood Prince	\N	\N	Audiobook	f	YA	J. K. Rowling	978-0439784542	\N	000
56dd0108-606c-430f-aba8-d9d5591ce672	Harry Potter and the Order of the Phoenix	\N	\N	Digital	f	YA	J. K. Rowling	978-0545582971	\N	000
9dc4d354-c66f-4765-beee-bb46ad53224f	Harry Potter and the Order of the Phoenix	\N	\N	Audiobook	f	YA	J. K. Rowling	978-0545582971	\N	000
f4c2759e-29a9-4b0a-9134-f792e2b0461d	Harry Potter and the Prisoner of Azkaban	2020-09-28	2020-10-12	Digital	f	YA	J. K. Rowling	978-0545582933	566257542721	000
88968a02-1e8b-4ffb-986a-5345e4377b68	Harry Potter and the Prisoner of Azkaban	\N	\N	Print	f	YA	J. K. Rowling	978-0545582933	\N	000
c464390c-73d6-4181-883e-dcac62720cd2	His Dark Materials: Northern Lights	\N	\N	Digital	f	YA	Philip Pullman	978-1407198705	\N	000
e6131385-2111-4cd0-8438-28556019d925	His Dark Materials: Northern Lights	\N	\N	Audiobook	f	YA	Philip Pullman	978-1407198705	\N	000
f3505428-8135-4346-bf1d-fc4c6b2a18d4	His Dark Materials: The Amber Spyglass	\N	\N	Print	f	YA	Philip Pullman	978-0440238157	\N	000
b23c8c58-2958-4ffa-a46a-9cf7c72b8e7f	His Dark Materials: The Amber Spyglass	\N	\N	Digital	f	YA	Philip Pullman	978-0440238157	\N	000
6f25fcf5-5b17-4448-bc4e-32a27b4dad57	His Dark Materials: The Amber Spyglass	\N	\N	Audiobook	f	YA	Philip Pullman	978-0440238157	\N	000
a46b554e-c738-44c7-af19-95a19b2911d9	His Dark Materials: The Subtle Knife	\N	\N	Print	f	YA	Philip Pullman	978-0345413369	\N	000
3b988f80-4e4a-4636-8d74-711fe5f2355f	His Dark Materials: The Subtle Knife	\N	\N	Digital	f	YA	Philip Pullman	978-0345413369	\N	000
e7bc371f-920e-4cab-aae7-f967b10cd922	His Dark Materials: The Subtle Knife	\N	\N	Audiobook	f	YA	Philip Pullman	978-0345413369	\N	000
035bb1be-f376-43b4-a39b-a5c986b873c6	IT	\N	\N	Digital	t	A	Stephen King	978-1473666948	\N	006
78d807d3-876a-48ee-9b2a-3db29e6ef026	IT	\N	\N	Print	t	A	Stephen King	978-1473666948	\N	006
58b79f1e-fbab-4125-a28e-fe4e94c77f1f	Life of Pi	2020-09-28	2020-10-12	Digital	f	YA	Yann Martel	978-0770430078	994373155987	001
676cbcf0-fe83-46ed-bf59-e3695f92f731	Life of Pi	\N	\N	Print	f	YA	Yann Martel	978-0770430078	\N	001
02f100f4-7a28-47a0-977a-8be526ba6586	Liftoff: The Story of America's Adevnture in Spaces Adevnture in Space	\N	\N	Print	f	A	Michael Collins	978-0802110114	\N	011
22e57bef-e2de-440d-8883-a2bffa8493af	Liftoff: The Story of America's Adevnture in Spaces Adevnture in Space	\N	\N	Audiobook	f	A	Michael Collins	978-0802110114	\N	011
48d89a48-0d3e-4168-84fd-3f943e83c667	Lord of the Flies	2020-09-28	2020-10-12	Print	f	YA	William Golding	978-0571191475	160316518797	007
b23edebb-f7ac-42fc-bcc5-a036bec84b2a	Lord of the Flies	\N	\N	Digital	f	YA	William Golding	978-0571191475	\N	007
eb8c8580-50b4-4bbc-9a36-5b66ba5f4c86	Mockingjay	\N	\N	Print	f	YA	Suzanne Collins	978-0545663267	\N	004
c351d207-2bbd-408f-bc98-ec5ffa7e92cb	Mockingjay	\N	\N	Digital	f	YA	Suzanne Collins	978-0545663267	\N	004
01d07551-4756-48b9-a290-9303fdf2fd76	Mockingjay	\N	\N	Audiobook	f	YA	Suzanne Collins	978-0545663267	\N	004
acf84fc4-f69c-4d99-bf1f-8dac96ec66b3	Mr. Putter & Tabby Walk the Dog	\N	\N	Digital	f	C	Cynthia Rylant	978-0152008918	\N	023
ce53bdf8-c33d-4962-a95b-ede0c3893e82	Mr. Putter & Tabby Walk the Dog	\N	\N	Print	f	C	Cynthia Rylant	978-0152008918	\N	023
f94c24cd-3e2e-41da-98b5-783e10d6aa28	Number the Stars	\N	\N	Print	f	C	Louis Lowry	978-0547577098	\N	023
678007f4-beec-4fe9-8950-6949f1357c70	Number the Stars	\N	\N	Digital	f	C	Louis Lowry	978-0547577098	\N	023
2723d917-7a41-496f-a483-8e9dda213759	Oh, the Places You'll Go!ll Go!	\N	\N	Print	f	C	Dr. Seuss	978-0679805274	\N	023
81ebcfe4-bded-4c9a-84a0-cd4de0e0ed4a	Oh, the Places You'll Go!ll Go!	\N	\N	Digital	f	C	Dr. Seuss	978-0679805274	\N	023
ad344da9-a964-4079-89d0-a7468457ceb7	One Flew Over the Cuckoo's Nests Nest	\N	\N	Print	t	A	Ken Kesey 	978-0451163967	\N	009
4ecb66b8-c581-4b42-929c-bd7c6ca8cd67	One Flew Over the Cuckoo's Nests Nest	\N	\N	Digital	t	A	Ken Kesey 	978-0451163967	\N	009
6e877e7d-0121-4e20-9876-10d9e486f44e	Out of the Silent Planet	\N	\N	Print	f	YA	C. S. Lewis	978-0743234900	\N	010
4df24bf9-4e20-432e-aec6-8364c349d726	Out of the Silent Planet	\N	\N	Digital	f	YA	C. S. Lewis	978-0743234900	\N	010
44fa0e31-c687-428c-be08-d1b9fe1faf81	Percy Jackson and the Olympians The Battle of the Labyrinth	\N	\N	Print	f	YA	Rick Riordan	978-1423101499	\N	000
485fb0ee-77f0-4809-bcd6-b3625121e4a1	Percy Jackson and the Olympians The Battle of the Labyrinth	\N	\N	Digital	f	YA	Rick Riordan	978-1423101499	\N	000
cfb28aaf-1ba9-44fc-b7c8-d25f72f55053	Percy Jackson and the Olympians The Battle of the Labyrinth	\N	\N	Digital	f	YA	Rick Riordan	978-1423101499	\N	000
ed49104a-094c-412c-80e2-7a986ddbbdb9	Percy Jackson and the Olympians The Last Olympian	\N	\N	Print	f	YA	Rick Riordan	978-1423101505	\N	000
95468429-87eb-41f1-ad91-f4f70f10e4e0	Percy Jackson and the Olympians The Last Olympian	\N	\N	Digital	f	YA	Rick Riordan	978-1423101505	\N	000
a9dc9e47-69c6-48af-9a79-d289cf97c5c2	Percy Jackson and the Olympians The Last Olympian	\N	\N	Digital	f	YA	Rick Riordan	978-1423101505	\N	000
552a6923-46d2-4b66-bc9a-99f4add03f69	Percy Jackson and the Olympians The Lightning Thief	\N	\N	Digital	f	YA	Rick Riordan	978-0786838653	\N	000
68ee3049-7b7a-4434-abbb-66af7f12d4a6	Percy Jackson and the Olympians The Lightning Thief	\N	\N	Digital	f	YA	Rick Riordan	978-0786838653	\N	000
a78af68e-aa73-4c22-ac87-ebca1e022d68	Percy Jackson and the Olympians The Sea of Monsters	\N	\N	Digital	f	YA	Rick Riordan	978-1423103349	\N	000
f47c01b9-20a2-412a-ab55-53596359db01	Percy Jackson and the Olympians The Sea of Monsters	\N	\N	Digital	f	YA	Rick Riordan	978-1423103349	\N	000
050bdc43-359f-450b-8219-f56746024846	Percy Jackson and the Olympians The Titan's Curses Curse	\N	\N	Print	f	YA	Rick Riordan	978-1423101482	\N	000
9def9a76-a682-4b49-a8c1-417ca8676257	Harry Potter and the Prisoner of Azkaban	2020-11-18	2020-12-02	Audiobook	f	YA	J. K. Rowling	978-0545582933	959027290311	000
7b33791e-2ae7-4a44-8c58-d84cf3a0979a	Harry Potter and the Order of the Phoenix	\N	\N	Print	f	YA	J. K. Rowling	978-0545582971	\N	000
d3c2a5ef-2fa5-4c71-b68a-6214a984cfc5	Harry Potter and the Deathly Hallows	2020-11-18	2020-12-02	Audiobook	f	YA	J. K. Rowling	978-0545139700	959027290311	000
c9ec54f0-818c-48ea-9113-8738c5f3fdd1	Percy Jackson and the Olympians The Lightning Thief	\N	\N	Print	f	YA	Rick Riordan	978-0786838653	\N	000
32f46bf9-9e70-417f-b086-f052895df572	Percy Jackson and the Olympians The Sea of Monsters	2020-11-18	2020-12-02	Print	f	YA	Rick Riordan	978-1423103349	959027290311	000
f5a1a629-8e0d-413c-b5b4-2c372bfca415	Harry Potter and the Goblet of Fire	\N	\N	Digital	f	YA	J. K. Rowling	978-0439139601	\N	000
c6ff5070-ebdb-4fc9-b433-b8f7e241e0fe	His Dark Materials: Northern Lights	2020-11-02	2020-11-16	Print	f	YA	Philip Pullman	978-1407198705	959027290311	000
f4d589f0-9c1f-4812-9430-8ac65320607a	Percy Jackson and the Olympians The Titan's Curses Curse	\N	\N	Digital	f	YA	Rick Riordan	978-1423101482	\N	000
686500ad-c3d5-4c56-8a5a-483e5992b534	Percy Jackson and the Olympians The Titan's Curses Curse	\N	\N	Digital	f	YA	Rick Riordan	978-1423101482	\N	000
ed30f8a2-e5af-4782-9bc5-df98747f104f	Perelandra	\N	\N	Print	f	YA	C. S. Lewis	978-0743234917	\N	010
ac61e397-e72c-421a-8c29-c24cdcaa370e	Perelandra	\N	\N	Digital	f	YA	C. S. Lewis	978-0743234917	\N	010
75f68743-1f4b-4c05-a3c9-c69129efb461	Peter Pan	\N	\N	Print	f	C	J. M. Barrie	978-0062362223	\N	000
9dc7ab80-7b44-4432-bec0-4c3e155f0f25	Peter Pan	\N	\N	Digital	f	C	J. M. Barrie	978-0062362223	\N	000
2de755e6-301e-4be9-8b87-147a1c38ca57	Pride and Prejudice	2020-10-12	2020-10-26	Digital	f	A	Jane Austen	979-8689704517	752387612667	002
ab012422-6f19-4e92-87d7-0615b05266df	Pride and Prejudice	\N	\N	Print	f	A	Jane Austen	979-8689704517	\N	002
912b91d9-d5cd-46ed-927b-25b61dbf55e1	Prince Caspian: The Return to Narnia	\N	\N	Print	f	YA	C. S. Lewis	978-0064471053	\N	000
e4fb37ea-0157-457e-a475-82424c15a08f	Prince Caspian: The Return to Narnia	\N	\N	Digital	f	YA	C. S. Lewis	978-0064471053	\N	000
971f72e6-3391-43d3-a4a0-d02f4bd519ae	Prince Caspian: The Return to Narnia	\N	\N	Audiobook	f	YA	C. S. Lewis	978-0064471053	\N	000
2a97005b-8484-4cca-936e-718e710294cc	Sense and Sensibility	\N	\N	Print	f	A	Jane Austen	978-1676583387	\N	002
acbefff9-1410-4a82-9bea-f0e870378b2f	Sense and Sensibility	\N	\N	Digital	f	A	Jane Austen	978-1676583387	\N	002
8a51bd6d-d89a-4f70-bfed-d63904f2dfdc	Thank you, Mr. Falker	\N	\N	Digital	f	C	Patricia Polacco	978-0399257629	\N	023
af173f21-6e04-422b-a5b7-92c8fc3d924c	Thank you, Mr. Falker	\N	\N	Print	f	C	Patricia Polacco	978-0399257629	\N	023
e8c16912-d345-42f5-aa05-03b55a9e5098	That Hideous Strength	\N	\N	Digital	f	YA	C. S. Lewis	978-0743234924	\N	010
ff9defae-21ef-42c7-aae2-0d81baa63230	The ABC Bunny	\N	\N	Digital	f	C	Wanda Gag	978-0816644162	\N	023
6cdaeb75-c805-4205-b19a-a5d682e092e0	The ABC Bunny	\N	\N	Print	f	C	Wanda Gag	978-0816644162	\N	023
d5b76c0c-30cb-4339-8f23-8ae104210f1e	The Autobiography of Benjamin Franklin	\N	\N	Print	f	A	Benjamin Franklin	978-1936594375	\N	011
5cf153ee-510d-4c8c-beb4-8aee90d87aa9	The Autobiography of Benjamin Franklin	\N	\N	Digital	f	A	Benjamin Franklin	978-1936594375	\N	011
15d1c034-4321-4ce8-9ce7-39e8dafd8641	The Ballad Of Songbirds And Snakes	\N	\N	Print	f	YA	Suzanne Collins	978-1338635171	\N	004
994ee38e-e241-4c46-8472-9b1a4dbfabac	The Ballad Of Songbirds And Snakes	\N	\N	Digital	f	YA	Suzanne Collins	978-1338635171	\N	004
28a1b24a-5637-4097-b5c7-6615841366b3	The Ballad Of Songbirds And Snakes	\N	\N	Audiobook	f	YA	Suzanne Collins	978-1338635171	\N	004
2043dd8b-f161-49b1-9a11-2dbaca58f093	The Book Thief	\N	\N	Print	f	YA	Markus Zusak	978-0375842207	\N	009
ddca2ff6-c3c9-417b-874f-3bc5f6fa75d1	The Book Thief	\N	\N	Digital	f	YA	Markus Zusak	978-0375842207	\N	009
144308dc-2ba5-4f9b-9514-81c03742a27d	The Boy in the Striped Pajamas	2020-10-10	2020-10-24	Digital	f	YA	John Boyne	978-0385751537	110382212241	009
9421b120-c0f3-4ddc-90d2-8c04154c5061	The Boy in the Striped Pajamas	\N	\N	Print	f	YA	John Boyne	978-0385751537	\N	009
b4af4c62-d850-4432-bc35-8ed46b0c1657	The Cat in the Hat	\N	\N	Print	f	C	Dr. Seuss	978-0375834929	\N	023
12e4da4b-db9c-47ed-bcbe-d8a164d940cf	The Cat in the Hat	\N	\N	Digital	f	C	Dr. Seuss	978-0375834929	\N	023
bb52bebb-290a-434b-85d8-7420184d35f7	The Catcher in the Rye	\N	\N	Audiobook	t	A	J. D. Salinger	978-0316769174	\N	003
53b4a132-080a-49b6-aa01-bff189dab27b	The Catcher in the Rye	\N	\N	Digital	t	A	J. D. Salinger	978-0316769174	\N	003
1f350a85-c60f-4f2e-a25c-5af8c5b41c32	The Da Vinci Code	2020-10-15	2020-10-29	Digital	f	A	Dan Brown	978-0307474278	368975792811	005
77722c85-67db-4a6b-b7f3-7530c8a28f86	The Da Vinci Code	\N	\N	Print	f	A	Dan Brown	978-0307474278	\N	005
f208ee61-1bfc-4bd7-85c0-70f6861c5eaa	The Diary of a Young Girl	2020-09-30	2020-10-14	Print	f	A	Anne Frank	978-0307594006	149322864602	011
946dc532-50a8-49af-b6e8-b2bb0e7f15bc	The Diary of a Young Girl	\N	\N	Digital	f	A	Anne Frank	978-0307594006	\N	011
8af96ce0-3bc9-4c17-909c-56f164712d56	The Giver	\N	\N	Print	f	YA	Lois Lowry	978-0544336261	\N	004
090dd2f5-2766-45e4-ba11-5e4d419e87f1	The Giver	\N	\N	Digital	f	YA	Lois Lowry	978-0544336261	\N	004
ba67fd6e-f46b-49c7-b6b6-ccba5b52bc26	The Great Gatsby	\N	\N	Print	f	A	F. Scott Firzgerald	978-0743273565	\N	003
5dcd8636-550d-4d15-86c1-2d19c1fc6283	The Great Gatsby	\N	\N	Digital	f	A	F. Scott Firzgerald	978-0743273565	\N	003
c42bbbd3-dfe6-4fff-9c40-a69dc04cdf89	The Gruffalo	\N	\N	Print	f	C	Julia Donaldson	978-0142403877	\N	023
9e2ade20-41d9-4539-bcff-d12e67c1afbf	The Gruffalo	\N	\N	Audiobook	f	C	Julia Donaldson	978-0142403877	\N	023
6de76afb-fa66-44e3-8f86-892f1419be47	The Hobbit	\N	\N	Print	f	YA	J. R. R. Tolkien	978-0547928227	\N	000
32628da9-93e4-491d-95d9-55fc10ca8065	The Hobbit	\N	\N	Digital	f	YA	J. R. R. Tolkien	978-0547928227	\N	000
318fe150-d913-4adc-94f7-0484a0553f93	The Hobbit	\N	\N	Audiobook	f	YA	J. R. R. Tolkien	978-0547928227	\N	000
6020ea30-4074-4996-a76b-8cebd1469372	The Horse and His Boy	\N	\N	Print	f	YA	C. S. Lewis	978-0064471060	\N	000
f2f18985-57c0-4f35-a8e3-00bdbf8a1893	The Horse and His Boy	\N	\N	Digital	f	YA	C. S. Lewis	978-0064471060	\N	000
36902b27-abdc-4406-bd34-1d73c7d50bc6	The Horse and His Boy	\N	\N	Audiobook	f	YA	C. S. Lewis	978-0064471060	\N	000
80934587-ed6a-4ec7-baeb-1d6991ba1af9	The Hunger Games	\N	\N	Print	f	YA	Suzanne Collins	978-0439023481	\N	004
6fa89dfa-2ac5-4bf5-8ead-fded66726f48	The Hunger Games	\N	\N	Digital	f	YA	Suzanne Collins	978-0439023481	\N	004
0752d8cb-d886-42ff-91f3-f2c881f4f293	The Hunger Games	\N	\N	Audiobook	f	YA	Suzanne Collins	978-0439023481	\N	004
ce87f71c-9829-4386-8fa6-139da3a898af	The Iliad	\N	\N	Print	f	A	Homer	978-1853262425	\N	000
2782ef37-0e76-44f6-9b2e-5e0ef8c754fc	The Iliad	\N	\N	Digital	f	A	Homer	978-1853262425	\N	000
97d74703-fa7b-4309-b914-181b7dcf573b	The Last Battle	\N	\N	Print	f	YA	C. S. Lewis	978-0064471084	\N	000
65b79ce8-ae64-4b08-9347-c45bd9452770	The Last Battle	\N	\N	Digital	f	YA	C. S. Lewis	978-0064471084	\N	000
d02d2af3-7de5-4b76-9f62-03c899e36e2e	The Last Battle	\N	\N	Audiobook	f	YA	C. S. Lewis	978-0064471084	\N	000
fe407b82-4283-4050-b924-c674b4f36da7	The Lion, the Witch and the Wardrobe	2020-10-14	2020-10-28	Print	f	YA	C. S. Lewis	978-0064409421	299045933849	000
8a8086a8-5e53-4463-b622-90b6b39e0383	The Lion, the Witch and the Wardrobe	\N	\N	Digital	f	YA	C. S. Lewis	978-0064409421	\N	000
6a8ad3ee-8ee4-473f-aab1-ed9913838ff9	The Little Mermaid	\N	\N	Print	f	C	Hans Christian Andersen 	978-0615963945	\N	000
f8d4aac9-abb7-42a4-991b-94418d520b90	The Little Mermaid	\N	\N	Digital	f	C	Hans Christian Andersen 	978-0615963945	\N	000
b8b6d179-ba68-4279-baac-0b9fd135ce2b	The Lorax	\N	\N	Print	f	C	Dr. Seuss	978-0394823379	\N	023
7e0093ea-ec27-4a1f-8051-1469a32817cb	The Lorax	\N	\N	Digital	f	C	Dr. Seuss	978-0394823379	\N	023
77720021-a3d7-4242-ae51-23816404ee71	The Lord of the Rings The Fellowship of the Ring	\N	\N	Print	f	YA	J. R. R. Tolkien	978-0544003415	\N	000
7a5fd390-d7ca-45c0-a440-fbb8dc3320b6	The Lord of the Rings The Fellowship of the Ring	\N	\N	Digital	f	YA	J. R. R. Tolkien	978-0544003415	\N	000
fc6d1a6c-b22d-496f-8575-28c1143c0976	The Lord of the Rings The Fellowship of the Ring	\N	\N	Audiobook	f	YA	J. R. R. Tolkien	978-0544003415	\N	000
e9b23af7-26da-4535-9a9d-75ecbf3f9eba	The Lord of the Rings The Return of the King	\N	\N	Print	f	YA	J. R. R. Tolkien	978-0345339737	\N	000
274569be-a0c7-41dc-977b-63003cb6f80d	The Lord of the Rings The Return of the King	\N	\N	Digital	f	YA	J. R. R. Tolkien	978-0345339737	\N	000
8c97eeb9-a108-4399-b3c7-bb841fd37ed0	The Lord of the Rings The Return of the King	\N	\N	Audiobook	f	YA	J. R. R. Tolkien	978-0345339737	\N	000
4cfc85c0-83c7-4634-9570-833429520a43	The Lord of the Rings The Two Towers	\N	\N	Print	f	YA	J. R. R. Tolkien	978-0618002238	\N	000
78ea5a11-4519-4d40-b376-98d597e53ba3	The Lord of the Rings The Two Towers	\N	\N	Digital	f	YA	J. R. R. Tolkien	978-0618002238	\N	000
8c20dca6-7830-42c6-8a3b-43861bd4941f	The Lord of the Rings The Two Towers	\N	\N	Audiobook	f	YA	J. R. R. Tolkien	978-0618002238	\N	000
2518d22b-911d-497a-afc0-76f7c9ea6aed	The Magician's Nephews Nephew	\N	\N	Digital	f	YA	C. S. Lewis	978-0064405058	\N	000
cbdbf305-d502-4a4c-a0ed-6f47cc947142	The Magician's Nephews Nephew	\N	\N	Audiobook	f	YA	C. S. Lewis	978-0064405058	\N	000
f2db1324-b744-4251-808e-75a704efb906	The Mitten	\N	\N	Print	f	C	Jan Brett	978-0399231094	\N	023
9efabf3c-9954-469f-bac7-38ea9c0e3009	The Mitten	\N	\N	Audiobook	f	C	Jan Brett	978-0399231094	\N	023
cce7bcd2-7d5c-45b5-a8ce-343fefb631c1	The Night Before Christmas	\N	\N	Print	f	C	Jan Brett	978-1984816825	\N	023
1058d299-0905-4ee1-9900-c98fc765b2f5	The Night Before Christmas	\N	\N	Digital	f	C	Jan Brett	978-1984816825	\N	023
3b210cac-f95c-4833-ba12-650986051c1e	The Odyssey	\N	\N	Audiobook	f	A	Homer	978-1500200145	\N	000
5d2efbbe-f13c-435f-89f4-b37ab3a56981	The Odyssey	\N	\N	Print	f	A	Homer	978-1500200145	\N	000
8b1c50f0-ce84-4662-82f9-26d0d710515c	The Only Skill That Matters 	\N	\N	Audiobook	f	A	Jonathan A. Levi	978-1544504346	\N	016
85edff8c-e302-4dd3-9ef4-30b4355121f6	The Only Skill That Matters 	\N	\N	Print	f	A	Jonathan A. Levi	978-1544504346	\N	016
98b527c1-7204-4aa1-8bec-081679f10669	The Silver Chair	\N	\N	Print	f	YA	C. S. Lewis	978-0064471091	\N	000
fa2b84d0-6a95-4c41-822e-9757d184515d	The Silver Chair	\N	\N	Digital	f	YA	C. S. Lewis	978-0064471091	\N	000
4302fc30-6a9e-450c-a37d-43d82f360a48	The Silver Chair	\N	\N	Audiobook	f	YA	C. S. Lewis	978-0064471091	\N	000
26f379ab-14c2-4a86-8d5a-32dd6b9215fd	The Snow Queen 	\N	\N	Print	f	C	Hans Christian Andersen 	978-0615934013	\N	000
be1d90ae-0e7a-49cc-a213-261e243d70db	The Snow Queen 	\N	\N	Digital	f	C	Hans Christian Andersen 	978-0615934013	\N	000
ed16f292-720a-45ab-b6a4-48522dd12261	The Voyage of the Dawn Treader	\N	\N	Print	f	YA	C. S. Lewis	978-0064405027	\N	000
7e938984-d37c-4532-b837-7bc30392e1f3	The Voyage of the Dawn Treader	\N	\N	Digital	f	YA	C. S. Lewis	978-0064405027	\N	000
e6684609-750d-49d7-9c24-1604dac2f42a	The Voyage of the Dawn Treader	\N	\N	Audiobook	f	YA	C. S. Lewis	978-0064405027	\N	000
07625a30-59a9-4c4d-bbbc-b33b8c7aa1f6	Through the Looking-Glass	\N	\N	Print	f	C	Lewis Carroll	978-1951570026	\N	000
05ff58e5-9f8f-4b47-9cc3-184428f12a20	Through the Looking-Glass	\N	\N	Digital	f	C	Lewis Carroll	978-1951570026	\N	000
baaeb29b-dd00-4d38-980b-4287a9428220	Thumbelina	\N	\N	Print	f	C	Hans Christian Andersen 	978-0803728127	\N	000
f07cc5c1-0579-4be4-bb6d-8706f9c7caa9	To Kill a Mockingbird	2020-09-29	2020-10-13	Print	t	A	Harper Lee	978-0060935467	486437364595	005
2222ef95-07d8-44dc-9428-226dfca7b853	Town Mouse, Country Mouse	\N	\N	Print	f	C	Jan Brett	978-0698119864	\N	023
ed41de04-758b-4fa3-bb99-990b42ed7f99	Town Mouse, Country Mouse	\N	\N	Digital	f	C	Jan Brett	978-0698119864	\N	023
b38379d6-6c18-4654-8e79-b457c8384217	Water for Elephants	2020-09-30	2020-10-14	Audiobook	t	A	Sara Gruen	978-1565125605	286743336269	002
d35719e4-8a79-4db4-be13-37959a177ffd	Water for Elephants	\N	\N	Print	t	A	Sara Gruen	978-1565125605	\N	002
e3b98743-3477-4084-b5e8-51465155dd31	We Seven	\N	\N	Print	f	A	Malcolm Carpenter, Leroy Cooper, John Glenn, Virgil Grissom, Walter Schirra, Donald Slayton, Alan Shepard	978-1439181034	\N	011
5e07e1be-6972-4000-826f-c8d8809f65fc	We Seven	\N	\N	Audiobook	f	A	Malcolm Carpenter, Leroy Cooper, John Glenn, Virgil Grissom, Walter Schirra, Donald Slayton, Alan Shepard	978-1439181034	\N	011
54e09397-3236-4c72-bfde-d5ea8332a135	Yard Sale!	\N	\N	Print	f	C	Mitra Modarressi	978-0789426512	\N	023
0544cbec-e0b1-4048-ad28-bd78eba49765	Yard Sale!	\N	\N	Digital	f	C	Mitra Modarressi	978-0789426512	\N	023
49e49c9b-bc93-4b0f-9ce8-b82fc56467c5	Harry Potter and the Sorcerer's Stone	2020-09-28	2020-10-12	Digital	f	YA	J. K. Rowling	978-0590353403	566257542721	000
33ee231c-135d-4183-b7d5-9f8705d0139d	Harry Potter and the Sorcerer's Stone	\N	\N	Audiobook	f	YA	J. K. Rowling	978-0590353403	\N	000
f7c6827e-3059-4f2c-8da2-fb696cb5f0b6	Harry Potter and the Sorcerer's Stone	\N	\N	Print	f	YA	J. K. Rowling	978-0590353403	\N	000
c67eb2e5-afd6-4098-b4d4-1eee8c423746	That Hideous Strength	2020-11-18	2020-12-02	Print	f	YA	C. S. Lewis	978-0743234924	959027290311	010
057b79ca-219e-4ca6-8896-e4d8ac41e379	Thumbelina	2020-11-18	2020-12-02	Digital	f	C	Hans Christian Andersen 	978-0803728127	959027290311	000
da01c4fb-166f-4496-8502-2722873d9cb7	Forever Young: A Life of Adventure in Air and Space	2020-11-18	2020-12-02	Print	f	A	John W. Young	978-0813049335	959027290311	011
ad20e8ba-3375-48dc-b921-1240241e95ac	To Kill a Mockingbird	\N	\N	Audiobook	t	A	Harper Lee	978-0060935467	\N	005
6c25bb5c-23a9-4b9c-b30e-686f49bb467b	The Magician's Nephews Nephew	\N	\N	Print	f	YA	C. S. Lewis	978-0064405058	\N	000
\.


--
-- Data for Name: card; Type: TABLE DATA; Schema: public; Owner: alex
--

COPY public.card (cardnumber, pin, issuedate) FROM stdin;
299045933849	8538	2020-10-01
110382212241	7551	2020-10-01
994373155987	1314	2020-10-01
368975792811	2289	2020-10-01
286743336269	2073	2020-10-01
771778925963	2821	2020-10-01
812958120357	3991	2020-10-01
353889623571	4817	2020-10-01
160316518797	6757	2020-10-02
486437364595	9077	2020-10-02
566257542721	9974	2020-10-02
762578252335	7595	2020-10-02
752387612667	6400	2020-10-02
149322864602	6284	2020-10-03
260344226465	4616	2020-10-03
574694081039	7436	2020-10-03
923876375725	2278	2020-10-03
294051144258	2057	2020-10-03
195290944622	3735	2020-10-03
724098502382	3440	2020-10-03
512788314000	2179	2020-10-05
271663253611	5258	2020-10-05
764599915380	9450	2020-10-06
663985373059	1760	2020-10-06
279893236088	5351	2020-10-06
111716443036	2972	2020-10-06
515961176864	9816	2020-10-06
567079489285	7534	2020-10-07
364679918460	1454	2020-10-07
145388045885	5511	2020-10-07
235850484904	8510	2020-10-07
529722053648	3354	2020-10-07
745479371791	1990	2020-10-09
322607473387	8731	2020-10-09
147262325924	9772	2020-10-09
501558874620	5040	2020-10-09
924918549341	7620	2020-10-10
218252010014	1708	2020-10-10
505764121174	5184	2020-10-12
840511653743	7935	2020-10-12
926059285960	7567	2020-10-12
274620608892	5830	2020-10-12
318528146649	6652	2020-10-12
802245904190	3847	2020-10-13
134634083644	7423	2020-10-14
223916955609	3951	2020-10-14
850496078081	4661	2020-10-14
434194677188	1674	2020-10-15
342777204451	6939	2020-10-15
241371158010	7422	2020-10-15
768112170789	1234	2020-11-17
959027290311	1234	2020-11-17
964147093980	1234	2020-11-19
\.


--
-- Data for Name: cardholder; Type: TABLE DATA; Schema: public; Owner: alex
--

COPY public.cardholder (cardholderid, name, age, cardnumber) FROM stdin;
58827de4-2584-4c5f-90f4-ab61a0869067	John Smith	73	299045933849
a05ea380-dc2c-4174-a34f-4c44a72913db	Robert Johnson	67	110382212241
60450705-f8f1-40e7-aa8e-acc02bbfbb46	Michael Williams	15	994373155987
b5a9240f-dae1-4c11-b6b8-8a8cb4b2f222	William Brown	21	368975792811
05bc8bdd-d4b8-41ee-8945-9d9f7f2f1d71	Lisa Jones	14	286743336269
100bdaf4-26a3-4d36-bc9f-948eb64352db	Richard Miller	10	771778925963
ca4bbe91-9f4d-48cd-ae4b-eaab81d8fba7	Courtney Davis	21	812958120357
81aac583-b5a1-4f20-96c0-38ae2e6d749b	John Smith	16	353889623571
ab372749-2229-4fe8-9595-4da972d348cc	Charles Rodriguez	26	160316518797
df9103e7-d516-46d7-9c0e-64f07d7d32d5	Mark Wilson	8	486437364595
9eca901b-8b2d-4a5c-ab4b-afbbb542317f	Paulina Martinez	20	566257542721
eb90df2e-f309-4b9b-a961-955e13baa6f6	Lisa  Anderson	50	762578252335
6e0a7b9b-85fd-49b7-bcde-91b457ca84dd	Monica Taylor	10	752387612667
0cce7576-58a0-4651-9180-fdff4aea2128	Kenneth Thomas	23	149322864602
6e961590-dba9-49f2-8c9b-dee1643e08a7	Joshua Hernandez	18	260344226465
75913734-e838-4eb2-9a9a-6f53ee5f1a4e	Kevin Moore	16	574694081039
6f7cb917-89ac-44eb-bed8-365a3b5bf555	Brian Martin	22	923876375725
91275fae-1cbe-4551-a97e-e3fcdc9e2244	George Jackson	30	294051144258
79e3841a-e6b6-4f87-b500-28b2486c14b1	Stephanie Turner	15	195290944622
ecaef4ce-607f-49b9-aed0-749b39ff7184	Ronald White	19	724098502382
b86cb542-0c92-417c-b6e2-a621e0cbed1a	Timothy Lopez	19	512788314000
fd5ea2fa-5366-4289-a71c-a6cec73f758f	Jason Lee	25	271663253611
a4989bb1-394d-4752-8abd-7b663c26f752	Jeffrey Gonzalez	15	764599915380
7fcc55f5-1ebc-47e5-b186-e2ed213cf20f	Alex Harris	8	663985373059
3f17c805-6690-49a3-9ac6-befd03c63dfe	Lisa Clark	28	279893236088
ae799781-6994-4804-97cc-233704c8795b	Jennifer Lewis	20	111716443036
77a71496-eee6-43a0-a46f-fce5b14ba91a	Linda Robinson	30	515961176864
d7bada6b-f43e-4585-8f90-77a4e843ca6c	Elizabeth Walker	29	567079489285
0aefb577-d272-4777-888b-a8ea877ebe17	Barbara Perez	6	364679918460
7ce3e92f-629c-480e-ae8e-db1bf392af8c	Susan Hall	30	145388045885
49772964-307e-4e99-8cea-00ca5f2d5703	John Young	12	235850484904
a75c2668-3dd0-470d-a1bd-1fcd2831aa2b	Sarah Allen	25	529722053648
533ce374-e921-489a-bb1a-0eb94d4ba731	Stephanie Turner	9	745479371791
a4efeeda-eebe-4780-8da7-f967520931e3	Nancy Wright	23	322607473387
48acc181-4a99-49d0-842b-5fe910f15eca	Lisa King	24	147262325924
f576114e-6c91-4d51-b8aa-5af63bbf81aa	Margaret Scott	30	501558874620
56517f1a-681d-4823-aec3-a947c44b93d8	Sarah Allen	21	924918549341
98ab3496-9355-4158-a93e-09e8dda690b9	Sandra Baker	29	218252010014
b9d6d51d-eb9d-4429-95e8-bd6dff9a517b	Ashley Adams	19	505764121174
cd9a12b8-a1e5-43ad-8304-74314c731a4e	Dorothy Nelson	6	840511653743
0ea485ca-aabd-4ffb-bf98-aaeb2b4f6f54	Kimberly Hill	9	926059285960
898b0d3e-1ccf-4833-a76f-cef891cefd42	Sarah Allen	30	274620608892
7b5a0a3f-9c01-4d11-93a5-0315790f5cc5	John Campbell	27	318528146649
71520a59-c2bf-4b40-bbdb-cc09a5c7fa1a	Michelle Mitchell	26	802245904190
8f620884-d9a3-4067-96be-b2232e9331dc	Lisa Roberts	89	134634083644
5c87ddcb-0713-4e48-87e7-cd1ae1934030	Amanda Carter	12	223916955609
db3786c7-755b-4a12-9bff-db0364992dcb	Eduardo Vidal	24	850496078081
5786fe32-8738-4496-8c11-3f59756879dd	Deborah Evans	25	434194677188
5a4fdaca-ebe2-4ba5-bb70-93c414b8fe8d	Stephanie Turner	17	342777204451
d7e749c5-7f2f-46d6-90b6-2ab967217f8f	John Smith	5	241371158010
a9b84b45-7bb6-44a3-b083-2b5c408c4614	Alex Bauman	21	959027290311
37ef0957-a0ea-4b77-8e4f-d53ed98f4f3c	Test Account	15	964147093980
\.


--
-- Data for Name: genre; Type: TABLE DATA; Schema: public; Owner: alex
--

COPY public.genre (genrecode, type) FROM stdin;
000	Fantasy
001	Adventure
002	Romance
003	Contemporary
004	Dystopian
005	Mystery
006	Horror
007	Thriller
008	Paranormal
009	Historical fiction
010	Science Fiction
011	Memoir
012	Cooking
013	Art
014	Self-help / Personal
015	Development
016	Motivational
017	Health
018	History
019	Travel
020	Guide / How-to
021	Families & Relationships
022	Humor
023	Children’s
024	Non-fiction
100	Action
101	Adventure
102	Animation
103	Biography
104	Comedy
105	Crime
106	Documentary
107	Drama
108	Family
109	Fantasy
110	Film Noir
111	History
112	Horror
113	Music
114	Musical
115	Mystery
116	Romance
117	Sci-Fi
118	Short
119	Sport
120	Superhero
121	Thriller
122	War
123	Western
\.


--
-- Data for Name: movie; Type: TABLE DATA; Schema: public; Owner: alex
--

COPY public.movie (movieid, title, checkoutdate, duedate, format, isadult, year, rating, checkedoutby, genrecode) FROM stdin;
90a00c6e-9d35-4ddc-a92f-bfca7ee281e9	A Beautiful Mind	\N	\N	DVD	f	2001	PG-13	\N	107
f3a161fe-d3b2-4d36-b62b-024bb373c285	A Beautiful Mind	\N	\N	Blu-ray	f	2001	PG-13	\N	107
d71a3522-61af-4523-a2fd-b3ecb7d7ac0e	A Hard Day's Nights Night	\N	\N	DVD	f	1964	G	\N	113
992f2ce9-10d8-40f2-944e-724837d348d4	A Hard Day's Nights Night	\N	\N	Blu-ray	f	1964	G	\N	113
723dc8b2-261e-41f7-8174-bddfee0058b4	Alien	2020-09-28	2020-10-12	Blu-ray	t	1979	R	566257542721	117
f929885b-c176-41c1-bcfb-747595c3847c	Alien	\N	\N	DVD	t	1979	R	\N	117
7f5cf941-181a-4dfc-aaf5-71d20a09c3b6	Alien: Covenant	\N	\N	DVD	t	2017	R	\N	117
51c65c3d-c070-4d49-8074-1abdd5fd9d24	Alien: Covenant	\N	\N	Blu-ray	t	2017	R	\N	117
d94ccfb1-361b-4507-8383-10be65042848	Alien: Covenant	\N	\N	Digital	t	2017	R	\N	117
8891e6b6-9e02-4890-9467-b0b2f8d3986a	Aliens	\N	\N	DVD	t	1986	R	\N	117
e5ff9874-cf59-4fe6-9202-39d59d0b7ca2	Aliens	\N	\N	Blu-ray	t	1986	R	\N	117
1dfa9753-9513-42e4-921d-0f486ddd2ea9	All Quiet on the Western Front	\N	\N	DVD	f	1930	Not Rated	\N	122
13344437-5703-4024-ac2d-df32f04cee3b	All Quiet on the Western Front	\N	\N	Blu-ray	f	1930	Not Rated	\N	122
eb5c5b5e-1b12-413d-b012-fd32016b138d	Anastasia	\N	\N	DVD	f	1997	G	\N	108
6a6bfc1d-b471-4a42-a655-078e8d85f78d	Anastasia	\N	\N	Blu-ray	f	1997	G	\N	108
8714922b-dacf-4f66-b476-a5a11d17cd0d	Apollo 11	2020-09-28	2020-10-12	DVD	f	2019	G	260344226465	106
9d328e9f-8e0c-41e5-ae93-5666ce6ee45c	Apollo 11	\N	\N	Blu-ray	f	2019	G	\N	106
9fc1864d-bcf0-4522-bd60-05272337490a	Apollo 13	\N	\N	DVD	f	1995	PG-13	\N	111
c1aa871a-3492-478d-a831-a2b0bd81e3e3	Apollo 13	\N	\N	Blu-ray	f	1995	PG-13	\N	111
2a48e704-f893-46af-a341-39d0307673d4	Apollo 13	\N	\N	Digital	f	1995	PG-13	\N	111
ec79a877-d332-4fce-b692-9c5deb550d56	Avengers: Age of Ultron	\N	\N	DVD	f	2015	PG-13	\N	120
7e68c2cc-dffe-4ef1-91bb-451d4a0fe09c	Avengers: Age of Ultron	\N	\N	Blu-ray	f	2015	PG-13	\N	120
ed44a840-d070-4e02-b2ee-60aed9607e20	Avengers: Age of Ultron	\N	\N	Digital	f	2015	PG-13	\N	120
cb0dddeb-06bf-4a43-9680-21a541505190	Avengers: Endgame	\N	\N	DVD	f	2019	PG-13	\N	120
87bbd171-a2ca-43ad-be05-a07d9d98a59d	Avengers: Endgame	\N	\N	Blu-ray	f	2019	PG-13	\N	120
d7444379-e970-48c0-a174-7cc4755dfed1	Avengers: Endgame	\N	\N	Digital	f	2019	PG-13	\N	120
ac333706-572f-4225-a59b-21ce7bef40b6	Avengers: Infinity War	\N	\N	DVD	f	2018	PG-13	\N	120
1678dab8-bd18-4a84-b3d1-84de022ca750	Avengers: Infinity War	\N	\N	Blu-ray	f	2018	PG-13	\N	120
3ea768d3-26ea-4637-a89a-34e8fbb0276a	Avengers: Infinity War	\N	\N	Digital	f	2018	PG-13	\N	120
fc6dcaa9-19f2-4ba8-b48a-4bd9955c8f5f	Bambi	\N	\N	DVD	f	1942	G	\N	108
50a06ebe-bc6a-4a5b-9eba-ad04fc27f4ae	Bambi	\N	\N	Blu-ray	f	1942	G	\N	108
1ef5605f-a106-48a8-a5b0-7add36cd28e9	Capone	\N	\N	Blu-ray	f	2020	R	\N	105
64e01ba9-7cfa-4139-89ef-35073e80d5cf	Capone	\N	\N	DVD	f	2020	R	\N	105
35d764aa-4d1f-40de-93a4-5603a2f9eb3b	Captain America: Civil War	\N	\N	DVD	f	2016	PG-13	\N	120
52ca1e80-01a8-4390-a718-6f48649f7b0a	Captain America: Civil War	\N	\N	Blu-ray	f	2016	PG-13	\N	120
b9fdeb39-357c-49cc-84b3-57526da9e93a	Captain America: Civil War	\N	\N	Digital	f	2016	PG-13	\N	120
a4d398c1-e375-402f-8b8b-7ec03e7a0f59	Captain America: The First Avenger	\N	\N	DVD	f	2011	PG-13	\N	120
a102bc53-d6fe-46ef-917e-3c5f4cd31b5d	Captain America: The First Avenger	\N	\N	Blu-ray	f	2011	PG-13	\N	120
5d40f044-5dba-4d27-8089-89e6d7c62b70	Captain America: The First Avenger	\N	\N	Digital	f	2011	PG-13	\N	120
f3bd82d6-9825-4a1c-8c74-ab9f29cbf1f3	Captain America: The Winter Soldier	\N	\N	DVD	f	2014	PG-13	\N	120
97bfc727-9fa6-43a3-a77d-9f55eb33aab7	Captain America: The Winter Soldier	\N	\N	Blu-ray	f	2014	PG-13	\N	120
4abd6e1e-f4f8-4aa5-852e-2d7f1f467eb9	Captain America: The Winter Soldier	\N	\N	Digital	f	2014	PG-13	\N	120
86e1937e-0a1c-4be5-953a-5f8712670276	Casablanca	\N	\N	DVD	f	1942	PG	\N	116
429cc0a9-ba25-4713-afca-a5a144a300aa	Casablanca	\N	\N	Blu-ray	f	1942	PG	\N	116
e6af6e60-6b43-4857-93a3-ee46fa9f517e	Charade	2020-10-10	2020-10-24	DVD	f	1963	G	110382212241	115
538060aa-86d1-40d3-9721-13d149314957	Charade	\N	\N	Blu-ray	f	1963	G	\N	115
4537ce4d-6ed5-4aeb-837a-bcb32ecc5271	Charade	\N	\N	Digital	f	1963	G	\N	115
fe7aaf84-5c8f-40e0-a7f0-95dc8150cf03	Cinderella	\N	\N	DVD	f	1950	G	\N	108
ca5af5f8-37e9-4554-982e-e3af22e982fc	Cinderella	\N	\N	Blu-ray	f	1950	G	\N	108
6ee54283-634f-4e76-be24-f39f92a120c6	Deadpool	2020-10-01	2020-10-15	Blu-ray	t	2016	R	923876375725	120
f6a17d95-5836-4354-a945-c543612cf8a6	Deadpool	\N	\N	DVD	t	2016	R	\N	120
2c0615a0-e695-4073-931d-2caa34c5af6d	First Man	\N	\N	DVD	f	2018	PG-13	\N	111
917b4857-9497-400c-afbc-a2f2768ec701	First Man	\N	\N	Blu-ray	f	2018	PG-13	\N	111
1bdc096c-892c-4d99-bbf1-08598a886d8f	First Man	\N	\N	Digital	f	2018	PG-13	\N	111
6736b168-b1c2-49e6-86ca-c317728977b6	Float	\N	\N	DVD	f	2019	G	\N	118
922f72f1-9bcc-41bd-9e84-be4138a08718	Float	\N	\N	Blu-ray	f	2019	G	\N	118
8c83bf1b-3a02-4b49-b8a3-61952d0e156a	Forrest Gump	\N	\N	DVD	f	1994	PG-13	\N	107
1c85caa3-5d49-476f-96d1-f401ac69c868	Forrest Gump	\N	\N	Blu-ray	f	1994	PG-13	\N	107
4a1f2b37-f912-4865-943f-e5e083557602	Good Will Hunting	\N	\N	DVD	t	1997	R	\N	107
e727554a-c030-4ba4-9700-534f127fa0a6	Good Will Hunting	\N	\N	Blu-ray	t	1997	R	\N	107
f3fe98ab-934b-4e9e-8079-6a5062e8a89d	Guardians of the Galaxy	\N	\N	DVD	f	2014	PG-13	\N	120
fd4c9507-6846-466c-9c59-ef3d170cf12e	Guardians of the Galaxy	\N	\N	Blu-ray	f	2014	PG-13	\N	120
d0e2ac84-d8bc-4e4a-b879-464a3fcce80c	Guardians of the Galaxy	\N	\N	Digital	f	2014	PG-13	\N	120
c5902f35-cbd5-4d90-a5cd-23fee01dc163	Guardians of the Galaxy Vol. 2	\N	\N	DVD	f	2017	PG-13	\N	120
ba5d6656-0764-4218-ae10-82704fc72c43	Guardians of the Galaxy Vol. 2	\N	\N	Blu-ray	f	2017	PG-13	\N	120
cbe29e8b-c3cb-4002-a0c0-4e4e06a96724	Guardians of the Galaxy Vol. 2	\N	\N	Digital	f	2017	PG-13	\N	120
8b152f91-1fd8-4789-8d37-f58c010efdea	Hacksaw Ridge	\N	\N	Blu-ray	t	2016	R	\N	122
127296d4-8b56-44e4-a5d4-1b77e88a7777	Hacksaw Ridge	\N	\N	DVD	t	2016	R	\N	122
58786398-72d1-4f49-8bac-3d64799f3b1b	Halloween	\N	\N	DVD	t	1978	R	\N	112
3c66663d-e474-4bb1-b93d-84bc45f18461	Halloween 5: The Revenge of Michael Myers	\N	\N	DVD	t	1989	R	\N	112
b854b7d5-cb28-4e0d-8539-b65e1dc6d42c	Halloween II	\N	\N	DVD	t	1981	R	\N	112
9daaa6a3-b506-4597-a445-16f34f18775e	Halloween II	\N	\N	Blu-ray	t	1981	R	\N	112
9d7e65c9-abf2-435f-b316-5894c8f00277	Halloweentown	\N	\N	DVD	f	1998	Not Rated	\N	108
d7d7d809-3fbf-43c6-bbe8-f0090080571c	Halloweentown	\N	\N	Blu-ray	f	1998	Not Rated	\N	108
c7ceae1f-0925-416b-9134-f1d1b4e54c17	Harry Potter and the Chamber of Secrets	\N	\N	DVD	f	2002	PG	\N	109
5e94612d-d8f4-41d0-a595-5182294e38bf	Harry Potter and the Chamber of Secrets	\N	\N	Blu-ray	f	2002	PG	\N	109
8151f395-9f5f-4005-9541-eee0aa5d84d9	Harry Potter and the Deathly Hallows Part 1	\N	\N	DVD	f	2010	PG-13	\N	109
b6f2f7ba-3594-4d6f-9bf5-18c43a056cce	Harry Potter and the Deathly Hallows Part 1	\N	\N	Blu-ray	f	2010	PG-13	\N	109
f993c3fb-96cc-4647-95a5-c79331a2bf26	Harry Potter and the Deathly Hallows Part 1	\N	\N	Digital	f	2010	PG-13	\N	109
22a7104e-898a-4089-91f2-5543660d1e60	Harry Potter and the Deathly Hallows Part 2	\N	\N	DVD	f	2011	PG-13	\N	109
764e6526-d7e1-4f49-86e2-b1a8a6ec36ea	Alien	2020-11-18	2020-12-02	Digital	t	1979	R	959027290311	117
b0a9ea63-270e-4260-aeac-664f0a8a43e2	Harry Potter and the Chamber of Secrets	2020-11-02	2020-11-16	Digital	f	2002	PG	959027290311	109
3c3c1259-8161-456f-9f7b-4dff31cbd4f4	Harry Potter and the Deathly Hallows Part 2	\N	\N	Blu-ray	f	2011	PG-13	\N	109
f8f979c4-147f-496b-a88a-677c8d7cf7c6	Harry Potter and the Deathly Hallows Part 2	\N	\N	Digital	f	2011	PG-13	\N	109
cc46a36e-7d4d-44e8-8b2c-b48001ba2f8a	Harry Potter and the Goblet of Fire	\N	\N	DVD	f	2005	PG-13	\N	109
4c503a0f-bb2e-434b-a39f-32f3315fa320	Harry Potter and the Goblet of Fire	\N	\N	Blu-ray	f	2005	PG-13	\N	109
20181d95-30b5-4feb-9d66-963c81bd0e3b	Harry Potter and the Goblet of Fire	\N	\N	Digital	f	2005	PG-13	\N	109
f2123dd5-08f6-4119-ad2f-d702bec517fb	Harry Potter and the Half-Blood Prince	\N	\N	DVD	f	2009	PG-13	\N	109
619173df-d9f6-4d67-ae44-fdd4c029013a	Harry Potter and the Half-Blood Prince	\N	\N	Blu-ray	f	2009	PG-13	\N	109
9cd47008-d30d-4453-8534-1bb542656481	Harry Potter and the Order of the Phoenix	\N	\N	DVD	f	2007	PG-13	\N	109
f34b700b-b172-42e2-8e87-0a5b4224e12d	Harry Potter and the Order of the Phoenix	\N	\N	Blu-ray	f	2007	PG-13	\N	109
0cdfa374-af68-4ba4-8401-bc71e082bc3d	Harry Potter and the Order of the Phoenix	\N	\N	Digital	f	2007	PG-13	\N	109
1f623fbf-9344-4bc7-9526-3f497fbdc73f	Harry Potter and the Prisoner of Azkaban	\N	\N	DVD	f	2004	PG	\N	109
e01ed313-9d78-4610-bd9f-c8f38746b629	Harry Potter and the Prisoner of Azkaban	\N	\N	Digital	f	2004	PG	\N	109
9fdeefae-e85b-47c1-86a0-f0190892ea2d	How to Train Your Dragon	2020-10-12	2020-10-26	DVD	f	2010	PG	279893236088	108
59f5621b-9945-400a-a2d1-c7960e501afb	How to Train Your Dragon	\N	\N	Blu-ray	f	2010	PG	\N	108
820b4b32-6b10-4da5-a62a-ccdfdba6b5a1	How to Train Your Dragon	\N	\N	Digital	f	2010	PG	\N	108
26f709d6-8863-4a00-ae16-c6ebd0a40433	How to Train Your Dragon 2	\N	\N	DVD	f	2014	PG	\N	108
62d971b9-d3a4-44e1-b791-462c4ea3a05d	How to Train Your Dragon 2	\N	\N	Blu-ray	f	2014	PG	\N	108
9304fdca-f81b-4974-b916-f1d6455056c7	How to Train Your Dragon 2	\N	\N	Digital	f	2014	PG	\N	108
9ecde2fa-4302-4850-bede-85d43a7828bc	How to Train Your Dragon: The Hidden World	\N	\N	DVD	f	2019	PG	\N	108
460114cf-8b06-45f0-883f-5185d9aaf12a	How to Train Your Dragon: The Hidden World	\N	\N	Blu-ray	f	2019	PG	\N	108
cf7a3fed-05e1-4ce6-b89b-640755be4ecd	How to Train Your Dragon: The Hidden World	\N	\N	Digital	f	2019	PG	\N	108
55ded665-5550-484d-b7a0-23893ea6af79	Howl's Moving Castles Moving Castle	\N	\N	DVD	f	2004	PG	\N	109
92e74c23-53f7-4789-b30e-22addf25257a	Howl's Moving Castles Moving Castle	\N	\N	Blu-ray	f	2004	PG	\N	109
901fa1a5-e83f-4e53-9079-3b5543bd0b9b	Indiana Jones and the Crystal Skull	\N	\N	DVD	f	2008	PG-13	\N	101
0e923d57-ff3a-4a76-8fb4-8f52131e2deb	Indiana Jones and the Crystal Skull	\N	\N	Blu-ray	f	2008	PG-13	\N	101
dc043ba6-0757-456a-8c73-5f4117b77460	Indiana Jones and the Crystal Skull	\N	\N	Digital	f	2008	PG-13	\N	101
c6c6eb7f-5146-45a4-8ec4-6a6ba19e7179	Indiana Jones and the Last Crusade	\N	\N	DVD	f	1989	PG	\N	101
7ba40d73-55e0-4761-b896-78e730a7daad	Indiana Jones and the Last Crusade	\N	\N	Blu-ray	f	1989	PG	\N	101
d8a671b4-0133-484a-9f29-8ae0b3370d6c	Indiana Jones and the Last Crusade	\N	\N	Digital	f	1989	PG	\N	101
473f6c20-a833-4a4a-9c67-6f2716d1b6b9	Indiana Jones and the Raiders of the Lost Ark	2020-09-28	2020-10-12	DVD	f	1981	PG	353889623571	101
f367c238-7d9a-479a-aeb0-e17cc3fe621a	Indiana Jones and the Raiders of the Lost Ark	\N	\N	Blu-ray	f	1981	PG	\N	101
31effca9-27e2-463c-9334-405c3909856f	Indiana Jones and the Raiders of the Lost Ark	\N	\N	Digital	f	1981	PG	\N	101
180da8f2-9f61-4dd9-b6ea-419a496f0e6a	Indiana Jones and the Temple of Doom	\N	\N	DVD	f	1984	PG-13	\N	101
e698661d-c70a-485d-8724-9ada3d13c9bb	Indiana Jones and the Temple of Doom	\N	\N	Blu-ray	f	1984	PG-13	\N	101
c0ddba3d-88c0-4f42-b19a-bff0989994e2	Indiana Jones and the Temple of Doom	\N	\N	Digital	f	1984	PG-13	\N	101
9201647d-4910-468c-8ffd-68beb8968e6c	Iron Man	\N	\N	DVD	f	2008	PG-13	\N	120
dabd6b0d-f65e-4a1d-b6c8-91b441286153	Iron Man	\N	\N	Blu-ray	f	2008	PG-13	\N	120
3f583bae-4dbe-46a5-ad43-0267f8d0dd50	Iron Man	\N	\N	Digital	f	2008	PG-13	\N	120
6b3b7ec0-9c5f-49cb-b8aa-fd360a129d0f	Iron Man 2	\N	\N	DVD	f	2010	PG-13	\N	120
7adc31c7-8d65-4d08-a818-1ce6904649bf	Iron Man 2	\N	\N	Blu-ray	f	2010	PG-13	\N	120
0baea9e9-c6ec-49bf-bb59-f280f3b330f4	Iron Man 2	\N	\N	Digital	f	2010	PG-13	\N	120
22663b01-9acd-43a4-a9ea-684075fe1920	Iron Man 3	\N	\N	DVD	f	2013	PG-13	\N	120
3e10d5d5-1f30-4d1f-ae7e-bd39aa06a4b3	Iron Man 3	\N	\N	Blu-ray	f	2013	PG-13	\N	120
0ca4e8d1-d01e-4a19-a0f7-f16ede08d89e	Iron Man 3	\N	\N	Digital	f	2013	PG-13	\N	120
44babc67-1d4f-425b-ac1d-19b4192fb2e2	Joker	2020-09-30	2020-10-14	Blu-ray	t	2019	R	574694081039	120
c2f30ba8-cff2-4e9a-9a06-db27bc4fe517	Joker	\N	\N	DVD	t	2019	R	\N	120
362f1aa9-576d-44a9-b5b4-d2f3d2003f00	Juno	\N	\N	DVD	f	2007	PG-13	\N	104
fb465bd6-a311-406f-a4f8-b8f09fd7f03b	Juno	\N	\N	Blu-ray	f	2007	PG-13	\N	104
45b28d04-2ea7-4b5b-9318-1971e8ed0258	Key Largo	\N	\N	DVD	f	1948	Not Rated	\N	110
ae649714-ba31-4a7f-b280-999c742896aa	Key Largo	\N	\N	Blu-ray	f	1948	Not Rated	\N	110
9544d4a4-29fc-42ab-a177-19c8b1eae7bb	Look Who's Talkings Talking	\N	\N	DVD	f	1989	PG-13	\N	107
8006c259-a392-44fe-a92e-2ec008459cbb	Look Who's Talkings Talking	\N	\N	Blu-ray	f	1989	PG-13	\N	107
0a87b441-f87d-4d39-8aa8-8eda17994fd4	Midnight Cowboy	2020-10-07	2020-10-21	DVD	t	1969	R	724098502382	107
fe364f39-0a64-413a-923a-ddbe42244463	Midnight Cowboy	\N	\N	Blu-ray	t	1969	R	\N	107
6102ba22-4811-4853-81bc-442309fbc867	Moneyball	\N	\N	DVD	f	2011	PG-13	\N	119
fe13cebc-941b-4357-af15-98f1574db5eb	Moneyball	\N	\N	Blu-ray	f	2011	PG-13	\N	119
26689e4e-6509-40d1-a533-ded547f6e5e5	Mulan	2020-10-17	2020-10-31	DVD	f	1998	G	279893236088	108
8ef75c49-dc0b-4109-9796-627f887dfddd	Mulan	\N	\N	Blu-ray	f	1998	G	\N	108
1d21e4e4-b7c4-4d4a-8165-a5183f28c751	Mulan	\N	\N	Digital	f	1998	G	\N	108
892d4cd8-87b1-4fe7-a7b9-80aee457add0	One Flew Over the Cuckoo's Nests Nest	2020-10-14	2020-10-28	DVD	t	1975	R	299045933849	107
cee07260-f033-4b97-992e-8dff7960d690	One Flew Over the Cuckoo's Nests Nest	\N	\N	Blu-ray	t	1975	R	\N	107
65587191-cd02-4364-bdd2-f60dc480651b	One Flew Over the Cuckoo's Nests Nest	\N	\N	Digital	t	1975	R	\N	107
dba64b24-ac83-49d3-aea6-2b16d320e838	Parasite	\N	\N	Blu-ray	t	2019	R	\N	121
2f6f281f-59f7-466c-a355-5448334fb847	Parasite	\N	\N	DVD	t	2019	R	\N	121
7e026757-287c-42de-94eb-516516b06328	Peter Pan	\N	\N	DVD	f	1953	G	\N	108
ac4cae91-25f2-425c-b9f2-16f88d413ce8	Peter Pan	\N	\N	Blu-ray	f	1953	G	\N	108
f39458ba-2110-4a0f-b25e-8b565e26e621	Peter Pan	\N	\N	Digital	f	1953	G	\N	108
f40bf526-b5db-4e4b-b19d-fb0f5354b32c	Remember the Titans	\N	\N	DVD	f	2000	PG	\N	119
1f235585-0fdf-40bd-b5c6-a60b12dd05f7	Remember the Titans	\N	\N	Blu-ray	f	2000	PG	\N	119
8bd48101-2667-4243-b32b-4c3e90683e41	Remember the Titans	\N	\N	Digital	f	2000	PG	\N	119
b30d299c-d14c-439a-8600-59e4f4bedffb	Rogue One: A Star Wars Story	\N	\N	DVD	f	2016	PG-13	\N	117
5a1c15f1-45a4-448f-bbae-282ec687ea9a	Rogue One: A Star Wars Story	\N	\N	Blu-ray	f	2016	PG-13	\N	117
9e3b4cd0-3c13-41c9-9d4a-d2e055150676	Terminator Salvation	\N	\N	DVD	t	2009	R	\N	100
f3e27c63-e278-4a4e-9d24-b2929bb0b50e	Harry Potter and the Prisoner of Azkaban	\N	\N	Blu-ray	f	2004	PG	\N	109
4614998c-f69a-4a9b-9bf3-42263273dfcf	Harry Potter and the Half-Blood Prince	\N	\N	Digital	f	2009	PG-13	\N	109
3bcaee1e-3085-442f-9f7b-75aca1d18fb5	Rogue One: A Star Wars Story	\N	\N	Digital	f	2016	PG-13	\N	117
0d65ab58-6926-4858-9983-82a2fe13d7ff	Showgirls	2020-10-03	2020-10-17	DVD	t	1995	NC-17	512788314000	107
35cc7dfe-d1ae-4aa1-a626-3e823621c5e0	Showgirls	\N	\N	Blu-ray	t	1995	NC-17	\N	107
d97e73d9-998d-41eb-9f46-2e0c01a958ce	Shrek	\N	\N	DVD	f	2001	PG	\N	108
c214cb04-5de5-4025-a689-f40993db1fe7	Shrek	\N	\N	Blu-ray	f	2001	PG	\N	108
ed1efac6-f5cd-4357-955a-11b916546470	Shrek	\N	\N	Digital	f	2001	PG	\N	108
b4745c82-9675-4671-9012-13aff8213926	Shrek 2	\N	\N	DVD	f	2004	PG	\N	108
6b1da505-6ab7-417d-b94a-d205a2207e9e	Shrek 2	\N	\N	Blu-ray	f	2004	PG	\N	108
027a8163-f34b-467c-9c37-d94a009adf4d	Shrek 2	\N	\N	Digital	f	2004	PG	\N	108
4913e6c3-7163-4d94-b114-44d4b0a0a752	Shrek Forever After	\N	\N	DVD	f	2010	PG	\N	108
7cd2cb77-adec-4338-837c-bed420fbfa55	Shrek Forever After	\N	\N	Blu-ray	f	2010	PG	\N	108
f47a9341-2722-47d1-bdb2-183b0f75a6c9	Shrek Forever After	\N	\N	Digital	f	2010	PG	\N	108
11356498-f692-4a09-b73a-3f6be4498e1e	Shrek the Third	\N	\N	DVD	f	2007	PG	\N	108
6bf51d46-2ed8-4c4f-a9b7-265b7204926c	Shrek the Third	\N	\N	Blu-ray	f	2007	PG	\N	108
e77b71f2-0461-4554-80d1-8cc87db449d1	Shrek the Third	\N	\N	Digital	f	2007	PG	\N	108
c7e778dc-fff5-4159-b8f7-1b85ee2a3b49	Sleeping Beauty	\N	\N	DVD	f	1959	G	\N	108
16bc0c45-6bb0-4ddd-9807-d5c83b713d9b	Sleeping Beauty	\N	\N	Blu-ray	f	1959	G	\N	108
ba612aa7-fe56-460d-bcf4-1dba4d16190c	Snow White and the Sevem Dwarfs	\N	\N	DVD	f	1937	G	\N	108
6b9936ee-22c8-4a4c-a234-529d6490eb2d	Snow White and the Sevem Dwarfs	\N	\N	Blu-ray	f	1937	G	\N	108
677f9f6b-1a37-42a9-9836-f8be1c9a127c	Solo: A Star Wars Story	\N	\N	DVD	f	2018	PG-13	\N	117
bce3b961-a9a2-48a9-953d-00926f0e1833	Solo: A Star Wars Story	\N	\N	Blu-ray	f	2018	PG-13	\N	117
7e577b66-cbc3-4f70-8678-8847033a4894	Solo: A Star Wars Story	\N	\N	Digital	f	2018	PG-13	\N	117
feeaf224-d705-4c23-97db-7711f922bdcd	Spider-Man	\N	\N	DVD	f	2002	PG-13	\N	120
eb16b9d1-901f-4c5a-bed8-a6d4f5b18abe	Spider-Man	\N	\N	Blu-ray	f	2002	PG-13	\N	120
06e72099-7be6-443e-ae90-815aa8d6469f	Spider-Man	\N	\N	Digital	f	2002	PG-13	\N	120
995053c8-4365-4458-98fd-827a66c21e1f	Spider-Man 2	\N	\N	DVD	f	2004	PG-13	\N	120
e7eac72e-335e-4e4c-af79-ab7b0ac24177	Spider-Man 2	\N	\N	Blu-ray	f	2004	PG-13	\N	120
21fa7dc1-1635-4fe2-9b6a-c4782588b35d	Spider-Man 2	\N	\N	Digital	f	2004	PG-13	\N	120
7944e595-9c9e-4d99-98af-1aab9735a524	Spider-Man 3	\N	\N	DVD	f	2007	PG-13	\N	120
b343b07e-8708-44cb-991d-887d4b1f40ac	Spider-Man 3	\N	\N	Blu-ray	f	2007	PG-13	\N	120
7433d4a0-16fc-4e6e-a526-4a2ed71f6570	Spider-Man 3	\N	\N	Digital	f	2007	PG-13	\N	120
9988daee-0f2a-47d7-b78a-9b4b999a5a25	Spider-Man: Far From Home	\N	\N	DVD	f	2019	PG-13	\N	120
f889e9df-8def-47cc-9258-21d7aa6cd4d4	Spider-Man: Far From Home	\N	\N	Blu-ray	f	2019	PG-13	\N	120
0a0f6641-b329-4edc-b651-960c101f5206	Spider-Man: Far From Home	\N	\N	Digital	f	2019	PG-13	\N	120
3566fadd-f039-417b-b837-40cd04819c27	Spider-Man: Homecoming	\N	\N	DVD	f	2017	PG-13	\N	120
948661fa-d977-427c-a660-b7303e8d3077	Spider-Man: Homecoming	\N	\N	Blu-ray	f	2017	PG-13	\N	120
ba088521-2701-4362-abb3-9703cc6aef58	Spider-Man: Homecoming	\N	\N	Digital	f	2017	PG-13	\N	120
a2ea0d82-dbea-4d3e-a07f-2603ee16043e	Spider-Man: Into the Spider-Verse	\N	\N	DVD	f	2018	PG	\N	120
a9433067-13a9-41bd-9c65-a071a55cda32	Spider-Man: Into the Spider-Verse	\N	\N	Blu-ray	f	2018	PG	\N	120
926bf549-7ad0-4c5b-8b97-78c36d391a2d	Spider-Man: Into the Spider-Verse	\N	\N	Digital	f	2018	PG	\N	120
e7e94d10-a9ca-4e91-87fa-2a731b0e4f8a	Spirted Away	\N	\N	DVD	f	2001	PG	\N	109
5efa8ee8-fdc7-43e1-93ff-77714bace118	Spirted Away	\N	\N	Blu-ray	f	2001	PG	\N	109
3491658c-df56-4692-9cea-cd41fc8d356f	Star Wars Episode I: The Phantom Menace	\N	\N	DVD	f	1999	PG	\N	117
41e90c35-6e62-4224-ace2-98025b256d15	Star Wars Episode I: The Phantom Menace	\N	\N	Blu-ray	f	1999	PG	\N	117
e9da4509-ce0d-4e77-8fd8-32703c0a1144	Star Wars Episode I: The Phantom Menace	\N	\N	Digital	f	1999	PG	\N	117
b82e2b86-033d-4777-a577-c0152f73388f	Star Wars Episode II: Attack of the Clones	\N	\N	DVD	f	2002	PG	\N	117
0c868e3b-3d87-4e76-8fe0-482acc87c85e	Star Wars Episode II: Attack of the Clones	\N	\N	Blu-ray	f	2002	PG	\N	117
1c8b3051-14a0-4666-8847-ea7dc7486fc2	Star Wars Episode II: Attack of the Clones	\N	\N	Digital	f	2002	PG	\N	117
5688d1aa-e159-4895-b559-83e937cd7437	Star Wars Episode III: Revenge of the Sith	\N	\N	DVD	f	2005	PG-13	\N	117
46b3b81a-c85a-48f4-9a3d-74da916de411	Star Wars Episode III: Revenge of the Sith	\N	\N	Blu-ray	f	2005	PG-13	\N	117
f3aa5ed6-5032-4cbf-866a-00b592a33813	Star Wars Episode III: Revenge of the Sith	\N	\N	Digital	f	2005	PG-13	\N	117
8ac0a701-815b-44c2-84c3-0471f3cee78b	Star Wars Episode IV:  A New Hope	\N	\N	DVD	f	1977	PG	\N	117
86e45c1d-48c3-46ef-8849-9dfce8a63aa4	Star Wars Episode IV:  A New Hope	\N	\N	Blu-ray	f	1977	PG	\N	117
4c682685-2148-43be-a3f5-0181e8739380	Star Wars Episode IV:  A New Hope	\N	\N	Digital	f	1977	PG	\N	117
4a9e80bf-dca9-4d7c-bc36-3a956ec9f41a	Star Wars Episode IX: The Rise of Skywalker	\N	\N	DVD	f	2019	PG-13	\N	117
d611231e-c423-4258-ad15-3b32f4fbbf3d	Star Wars Episode IX: The Rise of Skywalker	\N	\N	Blu-ray	f	2019	PG-13	\N	117
bc53719d-cd1f-4756-bcb2-bc1247fd7335	Star Wars Episode IX: The Rise of Skywalker	\N	\N	Digital	f	2019	PG-13	\N	117
92c4bc9a-b73f-43cd-a93b-a8635b05e191	Star Wars Episode V: The Empire Strikes Back	2020-10-12	2020-10-26	Blu-ray	f	1980	PG	762578252335	117
3c1933ab-f494-4f0c-881c-945718fd0eec	Star Wars Episode V: The Empire Strikes Back	\N	\N	DVD	f	1980	PG	\N	117
9c47dcda-d2c1-407e-ae5d-f9bcc2e96b00	Star Wars Episode V: The Empire Strikes Back	\N	\N	Digital	f	1980	PG	\N	117
16b0d990-a7be-49e5-b2c0-bc00b82d91bc	Star Wars Episode VI: Return of the Jedi	\N	\N	DVD	f	1983	PG	\N	117
f19fd8fb-1c3e-45d3-aa72-7e61a7aebac6	Star Wars Episode VI: Return of the Jedi	\N	\N	Blu-ray	f	1983	PG	\N	117
fa609990-deab-4aa0-b2cb-26495eb08ddf	Star Wars Episode VI: Return of the Jedi	\N	\N	Digital	f	1983	PG	\N	117
56297912-6286-4ade-bbd2-095dea6cc14a	Star Wars Episode VII: The Force Awakens	\N	\N	DVD	f	2015	PG-13	\N	117
1dcdbc46-4988-46e5-bac2-f4260b08570f	Star Wars Episode VII: The Force Awakens	\N	\N	Blu-ray	f	2015	PG-13	\N	117
eab79bf1-058c-47b5-a333-fb80c172a6df	Star Wars Episode VIII: The Last Jedi	\N	\N	DVD	f	2017	PG-13	\N	117
e987dfcb-4eb4-4a14-8446-ecfd67a73a56	Star Wars Episode VIII: The Last Jedi	\N	\N	Blu-ray	f	2017	PG-13	\N	117
36551fd4-654a-4253-9380-136e8dbe84fc	Star Wars Episode VIII: The Last Jedi	\N	\N	Digital	f	2017	PG-13	\N	117
3c503040-010c-4de4-8bd2-3ed889f037a0	Star Wars: The Clone Wars	\N	\N	DVD	f	2008	PG	\N	117
c2aa2abc-c611-4637-83d5-f86e2e9b874c	Star Wars: The Clone Wars	\N	\N	Blu-ray	f	2008	PG	\N	117
267c7e5a-7722-4b73-a0ab-1a17f85dbfdb	Star Wars: The Clone Wars	\N	\N	Digital	f	2008	PG	\N	117
5591c533-31dc-4f6a-9cb5-7e417a1462d3	Terminator 2: Judgment Day	\N	\N	DVD	t	1991	R	\N	100
875215c3-3cec-40df-94b9-e6d7697f5dc0	Terminator 2: Judgment Day	\N	\N	Blu-ray	t	1991	R	\N	100
4a200344-5811-4aa7-b2eb-d1d9616f40e9	Terminator 2: Judgment Day	\N	\N	Digital	t	1991	R	\N	100
f320449c-a1ca-4c41-b08f-a0436cde0d19	Terminator 3: Rise of the Machines	\N	\N	DVD	t	2003	R	\N	100
c53cce5f-0cc6-4998-8ff7-8a473fe21123	Terminator 3: Rise of the Machines	\N	\N	Blu-ray	t	2003	R	\N	100
14eeebf0-7683-4658-879c-61cb4d970fd5	Terminator 3: Rise of the Machines	\N	\N	Digital	t	2003	R	\N	100
6a66ab84-45be-408f-a301-6dbecab089c4	Terminator Salvation	\N	\N	Blu-ray	t	2009	R	\N	100
50c25d52-6266-4857-abd6-5fba4b13b33a	Terminator Salvation	\N	\N	Digital	t	2009	R	\N	100
b68ddb4f-1a8a-486c-9507-ec7889819cb2	The Amazing Spider-Man	\N	\N	DVD	f	2012	PG-13	\N	120
47b6e89f-f938-4c17-9a83-6f8ae982e6b3	The Amazing Spider-Man	\N	\N	Blu-ray	f	2012	PG-13	\N	120
154f44a4-3c5d-4162-add1-ac6a27c4926f	The Amazing Spider-Man	\N	\N	Digital	f	2012	PG-13	\N	120
c33e7f4d-967e-4fbb-a51a-885941873e2e	The Amazing Spider-Man 2	\N	\N	DVD	f	2014	PG-13	\N	120
311da38b-1f0e-4f32-8786-4868e2e4f792	The Amazing Spider-Man 2	\N	\N	Blu-ray	f	2014	PG-13	\N	120
9c500073-a360-4590-8bc8-603053b127e0	The Amazing Spider-Man 2	\N	\N	Digital	f	2014	PG-13	\N	120
bc86c351-be4d-432c-aa38-58df9d5d0827	The Avengers	\N	\N	DVD	f	2012	PG-13	\N	120
c019aef9-db97-491a-908d-d41f81ffed28	The Avengers	\N	\N	Blu-ray	f	2012	PG-13	\N	120
1e7296f0-d5ae-4418-8bf7-fc538c6bb4af	The Avengers	\N	\N	Digital	f	2012	PG-13	\N	120
611c8300-56d6-4b9c-ba24-fde5d95bb63a	The Beatles: Eight Days a Week	\N	\N	DVD	f	2016	Not Rated	\N	106
0b1c93aa-d599-4d30-8a83-734f80ae8d5e	The Beatles: Eight Days a Week	\N	\N	Blu-ray	f	2016	Not Rated	\N	106
ffada834-11bf-4091-b087-06bc8569eff0	The Dark Knight	2020-10-16	2020-10-30	Blu-ray	f	2008	PG-13	294051144258	120
46ea0860-e76a-4874-90fe-07f0e0e83e7d	The Dark Knight	\N	\N	DVD	f	2008	PG-13	\N	120
8e15959a-5419-4121-9e4e-7ae301631467	The Hobbit: An Unexpected Journey	\N	\N	DVD	f	2012	PG-13	\N	109
c3fda0ef-5da1-4aa3-84d1-5a54b2e8c9a3	The Hobbit: An Unexpected Journey	\N	\N	Blu-ray	f	2012	PG-13	\N	109
5252279f-b717-4a5e-b6a7-deb69261bd1a	The Hobbit: The Battle of the Five Armies	\N	\N	DVD	f	2014	PG-13	\N	109
b5ddf793-3761-4152-a8ed-922f2339ff2a	The Hobbit: The Battle of the Five Armies	\N	\N	Blu-ray	f	2014	PG-13	\N	109
12096d5c-2a48-4ce4-82a4-586092e74b86	The Hobbit: The Desolation of Smaug	\N	\N	DVD	f	2013	PG-13	\N	109
b50e825f-a8b6-4e68-99ee-4f2d3582b75a	The Hobbit: The Desolation of Smaug	\N	\N	Blu-ray	f	2013	PG-13	\N	109
1a471d84-94e5-40b9-a888-ca09de86f024	The Hunger Games	\N	\N	DVD	f	2012	PG-13	\N	100
e00f33ad-541f-4645-91f6-98ad405666ea	The Hunger Games	\N	\N	Blu-ray	f	2012	PG-13	\N	100
b6f19077-28ef-4039-b9a3-15b8ed7bfef2	The Hunger Games	\N	\N	Digital	f	2012	PG-13	\N	100
eb8e37a7-421e-4b14-bbba-159d544cc020	The Hunger Games: Catching Fire	\N	\N	DVD	f	2013	PG-13	\N	100
0d31de5c-6ed9-4f37-a896-3daedc00c854	The Hunger Games: Catching Fire	\N	\N	Digital	f	2013	PG-13	\N	100
004fda54-9a82-4046-a51d-35bbff738be6	The Hunger Games: Mockingjay Part 1	\N	\N	DVD	f	2014	PG-13	\N	100
3d262e3a-4df9-4f1d-922f-c83cf6d45762	The Hunger Games: Mockingjay Part 1	\N	\N	Blu-ray	f	2014	PG-13	\N	100
b746a0ce-3d67-4e2a-9f0f-ccc6c7b5c8e5	The Hunger Games: Mockingjay Part 1	\N	\N	Digital	f	2014	PG-13	\N	100
41787652-8112-4a19-8f45-31529536b538	The Hunger Games: Mockingjay Part 2	\N	\N	DVD	f	2015	PG-13	\N	100
40077187-f91b-4b46-a839-fab25acbcab4	The Hunger Games: Mockingjay Part 2	\N	\N	Blu-ray	f	2015	PG-13	\N	100
4d1e2001-1ed8-4d64-a68f-8537dd113558	The Hunger Games: Mockingjay Part 2	\N	\N	Digital	f	2015	PG-13	\N	100
daecc393-a2e9-43e4-b76f-26cbfa916e51	The Iron Giant	2020-10-15	2020-10-29	DVD	f	1999	PG	368975792811	108
90944831-a619-481a-ad52-41f9e87b381f	The Iron Giant	\N	\N	Blu-ray	f	1999	PG	\N	108
4ab840bf-186d-45a2-aaa5-885dce679cef	The Iron Giant	\N	\N	Digital	f	1999	PG	\N	108
f2c15003-26ee-4891-aa48-9a665e31abcd	The Jungle Book	2020-09-28	2020-10-12	DVD	f	1967	G	812958120357	108
2a3ce92b-996c-44e1-8e7a-93c88dcf3ebb	The Jungle Book	\N	\N	Blu-ray	f	1967	G	\N	108
1bb71600-cb67-4281-b536-a4fbb8fdd249	The Jungle Book	\N	\N	Digital	f	1967	G	\N	108
132ab1ee-26bd-49e4-a910-a8feaee4a548	The Land Before Time	2020-09-28	2020-10-12	DVD	f	1978	G	279893236088	108
3b563702-f9ec-40df-9102-c816b7c1a81f	The Land Before Time	\N	\N	Blu-ray	f	1978	G	\N	108
88325138-34a0-4c04-ace6-e9ff8e5d5148	The Land Before Time	\N	\N	Digital	f	1978	G	\N	108
67780437-7341-4473-b93a-a828fba29a54	The Lion King	\N	\N	DVD	f	1994	G	\N	108
d13be535-bf2e-4c74-ba88-3c5db785f538	The Lion King	\N	\N	Blu-ray	f	1994	G	\N	108
0495a28d-bfba-46fa-a988-bd6fe8d0779f	The Litte Mermaid	\N	\N	DVD	f	1989	G	\N	108
852e9118-774d-4018-bd71-d27d40b7ae8c	The Litte Mermaid	\N	\N	Blu-ray	f	1989	G	\N	108
419582fd-907b-4d7d-935c-21fa8f743d8f	The Lord of the Rings: The Fellowship of the Ring	\N	\N	DVD	f	2001	PG-13	\N	109
31c131c8-f170-4f54-9a61-6f3f075ad4aa	The Lord of the Rings: The Fellowship of the Ring	\N	\N	Blu-ray	f	2001	PG-13	\N	109
f9d4400e-5981-49e6-98c2-07eadd8b9219	The Lord of the Rings: The Fellowship of the Ring	\N	\N	Digital	f	2001	PG-13	\N	109
1980d094-f005-491c-9eed-06c0a0d5a9df	The Lord of the Rings: The Return of the King	\N	\N	Blu-ray	f	2003	PG-13	\N	109
662d6124-71fe-40a3-9594-c8b07e8834cb	The Lord of the Rings: The Return of the King	\N	\N	Digital	f	2003	PG-13	\N	109
4c4852bc-f2a1-4c5f-bdd1-bdd8b2e16711	The Lord of the Rings: The Two Towers	\N	\N	DVD	f	2002	PG-13	\N	109
13f16ee0-3ff3-4f86-bc65-9ec5d980fc5f	The Lord of the Rings: The Two Towers	\N	\N	Digital	f	2002	PG-13	\N	109
58296ee8-3e06-4335-9da0-79cc7a37fe48	The Mummy	\N	\N	DVD	f	1999	PG-13	\N	101
97461d8e-3f90-4b2b-afe4-3f390f89f1ab	The Mummy	\N	\N	Blu-ray	f	1999	PG-13	\N	101
d01252cf-e3c8-4b0e-a4cf-79839d095c48	The Mummy Returns	\N	\N	DVD	f	2001	PG-13	\N	101
2af3feac-e0ea-4082-8dbe-a0954e3cce32	The Mummy Returns	\N	\N	Blu-ray	f	2001	PG-13	\N	101
f54426a9-5007-430c-8e7b-46736d3cf0b0	The Mummy: Tomb of the Dragon Emperor	\N	\N	DVD	f	2008	PG-13	\N	101
fa43706d-e9f2-444a-8b69-46a4c577297c	The Mummy: Tomb of the Dragon Emperor	\N	\N	Blu-ray	f	2008	PG-13	\N	101
c82f3d69-2b2b-46cf-ab10-cd31744272da	The Right Stuff	2020-09-30	2020-10-14	DVD	f	1983	PG	724098502382	111
1a8a22b8-0081-4c5e-bf62-8cd9933eda38	The Right Stuff	\N	\N	Blu-ray	f	1983	PG	\N	111
1d384fca-3b9d-479f-a951-20e79ae81837	The Right Stuff	\N	\N	Digital	f	1983	PG	\N	111
b5676b59-94eb-4a3a-9b13-886a0134b27a	The Ring	\N	\N	DVD	t	2002	PG-13	\N	112
7e5cdb8f-6f52-4631-9eef-e857465a3d1c	The Ring	\N	\N	Blu-ray	t	2002	PG-13	\N	112
651de7c0-2e66-4e94-967c-be6d00ac2125	The Secret of NIMH	\N	\N	DVD	f	1982	G	\N	108
315e319e-fa89-48a3-bb3f-c9a9bea83be1	The Secret of NIMH	\N	\N	Blu-ray	f	1982	G	\N	108
1c260e67-b1cd-4abb-8bd6-6d7cde44ded4	The Shawshank Redemption	\N	\N	DVD	t	1994	R	\N	105
ed0f2f28-2ec0-411c-804b-05da2ea6b4a5	The Shawshank Redemption	\N	\N	Blu-ray	t	1994	R	\N	105
04a18b53-2b1a-4dc4-b5f9-09f34b756b2e	The Sound of Music	2020-09-28	2020-10-12	DVD	f	1965	G	160316518797	114
d12c70e3-705e-42d0-92e9-0b8ba8b0a636	The Sound of Music	\N	\N	Blu-ray	f	1965	G	\N	114
4ecb9f3c-88a5-4f98-9e4c-b7b6ace6c809	The Sound of Music	\N	\N	Digital	f	1965	G	\N	114
d719b3b4-88b6-4bfc-9bc3-686e7cdd7a2b	The Speed Cubers	\N	\N	DVD	f	2020	Not Rated	\N	106
879a6ffc-de24-4530-914f-1dc2d5fff305	The Speed Cubers	\N	\N	Blu-ray	f	2020	Not Rated	\N	106
e896f860-caea-433d-b5a7-dcc8b2ade6ce	The Terminator	2020-09-29	2020-10-13	DVD	t	1984	R	486437364595	100
4bfba909-8b97-4e0f-adfd-050767cee52c	The Terminator	\N	\N	Blu-ray	t	1984	R	\N	100
63c6e228-f78a-4f83-9a3c-f019a855363a	The Terminator	\N	\N	Digital	t	1984	R	\N	100
6e6aa9e3-f6a9-4b54-9f79-6f65fad7d621	The Hunger Games: Catching Fire	2020-11-18	2020-12-02	Blu-ray	f	2013	PG-13	959027290311	100
b673e938-e836-4eac-9722-42e19b7fc758	The Lord of the Rings: The Two Towers	\N	\N	Blu-ray	f	2002	PG-13	\N	109
07e04e01-3194-49dc-8c93-bb158282c24b	Thor	\N	\N	DVD	f	2011	PG-13	\N	120
116ef467-c575-4ee8-96d0-fbe4b55d22d4	Thor	\N	\N	Blu-ray	f	2011	PG-13	\N	120
52ed1f84-bf75-46be-89a5-dfc831c7f9b1	Thor	\N	\N	Digital	f	2011	PG-13	\N	120
3e00d99d-9d03-4b24-9ed5-47dbb5dd8fb9	Thor: Ragnarok	\N	\N	DVD	f	2017	PG-13	\N	120
202b9d14-752a-46b6-8396-64ab6f200513	Thor: Ragnarok	\N	\N	Blu-ray	f	2017	PG-13	\N	120
27253bad-4852-4589-9d4b-ea4ba4f94dab	Thor: Ragnarok	\N	\N	Digital	f	2017	PG-13	\N	120
a129fc44-35be-4133-af44-643aac01e4ae	Thor: The Dark World	\N	\N	DVD	f	2013	PG-13	\N	120
27f90a96-e712-4ab3-b1ff-9664bc3b06b0	Thor: The Dark World	\N	\N	Blu-ray	f	2013	PG-13	\N	120
ea5d4b83-a1c5-46e4-83bf-6c5129dc9e18	Thor: The Dark World	\N	\N	Digital	f	2013	PG-13	\N	120
f31f1eb7-23bc-46cb-bf0c-159513a0bb36	Titanic	\N	\N	Blu-ray	f	1997	PG-13	\N	116
68c4479f-5e27-45e2-8f9a-ea6f3cf07a39	Titanic	\N	\N	DVD	f	1997	PG-13	\N	116
92ad61f1-6d65-49fe-9f60-369f52da315b	To Kill a Mockingbird	\N	\N	DVD	f	1962	Not Rated	\N	105
fc50ce1e-f612-492e-b021-511f4b978bd3	To Kill a Mockingbird	\N	\N	Blu-ray	f	1962	Not Rated	\N	105
ba6f0ee5-d349-4807-ac4b-43364501b8b4	To Kill a Mockingbird	\N	\N	Digital	f	1962	Not Rated	\N	105
e9e57d5f-d4c4-4c96-a918-9ccda11fcb80	Unforgiven	\N	\N	DVD	t	1992	R	\N	123
77ca3cdd-7787-4d50-b4ca-e2f0b9ddb8d1	Unforgiven	\N	\N	Blu-ray	t	1992	R	\N	123
7d71cdd6-7a48-4c2e-821b-d0e106d3ebfa	Up	2020-09-30	2020-10-14	Blu-ray	f	2009	PG	286743336269	108
3818e87f-579b-4085-9d51-364c8e6190ba	Up	\N	\N	DVD	f	2009	PG	\N	108
8852839c-cd81-4254-95b0-6c7dee8d77b8	Up	\N	\N	Digital	f	2009	PG	\N	108
6ee88ce6-ec34-45ba-a2b3-e88731ca8f88	When Harry Met Sally	\N	\N	DVD	t	1989	R	\N	104
f944d35d-81b8-4717-b827-36d9f9ae4a6f	When Harry Met Sally	\N	\N	Blu-ray	t	1989	R	\N	104
35d2ddda-8630-4e3f-ade0-28b835202680	Wonder Woman	\N	\N	DVD	f	2017	PG-13	\N	120
e8e49b4d-dd59-436a-9102-ceb08065bc52	Harry Potter and the Sorcerer's Stone	\N	\N	DVD	f	2001	PG	\N	109
ce6aee8e-5442-40c2-b7b7-c6e89227164b	Harry Potter and the Sorcerer's Stone	\N	\N	Blu-ray	f	2001	PG	\N	109
224897d5-4454-4f3a-b5a1-79d62c13baba	Harry Potter and the Sorcerer's Stone	\N	\N	Digital	f	2001	PG	\N	109
7a5f1f0f-b1c4-4a67-a06e-8bc2e302319d	Halloween	\N	\N	Blu-ray	t	1978	R	\N	112
0cf5d1ad-7515-4339-9d8a-06f4ac2b3720	The Lord of the Rings: The Return of the King	2020-11-18	2020-12-02	DVD	f	2003	PG-13	959027290311	109
b5ff6f74-2822-418b-a3ef-7b10636795fb	Star Wars Episode VII: The Force Awakens	2020-11-18	2020-12-02	Digital	f	2015	PG-13	959027290311	117
908aa5c4-d9bf-48ca-801c-66f6a4007cb4	Wonder Woman	\N	\N	Blu-ray	f	2017	PG-13	\N	120
ed2d27ec-8a3a-4086-9b1d-67f2a73a3092	Halloween 5: The Revenge of Michael Myers	2020-11-02	2020-11-16	Blu-ray	t	1989	R	959027290311	112
\.


--
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: alex
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (bookid);


--
-- Name: card card_pkey; Type: CONSTRAINT; Schema: public; Owner: alex
--

ALTER TABLE ONLY public.card
    ADD CONSTRAINT card_pkey PRIMARY KEY (cardnumber);


--
-- Name: cardholder cardholder_pkey; Type: CONSTRAINT; Schema: public; Owner: alex
--

ALTER TABLE ONLY public.cardholder
    ADD CONSTRAINT cardholder_pkey PRIMARY KEY (cardholderid);


--
-- Name: genre genre_pkey; Type: CONSTRAINT; Schema: public; Owner: alex
--

ALTER TABLE ONLY public.genre
    ADD CONSTRAINT genre_pkey PRIMARY KEY (genrecode);


--
-- Name: movie movie_pkey; Type: CONSTRAINT; Schema: public; Owner: alex
--

ALTER TABLE ONLY public.movie
    ADD CONSTRAINT movie_pkey PRIMARY KEY (movieid);


--
-- Name: book book_checkedoutby_fkey; Type: FK CONSTRAINT; Schema: public; Owner: alex
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_checkedoutby_fkey FOREIGN KEY (checkedoutby) REFERENCES public.card(cardnumber) ON DELETE CASCADE;


--
-- Name: book book_genrecode_fkey; Type: FK CONSTRAINT; Schema: public; Owner: alex
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_genrecode_fkey FOREIGN KEY (genrecode) REFERENCES public.genre(genrecode);


--
-- Name: cardholder cardholder_cardnumber_fkey; Type: FK CONSTRAINT; Schema: public; Owner: alex
--

ALTER TABLE ONLY public.cardholder
    ADD CONSTRAINT cardholder_cardnumber_fkey FOREIGN KEY (cardnumber) REFERENCES public.card(cardnumber) ON DELETE CASCADE;


--
-- Name: movie movie_checkedoutby_fkey; Type: FK CONSTRAINT; Schema: public; Owner: alex
--

ALTER TABLE ONLY public.movie
    ADD CONSTRAINT movie_checkedoutby_fkey FOREIGN KEY (checkedoutby) REFERENCES public.card(cardnumber) ON DELETE CASCADE;


--
-- Name: movie movie_genrecode_fkey; Type: FK CONSTRAINT; Schema: public; Owner: alex
--

ALTER TABLE ONLY public.movie
    ADD CONSTRAINT movie_genrecode_fkey FOREIGN KEY (genrecode) REFERENCES public.genre(genrecode);


--
-- PostgreSQL database dump complete
--

