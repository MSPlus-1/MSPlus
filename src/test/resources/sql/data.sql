INSERT INTO `member_role` (`role`) VALUES ('ROLE_ADMIN'), ('ROLE_USER'), ('ROLE_GUEST');
INSERT INTO `member` (`member_id`, `password`, `member_role_id`, `name`, `email`, `nickname`, `phone`, `created_at`, `updated_at`, `deleted_at`) VALUES ('hama', 'hama1', 1, '하마', 'mailtest@msplus.com', '하마', '010-1111-2222', '2024-02-06 00:00:00', '2024-02-06 00:00:00', null);
INSERT INTO `member` (`member_id`, `password`, `member_role_id`, `name`, `email`, `nickname`, `phone`, `created_at`, `updated_at`, `deleted_at`) VALUES ('hama', 'hama2', 2, '하마2', 'mailtest@msplus.com', '하마', '010-1111-2222', '2024-02-06 00:00:00', '2024-02-06 00:00:00', null);
INSERT INTO `category` (`id`, `name`, `created_at`, `updated_at`, `deleted_at`) VALUES (1, 'category1', '2024-02-06 00:00:00', '2024-02-06 00:00:00', null);
INSERT INTO `board` (`id`, `name`, `category_id`, `member_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (1, '게시판1', 1, 1, '2024-02-06 00:00:00', '2024-02-06 00:00:00', null);
INSERT INTO `board` (`id`, `name`, `category_id`, `member_id`, `created_at`, `updated_at`, `deleted_at`) VALUES (2, '게시판2', 1, 1, '2024-02-06 00:00:00', '2024-02-06 00:00:00', null);
