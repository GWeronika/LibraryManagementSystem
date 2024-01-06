const express = require('express');
const mysql = require('mysql');
const cors = require('cors');
const app = express();
const port = 3000;

app.use(cors());

// Connect to MySQL
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'library_system_db'
});

db.connect((err) => {
    if (err) throw err;
    console.log('Connected to MySQL database');

    // Define routes and handle database queries here

    app.listen(port, () => {
        console.log(`Server is running on port ${port}`);
    });
});

// Example route to retrieve data from a MySQL table
app.get('/api/data', (req, res) => {
    const query = 'SELECT author FROM book where book_id=1';

    db.query(query, (err, result) => {
        if (err) throw err;
        res.json(result);
    });
});