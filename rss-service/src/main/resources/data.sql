DROP TABLE IF EXISTS rss;
 
CREATE TABLE rss (
	id INT AUTO_INCREMENT PRIMARY KEY,
	description VARCHAR(9050) NOT NULL,
	image VARCHAR(250) NOT NULL,
	pub_date VARCHAR(250) NOT NULL,
	title VARCHAR(250) NOT NULL
);