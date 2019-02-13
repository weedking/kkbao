// NOTE: This example will not work locally in all browsers.
// In Chrome, if you try this locally, you may get an error along the lines of:
//       Origin 'null' is therefore not allowed access.
// You can try it out on the website for the book http://javascriptbook.com/code/c08/
// or run it on your own server.

$('#showUser').on('submit', function(e) {                 // User clicks nav link
  e.preventDefault();                                // Stop loading new link
  var details = $('#showUser').serialize();         // Serialize form data
  // var url = this.href;                               // Get value of href
  // var url= "temShowUser.html";
  // var url= "../resources/templates/temShowUser.html";
  // var url="http://localhost:8080/showUser";
  var url = "jq-load.html";
  $.get('http://localhost:8080/showUser', details, function(data,status) {  // Use $.post() to send it
    // $('#resultList').toString(details);                  // Where to display result
    // alert("Data: " + data + "\nStatus: " + status);
    // window.location.replace("http://localhost:8080/t1/allDepartment");

  });

  // $('nav a.current').removeClass('current');         // Clear current indicator
  // $(this).addClass('current');                       // New current indicator

  $('#container').remove();                          // Remove old content
  $('#resultList').load(url + ' #container').hide().fadeIn('slow'); // New content
});


// $('nav a').on('click', function(e) {                 // User clicks nav link
//   e.preventDefault();                                // Stop loading new link
//   var url = this.href;                               // Get value of href
//
//   $('nav a.current').removeClass('current');         // Clear current indicator
//   $(this).addClass('current');                       // New current indicator
//
//   $('#container').remove();                          // Remove old content
//   $('#content').load(url + ' #container').hide().fadeIn('slow'); // New content
// });