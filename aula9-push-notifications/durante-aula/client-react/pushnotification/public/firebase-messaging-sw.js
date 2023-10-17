importScripts("https://www.gstatic.com/firebasejs/9.0.0/firebase-app-compat.js");
importScripts("https://www.gstatic.com/firebasejs/9.0.0/firebase-messaging-compat.js");

//the Firebase config object 
const firebaseConfig = {
  apiKey: "AIzaSyBEMwKR0hcshU-8qcSm_5aW7NMlFrgyE7o",
  authDomain: "push-notification-class-iftm.firebaseapp.com",
  projectId: "push-notification-class-iftm",
  storageBucket: "push-notification-class-iftm.appspot.com",
  messagingSenderId: "930975366131",
  appId: "1:930975366131:web:cba7a8486265b4fee2b086"
}; 

firebase.initializeApp(firebaseConfig);
const messaging = firebase.messaging();


messaging.onBackgroundMessage(
  function(payload) {
    console.log('Received background message ', payload);
    const notificationTitle = payload.notification.title;
    const notificationOptions = {
      body: payload.notification.body,
    };

  self.registration.showNotification(notificationTitle,
    notificationOptions);
});