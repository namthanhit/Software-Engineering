CREATE DATABASE DangVien;

use DangVien;

-- Table: Category
CREATE TABLE Category (
    id VARCHAR(255) PRIMARY KEY,
    categoryName VARCHAR(255),
    description VARCHAR(255)
);

-- Table: PartyOrganization
CREATE TABLE PartyOrganization (
    id VARCHAR(255) PRIMARY KEY,
    orgName VARCHAR(255),
    creationDate DATE
);

-- Table: PartyMember
CREATE TABLE PartyMember (
    id VARCHAR(255) PRIMARY KEY,
    fullName VARCHAR(255),
    birthDate DATE,
    joinDate DATE,
    address VARCHAR(255),
    email VARCHAR(255),
    phoneNumber VARCHAR(50),
    status VARCHAR(50),
    orgId VARCHAR(255),
    avatar LONGBLOB,
    FOREIGN KEY (orgId) REFERENCES PartyOrganization(id)
);

-- Table: User
CREATE TABLE User (
    -- id VARCHAR(255) PRIMARY KEY,
    partyMemberId VARCHAR(255) ,
    partOrgId VARCHAR(255),
    -- username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role BOOLEAN NOT NULL,
    FOREIGN KEY (partyMemberId) REFERENCES PartyMember(id),
    FOREIGN KEY (partOrgId) REFERENCES PartyOrganization(id)
);


-- Table: BranchActivity
CREATE TABLE BranchActivity (
    id VARCHAR(255) PRIMARY KEY,
    activityName VARCHAR(255),
    startDate DATE,
    endDate DATE,
    status VARCHAR(50),
    description VARCHAR(255),
    orgId VARCHAR(255),
    FOREIGN KEY (orgId) REFERENCES PartyOrganization(id)
);

-- Table: Reward
CREATE TABLE Reward (
    id VARCHAR(255) PRIMARY KEY,
    partyMemberId VARCHAR(255),
    rewardDate DATE,
    decisionMaker VARCHAR(255),
    description VARCHAR(255),
    FOREIGN KEY (partyMemberId) REFERENCES PartyMember(id)
);

-- Table: TransferOut
CREATE TABLE TransferOut (
    id VARCHAR(255) PRIMARY KEY,
    partyMemberId VARCHAR(255),
    orgId VARCHAR(255),
    status VARCHAR(50),
    transferDate DATE,
    reason text,
    FOREIGN KEY (partyMemberId) REFERENCES PartyMember(id),
    FOREIGN KEY (orgId) REFERENCES PartyOrganization(id)
);

-- Table: EvalRequest
CREATE TABLE EvalRequest (
    id VARCHAR(255) PRIMARY KEY,
    partyMemberId VARCHAR(255),
    orgId VARCHAR(255),
    date DATE,
    status VARCHAR(50),
    FOREIGN KEY (partyMemberId) REFERENCES PartyMember(id),
    FOREIGN KEY (orgId) REFERENCES PartyOrganization(id)
);

-- Table: Discipline
CREATE TABLE Discipline (
    id VARCHAR(255) PRIMARY KEY,
    partyMemberId VARCHAR(255),
    orgId VARCHAR(255),
    decisionMaker VARCHAR(255),
    disciplineDate DATE,
    description VARCHAR(255),
    FOREIGN KEY (partyMemberId) REFERENCES PartyMember(id),
    FOREIGN KEY (orgId) REFERENCES PartyOrganization(id)
);

INSERT INTO PartyOrganization (id, orgName, creationDate) 
VALUES ('ORG01', 'Chi bộ Thanh Xuân', '2010-05-12'),
       ('ORG02', 'Chi bộ Đống Đa', '2015-09-30'),
       ('ORG03', 'Chi bộ Hoàn Kiếm', '2012-07-20');
INSERT INTO PartyMember (id, fullName, birthDate, joinDate, address, email, phoneNumber, status, orgId, avatar)
VALUES ('PM001', 'Nguyễn Văn A', '1985-10-15', '2005-01-01', 'Hà Nội', 'nva@example.com', '0987654321', 'Đang sinh hoạt', 'ORG01', NULL),
       ('PM002', 'Trần Thị B', '1990-08-25', '2010-06-15', 'Đà Nẵng', 'ttb@example.com', '0912345678', 'Đang sinh hoạt', 'ORG02', NULL),
       ('PM003', 'Lê Văn C', '1978-03-10', '2000-11-05', 'Hồ Chí Minh', 'lvc@example.com', '0908765432', 'Đang sinh hoạt', 'ORG03', NULL);

INSERT INTO User (partyMemberId, partOrgId, password, role)
VALUES ('PM001', 'ORG01', 'matkhau123', false),
       ('PM002', 'ORG02', 'matkhau456', false),
       ('PM003', 'ORG03', 'matkhau789', true);

INSERT INTO BranchActivity (id, activityName, startDate, endDate, status, description, orgId)
VALUES ('ACT01', 'Họp chi bộ tháng 1', '2024-01-10', '2024-01-10', 'Hoàn thành', 'Họp bàn công việc đầu năm', 'ORG01'),
       ('ACT02', 'Sinh hoạt đảng thường kỳ', '2024-02-15', '2024-02-15', 'Hoàn thành', 'Sinh hoạt định kỳ tháng 2', 'ORG02'),
       ('ACT03', 'Tổ chức đại hội đảng', '2024-05-05', '2024-05-10', 'Hoàn thành', 'Đại hội chi bộ năm 2024', 'ORG03');

INSERT INTO Reward (id, partyMemberId, rewardDate, decisionMaker, description)
VALUES ('RW001', 'PM001', '2021-06-30', 'Ban Chấp hành Chi bộ', 'Khen thưởng đảng viên xuất sắc'),
       ('RW002', 'PM002', '2022-12-15', 'Ban Chấp hành Chi bộ', 'Khen thưởng vì thành tích đặc biệt trong công tác'),
       ('RW003', 'PM003', '2023-03-20', 'Ban Chấp hành Chi bộ', 'Khen thưởng đóng góp lâu dài cho chi bộ');

INSERT INTO TransferOut (id, partyMemberId, orgId, status, transferDate, reason)
VALUES ('TO001', 'PM001', 'ORG02', 'Chuyển đi', '2022-08-01', 'Chuyển công tác vào Đà Nẵng'),
       ('TO002', 'PM002', 'ORG03', 'Chuyển đi', '2023-04-12', 'Chuyển đến Hồ Chí Minh'),
       ('TO003', 'PM003', 'ORG01', 'Chuyển đến', '2024-01-15', 'Chuyển đến Hà Nội làm việc');

INSERT INTO EvalRequest (id, partyMemberId, orgId, date, status)
VALUES ('ER001', 'PM001', 'ORG01', '2023-12-01', 'Đã đánh giá'),
       ('ER002', 'PM002', 'ORG02', '2024-01-10', 'Đang chờ'),
       ('ER003', 'PM003', 'ORG03', '2024-02-05', 'Đã đánh giá');

INSERT INTO Discipline (id, partyMemberId, orgId, decisionMaker, disciplineDate, description)
VALUES ('DS001', 'PM001', 'ORG01', 'Ban Chấp hành Chi bộ', '2022-05-01', 'Khiển trách vì vi phạm nội quy'),
       ('DS002', 'PM002', 'ORG02', 'Ban Chấp hành Chi bộ', '2023-07-15', 'Cảnh cáo vì không tuân thủ quy định'),
       ('DS003', 'PM003', 'ORG03', 'Ban Chấp hành Chi bộ', '2024-03-20', 'Khai trừ vì sai phạm nghiêm trọng');