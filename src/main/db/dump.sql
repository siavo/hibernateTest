PGDMP  0    .                |            postgres    16.3    16.3 3               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                        1262    5    postgres    DATABASE     }   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Belarus.1251';
    DROP DATABASE postgres;
                postgres    false            !           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    4896                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            "           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            �            1259    24761    chat    TABLE     ^   CREATE TABLE public.chat (
    id bigint NOT NULL,
    name character varying(32) NOT NULL
);
    DROP TABLE public.chat;
       public         heap    postgres    false            �            1259    24760    chat_id_seq    SEQUENCE     t   CREATE SEQUENCE public.chat_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.chat_id_seq;
       public          postgres    false    223            #           0    0    chat_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.chat_id_seq OWNED BY public.chat.id;
          public          postgres    false    222            �            1259    24724    company    TABLE     b   CREATE TABLE public.company (
    id integer NOT NULL,
    name character varying(32) NOT NULL
);
    DROP TABLE public.company;
       public         heap    postgres    false            �            1259    24723    company_id_seq    SEQUENCE     �   CREATE SEQUENCE public.company_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.company_id_seq;
       public          postgres    false    217            $           0    0    company_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.company_id_seq OWNED BY public.company.id;
          public          postgres    false    216            �            1259    24747    profile    TABLE     �   CREATE TABLE public.profile (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    street character varying(32),
    language character(2)
);
    DROP TABLE public.profile;
       public         heap    postgres    false            �            1259    24746    profile_id_seq    SEQUENCE     w   CREATE SEQUENCE public.profile_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.profile_id_seq;
       public          postgres    false    221            %           0    0    profile_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.profile_id_seq OWNED BY public.profile.id;
          public          postgres    false    220            �            1259    24770 	   user_chat    TABLE     b   CREATE TABLE public.user_chat (
    id bigint NOT NULL,
    user_id bigint,
    chat_id bigint
);
    DROP TABLE public.user_chat;
       public         heap    postgres    false            �            1259    24769    user_chat_id_seq    SEQUENCE     y   CREATE SEQUENCE public.user_chat_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.user_chat_id_seq;
       public          postgres    false    225            &           0    0    user_chat_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.user_chat_id_seq OWNED BY public.user_chat.id;
          public          postgres    false    224            �            1259    24733    users    TABLE     �   CREATE TABLE public.users (
    id bigint NOT NULL,
    username character varying(128) NOT NULL,
    firstname character varying(128),
    lastname character varying(128),
    birth_date date,
    role character varying(32),
    company_id integer
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    24732    users_id_seq    SEQUENCE     u   CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false    219            '           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          postgres    false    218            h           2604    24764    chat id    DEFAULT     b   ALTER TABLE ONLY public.chat ALTER COLUMN id SET DEFAULT nextval('public.chat_id_seq'::regclass);
 6   ALTER TABLE public.chat ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    223    222    223            e           2604    24727 
   company id    DEFAULT     h   ALTER TABLE ONLY public.company ALTER COLUMN id SET DEFAULT nextval('public.company_id_seq'::regclass);
 9   ALTER TABLE public.company ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    216    217            g           2604    24750 
   profile id    DEFAULT     h   ALTER TABLE ONLY public.profile ALTER COLUMN id SET DEFAULT nextval('public.profile_id_seq'::regclass);
 9   ALTER TABLE public.profile ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    221    221            i           2604    24773    user_chat id    DEFAULT     l   ALTER TABLE ONLY public.user_chat ALTER COLUMN id SET DEFAULT nextval('public.user_chat_id_seq'::regclass);
 ;   ALTER TABLE public.user_chat ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    225    224    225            f           2604    24736    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    219    219                      0    24761    chat 
   TABLE DATA           (   COPY public.chat (id, name) FROM stdin;
    public          postgres    false    223   �5                 0    24724    company 
   TABLE DATA           +   COPY public.company (id, name) FROM stdin;
    public          postgres    false    217   6                 0    24747    profile 
   TABLE DATA           @   COPY public.profile (id, user_id, street, language) FROM stdin;
    public          postgres    false    221   36                 0    24770 	   user_chat 
   TABLE DATA           9   COPY public.user_chat (id, user_id, chat_id) FROM stdin;
    public          postgres    false    225   z6                 0    24733    users 
   TABLE DATA           `   COPY public.users (id, username, firstname, lastname, birth_date, role, company_id) FROM stdin;
    public          postgres    false    219   �6       (           0    0    chat_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.chat_id_seq', 7, true);
          public          postgres    false    222            )           0    0    company_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.company_id_seq', 3, true);
          public          postgres    false    216            *           0    0    profile_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.profile_id_seq', 7, true);
          public          postgres    false    220            +           0    0    user_chat_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.user_chat_id_seq', 7, true);
          public          postgres    false    224            ,           0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 7, true);
          public          postgres    false    218            w           2606    24768    chat chat_name_key 
   CONSTRAINT     M   ALTER TABLE ONLY public.chat
    ADD CONSTRAINT chat_name_key UNIQUE (name);
 <   ALTER TABLE ONLY public.chat DROP CONSTRAINT chat_name_key;
       public            postgres    false    223            y           2606    24766    chat chat_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.chat
    ADD CONSTRAINT chat_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.chat DROP CONSTRAINT chat_pkey;
       public            postgres    false    223            k           2606    24731    company company_name_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.company
    ADD CONSTRAINT company_name_key UNIQUE (name);
 B   ALTER TABLE ONLY public.company DROP CONSTRAINT company_name_key;
       public            postgres    false    217            m           2606    24729    company company_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.company
    ADD CONSTRAINT company_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.company DROP CONSTRAINT company_pkey;
       public            postgres    false    217            s           2606    24752    profile profile_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.profile DROP CONSTRAINT profile_pkey;
       public            postgres    false    221            u           2606    24754    profile profile_user_id_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_user_id_key UNIQUE (user_id);
 E   ALTER TABLE ONLY public.profile DROP CONSTRAINT profile_user_id_key;
       public            postgres    false    221            {           2606    24775    user_chat user_chat_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.user_chat
    ADD CONSTRAINT user_chat_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.user_chat DROP CONSTRAINT user_chat_pkey;
       public            postgres    false    225            }           2606    24777 '   user_chat user_chat_user_id_chat_id_key 
   CONSTRAINT     n   ALTER TABLE ONLY public.user_chat
    ADD CONSTRAINT user_chat_user_id_chat_id_key UNIQUE (user_id, chat_id);
 Q   ALTER TABLE ONLY public.user_chat DROP CONSTRAINT user_chat_user_id_chat_id_key;
       public            postgres    false    225    225            o           2606    24738    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    219            q           2606    24740    users users_username_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);
 B   ALTER TABLE ONLY public.users DROP CONSTRAINT users_username_key;
       public            postgres    false    219                       2606    24755    profile profile_user_id_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 F   ALTER TABLE ONLY public.profile DROP CONSTRAINT profile_user_id_fkey;
       public          postgres    false    219    221    4719            �           2606    24783     user_chat user_chat_chat_id_fkey    FK CONSTRAINT     ~   ALTER TABLE ONLY public.user_chat
    ADD CONSTRAINT user_chat_chat_id_fkey FOREIGN KEY (chat_id) REFERENCES public.chat(id);
 J   ALTER TABLE ONLY public.user_chat DROP CONSTRAINT user_chat_chat_id_fkey;
       public          postgres    false    4729    223    225            �           2606    24778     user_chat user_chat_user_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.user_chat
    ADD CONSTRAINT user_chat_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 J   ALTER TABLE ONLY public.user_chat DROP CONSTRAINT user_chat_user_id_fkey;
       public          postgres    false    219    225    4719            ~           2606    24741    users users_company_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_company_id_fkey FOREIGN KEY (company_id) REFERENCES public.company(id);
 E   ALTER TABLE ONLY public.users DROP CONSTRAINT users_company_id_fkey;
       public          postgres    false    219    4717    217               f   x�-ɻ1�ت���-Ջ��8px����f�����������rP���]���V�
�B3��,4�fMF����`sl�Р���$�5���q�̾�1���i*,            x�3�t��O�I����� ^J         7   x�Mǹ  �x]3͐���IO�*�sw�e?s\�h�N�!�d�V1���         *   x���  İw2R��2�?'�(�I�7a�K������         Y   x�3�,K�I�,�I��e�������@���i�e�2�tĭ�l�!�n%&`%������q��VbQbL���`e�f���qqq ��@�     