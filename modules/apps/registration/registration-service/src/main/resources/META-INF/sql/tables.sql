create table Acme_Registration (
	registrationId LONG not null primary key,
	groupId LONG,
	userId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	username VARCHAR(75) null,
	male BOOLEAN,
	birthday DATE null,
	password_ VARCHAR(75) null,
	confirmPassword VARCHAR(75) null,
	homePhone VARCHAR(75) null,
	mobilePhone VARCHAR(75) null,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	zipcode VARCHAR(75) null,
	securityQuestion VARCHAR(75) null,
	answer VARCHAR(75) null,
	acceptedToU BOOLEAN
);

create table Acme_RegistrationTrack (
	registrationTrackId LONG not null primary key,
	groupId LONG,
	userId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	eventDatetime DATE null,
	screenName VARCHAR(75) null,
	iPAdress VARCHAR(75) null,
	eventType VARCHAR(75) null
);