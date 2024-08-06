<!-- CreateUser.vue -->
<template>
    <div>
      <h2>Create Rep</h2>
      <form @submit.prevent="submitRep">
        <label for="Workout">Workout:</label>
        <input type="text" id="username" v-model="user.username">
        <label for="Exercise">Exercise:</label>
        <input type="text" id="username" v-model="user.username">
        <button type="submit">Create Rep</button>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        user: {
          username: '',
          email: ''
        }
      };
    },
    methods: {
      submitUser() {
        axios.post('/users', this.user)
          .then(response => {
            console.log('User created:', response.data);
            // Optionally, you can navigate to a different route or display a success message
          })
          .catch(error => {
            console.error('Error creating user:', error);
            // Handle error, display error message, etc.
          });
      }
    }
  };
  </script>
  
  <style scoped>
  /* Add your component styles here */
  </style>
  