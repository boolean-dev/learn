/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 120001
 Source Host           : localhost:5432
 Source Catalog        : master
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120001
 File Encoding         : 65001

 Date: 30/12/2019 18:33:56
*/


-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_user";
CREATE TABLE "public"."tb_user" (
  "id" int8 NOT NULL DEFAULT nextval('tb_user_id_seq'::regclass),
  "age" int4,
  "create_time" timestamp(6),
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "sex" int4,
  "update_time" timestamp(6)
)
;

-- ----------------------------
-- Primary Key structure for table tb_user
-- ----------------------------
ALTER TABLE "public"."tb_user" ADD CONSTRAINT "tb_user_pkey" PRIMARY KEY ("id");
