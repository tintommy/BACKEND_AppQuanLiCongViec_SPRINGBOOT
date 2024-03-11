USE [master]
GO
/****** Object:  Database [APP_QUAN_LY_CONG_VIEC]    Script Date: 3/11/2024 10:48:48 PM ******/
CREATE DATABASE [APP_QUAN_LY_CONG_VIEC]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'APP_QUAN_LY_CONG_VIEC', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\APP_QUAN_LY_CONG_VIEC.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'APP_QUAN_LY_CONG_VIEC_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\APP_QUAN_LY_CONG_VIEC_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [APP_QUAN_LY_CONG_VIEC].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET ARITHABORT OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET  DISABLE_BROKER 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET RECOVERY FULL 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET  MULTI_USER 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET DB_CHAINING OFF 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'APP_QUAN_LY_CONG_VIEC', N'ON'
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET QUERY_STORE = OFF
GO
USE [APP_QUAN_LY_CONG_VIEC]
GO
/****** Object:  Table [dbo].[Cong_Viec]    Script Date: 3/11/2024 10:48:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cong_Viec](
	[ma_cv] [int] IDENTITY(1,1) NOT NULL,
	[tieu_de] [nvarchar](200) NOT NULL,
	[noi_dung] [ntext] NOT NULL,
	[ngay_bat_dau] [date] NOT NULL,
	[tinh_chat] [int] NOT NULL,
	[chu_ki] [nvarchar](100) NOT NULL,
	[dung_sau_ngay] [date] NULL,
	[so_lan] [int] NULL,
	[ma_nd] [int] NOT NULL,
 CONSTRAINT [PK_Cong_Viec] PRIMARY KEY CLUSTERED 
(
	[ma_cv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cong_Viec_Ngay]    Script Date: 3/11/2024 10:48:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cong_Viec_Ngay](
	[ma_cv_ngay] [int] IDENTITY(1,1) NOT NULL,
	[ngay_lam] [date] NOT NULL,
	[trang_thai] [bit] NOT NULL,
	[ma_cv] [int] NOT NULL,
 CONSTRAINT [PK_Cong_Viec_Ngay] PRIMARY KEY CLUSTERED 
(
	[ma_cv_ngay] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ghi_Chu_Ca_Nhan]    Script Date: 3/11/2024 10:48:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ghi_Chu_Ca_Nhan](
	[ma_gccn] [int] IDENTITY(1,1) NOT NULL,
	[tieu_de] [nvarchar](500) NOT NULL,
	[noi_dung] [ntext] NOT NULL,
	[ngay_chinh_sua] [date] NOT NULL,
	[ma_nd] [int] NOT NULL,
 CONSTRAINT [PK_Ghi_Chu_Ca_Nhan] PRIMARY KEY CLUSTERED 
(
	[ma_gccn] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ghi_Chu_Mat_Khau]    Script Date: 3/11/2024 10:48:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ghi_Chu_Mat_Khau](
	[ma_gcmk] [int] IDENTITY(1,1) NOT NULL,
	[tieu_de] [nvarchar](500) NOT NULL,
	[tai_khoan] [ntext] NULL,
	[mat_khau] [ntext] NOT NULL,
	[ghi_chu_khac] [ntext] NOT NULL,
	[ma_nd] [int] NOT NULL,
 CONSTRAINT [PK_Ghi_Chu_Mat_Khau] PRIMARY KEY CLUSTERED 
(
	[ma_gcmk] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hinh_Anh]    Script Date: 3/11/2024 10:48:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hinh_Anh](
	[ma_hinh] [int] IDENTITY(1,1) NOT NULL,
	[link] [text] NOT NULL,
	[ma_cv_ngay] [int] NOT NULL,
 CONSTRAINT [PK_Hinh_Anh] PRIMARY KEY CLUSTERED 
(
	[ma_hinh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Nguoi_Dung]    Script Date: 3/11/2024 10:48:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nguoi_Dung](
	[ma_nd] [int] IDENTITY(1,1) NOT NULL,
	[ho] [nvarchar](50) NOT NULL,
	[ten] [nvarchar](50) NOT NULL,
	[ngay_sinh] [date] NOT NULL,
	[gioi_tinh] [bit] NOT NULL,
	[email] [ntext] NOT NULL,
	[mat_khau] [ntext] NOT NULL,
	[ma_pin] [char](6) NOT NULL,
 CONSTRAINT [PK_Nguoi_Dung] PRIMARY KEY CLUSTERED 
(
	[ma_nd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Su_Kien]    Script Date: 3/11/2024 10:48:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Su_Kien](
	[ma_sk] [int] IDENTITY(1,1) NOT NULL,
	[ten_su_kien] [nvarchar](500) NOT NULL,
	[ngay] [date] NOT NULL,
	[gio] [varchar](7) NOT NULL,
	[nhac_truoc] [int] NOT NULL,
	[ngay_nhac] [date] NOT NULL,
	[mo_ta] [ntext] NULL,
	[ma_nd] [int] NOT NULL,
 CONSTRAINT [PK_Su_Kien] PRIMARY KEY CLUSTERED 
(
	[ma_sk] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Cong_Viec] ON 

INSERT [dbo].[Cong_Viec] ([ma_cv], [tieu_de], [noi_dung], [ngay_bat_dau], [tinh_chat], [chu_ki], [dung_sau_ngay], [so_lan], [ma_nd]) VALUES (1, N'test tiêu đề', N'test nội dung', CAST(N'2024-03-04' AS Date), 0, N'1 lan', NULL, 2, 2)
INSERT [dbo].[Cong_Viec] ([ma_cv], [tieu_de], [noi_dung], [ngay_bat_dau], [tinh_chat], [chu_ki], [dung_sau_ngay], [so_lan], [ma_nd]) VALUES (4, N'test tiêu đề 2', N'test nội dung 2', CAST(N'2024-03-04' AS Date), 1, N'1 lan', NULL, 2, 2)
INSERT [dbo].[Cong_Viec] ([ma_cv], [tieu_de], [noi_dung], [ngay_bat_dau], [tinh_chat], [chu_ki], [dung_sau_ngay], [so_lan], [ma_nd]) VALUES (5, N'test tiêu đề 3', N'test nội dung 2', CAST(N'2024-03-04' AS Date), 2, N'1 lan', NULL, 2, 2)
SET IDENTITY_INSERT [dbo].[Cong_Viec] OFF
GO
SET IDENTITY_INSERT [dbo].[Cong_Viec_Ngay] ON 

INSERT [dbo].[Cong_Viec_Ngay] ([ma_cv_ngay], [ngay_lam], [trang_thai], [ma_cv]) VALUES (1066, CAST(N'2024-03-04' AS Date), 1, 4)
INSERT [dbo].[Cong_Viec_Ngay] ([ma_cv_ngay], [ngay_lam], [trang_thai], [ma_cv]) VALUES (1068, CAST(N'2024-03-04' AS Date), 1, 5)
INSERT [dbo].[Cong_Viec_Ngay] ([ma_cv_ngay], [ngay_lam], [trang_thai], [ma_cv]) VALUES (1069, CAST(N'2024-03-04' AS Date), 0, 1)
INSERT [dbo].[Cong_Viec_Ngay] ([ma_cv_ngay], [ngay_lam], [trang_thai], [ma_cv]) VALUES (1070, CAST(N'2024-03-04' AS Date), 1, 4)
INSERT [dbo].[Cong_Viec_Ngay] ([ma_cv_ngay], [ngay_lam], [trang_thai], [ma_cv]) VALUES (1071, CAST(N'2024-03-04' AS Date), 1, 5)
SET IDENTITY_INSERT [dbo].[Cong_Viec_Ngay] OFF
GO
SET IDENTITY_INSERT [dbo].[Hinh_Anh] ON 

INSERT [dbo].[Hinh_Anh] ([ma_hinh], [link], [ma_cv_ngay]) VALUES (1030, N'https://firebasestorage.googleapis.com/v0/b/appquanlycongviec-c8b0e.appspot.com/o/images%2Fimage_452e28cb-fa80-44e4-8192-88024a682a28?alt=media&token=76add153-82df-4ab7-bc55-f022c6d90075', 1071)
INSERT [dbo].[Hinh_Anh] ([ma_hinh], [link], [ma_cv_ngay]) VALUES (1031, N'https://firebasestorage.googleapis.com/v0/b/appquanlycongviec-c8b0e.appspot.com/o/images%2Fimage_e9f7f7e4-aa6b-4849-b73d-cdec5806237d?alt=media&token=b7564174-079e-4b87-9fe4-5874f2fd6c0f', 1071)
INSERT [dbo].[Hinh_Anh] ([ma_hinh], [link], [ma_cv_ngay]) VALUES (1032, N'https://firebasestorage.googleapis.com/v0/b/appquanlycongviec-c8b0e.appspot.com/o/images%2Fimage_21c45a5f-a61a-413f-965b-c65b915c303d?alt=media&token=33b5e0b2-ecc4-493b-ab15-1f2920d5359c', 1071)
INSERT [dbo].[Hinh_Anh] ([ma_hinh], [link], [ma_cv_ngay]) VALUES (1033, N'https://firebasestorage.googleapis.com/v0/b/appquanlycongviec-c8b0e.appspot.com/o/images%2Fimage_4c7706f9-73c0-43c0-8ecd-7f3f0c7e3461?alt=media&token=64651c98-c616-476a-a6f2-8d485fef60a0', 1068)
INSERT [dbo].[Hinh_Anh] ([ma_hinh], [link], [ma_cv_ngay]) VALUES (1034, N'https://firebasestorage.googleapis.com/v0/b/appquanlycongviec-c8b0e.appspot.com/o/images%2Fimage_732b1103-1229-4f29-9371-77228046dba1?alt=media&token=691c13e8-958a-41ff-add8-bf57f4d965a2', 1068)
SET IDENTITY_INSERT [dbo].[Hinh_Anh] OFF
GO
SET IDENTITY_INSERT [dbo].[Nguoi_Dung] ON 

INSERT [dbo].[Nguoi_Dung] ([ma_nd], [ho], [ten], [ngay_sinh], [gioi_tinh], [email], [mat_khau], [ma_pin]) VALUES (2, N'Nguyen', N'Tin', CAST(N'2002-05-27' AS Date), 1, N'tinnguyen3523', N'12345678', N'111111')
SET IDENTITY_INSERT [dbo].[Nguoi_Dung] OFF
GO
ALTER TABLE [dbo].[Cong_Viec]  WITH CHECK ADD  CONSTRAINT [FK_Cong_Viec_Nguoi_Dung] FOREIGN KEY([ma_nd])
REFERENCES [dbo].[Nguoi_Dung] ([ma_nd])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Cong_Viec] CHECK CONSTRAINT [FK_Cong_Viec_Nguoi_Dung]
GO
ALTER TABLE [dbo].[Cong_Viec]  WITH CHECK ADD  CONSTRAINT [FK6xewhqiljr4c3ql0xe3em93bg] FOREIGN KEY([ma_nd])
REFERENCES [dbo].[Nguoi_Dung] ([ma_nd])
GO
ALTER TABLE [dbo].[Cong_Viec] CHECK CONSTRAINT [FK6xewhqiljr4c3ql0xe3em93bg]
GO
ALTER TABLE [dbo].[Cong_Viec_Ngay]  WITH CHECK ADD  CONSTRAINT [FK_Cong_Viec_Ngay_Cong_Viec] FOREIGN KEY([ma_cv])
REFERENCES [dbo].[Cong_Viec] ([ma_cv])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Cong_Viec_Ngay] CHECK CONSTRAINT [FK_Cong_Viec_Ngay_Cong_Viec]
GO
ALTER TABLE [dbo].[Ghi_Chu_Ca_Nhan]  WITH CHECK ADD  CONSTRAINT [FK_Ghi_Chu_Ca_Nhan_Nguoi_Dung] FOREIGN KEY([ma_nd])
REFERENCES [dbo].[Nguoi_Dung] ([ma_nd])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Ghi_Chu_Ca_Nhan] CHECK CONSTRAINT [FK_Ghi_Chu_Ca_Nhan_Nguoi_Dung]
GO
ALTER TABLE [dbo].[Ghi_Chu_Mat_Khau]  WITH CHECK ADD  CONSTRAINT [FK_Ghi_Chu_Mat_Khau_Nguoi_Dung] FOREIGN KEY([ma_nd])
REFERENCES [dbo].[Nguoi_Dung] ([ma_nd])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Ghi_Chu_Mat_Khau] CHECK CONSTRAINT [FK_Ghi_Chu_Mat_Khau_Nguoi_Dung]
GO
ALTER TABLE [dbo].[Ghi_Chu_Mat_Khau]  WITH CHECK ADD  CONSTRAINT [FKewo83nn2g4ot7efebr5noreh4] FOREIGN KEY([ma_nd])
REFERENCES [dbo].[Nguoi_Dung] ([ma_nd])
GO
ALTER TABLE [dbo].[Ghi_Chu_Mat_Khau] CHECK CONSTRAINT [FKewo83nn2g4ot7efebr5noreh4]
GO
ALTER TABLE [dbo].[Hinh_Anh]  WITH CHECK ADD  CONSTRAINT [FK_Hinh_Anh_Cong_Viec_Ngay] FOREIGN KEY([ma_cv_ngay])
REFERENCES [dbo].[Cong_Viec_Ngay] ([ma_cv_ngay])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Hinh_Anh] CHECK CONSTRAINT [FK_Hinh_Anh_Cong_Viec_Ngay]
GO
ALTER TABLE [dbo].[Su_Kien]  WITH CHECK ADD  CONSTRAINT [FK_Su_Kien_Nguoi_Dung] FOREIGN KEY([ma_nd])
REFERENCES [dbo].[Nguoi_Dung] ([ma_nd])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Su_Kien] CHECK CONSTRAINT [FK_Su_Kien_Nguoi_Dung]
GO
ALTER TABLE [dbo].[Su_Kien]  WITH CHECK ADD  CONSTRAINT [FKb7ky3x0adl82jvfvxx8yovcj7] FOREIGN KEY([ma_nd])
REFERENCES [dbo].[Nguoi_Dung] ([ma_nd])
GO
ALTER TABLE [dbo].[Su_Kien] CHECK CONSTRAINT [FKb7ky3x0adl82jvfvxx8yovcj7]
GO
USE [master]
GO
ALTER DATABASE [APP_QUAN_LY_CONG_VIEC] SET  READ_WRITE 
GO
