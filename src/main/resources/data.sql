INSERT INTO `member_role` (`role`) VALUES ('ROLE_ADMIN'), ('ROLE_USER'), ('ROLE_GUEST');
INSERT INTO `member` (`member_id`, `password`, `member_role_id`, `name`, `email`, `nickname`, `phone`, `created_at`, `updated_at`, `deleted_at`) VALUES ('hama', 'abc123', 1, '하마', 'mailtest@msplus.com', '하마', '010-1111-2222', '2024-02-06 00:00:00', '2024-02-06 00:00:00', null);
INSERT INTO `category` (`id`, `name`, `created_at`, `updated_at`, `deleted_at`) VALUES (1, 'category1', '2024-02-06 00:00:00', '2024-02-06 00:00:00', null);
