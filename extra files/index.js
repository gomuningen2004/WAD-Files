const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');

const app = express();
const PORT = 3000;

// Connect to MongoDB (Make sure MongoDB is installed and running)
mongoose.connect('mongodb://localhost:27017/mydatabase', { useNewUrlParser: true, useUnifiedTopology: true });

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

// Register route
app.post('/register', (req, res) => {
  // Handle registration logic and save user to the database
  const { name, email, mobile, password } = req.body;
  // Save to MongoDB (you should use a schema and validation in a real app)
  // Example using Mongoose:
  // const User = mongoose.model('User', userSchema);
  // const newUser = new User({ name, email, mobile, password });
  // newUser.save()
  res.send('User registered successfully!');
});

// Login route
app.post('/login', (req, res) => {
  // Handle login logic (check credentials, compare hashed password, etc.)
  const { login_email, login_password } = req.body;
  // Check credentials and redirect to a welcome page
  // You should implement proper authentication and session management in a real app
  res.redirect(`/welcome?name=User`);
});

app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
