const express = require('express');

const app = express();

const PORT = process.env.PORT;

app.use('/', (req, res) => {
    res.json({id: PORT, username: 'Bob', roles: ['ROLE_ADMIN', 'ROLE_USER']});
});

app.listen(PORT, () => console.log(`listening on :${PORT}`));