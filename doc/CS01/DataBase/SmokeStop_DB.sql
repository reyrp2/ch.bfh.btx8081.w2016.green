CREATE TABLE Person
( Name			NVARCHAR(40)
, Firstname		NVARCHAR(40)
, Birthdate		DATE
, TimeSmoking	INT --Years how long smoking
, UserName		NVARCHAR(40) NOT NULL
	CONSTRAINT PK_Person PRIMARY KEY
, Password		NVARCHAR(40) NOT NULL
);

CREATE TABLE Motivator
( UserName NVARCHAR (40)
		CONSTRAINT PK_Motivator PRIMARY KEY
		CONSTRAINT FK_Motivator REFERENCES Person
, MotivationTxt		NVARCHAR(2000)
, MotivationPicture	VARBINARY(MAX)
);

CREATE TABLE Goals
( UserName NVARCHAR (40)
		CONSTRAINT PK_Goals PRIMARY KEY
		CONSTRAINT FK_Goals REFERENCES Person
, BigGoal Date NOT NULL
, DailyGoal INT
);