create database newsweb

create table Users(
	username varchar(20) primary key,
	matkhau varchar(20) not null,
	hoten Nvarchar(30) not null,
	quyen int check(quyen = 0 or quyen = 1)
)

create table Theloai(
	id_theloai varchar(20) primary key,
	theloai Nvarchar(20) not null
)

create table Baiviet(
	id int identity(1,1) primary key,
	tieude Nvarchar(200) not null,
	username varchar(20) not null foreign key references Users(username),
	theloai varchar(20) not null foreign key references Theloai(id_theloai),
	tomtat Nvarchar(500) not null,
	noidung Nvarchar(max) not null,
	hinhanh varchar(500) not null,
	ngaydang DATE,
	duyet int check (duyet = 0 or duyet = 1),
	ngayduyet DATE
)

create table Thongbao(
	id int identity(1,1) primary key,
	usergui varchar(20) not null foreign key references Users(username),
	usernhan varchar(20) not null foreign key references Users(username),
	noidung Nvarchar(Max) not null,
	ngaygui date,
	trangthai int check (trangthai = 0 or trangthai = 1) not null
)


insert into Users
values

('son','123',N'nguyễn sơn',0),

('admin','admin','admin',1)

delete from Users
where quyen = 0

select * from Users

insert into Theloai
values
('congnghe',N'Công nghệ')
('giaitri',N'Giải trí'),
('vanhoa',N'Văn hóa'),
('doisong',N'Đời sống'),
('thethao',N'Thể thao')



select top 1 * from Baiviet
where theloai = 'giaitri' and ngayduyet = (select max(ngayduyet) from Baiviet where theloai = 'giaitri')
union
select top 1 * from Baiviet
where theloai = 'vanhoa' and ngayduyet = (select max(ngayduyet) from Baiviet where theloai = 'vanhoa')
union
select top 1 * from Baiviet
where theloai = 'doisong' and ngayduyet = (select max(ngayduyet) from Baiviet where theloai = 'doisong')
union
select top 1 * from Baiviet
where theloai = 'thethao' and ngayduyet = (select max(ngayduyet) from Baiviet where theloai = 'thethao')


select top 4 * from Baiviet
group by id


select * from baiviet limit 1,3

select count(id) from baiviet
where theloai = 'vanhoa'


select * from baiviet where tieuDe = N'Nam MC VTV bị vợ “dọa” cho… ra đường nếu không chịu nấu ăn'

select hoten from Users where username = 'son'

update baiviet 
set tieude = ?

delete from baiviet
where tieuDe = ''

select u.username,u.hoten, sum(b.duyet) as 'so bai viet'
from users as u
left join
Baiviet as b on u.username = b.username 
where u.quyen = 0
group by u.username,u.hoten




select * from Baiviet where duyet = 0

select * from users

delete from Baiviet where username = 'son123'
delete from users where username = 'son123'

select * from baiviet


select top 3 * from baiviet where duyet = 1 order by id desc

select top 1 * from baiviet where theloai = 'doisong' and duyet = 1 order by id desc

select * from (select top 3 * from baiviet where duyet = 1 order by id desc) as b 
where id < (select max(id) from baiviet where duyet = 1)

select top 1 * from baiviet where duyet = 1 order by id desc

ALTER TABLE thongbao
aDD status varchar(10);

update baiviet 
set luotxem =22
where id = 2

insert into baiviet
values
('11','son','thethao','fdf','ffff','3.jpg','2019-03-30',0,null,0)


select * from Users
select * from Thongbao
select count(trangthai) from Thongbao where trangthai = 0 and usernhan = 'son'

insert Thongbao
values
('admin','son',N'Bài viết của bạn đã được duyệt','2019-3-30',0)