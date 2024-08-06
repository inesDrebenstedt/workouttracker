// Create the admin user
db.createUser({
  user: 'admin',
  pwd:  'pass',
  roles: [{ role: 'root', db: 'admin' }],
  mechanisms: ["SCRAM-SHA-1"]
});

// Switch to the specified database (e.g., mydatabase)
db = db.getSiblingDB('fitcontroldb');

// Create a user for the specified database
db.createUser({
  user: 'rootuser',
  pwd:  'rootpass',
  roles: [{ role: 'readWrite', db: 'fitcontroldb' }],
  mechanisms: ["SCRAM-SHA-1"]
});
db.createCollection("test");
